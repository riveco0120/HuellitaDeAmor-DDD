package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.events;

import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public class NombreVeterinarioActualizado extends DomainEvent {
    private final Nombre nombre;

    public NombreVeterinarioActualizado(Nombre nombre) {
        super("huellitadeamor.personalmedico.nombreVeterinarioActualizado");
        this.nombre = nombre;
    }


    public Nombre getNombre() {
        return nombre;
    }

}
