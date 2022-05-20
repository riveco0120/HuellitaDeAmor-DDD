package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.CuartoHospitalizacionID;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.NivelDeRiesgo;
import co.com.sofka.domain.generic.Command;

public class CrearCuartoHospitalizacion extends Command {
    private final CuartoHospitalizacionID cuartoHospitalizacionID;
    private final NivelDeRiesgo nivelDeRiesgo;

    public CrearCuartoHospitalizacion(CuartoHospitalizacionID cuartoHospitalizacionID, NivelDeRiesgo nivelDeRiesgo) {
        this.cuartoHospitalizacionID = cuartoHospitalizacionID;
        this.nivelDeRiesgo = nivelDeRiesgo;
    }

    public CuartoHospitalizacionID getCuartoHospitalizacionID() {
        return cuartoHospitalizacionID;
    }

    public NivelDeRiesgo getNivelDeRiesgo() {
        return nivelDeRiesgo;
    }
}