package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.events;

import co.com.huellitasdeamor.internacion.generico.Nombre;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.MedicamentoID;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.RegistroInvima;
import co.com.sofka.domain.generic.DomainEvent;

public class MedicametoAgregado extends DomainEvent {

    private final MedicamentoID medicamentoID;
    private final Nombre nombreMedicamento;
    private final RegistroInvima registroInvima;
    public MedicametoAgregado(MedicamentoID medicamentoID, Nombre nombreMedicamento, RegistroInvima registroInvima) {
        super("Huellitadeamor.cuartodehospitalizacin.medicamentoagregado");
        this.medicamentoID=medicamentoID;
        this.nombreMedicamento = nombreMedicamento;
        this.registroInvima=registroInvima;
    }

    public MedicamentoID getMedicamentoID() {
        return medicamentoID;
    }

    public Nombre getNombreMedicamento() {
        return nombreMedicamento;
    }

    public RegistroInvima getRegistroInvima() {
        return registroInvima;
    }
}
