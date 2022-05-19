package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.PersonalMedico;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.commands.EliminarAuxiliarVeterinario;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class EliminarAuxiliarVeterinarioUseCase extends UseCase<RequestCommand<EliminarAuxiliarVeterinario>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<EliminarAuxiliarVeterinario> eliminarAuxiliarVeterinarioRequestCommand) {
        var comman = eliminarAuxiliarVeterinarioRequestCommand.getCommand();
        var personalMedico = PersonalMedico.from(comman.getPersonalMedicoID(),retrieveEvents());
        personalMedico.eliminarAuxiliarVeterinario(comman.getEntityId());
        emit().onResponse(new ResponseEvents(personalMedico.getUncommittedChanges()));
    }

}
