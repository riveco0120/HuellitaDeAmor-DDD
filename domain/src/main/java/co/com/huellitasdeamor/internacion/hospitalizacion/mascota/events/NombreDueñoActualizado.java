package co.com.huellitasdeamor.internacion.hospitalizacion.mascota.events;

import co.com.huellitasdeamor.internacion.generico.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public class NombreDueñoActualizado extends DomainEvent {

    private final Nombre nombreDueño;

    public NombreDueñoActualizado(Nombre nombreDueño) {
        super("co.com.huellitasdeamor.internacion.hospitalizacion.nombredueñoactualo");
        this.nombreDueño = nombreDueño;
    }

    public Nombre getNombreDueño() {
        return nombreDueño;
    }
}
