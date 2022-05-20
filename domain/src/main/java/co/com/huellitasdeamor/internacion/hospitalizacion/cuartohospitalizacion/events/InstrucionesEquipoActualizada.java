package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.events;

import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.EquipoMedicoID;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.Instrucion;
import co.com.sofka.domain.generic.DomainEvent;

public class InstrucionesEquipoActualizada extends DomainEvent {
    private final EquipoMedicoID equipoMedicoID;
    private final Instrucion instrucion;

    public InstrucionesEquipoActualizada(EquipoMedicoID equipoMedicoID, Instrucion instrucion) {
        super("huellitadeamor.cuartohospitalizacion.instrucionesequipoactualizadas");
        this.equipoMedicoID = equipoMedicoID;
        this.instrucion = instrucion;
    }

    public EquipoMedicoID getEquipoMedicoID() {
        return equipoMedicoID;
    }

    public Instrucion getInstrucion() {
        return instrucion;
    }
}
