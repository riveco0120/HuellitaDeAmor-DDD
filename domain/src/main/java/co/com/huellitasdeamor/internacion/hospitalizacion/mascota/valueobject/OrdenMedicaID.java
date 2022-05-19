package co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject;

import co.com.sofka.domain.generic.Identity;

public class OrdenMedicaID extends Identity {

    public OrdenMedicaID(String id) {
        super(id);
    }

    public static OrdenMedicaID of(String id) {

        return new OrdenMedicaID(id);
    }
}
