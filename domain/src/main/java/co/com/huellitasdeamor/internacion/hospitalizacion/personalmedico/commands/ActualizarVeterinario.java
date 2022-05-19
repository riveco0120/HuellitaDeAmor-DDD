package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.Especialidad;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.Nombre;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.PersonalMedicoID;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.VeterinarioID;
import co.com.sofka.domain.generic.Command;

public class ActualizarVeterinario extends Command {
    private final PersonalMedicoID personalMedicoID;
    private final VeterinarioID entityId;
    private final Nombre nombre;
    private final Especialidad especialidad;


    public ActualizarVeterinario(PersonalMedicoID personalMedicoID, VeterinarioID entityId, Nombre nombre, Especialidad especialidad) {
        this.personalMedicoID = personalMedicoID;
        this.entityId = entityId;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public PersonalMedicoID getPersonalMedicoID() {
        return personalMedicoID;
    }

    public VeterinarioID getEntityId() {
        return entityId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }
}
