package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.events;

import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.events.TurnoPersonalMedicoFinalizado;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.PersonalMedico;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class ActualizarHorrarioPersonalMedicoUseCase extends UseCase<TriggeredEvent<TurnoPersonalMedicoFinalizado>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<TurnoPersonalMedicoFinalizado> turnoPersonalMedicoFinalizadoTriggeredEvent) {
        var event =turnoPersonalMedicoFinalizadoTriggeredEvent.getDomainEvent();
        var personalMedico = PersonalMedico.from(event.getPersonalMedicoID(),repository().getEventsBy(event.getPersonalMedicoID().value()));

        personalMedico.actualizarHorrario(event.getHorrarioPersonalMedico());

        emit().onResponse(new ResponseEvents(personalMedico.getUncommittedChanges()));
    }
}
