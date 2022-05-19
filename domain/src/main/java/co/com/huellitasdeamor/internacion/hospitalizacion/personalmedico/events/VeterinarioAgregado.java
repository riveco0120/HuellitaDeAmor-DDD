package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.events;

import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.Especialidad;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.Nombre;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.VeterinarioID;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.UUID;

public class VeterinarioAgregado extends DomainEvent {
    private final VeterinarioID entityId;
    private final Nombre nombre;
    private final Especialidad especialidad;
    public VeterinarioAgregado(VeterinarioID entityId, Nombre nombre, Especialidad especialidad) {
        super("hullitadeamor.personalmedico.veterinarioagregado");
        this.entityId=entityId;
        this.nombre=nombre;
        this.especialidad=especialidad;
    }

    public VeterinarioID getEntityId() {
        return entityId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }
}
