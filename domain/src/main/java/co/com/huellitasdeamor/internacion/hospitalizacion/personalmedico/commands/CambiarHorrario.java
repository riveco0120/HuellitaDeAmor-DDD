package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.Horrario;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.PersonalMedicoID;
import co.com.sofka.domain.generic.Command;

public class CambiarHorrario extends Command {
    private final PersonalMedicoID personalMedicoID;
    private final Horrario horrario;

    public CambiarHorrario(PersonalMedicoID personalMedicoID, Horrario horrario) {
        this.personalMedicoID = personalMedicoID;
        this.horrario = horrario;
    }

    public PersonalMedicoID getPersonalMedicoID() {
        return personalMedicoID;
    }

    public Horrario getHorrario() {
        return horrario;
    }
}
