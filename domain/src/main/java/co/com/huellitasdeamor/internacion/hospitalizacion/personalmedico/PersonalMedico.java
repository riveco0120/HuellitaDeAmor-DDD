package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico;

import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.Horrario;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.PersonalMedicoID;
import co.com.sofka.domain.generic.AggregateEvent;

public class PersonalMedico extends AggregateEvent<PersonalMedicoID> {

    Horrario horrario;

    public PersonalMedico(PersonalMedicoID entityId, Horrario horrario) {
        super(entityId);
    }
}
