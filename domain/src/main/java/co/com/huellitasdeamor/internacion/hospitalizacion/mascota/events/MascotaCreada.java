package co.com.huellitasdeamor.internacion.hospitalizacion.mascota.events;

import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.Especie;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.NombreMascota;
import co.com.sofka.domain.generic.DomainEvent;

public class MascotaCreada extends DomainEvent {

    private final NombreMascota nombreMascota;
    private final Especie especie;

    public MascotaCreada(NombreMascota nombreMascota,Especie especie){
        super("hullitadeamor.mascota.mascotacreada");
        this.nombreMascota = nombreMascota;
        this.especie = especie;
    }

    public NombreMascota getNombreMascota() {
        return nombreMascota;
    }

    public Especie getEspecie() {
        return especie;
    }
}
