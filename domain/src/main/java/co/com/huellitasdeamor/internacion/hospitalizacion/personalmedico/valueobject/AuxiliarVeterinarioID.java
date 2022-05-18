package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject;

import co.com.sofka.domain.generic.Identity;

public class AuxiliarVeterinarioID extends Identity {

    public AuxiliarVeterinarioID(String id){
        super(id);
    }
    public static AuxiliarVeterinarioID of(String id) {
        return new AuxiliarVeterinarioID(id);
    }
}
