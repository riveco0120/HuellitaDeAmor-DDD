package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico;

import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.commands.AgregarAuxiliar;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarAuxiliarUseCase extends UseCase<RequestCommand<AgregarAuxiliar>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarAuxiliar> agregarAuxiliarRequestCommand) {
        var command = agregarAuxiliarRequestCommand.getCommand();
        var personalMedico = PersonalMedico.from(command.getPersonalMedicoID(),retrieveEvents(command.getEntityId().value()));
        personalMedico.agregarAuxiliar(command.getEntityId(),command.getNombre(),command.getFuncion());
        emit().onResponse(new ResponseEvents(personalMedico.getUncommittedChanges()));
    }
}
