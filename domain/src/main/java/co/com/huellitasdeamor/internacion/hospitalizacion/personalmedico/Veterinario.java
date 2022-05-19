package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico;

import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.Especialidad;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.Nombre;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.VeterinarioID;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Veterinario extends Entity<VeterinarioID> {
    private  Nombre nombre;
    private  Especialidad especialidad;
    public Veterinario(VeterinarioID entityId, Nombre nombre, Especialidad especialidad) {
        super(entityId);
        this.nombre=nombre;
        this.especialidad=especialidad;
    }

    //Comportamiento para actualizar una especialidad

    public void actualizarEspecialidad(Especialidad especialidad){
        this.especialidad= Objects.requireNonNull(especialidad);
    }

    //Comportamiento para actualizar nombre del veterinario
    public void actualizarNombreVeterinario(Nombre nombre){
        this.nombre = Objects.requireNonNull(nombre);
    }

    public Nombre nombre() {
        return nombre;
    }

    public Especialidad especialidad() {
        return especialidad;
    }
}
