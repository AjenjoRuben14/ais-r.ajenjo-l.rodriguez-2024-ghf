package es.codeurjc.ais.nitflex;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BugTest {

    @LocalServerPort
    int port;

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setupTest() {
        ChromeOptions options = new ChromeOptions();
    	options.addArguments("--headless");
        this.driver = new ChromeDriver(options);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @DisplayName("Test bug encontrado")
    @Test
    public void test() {

        driver.get("http://localhost:" + this.port + "/");
        String title = "peliculaTest1";
        String synopsis = "sinopsis";
        int year = 2024;
        String url = "https://i.blogs.es/a19bfc/testing/1366_2000.jpg";

        // Hacemos click en "New film" y esperamos a estar en la nueva pagina
        driver.findElement(By.id("create-film")).click();
        wait.until(presenceOfElementLocated(By.id("Save")));

        // Rellenamos los datos
        driver.findElement(By.name("title")).sendKeys(title);
        driver.findElement(By.name("releaseYear")).sendKeys(String.valueOf(year));
        driver.findElement(By.name("url")).sendKeys(url);
        driver.findElement(By.name("synopsis")).sendKeys(synopsis);

        // Hacemos click en el botón Save y esperamos a estar en la nueva pagina
        driver.findElement(By.id("Save")).click();
        wait.until(presenceOfElementLocated(By.id("edit-film")));

        // Hacemos click en el botón edit y esperamos a estar en la nueva pagina
        driver.findElement(By.id("edit-film")).click();
        wait.until(presenceOfElementLocated(By.id("Cancel")));

        // Hacemos click en el botón Cancel
        driver.findElement(By.id("Cancel")).click();

        //Comprobamos que está en la página principal
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("http://localhost:" + this.port + "/films/"));

    }
}




