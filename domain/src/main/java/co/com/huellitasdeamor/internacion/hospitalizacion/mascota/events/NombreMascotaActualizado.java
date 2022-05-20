package co.com.huellitasdeamor.internacion.hospitalizacion.mascota.events;

import co.com.huellitasdeamor.internacion.generico.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public class NombreMascotaActualizado extends DomainEvent {
    private final Nombre nombreMascota;
    public NombreMascotaActualizado(Nombre nombreMascota) {
        super("");
        this.nombreMascota=nombreMascota;
    }

    public Nombre getNombreMascota() {
        return nombreMascota;
    }
}
