package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.events;

import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.MascotaID;
import co.com.sofka.domain.generic.DomainEvent;

public class MascotaAgregada extends DomainEvent {
    private final MascotaID mascotaID;
    public MascotaAgregada(MascotaID mascotaID) {
        super("huellitadeamor.cuartpohospitalizacion.mascotaagregada");
        this.mascotaID=mascotaID;
    }

    public MascotaID getMascotaID() {
        return mascotaID;
    }
}
