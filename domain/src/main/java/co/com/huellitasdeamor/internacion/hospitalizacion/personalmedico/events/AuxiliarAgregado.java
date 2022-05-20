package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.events;

import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.AuxiliarVeterinarioID;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.Funcion;
import co.com.huellitasdeamor.internacion.generico.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public class AuxiliarAgregado extends DomainEvent {

    private final AuxiliarVeterinarioID entityId;
    private final Nombre nombre;
    private final Funcion funcion;

    public AuxiliarAgregado(AuxiliarVeterinarioID entityId, Nombre nombre, Funcion funcion) {
        super("huellitadeamor.personalmedico.auxiliaragregado");
        this.entityId=entityId;
        this.nombre =nombre;
        this.funcion=funcion;
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
