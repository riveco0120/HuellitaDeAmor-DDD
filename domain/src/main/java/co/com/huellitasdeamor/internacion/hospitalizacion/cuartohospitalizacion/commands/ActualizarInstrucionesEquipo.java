package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.CuartoHospitalizacionID;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.EquipoMedicoID;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.Instrucion;
import co.com.sofka.domain.generic.Command;

public class ActualizarInstrucionesEquipo extends Command {
    private final CuartoHospitalizacionID cuartoHospitalizacionID;
    private final EquipoMedicoID equipoMedicoID;
    private final Instrucion instrucion;

    public ActualizarInstrucionesEquipo(CuartoHospitalizacionID cuartoHospitalizacionID, EquipoMedicoID equipoMedicoID, Instrucion instrucion) {
        this.cuartoHospitalizacionID = cuartoHospitalizacionID;
        this.equipoMedicoID = equipoMedicoID;
        this.instrucion = instrucion;
    }

    public CuartoHospitalizacionID getCuartoHospitalizacionID() {
        return cuartoHospitalizacionID;
    }

    public EquipoMedicoID getEquipoMedicoID() {
        return equipoMedicoID;
    }

    public Instrucion getInstrucion() {
        return instrucion;
    }
}
