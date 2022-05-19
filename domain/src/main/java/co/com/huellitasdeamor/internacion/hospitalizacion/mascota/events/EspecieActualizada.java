package co.com.huellitasdeamor.internacion.hospitalizacion.mascota.events;

import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.Especie;
import co.com.sofka.domain.generic.DomainEvent;

public class EspecieActualizada extends DomainEvent {

    private final Especie especie;
    public EspecieActualizada(Especie especie) {
        super("");
        this.especie=especie;
    }

    public Especie getEspecie() {
        return especie;
    }
}
