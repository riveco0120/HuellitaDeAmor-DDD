package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.events;

import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.EquipoMedicoID;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.Instrucion;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.TipoDeEquipo;
import co.com.sofka.domain.generic.DomainEvent;

public class EquipoMedicoAgregado extends DomainEvent {


    private final EquipoMedicoID equipoMedicoID;
    private final TipoDeEquipo tipoDeEquipo;
    private final Instrucion instrucion;
    public EquipoMedicoAgregado(EquipoMedicoID equipoMedicoID,TipoDeEquipo tipoDeEquipo,Instrucion instrucion) {
        super("huellitadeamor.cuartohospitalizacion.equipomedicoagregado");
        this.equipoMedicoID=equipoMedicoID;
        this.tipoDeEquipo=tipoDeEquipo;
        this.instrucion=instrucion;
    }

    public EquipoMedicoID getEquipoMedicoID() {
        return equipoMedicoID;
    }

    public TipoDeEquipo getTipoDeEquipo() {
        return tipoDeEquipo;
    }

    public Instrucion getInstrucion() {
        return instrucion;
    }
}
