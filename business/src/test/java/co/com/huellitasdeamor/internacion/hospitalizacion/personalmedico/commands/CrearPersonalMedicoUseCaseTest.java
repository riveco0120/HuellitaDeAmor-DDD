package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.events.PersonalMedicoCreado;
import co.com.huellitasdeamor.internacion.generico.HorrarioPersonaMedico;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.PersonalMedicoID;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CrearPersonalMedicoUseCaseTest {

    private CrearPersonalMedicoUseCase useCase;

    @BeforeEach
    public void setup(){
        useCase= new CrearPersonalMedicoUseCase();
    }

    @Test
    @DisplayName("Test para crear personal medico")
    void creaPersonalmedicoTest(){
        //Arrange
        PersonalMedicoID personalMedicoID = PersonalMedicoID.of("xxxx");
        HorrarioPersonaMedico horrario = new HorrarioPersonaMedico("Lunes a sabado de 8am a 6 pm");
        var command = new CrearPersonalMedico(personalMedicoID,horrario);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //asserts
        var personalMedico =(PersonalMedicoCreado)events.get(0);
        Assertions.assertEquals("xxxx",personalMedico.aggregateRootId());
        Assertions.assertEquals("Lunes a sabado de 8am a 6 pm",personalMedico.getHorrario().value());

    }
}