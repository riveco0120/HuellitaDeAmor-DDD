package co.com.huellitasdeamor.internacion.hospitalizacion.mascota.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.MascotaID;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.ResultadoExamene;
import co.com.sofka.domain.generic.Command;

public class ActualizarResultadosOrden extends Command {
    private final MascotaID mascotaID;
    private final ResultadoExamene resultadoExamene;

    public ActualizarResultadosOrden(MascotaID mascotaID, ResultadoExamene resultadoExamene) {
        this.mascotaID = mascotaID;
        this.resultadoExamene = resultadoExamene;
    }

    public MascotaID getMascotaID() {
        return mascotaID;
    }

    public ResultadoExamene getResultadoExamene() {
        return resultadoExamene;
    }
}
