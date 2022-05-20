package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.AuxiliarVeterinarioID;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.Funcion;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.PersonalMedicoID;
import co.com.sofka.domain.generic.Command;

public class ActualizarFuncionAuxiliar extends Command {
    private final PersonalMedicoID personalMedicoID;
    private final AuxiliarVeterinarioID entityId;
    private final Funcion funcion;

    public ActualizarFuncionAuxiliar(PersonalMedicoID personalMedicoID, AuxiliarVeterinarioID entityId, Funcion funcion) {
        this.personalMedicoID = personalMedicoID;
        this.entityId = entityId;
        this.funcion = funcion;
    }

    public PersonalMedicoID getPersonalMedicoID() {
        return personalMedicoID;
    }

    public AuxiliarVeterinarioID getEntityId() {
        return entityId;
    }

    public Funcion getFuncion() {
        return funcion;
    }
}
