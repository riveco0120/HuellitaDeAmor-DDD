package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.events;

import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.Especialidad;
import co.com.sofka.domain.generic.DomainEvent;

public class EspecialidadVeterinarioActualizada extends DomainEvent {
    private final Especialidad especialidad;

    public EspecialidadVeterinarioActualizada(Especialidad especialidad) {
        super("huellitadeamor.personalmedico.especialidadveterinarioactualizada");
        this.especialidad = especialidad;
    }


    public Especialidad getEspecialidad() {
        return especialidad;

    }
}
