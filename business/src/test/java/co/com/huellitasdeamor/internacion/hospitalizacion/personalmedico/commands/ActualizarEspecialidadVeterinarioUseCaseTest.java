package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.commands;

import co.com.huellitasdeamor.internacion.generico.HorrarioPersonaMedico;
import co.com.huellitasdeamor.internacion.generico.Nombre;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.events.EspecialidadVeterinarioActualizada;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.events.PersonalMedicoCreado;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.events.VeterinarioAgregado;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.Especialidad;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.PersonalMedicoID;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.VeterinarioID;
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

@ExtendWith(MockitoExtension.class)
class ActualizarEspecialidadVeterinarioUseCaseTest {

    @InjectMocks
    private ActualizarEspecialidadVeterinarioUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test para probar actualizar especialidad")
    void actualizarEspecialidadVeterinario(){
        //Arrange
        PersonalMedicoID personalMedicoID = PersonalMedicoID.of("xxxx");
        Especialidad especialidad = new Especialidad("Masajista");
        var command = new ActualizarEspecialidadVeterinario(personalMedicoID,especialidad);
        Mockito.when(repository.getEventsBy("xxxx")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(personalMedicoID.value())
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (EspecialidadVeterinarioActualizada)events.get(0);
        Assertions.assertEquals("Masajista",event.getEspecialidad().value());
        Mockito.verify(repository).getEventsBy(personalMedicoID.value());
    }

    private List<DomainEvent> history(){
        HorrarioPersonaMedico horrarioPersonaMedico = new HorrarioPersonaMedico("6am a 7 pm");
        var event = new PersonalMedicoCreado(horrarioPersonaMedico);
        event.setAggregateRootId("xxxx");
        var eventEspecialidad = new VeterinarioAgregado(VeterinarioID.of("1245"),new Nombre("Calos"),new Especialidad("comida rapida"));
        return List.of(event,eventEspecialidad);
    }

}

