package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.events;

import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.MedicamentoID;
import co.com.sofka.domain.generic.DomainEvent;

public class MedicamentoEliminado extends DomainEvent {
    private final MedicamentoID medicamentoID;

    public MedicamentoEliminado(MedicamentoID medicamentoID) {
        super("huellitadeamor.hospitalizacion.medicamentoeliminado");
        this.medicamentoID = medicamentoID;
    }

    public MedicamentoID getMedicamentoID() {
        return medicamentoID;
    }
}
