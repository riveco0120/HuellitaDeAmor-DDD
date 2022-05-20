package co.com.huellitasdeamor.internacion.hospitalizacion.mascota;

import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.Especie;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.MascotaID;
import co.com.sofka.domain.generic.Command;

public class ActualizarEspecie extends Command {
    private final MascotaID mascotaID;
    private final Especie especie;

    public ActualizarEspecie(MascotaID mascotaID, Especie especie) {
        this.mascotaID = mascotaID;
        this.especie = especie;
    }

    public MascotaID getMascotaID() {
        return mascotaID;
    }

    public Especie getEspecie() {
        return especie;
    }
}
