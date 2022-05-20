package co.com.huellitasdeamor.internacion.hospitalizacion.mascota.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.Mascota;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearMascotaUseCase extends UseCase<RequestCommand<CrearMascota>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearMascota> crearMascotaRequestCommand) {
        var command = crearMascotaRequestCommand.getCommand();
        var mascota = new Mascota(command.getMascotaID(),command.getNombreMascota(),command.getEspecie());
        emit().onResponse(new ResponseEvents(mascota.getUncommittedChanges()));
    }
}
