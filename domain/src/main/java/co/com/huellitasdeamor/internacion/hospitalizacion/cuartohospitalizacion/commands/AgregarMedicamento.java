package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.CuartoHospitalizacionID;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.MedicamentoID;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.NombreMedicamento;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.RegistroInvima;
import co.com.sofka.domain.generic.Command;

public class AgregarMedicamento extends Command {
    private final CuartoHospitalizacionID cuartoHospitalizacionID;
    private final MedicamentoID medicamentoID;
    private final NombreMedicamento nombreMedicamento;
    private final RegistroInvima registroInvima;

    public AgregarMedicamento(CuartoHospitalizacionID cuartoHospitalizacionID, MedicamentoID medicamentoID, NombreMedicamento nombreMedicamento, RegistroInvima registroInvima) {
        this.cuartoHospitalizacionID = cuartoHospitalizacionID;
        this.medicamentoID = medicamentoID;
        this.nombreMedicamento = nombreMedicamento;
        this.registroInvima = registroInvima;
    }
}
