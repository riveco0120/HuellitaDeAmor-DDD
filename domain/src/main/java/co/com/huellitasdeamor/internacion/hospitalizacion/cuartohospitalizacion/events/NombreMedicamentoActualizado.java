package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.events;

import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.MedicamentoID;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.NombreMedicamento;
import co.com.sofka.domain.generic.DomainEvent;

public class NombreMedicamentoActualizado extends DomainEvent {
    private final MedicamentoID medicamentoID;
    private final NombreMedicamento nombreMedicamento;

    public NombreMedicamentoActualizado(MedicamentoID medicamentoID, NombreMedicamento nombreMedicamento) {
        super("huellitadeamor.cuartohospitalizacion.nombremedicamentoactualizado");
        this.medicamentoID = medicamentoID;
        this.nombreMedicamento = nombreMedicamento;
    }

    public MedicamentoID getMedicamentoID() {
        return medicamentoID;
    }

    public NombreMedicamento getNombreMedicamento() {
        return nombreMedicamento;
    }
}
