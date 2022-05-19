package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.events;

import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.AuxiliarVeterinarioID;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public class NombreDeAuxiliarAlctualizado extends DomainEvent {
    private final AuxiliarVeterinarioID entityId;
    private final Nombre nombre;
    public NombreDeAuxiliarAlctualizado(AuxiliarVeterinarioID entityId, Nombre nombre){
        super("huellitadeamor.personalmedico.nombreadeauxiliaractualizado");
        this.entityId=entityId;
        this.nombre=nombre;

    }

    public AuxiliarVeterinarioID getEntityId() {
        return entityId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
