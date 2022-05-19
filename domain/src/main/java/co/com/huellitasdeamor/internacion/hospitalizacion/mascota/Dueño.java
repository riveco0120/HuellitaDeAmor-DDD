package co.com.huellitasdeamor.internacion.hospitalizacion.mascota;

import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.Direccion;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.DueñoID;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.NombreDueño;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.Telefono;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Dueño extends Entity<DueñoID> {

    private NombreDueño nombreDueño;
    private Direccion direccion;
    private Telefono telefono;

    public Dueño(DueñoID entityId, NombreDueño nombreDueño, Direccion direccion,Telefono telefono) {
        super(entityId);
        this.nombreDueño=nombreDueño;
        this.direccion=direccion;
        this.telefono=telefono;
    }

    //Comportamiento para actualizar Nombre
    public void actualizarNombreDueño(NombreDueño nombreDueño){
        this.nombreDueño = Objects.requireNonNull(nombreDueño);
    }
    //Comportamiento para actualizar Direccion
    public void actualizarDireccion(Direccion direccion){
        this.direccion=Objects.requireNonNull(direccion);
    }
    //Comportamiento para actualizar Telefono
    public void actualizarTelefono(Telefono telefono){
        this.telefono = Objects.requireNonNull(telefono);
    }

    public NombreDueño getNombreDueño() {
        return nombreDueño;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
