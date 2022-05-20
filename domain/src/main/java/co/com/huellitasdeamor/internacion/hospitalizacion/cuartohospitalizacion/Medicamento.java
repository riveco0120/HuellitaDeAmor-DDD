package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion;

import co.com.huellitasdeamor.internacion.generico.Nombre;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.*;
import co.com.sofka.domain.generic.Entity;


public class Medicamento extends Entity<MedicamentoID> {
    protected Nombre nombreMedicamento;
    protected RegistroInvima registroInvima;

    public Medicamento(MedicamentoID entityId, Nombre nombreMedicamento, RegistroInvima registroInvima) {
        super(entityId);
        this.nombreMedicamento = nombreMedicamento;
        this.registroInvima = registroInvima;
    }

}
