package co.com.huellitasdeamor.internacion.hospitalizacion.mascota.events;

import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.NombreMascota;
import co.com.sofka.domain.generic.DomainEvent;

public class NombreMascotaActualizado extends DomainEvent {
    private final NombreMascota nombreMascota;
    public NombreMascotaActualizado(NombreMascota nombreMascota) {
        super("");
        this.nombreMascota=nombreMascota;
    }

    public NombreMascota getNombreMascota() {
        return nombreMascota;
    }
}
