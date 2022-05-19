package co.com.huellitasdeamor.internacion.hospitalizacion.mascota.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.MascotaID;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.NombreMascota;
import co.com.sofka.domain.generic.Command;

public class ActualizarNombreMascota extends Command {
    private final MascotaID mascotaID;
    private final NombreMascota nombreMascota;


    public ActualizarNombreMascota(MascotaID mascotaID, NombreMascota nombreMascota) {
        this.mascotaID = mascotaID;
        this.nombreMascota = nombreMascota;
    }

    public MascotaID getMascotaID() {
        return mascotaID;
    }

    public NombreMascota getNombreMascota() {
        return nombreMascota;
    }
}
