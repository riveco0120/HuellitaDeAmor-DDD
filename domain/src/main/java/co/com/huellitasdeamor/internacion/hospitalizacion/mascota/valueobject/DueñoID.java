package co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject;

import co.com.sofka.domain.generic.Identity;

public class DueñoID extends Identity {

    public DueñoID(String id) {
        super(id);
    }

    public static DueñoID of(String id) {

        return new DueñoID(id);
    }
}