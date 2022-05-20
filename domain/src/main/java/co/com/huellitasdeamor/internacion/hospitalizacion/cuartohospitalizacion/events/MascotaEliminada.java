package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.events;

import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.MascotaID;
import co.com.sofka.domain.generic.DomainEvent;

public class MascotaEliminada extends DomainEvent {

    private final MascotaID mascotaID;

    public MascotaEliminada(MascotaID mascotaID) {
        super("huellitadeamor.cuartohospitalizacion.mascotaeliminada");
        this.mascotaID = mascotaID;
    }

    public MascotaID getMascotaID() {
        return mascotaID;
    }
}
