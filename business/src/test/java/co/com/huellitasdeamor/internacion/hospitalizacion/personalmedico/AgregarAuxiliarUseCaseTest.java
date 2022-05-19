package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico;

import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.commands.AgregarAuxiliar;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.commands.AgregarAuxiliarUseCase;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.events.AuxiliarAgregado;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.events.PersonalMedicoCreado;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.*;
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

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarAuxiliarUseCaseTest {

    @InjectMocks
    private AgregarAuxiliarUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test para validar agregar auxiliar")
    void agregarAuxiliarVeterinarioTest(){
        //Arrange
        PersonalMedicoID personalMedicoID = PersonalMedicoID.of("xxxx");
        AuxiliarVeterinarioID auxiliarVeterinarioID = AuxiliarVeterinarioID.of("10101");
        Nombre nombre = new Nombre("Carlos coneo");
        Funcion funcion = new Funcion("Eliminar desechos");
        var command = new AgregarAuxiliar(personalMedicoID,auxiliarVeterinarioID,nombre,funcion);
        when(repository.getEventsBy("10101")).thenReturn(history());
        useCase.addRepository(repository);
        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("10101")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //Assert
        var event =(AuxiliarAgregado)events.get(0);
        Assertions.assertEquals("10101",event.getEntityId().value());
        Assertions.assertEquals("Carlos coneo",event.getNombre().value());
        Assertions.assertEquals("Eliminar desechos",event.getFuncion().value());
        Mockito.verify(repository).getEventsBy("10101");
    }
    private List<DomainEvent> history() {
       Horrario horrario = new Horrario("Lunes a viernes 6 am a 8 pm");
        var event = new PersonalMedicoCreado(horrario);
        event.setAggregateRootId("xxxxx");
        return List.of(event);
    }



}