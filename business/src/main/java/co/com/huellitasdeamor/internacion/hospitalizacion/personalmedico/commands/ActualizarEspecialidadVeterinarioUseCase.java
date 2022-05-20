package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.PersonalMedico;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarEspecialidadVeterinarioUseCase extends UseCase<RequestCommand<ActualizarEspecialidadVeterinario>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarEspecialidadVeterinario> actualizarEspecialidadVeterinarioRequestCommand) {
        var command = actualizarEspecialidadVeterinarioRequestCommand.getCommand();
        var persolamedico = PersonalMedico.from(command.getPersonalMedicoID(),retrieveEvents(command.getPersonalMedicoID().value()));
        persolamedico.actualizarEspecialidadVeterinario(command.getEspecialidad());
        emit().onResponse(new ResponseEvents(persolamedico.getUncommittedChanges()));
    }
}
