package co.com.huellitasdeamor.internacion.hospitalizacion.mascota.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.*;
import co.com.sofka.domain.generic.Command;

public class AgregarOrdenMedica extends Command {
    private final MascotaID mascotaID;
    private final OrdenMedicaID ordenMedicaID;
    private final FechaOrdenMedica fechaOrdenMedica;
    private final ResultadoExamene resultadoExamene;
    private final DescripcionOrden descripcionOrden;

    public AgregarOrdenMedica(MascotaID mascotaID, OrdenMedicaID ordenMedicaID, FechaOrdenMedica fechaOrdenMedica, ResultadoExamene resultadoExamene, DescripcionOrden descripcionOrden) {
        this.mascotaID = mascotaID;
        this.ordenMedicaID = ordenMedicaID;
        this.fechaOrdenMedica = fechaOrdenMedica;
        this.resultadoExamene = resultadoExamene;
        this.descripcionOrden = descripcionOrden;
    }

    public MascotaID getMascotaID() {
        return mascotaID;
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
