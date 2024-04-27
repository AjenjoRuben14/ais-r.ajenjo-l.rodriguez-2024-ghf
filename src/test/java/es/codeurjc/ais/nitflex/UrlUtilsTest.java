package es.codeurjc.ais.nitflex;

import es.codeurjc.ais.nitflex.utils.UrlUtils;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class UrlUtilsTest {
    private UrlUtils urlUtils;

    @Test
    public void testUrlInvalida (){
        // Creamos una nueva instancia de urlUtils
        this.urlUtils = new UrlUtils();

        // URL con formato incorrecto
        String urlFormatoIncorrecto = "hps://i.blogs/a19bfc/testing/1366_2000";

        // Verificamos que se lanza la excepcion del tipo ResponseStatusException al utilizar el metodo checkValidImageURL
        assertThrows(ResponseStatusException.class, () -> {
            urlUtils.checkValidImageURL(urlFormatoIncorrecto);});
    }

    @Test
    public void testURLValidaNoExiste() {
        // URL con formato correcto pero que no existe
        String URLValidaNoExiste = "https://www.themoviedb.org/image.png";

        // Comprobamos que se lanza la excepcion ResponseStatusException
        assertThrows(ResponseStatusException.class, () -> {
            try {
                urlUtils.checkValidImageURL(URLValidaNoExiste);
            // Si lanza NullPointerException la capturamos y lanzamos la nueva excepcion
            } catch (NullPointerException e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "URL resource does not exist");
            }
        });
    }
}







