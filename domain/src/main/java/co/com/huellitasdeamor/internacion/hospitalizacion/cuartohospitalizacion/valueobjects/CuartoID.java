package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects;

import co.com.sofka.domain.generic.Identity;

public class CuartoID extends Identity {

    public CuartoID(String id) {
        super(id);
    }

    public static CuartoID of(String id) {

        return new CuartoID(id);
    }
}
