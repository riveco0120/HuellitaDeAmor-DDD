package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.PersonalMedico;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearPersonalMedicoUseCase extends UseCase<RequestCommand<CrearPersonalMedico>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearPersonalMedico> crearPersonalMedicoRequestCommand) {
        var comman = crearPersonalMedicoRequestCommand.getCommand();
        var personalMedico= new PersonalMedico(comman.getEntityId(),comman.getHorrario());
        emit().onResponse(new ResponseEvents(personalMedico.getUncommittedChanges()));
    }
}
