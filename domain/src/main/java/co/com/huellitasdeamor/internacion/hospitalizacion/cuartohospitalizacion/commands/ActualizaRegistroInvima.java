package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.CuartoHospitalizacionID;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.MedicamentoID;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.RegistroInvima;
import co.com.sofka.domain.generic.Command;

public class ActualizaRegistroInvima extends Command {
    private final CuartoHospitalizacionID cuartoHospitalizacionID;
    private final MedicamentoID medicamentoID;
    private final RegistroInvima registroInvima;

    public ActualizaRegistroInvima(CuartoHospitalizacionID cuartoHospitalizacionID, MedicamentoID medicamentoID, RegistroInvima registroInvima) {
        this.cuartoHospitalizacionID = cuartoHospitalizacionID;
        this.medicamentoID = medicamentoID;
        this.registroInvima = registroInvima;
    }

    public CuartoHospitalizacionID getCuartoHospitalizacionID() {
        return cuartoHospitalizacionID;
    }

    public MedicamentoID getMedicamentoID() {
        return medicamentoID;
    }

    public RegistroInvima getRegistroInvima() {
        return registroInvima;
    }
}
