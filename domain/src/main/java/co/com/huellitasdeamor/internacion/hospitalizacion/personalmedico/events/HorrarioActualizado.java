package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.events;

import co.com.huellitasdeamor.internacion.generico.HorrarioPersonaMedico;
import co.com.sofka.domain.generic.DomainEvent;

public class HorrarioActualizado extends DomainEvent {

    private final HorrarioPersonaMedico horrario;


    public HorrarioActualizado(HorrarioPersonaMedico horrario) {
        super("hullitadeamor.persolamedico.horrariocambiado");
        this.horrario = horrario;
    }

    public HorrarioPersonaMedico getHorrario() {
        return horrario;
    }
}
