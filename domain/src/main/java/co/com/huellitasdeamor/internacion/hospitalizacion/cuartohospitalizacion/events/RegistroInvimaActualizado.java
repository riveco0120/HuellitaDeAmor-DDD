package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.events;

import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.MedicamentoID;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.RegistroInvima;
import co.com.sofka.domain.generic.DomainEvent;

public class RegistroInvimaActualizado extends DomainEvent {
    private final MedicamentoID medicamentoID;
    private final RegistroInvima registroInvima;

    public RegistroInvimaActualizado(MedicamentoID medicamentoID, RegistroInvima registroInvima) {
        super("huellitadeamor.cuartohospitalizacion.registroinvimaactualizado");
        this.medicamentoID = medicamentoID;
        this.registroInvima = registroInvima;
    }

    public MedicamentoID getMedicamentoID() {
        return medicamentoID;
    }

    public RegistroInvima getRegistroInvima() {
        return registroInvima;
    }
}