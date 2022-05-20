package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.CuartoHospitalizacionID;
import co.com.huellitasdeamor.internacion.generico.ValoracionMascota;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.MascotaID;
import co.com.sofka.domain.generic.Command;

public class FinalizarEstadiaMascota extends Command {
    private final CuartoHospitalizacionID cuartoHospitalizacionID;
    private final MascotaID mascotaID;

    public FinalizarEstadiaMascota(CuartoHospitalizacionID cuartoHospitalizacionID, MascotaID mascotaID) {
        this.cuartoHospitalizacionID = cuartoHospitalizacionID;
        this.mascotaID = mascotaID;
    }

    public CuartoHospitalizacionID getCuartoHospitalizacionID() {
        return cuartoHospitalizacionID;
    }

    public MascotaID getMascotaID() {
        return mascotaID;
    }
}
