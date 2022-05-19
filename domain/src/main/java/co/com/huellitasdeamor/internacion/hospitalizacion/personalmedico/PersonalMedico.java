package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico;

import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.events.PersonalMedicoCreado;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.Horrario;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.PersonalMedicoID;
import co.com.sofka.domain.generic.AggregateEvent;

import java.util.Set;

public class PersonalMedico extends AggregateEvent<PersonalMedicoID> {

    protected Horrario horrario;
    protected Veterinario veterinario;
    protected Set<AuxiliarVeterinario> auxiliarVeterinarios;

    public PersonalMedico(PersonalMedicoID entityId, Horrario horrario) {
        super(entityId);
        appendChange(new PersonalMedicoCreado(horrario)).apply();
    }



}
