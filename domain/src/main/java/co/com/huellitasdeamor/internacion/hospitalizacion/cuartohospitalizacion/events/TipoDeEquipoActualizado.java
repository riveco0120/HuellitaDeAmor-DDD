package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.events;

import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.EquipoMedicoID;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.TipoDeEquipo;
import co.com.sofka.domain.generic.DomainEvent;

public class TipoDeEquipoActualizado extends DomainEvent {
    private final EquipoMedicoID equipoMedicoID;
    private final TipoDeEquipo tipoDeEquipo;

    public TipoDeEquipoActualizado(EquipoMedicoID equipoMedicoID, TipoDeEquipo tipoDeEquipo) {
        super("huellitadeamor.cuartohospitalizacion.tipodeequipoactualizadas");
        this.equipoMedicoID = equipoMedicoID;
        this.tipoDeEquipo = tipoDeEquipo;
    }

    public EquipoMedicoID getEquipoMedicoID() {
        return equipoMedicoID;
    }

    public TipoDeEquipo getTipoDeEquipo() {
        return tipoDeEquipo;
    }
}
