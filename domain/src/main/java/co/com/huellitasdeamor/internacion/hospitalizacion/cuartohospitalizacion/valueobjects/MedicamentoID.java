package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects;

import co.com.sofka.domain.generic.Identity;

public class MedicamentoID  extends Identity {

    public MedicamentoID(String id) {
        super(id);
    }

    public static MedicamentoID of(String id) {

        return new MedicamentoID(id);
    }
}
