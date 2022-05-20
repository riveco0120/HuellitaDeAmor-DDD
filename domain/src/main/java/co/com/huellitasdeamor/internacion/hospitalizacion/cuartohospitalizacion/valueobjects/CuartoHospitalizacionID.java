package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects;

import co.com.sofka.domain.generic.Identity;

public class CuartoHospitalizacionID extends Identity {

    public CuartoHospitalizacionID(String id) {
        super(id);
    }

    public static CuartoHospitalizacionID of(String id) {

        return new CuartoHospitalizacionID(id);
    }
}
