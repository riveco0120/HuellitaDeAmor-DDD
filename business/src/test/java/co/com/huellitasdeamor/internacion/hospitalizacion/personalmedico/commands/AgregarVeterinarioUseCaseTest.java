package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.commands;


import co.com.huellitasdeamor.internacion.generico.HorrarioPersonaMedico;
import co.com.huellitasdeamor.internacion.generico.Nombre;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.events.PersonalMedicoCreado;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.events.VeterinarioAgregado;
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
class AgregarVeterinarioUseCaseTest {
   @InjectMocks
   private AgregarVeterinarioUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test para validar agregar veterinario")
    void agregarVeterinarioTest(){
        //Arrange
        PersonalMedicoID personalMedicoID = PersonalMedicoID.of("xxxx");
        VeterinarioID veterinarioID = VeterinarioID.of("20202");
        Nombre nombre = new Nombre("Juanes perez");
        Especialidad especialidad = new Especialidad("Terapeuta");
        var commad = new AgregarVeterinario(personalMedicoID,veterinarioID,nombre,especialidad);
        when(repository.getEventsBy("20202")).thenReturn(history());
        useCase.addRepository(repository);
        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("20202")
                .syncExecutor(useCase,new RequestCommand<>(commad))
                .orElseThrow()
                .getDomainEvents();
        //Asser

        var event = (VeterinarioAgregado)events.get(0);
        Assertions.assertEquals("20202",event.getEntityId().value());
        Assertions.assertEquals("Juanes perez",event.getNombre().value());
        Assertions.assertEquals("Terapeuta",event.getEspecialidad().value());
        Mockito.verify(repository).getEventsBy("20202");

    }
    private List<DomainEvent> history() {
        HorrarioPersonaMedico horrario = new HorrarioPersonaMedico("Lunes a viernes 6 am a 8 pm");
        var event = new PersonalMedicoCreado(horrario);
        event.setAggregateRootId("xxxxx");
        return List.of(event);
    }


}