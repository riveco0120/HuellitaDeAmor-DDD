package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.events;

import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.EquipoMedicoID;
import co.com.sofka.domain.generic.DomainEvent;

public class EquipoMedicoEliminado extends DomainEvent {
    private final EquipoMedicoID equipoMedicoID;

    public EquipoMedicoEliminado(EquipoMedicoID equipoMedicoID) {
        super("huellitadeamor.cuartohospitalizacion.equipomedicoeliminado");
        this.equipoMedicoID = equipoMedicoID;
    }

    public EquipoMedicoID getEquipoMedicoID() {
        return equipoMedicoID;
    }
}
