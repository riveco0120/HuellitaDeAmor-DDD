package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.CuartoHospitalizacionID;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.EquipoMedicoID;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.Instrucion;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.TipoDeEquipo;
import co.com.sofka.domain.generic.Command;

public class AgregarEquipoMedico extends Command {
    private final CuartoHospitalizacionID cuartoHospitalizacionID;
    private final EquipoMedicoID equipoMedicoID;
    private final TipoDeEquipo tipoDeEquipo;
    private final Instrucion instrucion;

    public AgregarEquipoMedico(CuartoHospitalizacionID cuartoHospitalizacionID, EquipoMedicoID equipoMedicoID, TipoDeEquipo tipoDeEquipo, Instrucion instrucion) {
        this.cuartoHospitalizacionID = cuartoHospitalizacionID;
        this.equipoMedicoID = equipoMedicoID;
        this.tipoDeEquipo = tipoDeEquipo;
        this.instrucion = instrucion;
    }

    public CuartoHospitalizacionID getCuartoHospitalizacionID() {
        return cuartoHospitalizacionID;
    }

    public EquipoMedicoID getEquipoMedicoID() {
        return equipoMedicoID;
    }

    public TipoDeEquipo getTipoDeEquipo() {
        return tipoDeEquipo;
    }

    public Instrucion getInstrucion() {
        return instrucion;
    }
}
