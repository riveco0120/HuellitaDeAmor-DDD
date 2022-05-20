package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.CuartoHospitalizacion;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearCuartoHospitalizacionUseCase extends UseCase<RequestCommand<CrearCuartoHospitalizacion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearCuartoHospitalizacion> crearCuartoHospitalizacionRequestCommand) {
        var command = crearCuartoHospitalizacionRequestCommand.getCommand();
        var cuartoHospitalizacion = new CuartoHospitalizacion(command.getCuartoHospitalizacionID(), command.getMascotaID(), command.getPersonalMedicoID(),command.getNivelDeRiesgo());
        emit().onResponse(new ResponseEvents(cuartoHospitalizacion.getUncommittedChanges()));
    }
}
