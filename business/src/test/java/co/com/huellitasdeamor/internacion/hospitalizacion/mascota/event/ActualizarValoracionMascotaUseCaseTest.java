package co.com.huellitasdeamor.internacion.hospitalizacion.mascota.event;

import co.com.huellitasdeamor.internacion.generico.ValoracionMascota;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.events.CuartoHospitalizacionCreado;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.events.EstadiaMascotaFinalizada;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.NivelDeRiesgo;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.events.MascotaCreada;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.events.ValoracionActualizadad;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.Especie;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.MascotaID;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.NombreMascota;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarValoracionMascotaUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @InjectMocks
    private ActualizarValoracionMascotaUseCase useCase;

    @Test
    @DisplayName("Test para probar caso de uso por evento")
    void actualizarValoracionTest() {
        var event = new EstadiaMascotaFinalizada(new ValoracionMascota(70D), MascotaID.of("2525"));
        when(repository.getEventsBy("2525")).thenReturn(history());
        useCase.addRepository(repository);
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var valoracionActualizadad = (ValoracionActualizadad)events.get(0);
        Assertions.assertEquals(70D, valoracionActualizadad.getValoracion().value());

    }

    private List<DomainEvent> history() {
        NombreMascota nombreMascota =new NombreMascota("Ambar");
        Especie especie = new Especie("Gato domestico");
        var event = new MascotaCreada(nombreMascota,especie);
        return List.of(event);
    }

}