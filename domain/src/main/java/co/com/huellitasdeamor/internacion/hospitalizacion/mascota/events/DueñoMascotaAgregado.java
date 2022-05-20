package co.com.huellitasdeamor.internacion.hospitalizacion.mascota.events;

import co.com.huellitasdeamor.internacion.generico.Nombre;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.Direccion;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.DueñoID;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.Telefono;
import co.com.sofka.domain.generic.DomainEvent;

public class DueñoMascotaAgregado extends DomainEvent {
    private final DueñoID dueñoID;
    private final Nombre nombreDueño;
    private final Direccion direccion;
    private final Telefono telefono;

    public DueñoMascotaAgregado(DueñoID dueñoID, Nombre nombreDueño, Direccion direccion, Telefono telefono){
        super("huellitadeamor.mascota.dueñomascotaagregado");
        this.dueñoID=dueñoID;
        this.nombreDueño=nombreDueño;
        this.direccion=direccion;
        this.telefono=telefono;
    }

    public DueñoID getDueñoID() {
        return dueñoID;
    }

    public Nombre getNombreDueño() {
        return nombreDueño;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
