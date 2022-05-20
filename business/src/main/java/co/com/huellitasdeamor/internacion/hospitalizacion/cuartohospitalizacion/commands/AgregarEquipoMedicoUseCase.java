package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.CuartoHospitalizacion;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarEquipoMedicoUseCase extends UseCase<RequestCommand<AgregarEquipoMedico>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarEquipoMedico> agregarEquipoMedicoRequestCommand) {
        var command = agregarEquipoMedicoRequestCommand.getCommand();
        var cuartoHospitalizacion = CuartoHospitalizacion.from(command.getCuartoHospitalizacionID(),retrieveEvents());
        cuartoHospitalizacion.agregarEquipoMedico(command.getEquipoMedicoID(),command.getTipoDeEquipo(),command.getInstrucion());
        emit().onResponse(new ResponseEvents(cuartoHospitalizacion.getUncommittedChanges()));
    }
}
