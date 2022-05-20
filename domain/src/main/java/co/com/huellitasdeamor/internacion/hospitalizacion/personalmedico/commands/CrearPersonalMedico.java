package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.commands;

import co.com.huellitasdeamor.internacion.generico.HorrarioPersonaMedico;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.PersonalMedicoID;
import co.com.sofka.domain.generic.Command;

public class CrearPersonalMedico extends Command {
    private final PersonalMedicoID entityId;
    private final HorrarioPersonaMedico horrario;

    public CrearPersonalMedico(PersonalMedicoID entityId, HorrarioPersonaMedico horrario) {
        this.entityId = entityId;
        this.horrario = horrario;
    }

    public PersonalMedicoID getEntityId() {
        return entityId;
    }

    public HorrarioPersonaMedico getHorrario() {
        return horrario;
    }
}
