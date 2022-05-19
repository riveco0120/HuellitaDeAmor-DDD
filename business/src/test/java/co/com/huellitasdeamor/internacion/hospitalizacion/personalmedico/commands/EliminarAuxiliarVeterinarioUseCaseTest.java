package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.commands.EliminarAuxiliarVeterinario;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.commands.EliminarAuxiliarVeterinarioUseCase;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.events.AuxiliarAgregado;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.events.AuxiliarVEterinarioEliminado;
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
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EliminarAuxiliarVeterinarioUseCaseTest {

    @InjectMocks
    private EliminarAuxiliarVeterinarioUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test para probar eliminar auxiliar")
    void eliminarAuxiliar(){
        //Arrange
        PersonalMedicoID personalMedicoID = PersonalMedicoID.of("xxxx");
        AuxiliarVeterinarioID auxiliarVeterinarioID =AuxiliarVeterinarioID.of("10101");
        var command = new EliminarAuxiliarVeterinario(personalMedicoID,auxiliarVeterinarioID);
        when(repository.getEventsBy("xxxx")).thenReturn(history());
        useCase.addRepository(repository);
        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(personalMedicoID.value())
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event=(AuxiliarVEterinarioEliminado)events.get(0);
        Assertions.assertEquals("huellitadeamor.persomalmedico.auxiliarveterinarioeliminado",event.type);
        Assertions.assertEquals("10101",event.getAuxiliarVeterinarioID().value());

    }
    private List<DomainEvent> history() {
        Horrario horrario = new Horrario("Lunes a viernes 6 am a 8 pm");
        var event = new PersonalMedicoCreado(horrario);
        event.setAggregateRootId("xxxxx");
        var event2 = new AuxiliarAgregado(AuxiliarVeterinarioID.of("10101"),new Nombre("Carlos salas"),new Funcion("Eliminar desecho"));
        var event3 = new AuxiliarAgregado(AuxiliarVeterinarioID.of("10102"),new Nombre("Maria fernanda"),new Funcion("Atender pacientes"));
        var event4 = new AuxiliarAgregado(AuxiliarVeterinarioID.of("10103"),new Nombre("Sandy camila"),new Funcion("Mantenimiento de equipos"));
        return List.of(event,event2,event3,event4);
    }

}