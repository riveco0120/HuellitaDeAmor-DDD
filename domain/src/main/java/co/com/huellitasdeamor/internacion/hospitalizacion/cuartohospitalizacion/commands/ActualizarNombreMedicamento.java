package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.CuartoHospitalizacionID;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.MedicamentoID;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.NombreMedicamento;
import co.com.sofka.domain.generic.Command;

public class ActualizarNombreMedicamento extends Command {
        private final CuartoHospitalizacionID cuartoHospitalizacionID;
        private final MedicamentoID medicamentoID;
        private final NombreMedicamento nombreMedicamento;

        public ActualizarNombreMedicamento(CuartoHospitalizacionID cuartoHospitalizacionID, MedicamentoID medicamentoID, NombreMedicamento nombreMedicamento) {
                this.cuartoHospitalizacionID = cuartoHospitalizacionID;
                this.medicamentoID = medicamentoID;
                this.nombreMedicamento = nombreMedicamento;
        }

        public CuartoHospitalizacionID getCuartoHospitalizacionID() {
                return cuartoHospitalizacionID;
        }

        public MedicamentoID getMedicamentoID() {
                return medicamentoID;
        }

        public NombreMedicamento getNombreMedicamento() {
                return nombreMedicamento;
        }
}
