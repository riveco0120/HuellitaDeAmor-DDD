package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.events.CuartoHospitalizacionCreado;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.events.MedicametoAgregado;
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

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarMedicamentoUseCaseTest {

    @InjectMocks
    private AgregarMedicamentoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Agregando test para probar agregar medicamento")
    void agregarMedicamentoTest(){
        //Arrange
        CuartoHospitalizacionID cuartoHospitalizacionID = CuartoHospitalizacionID.of("xxx");
        MedicamentoID medicamentoID = MedicamentoID.of("1235");
        NombreMedicamento nombreMedicamento = new NombreMedicamento("Aspirina");
        RegistroInvima registroInvima = new RegistroInvima("HTT12");
        var command = new AgregarMedicamento(cuartoHospitalizacionID,medicamentoID,nombreMedicamento,registroInvima);
        when(repository.getEventsBy("1235")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("1235")
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event =(MedicametoAgregado)events.get(0);
        Assertions.assertEquals("1235",event.getMedicamentoID().value());
        Assertions.assertEquals("Aspirina",event.getNombreMedicamento().value());
        Assertions.assertEquals("HTT12",event.getRegistroInvima().value());
        Mockito.verify(repository).getEventsBy("1235");
    }

    private List<DomainEvent> history() {
        NivelDeRiesgo nivelDeRiesgo = new NivelDeRiesgo("bajo");
        MascotaID mascotaID = MascotaID.of("2525");
        PersonalMedicoID personalMedicoID = PersonalMedicoID.of("1235");
        var event = new CuartoHospitalizacionCreado(nivelDeRiesgo,mascotaID,personalMedicoID);
        event.setAggregateRootId("xxx");
        return List.of(event);
    }

}