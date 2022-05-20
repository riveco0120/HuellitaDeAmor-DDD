package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.events;

import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.MedicamentoID;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.NombreMedicamento;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.RegistroInvima;
import co.com.sofka.domain.generic.DomainEvent;

public class MedicametoAgregado extends DomainEvent {

    private final MedicamentoID medicamentoID;
    private final NombreMedicamento nombreMedicamento;
    private final RegistroInvima registroInvima;
    public MedicametoAgregado(MedicamentoID medicamentoID, NombreMedicamento nombreMedicamento, RegistroInvima registroInvima) {
        super("Huellitadeamor.cuartodehospitalizacin.medicamentoagregado");
        this.medicamentoID=medicamentoID;
        this.nombreMedicamento = nombreMedicamento;
        this.registroInvima=registroInvima;
    }

    public MedicamentoID getMedicamentoID() {
        return medicamentoID;
    }

    public NombreMedicamento getNombreMedicamento() {
        return nombreMedicamento;
    }

    public RegistroInvima getRegistroInvima() {
        return registroInvima;
    }
}
