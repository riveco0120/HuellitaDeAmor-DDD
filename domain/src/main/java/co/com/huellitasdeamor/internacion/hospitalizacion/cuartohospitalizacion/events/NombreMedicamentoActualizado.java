package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.events;

import co.com.huellitasdeamor.internacion.generico.Nombre;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.MedicamentoID;
import co.com.sofka.domain.generic.DomainEvent;

public class NombreMedicamentoActualizado extends DomainEvent {
    private final MedicamentoID medicamentoID;
    private final Nombre nombreMedicamento;

    public NombreMedicamentoActualizado(MedicamentoID medicamentoID, Nombre nombreMedicamento) {
        super("huellitadeamor.cuartohospitalizacion.nombremedicamentoactualizado");
        this.medicamentoID = medicamentoID;
        this.nombreMedicamento = nombreMedicamento;
    }

    public MedicamentoID getMedicamentoID() {
        return medicamentoID;
    }

    public Nombre getNombreMedicamento() {
        return nombreMedicamento;
    }
}
