package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.PersonalMedico;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.PersonalMedicoID;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarVeterinarioUseCase extends UseCase<RequestCommand<AgregarVeterinario>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarVeterinario> agregarVeterinarioRequestCommand) {
        var command = agregarVeterinarioRequestCommand.getCommand();
        var personalMedico = PersonalMedico.from(command.getPersonalMedicoID(),retrieveEvents());
        personalMedico.agregarVeterinario(command.getEntityId(),command.getNombre(),command.getEspecialidad());
        emit().onResponse(new ResponseEvents(personalMedico.getUncommittedChanges()));
    }
}
