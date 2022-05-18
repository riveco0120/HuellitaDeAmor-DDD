package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject;

import co.com.sofka.domain.generic.Identity;

public class VeterinarioID extends Identity {

    public VeterinarioID(String id){
        super(id);
    }
    public static VeterinarioID of(String id) {
        return new VeterinarioID(id);
    }
}
