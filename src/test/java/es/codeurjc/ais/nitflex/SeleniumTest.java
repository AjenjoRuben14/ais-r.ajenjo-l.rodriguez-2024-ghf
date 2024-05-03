package es.codeurjc.ais.nitflex;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SeleniumTest {

    @LocalServerPort
    int port;

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @DisplayName("Test anadir pelicula")
    @Test
    public void anadirPeliculaTest() {

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

        // Comprobamos que la pelicula se ha creado
        assertThrows(NoSuchElementException.class, () -> {
            driver.findElement(By.linkText(title));
        });
    }

    @DisplayName("Test borrar pelicula")
    @Test
    public void borrarPeliculaTest() throws Exception {

        driver.get("http://localhost:" + this.port + "/");
        String title = "peliculaTest1";
        String synopsis = "sinopsis";
        int year = 2024;
        String url = "https://i.blogs.es/a19bfc/testing/1366_2000.jpg";

        // Hacemos click en "New film" de manera diferenta al test anterior y esperamos a estar en la nueva pagina
        driver.findElement(By.xpath("//*[text()='New film']")).click();
        wait.until(presenceOfElementLocated(By.id("Save")));

        // Rellenamos los datos
        driver.findElement(By.name("title")).sendKeys(title);
        driver.findElement(By.name("releaseYear")).sendKeys(String.valueOf(year));
        driver.findElement(By.name("url")).sendKeys(url);
        driver.findElement(By.name("synopsis")).sendKeys(synopsis);

        // Hacemos click en el botón Save y esperamos a estar en la nueva pagina
        driver.findElement(By.id("Save")).click();
        wait.until(presenceOfElementLocated(By.id("remove-film")));

        // La borramos y nos devuelve a la paina principal
        driver.findElement(By.id("remove-film")).click();

        // Comprobamos que la pelicula se ha borrado
        assertThrows(NoSuchElementException.class, () -> {
            driver.findElement(By.linkText(title));
        });
    }
}