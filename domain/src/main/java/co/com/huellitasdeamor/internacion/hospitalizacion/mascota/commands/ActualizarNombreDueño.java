package co.com.huellitasdeamor.internacion.hospitalizacion.mascota.commands;

import co.com.huellitasdeamor.internacion.generico.Nombre;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.MascotaID;
import co.com.sofka.domain.generic.Command;

public class ActualizarNombreDueño extends Command {
    private final MascotaID mascotaID;
    private final Nombre nombreDueño;

    public ActualizarNombreDueño(MascotaID mascotaID, Nombre nombreDueño) {
        this.mascotaID = mascotaID;
        this.nombreDueño = nombreDueño;
    }

    public MascotaID getMascotaID() {
        return mascotaID;
    }

    public Nombre getNombreDueño() {
        return nombreDueño;
    }
}
