package co.com.huellitasdeamor.internacion.hospitalizacion.mascota.commands;

import co.com.huellitasdeamor.internacion.generico.Nombre;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.events.DueñoMascotaAgregado;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.events.MascotaCreada;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.events.NombreDueñoActualizado;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.*;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class ActualizarNombreDueñoUseCaseTest {

    @InjectMocks
    private ActualizarNombreDueñoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test para probar actualizar nombre")
    void actualizarNombreDueñoTest(){
        //Arrange
        MascotaID mascotaID = MascotaID.of("xxxx");
        Nombre nombreDueño =new Nombre("Maximiliano");
        var command = new ActualizarNombreDueño(mascotaID,nombreDueño);
        Mockito.when(repository.getEventsBy("xxxx")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(mascotaID.value())
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event =(NombreDueñoActualizado)events.get(0);
        Assertions.assertEquals("Maximiliano",event.getNombreDueño().value());
        Mockito.verify(repository).getEventsBy(mascotaID.value());

    }

    private List<DomainEvent>history(){
        Nombre nombreMascota = new Nombre("Susi");
        Especie especie = new Especie("Gato domestico");
        var event = new MascotaCreada(nombreMascota,especie);
        event.setAggregateRootId("xxxx");
        var eventDueño = new DueñoMascotaAgregado(DueñoID.of("dddd"),new Nombre("Sindy"),new Direccion("Alto prado"),new Telefono("3002451578"));
        return List.of(event,eventDueño);
    }



}