package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.CuartoHospitalizacion;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.events.CuartoHospitalizacionCreado;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.CuartoHospitalizacionID;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.NivelDeRiesgo;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.NombreMedicamento;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        NivelDeRiesgo nivelDeRiesgo = new NivelDeRiesgo("Bajo");
        var command = new CrearCuartoHospitalizacion(cuartoHospitalizacionID, nivelDeRiesgo);

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var event =(CuartoHospitalizacionCreado)events.get(0);
        Assertions.assertEquals("xxx",event.aggregateRootId());
        Assertions.assertEquals("Bajo",event.getNivelDeRiesgo().value());
    }

}