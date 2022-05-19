package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.events;

import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.Horrario;
import co.com.sofka.domain.generic.DomainEvent;

public class HorrarioCambiado extends DomainEvent {

    private final Horrario horrario;


    public HorrarioCambiado(Horrario horrario) {
        super("hullitadeamor.persolamedico.horrariocambiado");
        this.horrario = horrario;
    }

    public Horrario getHorrario() {
        return horrario;
    }
}
