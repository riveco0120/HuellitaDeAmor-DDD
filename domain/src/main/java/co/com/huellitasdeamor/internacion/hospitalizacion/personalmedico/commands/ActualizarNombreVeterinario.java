package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.commands;

import co.com.huellitasdeamor.internacion.generico.Nombre;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.PersonalMedicoID;
import co.com.sofka.domain.generic.Command;

public class ActualizarNombreVeterinario extends Command {
    private final PersonalMedicoID personalMedicoID;
    private final Nombre nombre;

    public ActualizarNombreVeterinario(PersonalMedicoID personalMedicoID, Nombre nombre) {
        this.personalMedicoID = personalMedicoID;
        this.nombre = nombre;
    }

    public PersonalMedicoID getPersonalMedicoID() {
        return personalMedicoID;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
