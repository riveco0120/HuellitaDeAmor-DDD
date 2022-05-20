package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion;

import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.EquipoMedicoID;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.Instrucion;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.TipoDeEquipo;
import co.com.sofka.domain.generic.Entity;


public class EquipoMedico extends Entity<EquipoMedicoID> {
    private TipoDeEquipo tipoDeEquipo;
    private Instrucion instrucion;

    public EquipoMedico(EquipoMedicoID entityId, TipoDeEquipo tipoDeEquipo, Instrucion instrucion) {
        super(entityId);
        this.tipoDeEquipo = tipoDeEquipo;
        this.instrucion = instrucion;
    }


}
