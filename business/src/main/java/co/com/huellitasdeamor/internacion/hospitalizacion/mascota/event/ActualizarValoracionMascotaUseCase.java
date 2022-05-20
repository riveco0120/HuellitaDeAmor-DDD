package co.com.huellitasdeamor.internacion.hospitalizacion.mascota.event;

import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.events.EstadiaMascotaFinalizada;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.Mascota;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.MascotaID;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class ActualizarValoracionMascotaUseCase extends UseCase<TriggeredEvent<EstadiaMascotaFinalizada>, ResponseEvents>{

    @Override
    public void executeUseCase(TriggeredEvent<EstadiaMascotaFinalizada> estadiaMascotaFinalizadaTriggeredEvent) {
        var event = estadiaMascotaFinalizadaTriggeredEvent.getDomainEvent();
        var mascota = Mascota.from(event.getMascotaID(),repository().getEventsBy(event.getMascotaID().value()));

        mascota.actualizarValoracion(event.getValoracionMascota());

        emit().onResponse(new ResponseEvents(mascota.getUncommittedChanges()));

    }
}
