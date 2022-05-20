package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.events;

import co.com.huellitasdeamor.internacion.generico.HorrarioPersonaMedico;
import co.com.huellitasdeamor.internacion.generico.ValoracionMascota;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.PersonalMedicoID;
import co.com.sofka.domain.generic.DomainEvent;

public class TurnoPersonalMedicoFinalizado extends DomainEvent {

    private final HorrarioPersonaMedico horrarioPersonaMedico;
    private final PersonalMedicoID personalMedicoID;

    public TurnoPersonalMedicoFinalizado(HorrarioPersonaMedico horrarioPersonaMedico,PersonalMedicoID personalMedicoID) {
        super("huellitadeamor.cuartohospitalizacion.turnopersonalmedicofinalizado");
        this.horrarioPersonaMedico = horrarioPersonaMedico;
        this.personalMedicoID = personalMedicoID;
    }

    public HorrarioPersonaMedico getHorrarioPersonalMedico() {
        return horrarioPersonaMedico;
    }

    public PersonalMedicoID getPersonalMedicoID() {
        return personalMedicoID;
    }
}