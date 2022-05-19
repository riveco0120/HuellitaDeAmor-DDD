package co.com.huellitasdeamor.internacion.hospitalizacion.mascota.events;

import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.DescripcionOrden;
import co.com.sofka.domain.generic.DomainEvent;

public class DescripcionOrdenActualizada extends DomainEvent {

    private final DescripcionOrden descripcionOrden;
    public DescripcionOrdenActualizada(DescripcionOrden descripcionOrden) {
        super("");
        this.descripcionOrden=descripcionOrden;
    }

    public DescripcionOrden getDescripcionOrden() {
        return descripcionOrden;
    }
}
