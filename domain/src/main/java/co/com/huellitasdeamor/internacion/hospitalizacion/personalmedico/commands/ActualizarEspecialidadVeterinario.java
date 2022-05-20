package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.Especialidad;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.PersonalMedicoID;
import co.com.sofka.domain.generic.Command;

public class ActualizarEspecialidadVeterinario extends Command {
    private final PersonalMedicoID personalMedicoID;
    private final Especialidad especialidad;

    public ActualizarEspecialidadVeterinario(PersonalMedicoID personalMedicoID, Especialidad especialidad) {
        this.personalMedicoID = personalMedicoID;
        this.especialidad = especialidad;
    }

    public PersonalMedicoID getPersonalMedicoID() {
        return personalMedicoID;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }
}
