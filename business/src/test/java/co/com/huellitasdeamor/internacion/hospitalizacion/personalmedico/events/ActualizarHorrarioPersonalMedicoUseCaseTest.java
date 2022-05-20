package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.events;

import co.com.huellitasdeamor.internacion.generico.HorrarioPersonaMedico;
import co.com.huellitasdeamor.internacion.generico.Nombre;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.events.TurnoPersonalMedicoFinalizado;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.*;
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

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarHorrarioPersonalMedicoUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @InjectMocks
    private ActualizarHorrarioPersonalMedicoUseCase useCase;

    @Test
    @DisplayName("Test para provar evento de actualizar horrario")
    void actualizarHorrarioPersonalMedicoTest(){
        var event = new TurnoPersonalMedicoFinalizado(new HorrarioPersonaMedico("7am a 8pm"), PersonalMedicoID.of("1235"));
        when(repository.getEventsBy("1235")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var horrario = (HorrarioActualizado)events.get(0);
        Assertions.assertEquals("7am a 8pm", horrario.getHorrario().value());

    }
    private List<DomainEvent> history() {
        HorrarioPersonaMedico horrarioPersonaMedico = new HorrarioPersonaMedico("7pm a 6am");

        var event = new PersonalMedicoCreado(horrarioPersonaMedico);
        event.setAggregateRootId("xxxx");
        VeterinarioAgregado veterinario = new VeterinarioAgregado(VeterinarioID.of("1245"),new Nombre("Calos"),new Especialidad("comida rapida"));
        AuxiliarAgregado auxiliarAgregado = new AuxiliarAgregado(AuxiliarVeterinarioID.of("1596"),new Nombre("Silvia"),new Funcion("Mantenimiento"));
        AuxiliarVEterinarioEliminado auxiliarEliminado = new AuxiliarVEterinarioEliminado(AuxiliarVeterinarioID.of("1596"));
        EspecialidadVeterinarioActualizada especialidaNueva = new EspecialidadVeterinarioActualizada(new Especialidad("Cirugias"));
        return List.of(event,veterinario,auxiliarAgregado,auxiliarEliminado,especialidaNueva);

    }


    }
