package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion;

import co.com.huellitasdeamor.internacion.generico.Nombre;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.*;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Medicamento extends Entity<MedicamentoID> {
    protected Nombre nombreMedicamento;
    protected RegistroInvima registroInvima;

    public Medicamento(MedicamentoID entityId, Nombre nombreMedicamento, RegistroInvima registroInvima) {
        super(entityId);
        this.nombreMedicamento = nombreMedicamento;
        this.registroInvima = registroInvima;
    }
   //Comportamiento para actualizar Nombre del medicamento

    public void actualizarNombreMedicamento(Nombre nombreMedicamento){
        this.nombreMedicamento= Objects.requireNonNull(nombreMedicamento);
    }

    //Comportamiento para actualizar registroInvima
    public void actualizarRegistroInvima(RegistroInvima registroInvima){
        this.registroInvima = Objects.requireNonNull(registroInvima);
    }

    public Nombre getNombreMedicamento() {
        return nombreMedicamento;
    }

    public RegistroInvima getRegistroInvima() {
        return registroInvima;
    }
}
