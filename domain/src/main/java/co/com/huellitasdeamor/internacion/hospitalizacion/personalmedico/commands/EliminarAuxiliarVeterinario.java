package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.AuxiliarVeterinarioID;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.PersonalMedicoID;
import co.com.sofka.domain.generic.Command;

public class EliminarAuxiliarVeterinario extends Command {
    private final PersonalMedicoID personalMedicoID;
    private final AuxiliarVeterinarioID entityId;

    public EliminarAuxiliarVeterinario(PersonalMedicoID personalMedicoID, AuxiliarVeterinarioID entityId) {
        this.personalMedicoID = personalMedicoID;
        this.entityId = entityId;
    }

    public PersonalMedicoID getPersonalMedicoID() {
        return personalMedicoID;
    }

    public AuxiliarVeterinarioID getEntityId() {
        return entityId;
    }
}
