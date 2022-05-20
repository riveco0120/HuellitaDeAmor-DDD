package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.events;


import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.NivelDeRiesgo;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.MascotaID;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.PersonalMedico;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.PersonalMedicoID;
import co.com.sofka.domain.generic.DomainEvent;

public class CuartoHospitalizacionCreado extends DomainEvent {

    private final NivelDeRiesgo nivelDeRiesgo;
    private final MascotaID mascotaID;
    private final PersonalMedicoID personalMedicoID;

    public CuartoHospitalizacionCreado(NivelDeRiesgo nivelDeRiesgo, MascotaID mascotaID, PersonalMedicoID personalMedicoID) {
        super("hullitadeamor.cuartohospitalizacion.cuartohospitalizacioncreado");
        this.nivelDeRiesgo=nivelDeRiesgo;
        this.mascotaID = mascotaID;
        this.personalMedicoID=personalMedicoID;
    }

    public NivelDeRiesgo getNivelDeRiesgo() {
        return nivelDeRiesgo;
    }

    public MascotaID getMascotaID() {
        return mascotaID;
    }

    public PersonalMedicoID getPersonalMedicoID() {
        return personalMedicoID;
    }
}