package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.events;

import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.AuxiliarVeterinarioID;
import co.com.sofka.domain.generic.DomainEvent;

public class AuxiliarVEterinarioEliminado extends DomainEvent {
    private final AuxiliarVeterinarioID auxiliarVeterinarioID;

    public AuxiliarVEterinarioEliminado(AuxiliarVeterinarioID auxiliarVeterinarioID) {
        super("co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.auxiliarveterinarioeliminado");
        this.auxiliarVeterinarioID = auxiliarVeterinarioID;
    }

    public AuxiliarVeterinarioID getAuxiliarVeterinarioID() {
        return auxiliarVeterinarioID;
    }
}
