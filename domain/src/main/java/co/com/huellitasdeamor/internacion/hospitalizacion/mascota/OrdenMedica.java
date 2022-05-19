package co.com.huellitasdeamor.internacion.hospitalizacion.mascota;

import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.DescripcionOrden;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.FechaOrdenMedica;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.OrdenMedicaID;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.ResultadoExamene;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class OrdenMedica extends Entity<OrdenMedicaID> {
    private FechaOrdenMedica fechaOrdenMedica;
    private ResultadoExamene resultadoExamene;
    private DescripcionOrden descripcionOrden;

    public OrdenMedica(OrdenMedicaID entityId, FechaOrdenMedica fechaOrdenMedica, ResultadoExamene resultadoExamene, DescripcionOrden descripcionOrden) {
        super(entityId);
        this.fechaOrdenMedica = fechaOrdenMedica;
        this.resultadoExamene = resultadoExamene;
        this.descripcionOrden = descripcionOrden;
    }
    //Comporatmiento para actualizar fecha
    public void actualizarFechaOrden(FechaOrdenMedica fechaOrdenMedica){
        this.fechaOrdenMedica= Objects.requireNonNull(fechaOrdenMedica);
    }
    //Comportamiento para actualiar resultado examenes
    public void actualizarResultadoExamenes(ResultadoExamene examene){
        this.resultadoExamene = Objects.requireNonNull(examene);
    }
    //Comportamienot para actualiar Descripcion
    public void actualiarDescripcion(DescripcionOrden descripcionOrden){
        this.descripcionOrden = Objects.requireNonNull(descripcionOrden);
    }

    public FechaOrdenMedica getFechaOrdenMedica() {
        return fechaOrdenMedica;
    }

    public ResultadoExamene getResultadoExamene() {
        return resultadoExamene;
    }

    public DescripcionOrden getDescripcionOrden() {
        return descripcionOrden;
    }
}
