package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.events;

import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.AuxiliarVeterinarioID;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.Funcion;
import co.com.sofka.domain.generic.DomainEvent;


public class FuncionDeAuxiliarAlctualizado  extends DomainEvent {

    private final AuxiliarVeterinarioID auxiliarVeterinarioID;
    private final Funcion funcion;

    public FuncionDeAuxiliarAlctualizado(AuxiliarVeterinarioID auxiliarVeterinarioID, Funcion funcion) {
        super("huellitadeamor.personalmedico.funcionauxiliaracualizada");
        this.auxiliarVeterinarioID = auxiliarVeterinarioID;
        this.funcion = funcion;
    }

    public AuxiliarVeterinarioID getAuxiliarVeterinarioID() {
        return auxiliarVeterinarioID;
    }

    public Funcion getFuncion() {
        return funcion;
    }
}
