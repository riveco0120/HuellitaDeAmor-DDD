package co.com.huellitasdeamor.internacion.hospitalizacion.mascota.commands;

import co.com.huellitasdeamor.internacion.generico.Nombre;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.Especie;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.MascotaID;
import co.com.sofka.domain.generic.Command;

public class CrearMascota extends Command {
    private final MascotaID mascotaID;
    private final Nombre nombreMascota;
    private final Especie especie;

    public CrearMascota(MascotaID mascotaID, Nombre nombreMascota, Especie especie) {
        this.mascotaID = mascotaID;
        this.nombreMascota = nombreMascota;
        this.especie = especie;
    }

    public MascotaID getMascotaID() {
        return mascotaID;
    }

    public Nombre getNombreMascota() {
        return nombreMascota;
    }

    public Especie getEspecie() {
        return especie;
    }
}
