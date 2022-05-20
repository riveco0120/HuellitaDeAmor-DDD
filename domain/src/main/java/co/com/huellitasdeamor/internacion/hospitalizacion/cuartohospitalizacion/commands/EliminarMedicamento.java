package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.CuartoHospitalizacionID;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.MedicamentoID;
import co.com.sofka.domain.generic.Command;

public class EliminarMedicamento extends Command {
    private final CuartoHospitalizacionID cuartoHospitalizacionID;
    private final MedicamentoID medicamentoID;

    public EliminarMedicamento(CuartoHospitalizacionID cuartoHospitalizacionID, MedicamentoID medicamentoID) {
        this.cuartoHospitalizacionID = cuartoHospitalizacionID;
        this.medicamentoID = medicamentoID;
    }

    public CuartoHospitalizacionID getCuartoHospitalizacionID() {
        return cuartoHospitalizacionID;
    }

    public MedicamentoID getMedicamentoID() {
        return medicamentoID;
    }
}
