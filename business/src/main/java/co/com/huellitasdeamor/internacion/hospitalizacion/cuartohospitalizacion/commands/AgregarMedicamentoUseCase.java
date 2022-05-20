package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.CuartoHospitalizacion;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarMedicamentoUseCase extends UseCase<RequestCommand<AgregarMedicamento>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarMedicamento> agregarMedicamentoRequestCommand) {
        var command = agregarMedicamentoRequestCommand.getCommand();
        var cuarto = CuartoHospitalizacion.from(command.getCuartoHospitalizacionID(),retrieveEvents());
        cuarto.agregarMedicamento(command.getMedicamentoID(),command.getNombreMedicamento(),command.getRegistroInvima());
        emit().onResponse(new ResponseEvents(cuarto.getUncommittedChanges()));
    }
}
