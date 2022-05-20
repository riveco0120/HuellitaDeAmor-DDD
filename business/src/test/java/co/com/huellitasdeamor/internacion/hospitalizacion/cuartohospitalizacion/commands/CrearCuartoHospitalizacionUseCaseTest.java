package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.events.CuartoHospitalizacionCreado;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.CuartoHospitalizacionID;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.NivelDeRiesgo;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.MascotaID;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.PersonalMedicoID;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CrearCuartoHospitalizacionUseCaseTest {

    private CrearCuartoHospitalizacionUseCase useCase;

    @BeforeEach
    void setup(){
        useCase= new CrearCuartoHospitalizacionUseCase();
    }

    @Test
    @DisplayName("Test para probar crear cuarto de hospitalizacion")
    void crearCuartoDeHospitalizacionTest() {
        //Arrange
        CuartoHospitalizacionID cuartoHospitalizacionID = CuartoHospitalizacionID.of("xxx");
        MascotaID mascotaID =MascotaID.of("2525");
        PersonalMedicoID personalMedicoID = PersonalMedicoID.of("1235");
        NivelDeRiesgo nivelDeRiesgo = new NivelDeRiesgo("Bajo");
        var command = new CrearCuartoHospitalizacion(cuartoHospitalizacionID,mascotaID,personalMedicoID,nivelDeRiesgo);

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var event =(CuartoHospitalizacionCreado)events.get(0);
        Assertions.assertEquals("xxx",event.aggregateRootId());
        Assertions.assertEquals("2525",event.getMascotaID().value());
        Assertions.assertEquals("Bajo",event.getNivelDeRiesgo().value());
    }

}