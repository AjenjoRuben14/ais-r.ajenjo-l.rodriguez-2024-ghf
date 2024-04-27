package es.codeurjc.ais.nitflex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.codeurjc.ais.nitflex.film.Film;
import es.codeurjc.ais.nitflex.film.FilmRepository;
import es.codeurjc.ais.nitflex.film.FilmService;
import es.codeurjc.ais.nitflex.notification.NotificationService;
import es.codeurjc.ais.nitflex.utils.UrlUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FilmServiceTest {
    private FilmService filmservice;
    private FilmRepository repositorio;
    private NotificationService notificationservice;
    private UrlUtils urlutils;

    // Previo a cada test se ejecutara este metodo
    @BeforeEach
    public void configuracionPrevia () {
        this.repositorio = mock(FilmRepository.class);
        this.notificationservice = mock(NotificationService.class);
        this.urlutils = mock(UrlUtils.class);
        this.filmservice = new FilmService(repositorio, notificationservice, urlutils);
    }

    @Test
    public void testguardarPeliculaURLCorrecta () {
        // Creamos una nueva pelicula
        Film pelicula = new Film("peliculaTest1", "sinopsis", 2024, "https://i.blogs.es/a19bfc/testing/1366_2000.jpg");
        pelicula.setId(1L);

        // Given - Describimos el comportamiento esperado
        // Al guardar la pelicula nos debe devolver esa misma pelicula
        when(repositorio.save(pelicula)).thenReturn(pelicula);

        // When - Ejecutamos el metodo que queremos probar
        filmservice.save(pelicula);

        // Verificamos que la pelicula se ha guardado correctamente y esta en el repositorio
        verify(repositorio).save(pelicula);
        // Verificamos que lanza la notificacion
        verify(notificationservice).notify("Film Event: Film with title=" + pelicula.getTitle() + " was created");
    }

    @Test
    public void testguardarPeliculaURLIncorrecta () {
        // Creamos una nueva pelicula con una URL incorrecta
        Film pelicula = new Film("peliculaTest2", "sinopsis", 2024, "urlIncorrecta");
        pelicula.setId(1L);

        // Given - Describimos el comportamiento esperado
        // Describimos el mensaje y excepcion que esperamos
        doThrow(new ResponseStatusException(HttpStatus.BAD_REQUEST, "The url format is not valid"))
                .when(urlutils).checkValidImageURL(pelicula.getUrl());

        // Then - Verificamos que se lanza la excepcion y el mensaje esperado
        assertThrows(ResponseStatusException.class, () -> filmservice.save(pelicula));

        // Then - Verificamos que no se ha mandado ninguna notificacion
        verify(notificationservice, times(0)).notify(anyString());
    }
}