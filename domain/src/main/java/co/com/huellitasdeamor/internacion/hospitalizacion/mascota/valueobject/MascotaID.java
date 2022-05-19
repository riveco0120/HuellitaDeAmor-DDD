package co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject;

import co.com.sofka.domain.generic.Identity;

public class MascotaID extends Identity {
    public MascotaID(String id) {
        super(id);
    }

    public static MascotaID of(String id) {

        return new MascotaID(id);
    }
}
