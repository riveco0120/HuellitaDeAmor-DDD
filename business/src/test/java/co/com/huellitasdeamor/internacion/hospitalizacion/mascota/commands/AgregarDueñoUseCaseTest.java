package co.com.huellitasdeamor.internacion.hospitalizacion.mascota.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.events.DueñoMascotaAgregado;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.events.MascotaCreada;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarDueñoUseCaseTest {

    @InjectMocks
    private AgregarDueñoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test para probar agregar dueño")
    void agregarDueñoMascotaTest(){
        //Arrange
        MascotaID mascotaID = MascotaID.of("xxxx");
        DueñoID dueñoID = DueñoID.of("10101");
        NombreDueño nombreDueño = new NombreDueño("Alejandro");
        Direccion direccion = new Direccion("planeta rica");
        Telefono telefono = new Telefono("3116547898");
        var command = new AgregarDueño(mascotaID,dueñoID,nombreDueño,direccion,telefono);
        when(repository.getEventsBy("10101")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("10101")
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event =(DueñoMascotaAgregado)events.get(0);
        Assertions.assertEquals("10101",event.getDueñoID().value());
        Assertions.assertEquals("Alejandro",event.getNombreDueño().value());
        Assertions.assertEquals("planeta rica",event.getDireccion().value());
        Assertions.assertEquals("3116547898",event.getTelefono().value());
        Mockito.verify(repository).getEventsBy("10101");

    }

    private List<DomainEvent> history() {
        NombreMascota nombreMascota = new NombreMascota("Susi");
        Especie especie = new Especie("Gato domestico");
        var event = new MascotaCreada(nombreMascota,especie);
        event.setAggregateRootId("xxxx");
           return List.of(event);
    }

}