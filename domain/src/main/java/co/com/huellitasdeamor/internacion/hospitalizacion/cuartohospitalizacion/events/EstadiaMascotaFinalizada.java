package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.events;

import co.com.huellitasdeamor.internacion.generico.ValoracionMascota;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.MascotaID;
import co.com.sofka.domain.generic.DomainEvent;

public class EstadiaMascotaFinalizada extends DomainEvent {

    private final ValoracionMascota valoracionMascota;
    private final MascotaID mascotaID;


    public EstadiaMascotaFinalizada(ValoracionMascota valoracionMascota,MascotaID mascotaID) {
        super("huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion");
        this.valoracionMascota=valoracionMascota;
        this.mascotaID  = mascotaID;
    }

    public ValoracionMascota getValoracionMascota() {
        return valoracionMascota;
    }

    public MascotaID getMascotaID() {
        return mascotaID;
    }
}
