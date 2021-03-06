package co.com.huellitasdeamor.internacion.hospitalizacion.mascota.commands;

import co.com.huellitasdeamor.internacion.generico.Nombre;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.*;
import co.com.sofka.domain.generic.Command;

public class AgregarDueño extends Command {
    private final MascotaID mascotaID;
    private final DueñoID dueñoID;
    private final Nombre nombreDueño;
    private final Direccion direccion;
    private final Telefono telefono;

    public AgregarDueño(MascotaID mascotaID, DueñoID dueñoID, Nombre nombreDueño, Direccion direccion, Telefono telefono) {
        this.mascotaID = mascotaID;
        this.dueñoID = dueñoID;
        this.nombreDueño = nombreDueño;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public MascotaID getMascotaID() {
        return mascotaID;
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
