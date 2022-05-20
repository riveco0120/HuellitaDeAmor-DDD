package co.com.huellitasdeamor.internacion.hospitalizacion.mascota.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.Mascota;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.ActualizarNombreDueño;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarNombreDueñoUseCase extends UseCase<RequestCommand<ActualizarNombreDueño>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreDueño> actualizarNombreDueñoRequestCommand) {
        var command = actualizarNombreDueñoRequestCommand.getCommand();
        var mascota = Mascota.from(command.getMascotaID(),retrieveEvents(command.getMascotaID().value()));
        mascota.actualizarNombreDueño(command.getNombreDueño());
        emit().onResponse(new ResponseEvents(mascota.getUncommittedChanges()));
    }
}
