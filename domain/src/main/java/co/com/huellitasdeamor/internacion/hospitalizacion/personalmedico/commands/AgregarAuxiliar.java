package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.AuxiliarVeterinarioID;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.Funcion;
import co.com.huellitasdeamor.internacion.generico.Nombre;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.PersonalMedicoID;
import co.com.sofka.domain.generic.Command;

public class AgregarAuxiliar extends Command {
   private final PersonalMedicoID personalMedicoID;
    private final AuxiliarVeterinarioID entityId;
    private final Nombre nombre;
    private final Funcion funcion;

    public AgregarAuxiliar(PersonalMedicoID personalMedicoID,AuxiliarVeterinarioID entityId, Nombre nombre, Funcion funcion) {
        this.personalMedicoID=personalMedicoID;
        this.entityId = entityId;
        this.nombre = nombre;
        this.funcion = funcion;
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

    public Funcion getFuncion() {
        return funcion;
    }
}
