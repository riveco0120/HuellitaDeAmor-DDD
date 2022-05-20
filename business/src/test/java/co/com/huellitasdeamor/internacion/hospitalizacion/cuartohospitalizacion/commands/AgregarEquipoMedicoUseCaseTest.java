package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.events.CuartoHospitalizacionCreado;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.events.EquipoMedicoAgregado;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.*;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.MascotaID;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.PersonalMedicoID;
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
class AgregarEquipoMedicoUseCaseTest {
    @InjectMocks
    private AgregarEquipoMedicoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test para probar agregar equipo")
    void agregarEquipóMedicoTest(){
        //Arrange
        CuartoHospitalizacionID cuartoHospitalizacionID = CuartoHospitalizacionID.of("xxx");
        EquipoMedicoID equipoMedicoID = EquipoMedicoID.of("5252");
        TipoDeEquipo tipoDeEquipo = new TipoDeEquipo("Termomentro");
        Instrucion instrucion = new Instrucion("Agitar antes de usar");
        var command = new AgregarEquipoMedico(cuartoHospitalizacionID,equipoMedicoID,tipoDeEquipo,instrucion);
        when(repository.getEventsBy("5252")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("5252")
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event =(EquipoMedicoAgregado)events.get(0);
        Assertions.assertEquals("5252",event.getEquipoMedicoID().value());
        Assertions.assertEquals("Termomentro",event.getTipoDeEquipo().value());
        Assertions.assertEquals("Agitar antes de usar",event.getInstrucion().value());
        Mockito.verify(repository).getEventsBy("5252");

    }
    private List<DomainEvent> history() {
        NivelDeRiesgo nivelDeRiesgo = new NivelDeRiesgo("bajo");
        MascotaID mascotaID = MascotaID.of("2525");
        PersonalMedicoID personalMedicoID = PersonalMedicoID.of("1223");
        var event = new CuartoHospitalizacionCreado(nivelDeRiesgo,mascotaID,personalMedicoID);
        event.setAggregateRootId("xxx");
        return List.of(event);
    }
}