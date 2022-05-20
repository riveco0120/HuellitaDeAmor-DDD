package co.com.huellitasdeamor.internacion.hospitalizacion.mascota.events;

import co.com.huellitasdeamor.internacion.generico.ValoracionMascota;
import co.com.sofka.domain.generic.DomainEvent;

public class ValoracionActualizadad extends DomainEvent {
    private ValoracionMascota valoracion;

    public ValoracionActualizadad(ValoracionMascota valoracion) {
        super("huellitadeamor.mascota.valoracionactualizada");
        this.valoracion = valoracion;
    }

    public ValoracionMascota getValoracion() {
        return valoracion;
    }
}
