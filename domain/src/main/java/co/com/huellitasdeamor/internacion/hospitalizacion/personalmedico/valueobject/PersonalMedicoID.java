package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject;

import co.com.sofka.domain.generic.Identity;

public class PersonalMedicoID extends Identity {

    public PersonalMedicoID(String id) {
        super(id);
    }

    public static PersonalMedicoID of(String id) {

        return new PersonalMedicoID(id);
    }
}
