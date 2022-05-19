package co.com.huellitasdeamor.internacion.hospitalizacion.mascota.events;

import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.NombreDueño;
import co.com.sofka.domain.generic.DomainEvent;

public class NombreDueñoActualizado extends DomainEvent {

    private final NombreDueño nombreDueño;

    public NombreDueñoActualizado(NombreDueño nombreDueño) {
        super("");
        this.nombreDueño = nombreDueño;
    }

    public NombreDueño getNombreDueño() {
        return nombreDueño;
    }
}
