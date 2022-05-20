package co.com.huellitasdeamor.internacion.hospitalizacion.mascota.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.Mascota;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarDescripcionOrdenUseCase extends UseCase<RequestCommand<ActualizarDescripcionOrden>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarDescripcionOrden> actualizarDescripcionOrdenRequestCommand) {
        var command = actualizarDescripcionOrdenRequestCommand.getCommand();
        var mascota = Mascota.from(command.getMascotaID(),retrieveEvents(command.getMascotaID().value()));
        mascota.actualizarDescripcionOrden(command.getDescripcionOrden());
        emit().onResponse(new ResponseEvents(mascota.getUncommittedChanges()));
    }
}
