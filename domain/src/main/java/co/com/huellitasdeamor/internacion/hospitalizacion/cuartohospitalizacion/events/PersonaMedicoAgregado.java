package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.events;

import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.PersonalMedicoID;
import co.com.sofka.domain.generic.DomainEvent;

public class PersonaMedicoAgregado extends DomainEvent {

    private final PersonalMedicoID personalMedicoID;

    public PersonaMedicoAgregado(PersonalMedicoID personalMedicoID) {
        super("huellitadeamor.cuartohospitalizacion.personalmedicoagregado");
        this.personalMedicoID=personalMedicoID;
    }

    public PersonalMedicoID getPersonalMedicoID() {
        return personalMedicoID;
    }
}
