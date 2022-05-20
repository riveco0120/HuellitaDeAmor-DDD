package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion;

import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.EquipoMedicoID;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.Instrucion;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.TipoDeEquipo;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class EquipoMedico extends Entity<EquipoMedicoID> {
    private TipoDeEquipo tipoDeEquipo;
    private Instrucion instrucion;

    public EquipoMedico(EquipoMedicoID entityId, TipoDeEquipo tipoDeEquipo, Instrucion instrucion) {
        super(entityId);
        this.tipoDeEquipo = tipoDeEquipo;
        this.instrucion = instrucion;
    }
//Comportamiento para actualizar Tipo

    public void actualizarTipoDeEquipo(TipoDeEquipo tipoDeEquipo){
        this.tipoDeEquipo= Objects.requireNonNull(tipoDeEquipo);
    }

    //Comportamiento para actualizar instrucion
    public void actualizarInstrucioneterinario(Instrucion instrucion){
        this.instrucion = Objects.requireNonNull(instrucion);
    }


    public TipoDeEquipo getTipoDeEquipo() {
        return tipoDeEquipo;
    }

    public Instrucion getInstrucion() {
        return instrucion;
    }
}
