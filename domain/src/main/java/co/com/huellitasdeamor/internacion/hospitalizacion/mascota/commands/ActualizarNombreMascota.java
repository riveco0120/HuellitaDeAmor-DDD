package co.com.huellitasdeamor.internacion.hospitalizacion.mascota.commands;

import co.com.huellitasdeamor.internacion.generico.Nombre;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.MascotaID;
import co.com.sofka.domain.generic.Command;

public class ActualizarNombreMascota extends Command {
    private final MascotaID mascotaID;
    private final Nombre nombreMascota;


    public ActualizarNombreMascota(MascotaID mascotaID, Nombre nombreMascota) {
        this.mascotaID = mascotaID;
        this.nombreMascota = nombreMascota;
    }

    public MascotaID getMascotaID() {
        return mascotaID;
    }

    public Nombre getNombreMascota() {
        return nombreMascota;
    }
}
