package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.events;

import co.com.huellitasdeamor.internacion.generico.HorrarioPersonaMedico;
import co.com.sofka.domain.generic.DomainEvent;

public class PersonalMedicoCreado extends DomainEvent {

    private final HorrarioPersonaMedico horrario;

    public PersonalMedicoCreado(HorrarioPersonaMedico horrario){
        super("co.com.huellitasdeamor.internacion.hospitalizacion.personalmedicocreado");

        this.horrario = horrario;
    }

    public HorrarioPersonaMedico getHorrario() {
        return horrario;
    }
}
