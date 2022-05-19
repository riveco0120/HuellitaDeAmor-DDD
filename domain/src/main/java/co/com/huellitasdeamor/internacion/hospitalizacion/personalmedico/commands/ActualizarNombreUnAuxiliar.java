package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.AuxiliarVeterinarioID;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.Nombre;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.PersonalMedicoID;
import co.com.sofka.domain.generic.Command;

public class ActualizarNombreUnAuxiliar extends Command {
    private final PersonalMedicoID personalMedicoID;
    private final AuxiliarVeterinarioID entityId;
    private final Nombre nombre;


    public ActualizarNombreUnAuxiliar(PersonalMedicoID personalMedicoID, AuxiliarVeterinarioID entityId, Nombre nombre) {
        this.personalMedicoID = personalMedicoID;
        this.entityId = entityId;
        this.nombre = nombre;
    }

    public PersonalMedicoID getPersonalMedicoID() {
        return personalMedicoID;
    }

    public AuxiliarVeterinarioID getEntityId() {
        return entityId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
