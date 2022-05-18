package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico;

import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.Especialidad;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.Nombre;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.VeterinarioID;
import co.com.sofka.domain.generic.Entity;

public class Veterinario extends Entity<VeterinarioID> {
    private final Nombre nombre;
    private final Especialidad especialidad;
    public Veterinario(VeterinarioID entityId, Nombre nombre, Especialidad especialidad) {
        super(entityId);
        this.nombre=nombre;
        this.especialidad=especialidad;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Especialidad especialidad() {
        return especialidad;
    }
}
