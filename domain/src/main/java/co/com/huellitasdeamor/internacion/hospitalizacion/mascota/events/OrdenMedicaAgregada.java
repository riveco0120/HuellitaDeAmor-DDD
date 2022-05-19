package co.com.huellitasdeamor.internacion.hospitalizacion.mascota.events;

import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.DescripcionOrden;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.FechaOrdenMedica;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.OrdenMedicaID;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.ResultadoExamene;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.UUID;

public class OrdenMedicaAgregada extends DomainEvent {

    private final OrdenMedicaID ordenMedicaID;
    private final FechaOrdenMedica fechaOrdenMedica;
    private final ResultadoExamene resultadoExamene;
    private final DescripcionOrden descripcionOrden;

    public OrdenMedicaAgregada(OrdenMedicaID ordenMedicaID, FechaOrdenMedica fechaOrdenMedica, ResultadoExamene resultadoExamene, DescripcionOrden descripcionOrden) {
        super("huellitadeamor.mascota.ordenmedicaagregada");
        this.ordenMedicaID=ordenMedicaID;
        this.fechaOrdenMedica=fechaOrdenMedica;
        this.resultadoExamene=resultadoExamene;
        this.descripcionOrden=descripcionOrden;
    }

    public OrdenMedicaID getOrdenMedicaID() {
        return ordenMedicaID;
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
