package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.CuartoHospitalizacionID;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.NivelDeRiesgo;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.MascotaID;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.PersonalMedicoID;
import co.com.sofka.domain.generic.Command;

public class CrearCuartoHospitalizacion extends Command {
    private final CuartoHospitalizacionID cuartoHospitalizacionID;
    private final MascotaID mascotaID;
    private final PersonalMedicoID personalMedicoID;
    private final NivelDeRiesgo nivelDeRiesgo;

    public CrearCuartoHospitalizacion(CuartoHospitalizacionID cuartoHospitalizacionID, MascotaID mascotaID,PersonalMedicoID personalMedicoID, NivelDeRiesgo nivelDeRiesgo) {
        this.cuartoHospitalizacionID = cuartoHospitalizacionID;
        this.nivelDeRiesgo = nivelDeRiesgo;
        this.mascotaID = mascotaID;
        this.personalMedicoID = personalMedicoID;
    }

    public CuartoHospitalizacionID getCuartoHospitalizacionID() {
        return cuartoHospitalizacionID;
    }

    public NivelDeRiesgo getNivelDeRiesgo() {
        return nivelDeRiesgo;
    }

    public MascotaID getMascotaID() {
        return mascotaID;
    }

    public PersonalMedicoID getPersonalMedicoID() {
        return personalMedicoID;
    }
}
