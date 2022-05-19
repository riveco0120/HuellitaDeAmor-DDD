package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.events;

import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.Especialidad;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.Nombre;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.VeterinarioID;
import co.com.sofka.domain.generic.DomainEvent;

public class VeterinarioActualizado extends DomainEvent {
    private final VeterinarioID veterinarioID;
    private final Nombre nombre;
    private final Especialidad especialidad;

    public VeterinarioActualizado(VeterinarioID veterinarioID, Nombre nombre, Especialidad especialidad) {
        super("huellitadeamor.personalmedico.veterinarioactualizado");
        this.veterinarioID = veterinarioID;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public VeterinarioID getVeterinarioID() {
        return veterinarioID;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }
}
