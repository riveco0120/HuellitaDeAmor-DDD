package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.CuartoHospitalizacionID;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.PersonalMedicoID;
import co.com.sofka.domain.generic.Command;

public class AgregarPersonalMedico extends Command {
    private final CuartoHospitalizacionID cuartoHospitalizacionID;
    private final PersonalMedicoID personalMedicoID;

    public AgregarPersonalMedico(CuartoHospitalizacionID cuartoHospitalizacionID, PersonalMedicoID personalMedicoID) {
        this.cuartoHospitalizacionID = cuartoHospitalizacionID;
        this.personalMedicoID = personalMedicoID;
    }

    public CuartoHospitalizacionID getCuartoHospitalizacionID() {
        return cuartoHospitalizacionID;
    }

    public PersonalMedicoID getPersonalMedicoID() {
        return personalMedicoID;
    }
}
