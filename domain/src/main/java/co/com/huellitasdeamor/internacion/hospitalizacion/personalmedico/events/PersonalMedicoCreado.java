package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.events;

import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.Horrario;
import co.com.sofka.domain.generic.DomainEvent;

public class PersonalMedicoCreado extends DomainEvent {

    private final Horrario horrario;

    public PersonalMedicoCreado(Horrario horrario, Horrario horrario1){
        super("hullitadeamor.personalmedico.personalmedicocreado");

        this.horrario = horrario1;
    }

    public Horrario getHorrario() {
        return horrario;
    }
}
