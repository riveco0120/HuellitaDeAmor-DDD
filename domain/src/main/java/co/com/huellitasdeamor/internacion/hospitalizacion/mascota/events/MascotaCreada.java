package co.com.huellitasdeamor.internacion.hospitalizacion.mascota.events;

import co.com.huellitasdeamor.internacion.generico.Nombre;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.Especie;
import co.com.sofka.domain.generic.DomainEvent;

public class MascotaCreada extends DomainEvent {

    private final Nombre nombreMascota;
    private final Especie especie;

    public MascotaCreada(Nombre nombreMascota,Especie especie){
        super("hullitadeamor.mascota.mascotacreada");
        this.nombreMascota = nombreMascota;
        this.especie = especie;
    }

    public Nombre getNombreMascota() {
        return nombreMascota;
    }

    public Especie getEspecie() {
        return especie;
    }
}
