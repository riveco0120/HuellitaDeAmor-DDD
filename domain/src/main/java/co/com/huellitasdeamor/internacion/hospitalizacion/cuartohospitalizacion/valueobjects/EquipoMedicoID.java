package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects;

import co.com.sofka.domain.generic.Identity;

public class EquipoMedicoID extends Identity {

    public EquipoMedicoID(String id) {
        super(id);
    }

    public static EquipoMedicoID of(String id) {

        return new EquipoMedicoID(id);
    }
}
