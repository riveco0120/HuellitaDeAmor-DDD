package co.com.huellitasdeamor.internacion.hospitalizacion.mascota;

import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.events.MascotaCreada;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.Especie;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.MascotaID;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.NombreMascota;
import co.com.sofka.domain.generic.AggregateEvent;

import java.util.Objects;

public class Mascota extends AggregateEvent<MascotaID> {

    protected OrdenMedica ordenMedica;
    protected Dueño dueño;
    protected Especie especie;
    protected NombreMascota nombreMascota;

    public Mascota(MascotaID entityId,NombreMascota nombreMascota,Especie especie) {
        super(entityId);
        Objects.requireNonNull(nombreMascota);
        Objects.requireNonNull(especie);
        appendChange(new MascotaCreada(nombreMascota,especie)).apply();
    }
}
