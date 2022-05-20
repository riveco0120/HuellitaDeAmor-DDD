package co.com.huellitasdeamor.internacion.hospitalizacion.mascota;

import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.MascotaID;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.NombreDueño;
import co.com.sofka.domain.generic.Command;

public class ActualizarNombreDueño extends Command {
    private final MascotaID mascotaID;
    private final NombreDueño nombreDueño;

    public ActualizarNombreDueño(MascotaID mascotaID, NombreDueño nombreDueño) {
        this.mascotaID = mascotaID;
        this.nombreDueño = nombreDueño;
    }

    public MascotaID getMascotaID() {
        return mascotaID;
    }

    public NombreDueño getNombreDueño() {
        return nombreDueño;
    }
}
