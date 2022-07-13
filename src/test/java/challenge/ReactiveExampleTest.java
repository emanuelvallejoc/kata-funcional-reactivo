package challenge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;


@ExtendWith(MockitoExtension.class)
class ReactiveExampleTest {

    @InjectMocks
    ReactiveExample reactiveExample;


    @Test
    void sumaDePuntajes(){

        var sumaPuntajes = reactiveExample.sumaDePuntajes();

        StepVerifier.create(sumaPuntajes)
                .expectNext(260)
                .verifyComplete();


    }

    @Test
    void mayorPuntajeDeEstudiante(){

        var estudianteRespo  = reactiveExample.mayorPuntajeDeEstudiante(75);

        StepVerifier.create(estudianteRespo)
                .expectNextMatches(estudiante ->  estudiante.getNombre().equalsIgnoreCase("pedro"))
                .verifyComplete();

    }

    @Test
    void totalDeAsisntenciasDeEstudiantesComMayorPuntajeDe(){

        var totalAsistencias = reactiveExample.totalDeAsisntenciasDeEstudiantesConMayorPuntajeDe(75);

        StepVerifier.create(totalAsistencias)
                .expectNext(43)
                .verifyComplete();

    }

    @Test
    void elEstudianteTieneAsistenciasCorrectas(){

        var asistenciasCorrectas = reactiveExample.elEstudianteTieneAsistenciasCorrectas(
                new Estudiante("raul",
                        30,
                        List.of(5,2,1,4,5))
        );

        StepVerifier.create(asistenciasCorrectas)
                .expectNext(Boolean.TRUE)
                .verifyComplete();

    }

    @Test
    void promedioDePuntajesPorEstudiantes(){

        var promedio = reactiveExample.promedioDePuntajesPorEstudiantes();

        StepVerifier.create(promedio)
                .expectNext(52.0)
                .verifyComplete();

    }

    @Test
    void estudiantesAprovados(){

        var aprobados = reactiveExample.estudiantesAprovados();

        StepVerifier.create(aprobados)
                .expectNext("juan", "pedro")
                .verifyComplete();

    }
}