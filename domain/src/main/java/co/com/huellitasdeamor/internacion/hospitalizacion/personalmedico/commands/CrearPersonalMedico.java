package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.Horrario;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.PersonalMedicoID;
import co.com.sofka.domain.generic.Command;

public class CrearPersonalMedico extends Command {
    private final PersonalMedicoID entityId;
    private final Horrario horrario;

    public CrearPersonalMedico(PersonalMedicoID entityId, Horrario horrario) {
        this.entityId = entityId;
        this.horrario = horrario;
    }

    public PersonalMedicoID getEntityId() {
        return entityId;
    }

    public Horrario getHorrario() {
        return horrario;
    }
}
