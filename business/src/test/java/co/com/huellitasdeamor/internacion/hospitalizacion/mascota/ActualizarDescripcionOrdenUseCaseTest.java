package co.com.huellitasdeamor.internacion.hospitalizacion.mascota;

import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.commands.ActualizarDescripcionOrdenUseCase;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.events.DescripcionOrdenActualizada;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.events.MascotaCreada;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.events.OrdenMedicaAgregada;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.*;
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

import java.time.LocalDateTime;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class ActualizarDescripcionOrdenUseCaseTest {

    @InjectMocks
    private ActualizarDescripcionOrdenUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    @DisplayName("Test para probar actualizar descripcion orden")
    void actualizarDescripcionOrdenTest(){
        //Arrange
        MascotaID mascotaID = MascotaID.of("xxxx");
        DescripcionOrden descripcionOrden = new DescripcionOrden("Acidente de transito");
        var command = new ActualizarDescripcionOrden(mascotaID,descripcionOrden);
        Mockito.when(repository.getEventsBy("xxxx")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(mascotaID.value())
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (DescripcionOrdenActualizada)events.get(0);
        Assertions.assertEquals("Acidente de transito",event.getDescripcionOrden().value());
        Mockito.verify(repository).getEventsBy(mascotaID.value());
    }

    private List<DomainEvent> history(){
        NombreMascota nombreMascota = new NombreMascota("Susi");
        Especie especie = new Especie("Gato domestico");
        var event = new MascotaCreada(nombreMascota,especie);
        event.setAggregateRootId("xxxx");
        var eventOrden = new OrdenMedicaAgregada(OrdenMedicaID.of("20202"),new FechaOrdenMedica(LocalDateTime.now()),new ResultadoExamene("No expesifica"),new DescripcionOrden("Paciente en mal estado por"));
        return List.of(event,eventOrden);
    }

}