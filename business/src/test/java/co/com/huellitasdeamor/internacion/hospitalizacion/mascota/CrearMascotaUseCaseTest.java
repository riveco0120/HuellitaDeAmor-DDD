package co.com.huellitasdeamor.internacion.hospitalizacion.mascota;

import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.commands.CrearMascotaUseCase;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.events.MascotaCreada;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.Especie;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.MascotaID;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.NombreMascota;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CrearMascotaUseCaseTest {
    private CrearMascotaUseCase useCase;

    @BeforeEach
    void setup(){
        useCase = new CrearMascotaUseCase();
    }

    @Test
    @DisplayName("Test para probar crear mascota")
    void crearMascotaTest(){
        //Arrange
        MascotaID mascotaID= MascotaID.of("dddd");
        NombreMascota nombreMascota = new NombreMascota("Tommy");
        Especie especie= new Especie("Perro domestico");
        var command = new CrearMascota(mascotaID,nombreMascota,especie);

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //Asserts
        var event =(MascotaCreada)events.get(0);
        Assertions.assertEquals("dddd",event.aggregateRootId());
        Assertions.assertEquals("Tommy",event.getNombreMascota().value());
        Assertions.assertEquals("Perro domestico",event.getEspecie().value());
    }

}