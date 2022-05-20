package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico;

import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.AuxiliarVeterinarioID;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.Funcion;
import co.com.huellitasdeamor.internacion.generico.Nombre;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class AuxiliarVeterinario extends Entity<AuxiliarVeterinarioID> {

    private  Nombre nombre;
    private  Funcion funcion;

    public AuxiliarVeterinario(AuxiliarVeterinarioID entityId, Nombre nombre, Funcion funcion) {
        super(entityId);
        this.nombre = nombre;
        this.funcion = funcion;
    }

    //Comportamiento para actualizar una funcion

    public void actualizarFuncion(Funcion funcion) {
        this.funcion = Objects.requireNonNull(funcion);
    }

    //Comportamiento para actualizar nombre del auxiliar veterinario
    public void actualizarNombreAuxiliar(Nombre nombre) {
        this.nombre = Objects.requireNonNull(nombre);
    }

    public Nombre nombre() {
        return nombre;
    }

    public Funcion funcion() {
        return funcion;
    }
}
