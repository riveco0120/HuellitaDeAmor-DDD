package co.com.huellitasdeamor.internacion.hospitalizacion.mascota.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.Mascota;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarDueñoUseCase extends UseCase<RequestCommand<AgregarDueño>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarDueño> agregarDueñoRequestCommand) {
        var command = agregarDueñoRequestCommand.getCommand();
        var mascota = Mascota.from(command.getMascotaID(),retrieveEvents());
        mascota.agregarDueño(command.getDueñoID(),command.getNombreDueño(),command.getDireccion(),command.getTelefono());
        emit().onResponse(new ResponseEvents(mascota.getUncommittedChanges()));
    }
}
