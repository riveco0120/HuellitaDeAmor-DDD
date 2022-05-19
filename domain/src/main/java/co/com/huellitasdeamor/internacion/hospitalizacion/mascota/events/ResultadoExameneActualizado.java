package co.com.huellitasdeamor.internacion.hospitalizacion.mascota.events;

import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.ResultadoExamene;
import co.com.sofka.domain.generic.DomainEvent;

public class ResultadoExameneActualizado extends DomainEvent {
   private final ResultadoExamene resultadoExamene;
    public ResultadoExameneActualizado(ResultadoExamene resultadoExamene) {
        super("");
        this.resultadoExamene=resultadoExamene;
    }

    public ResultadoExamene getResultadoExamene() {
        return resultadoExamene;
    }
}
