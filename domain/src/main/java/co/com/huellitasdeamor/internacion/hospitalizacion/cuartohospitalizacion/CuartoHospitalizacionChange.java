package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion;

import co.com.huellitasdeamor.internacion.generico.HorrarioPersonaMedico;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.events.*;
import co.com.huellitasdeamor.internacion.generico.ValoracionMascota;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.EstadoMascota;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.EstadoTurnoPersonal;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class CuartoHospitalizacionChange extends EventChange {
    public CuartoHospitalizacionChange(CuartoHospitalizacion cuartoHospitalizacion) {
        //Para crear CuartoHospitalizacion
        apply((CuartoHospitalizacionCreado event) -> {
            cuartoHospitalizacion.nivelDeRiesgo = event.getNivelDeRiesgo();
            cuartoHospitalizacion.medicamentos = new HashSet<>();
            cuartoHospitalizacion.equipoMedicos = new HashSet<>();
            cuartoHospitalizacion.estadoMascota = new EstadoMascota(EstadoMascota.Estados.POR_INICIAR);
            cuartoHospitalizacion.valoracionMascota = new ValoracionMascota(0D);
            cuartoHospitalizacion.estadoTurnoPersonal= new EstadoTurnoPersonal(EstadoTurnoPersonal.Estados.POR_INICIAR);
            cuartoHospitalizacion.horrarioPersonaMedico = new HorrarioPersonaMedico("en casa");
            cuartoHospitalizacion.mascotaid = event.getMascotaID();
            cuartoHospitalizacion.personalMedicoID=event.getPersonalMedicoID();
        });

        //Agregando equipo medico
        apply((EquipoMedicoAgregado event) -> {
            var numEquipo = cuartoHospitalizacion.equipoMedicos().size();
            if (numEquipo == 10) {
                throw new IllegalArgumentException("No se puede tener mas de 10 equipos por cuarto");
            }
            cuartoHospitalizacion.equipoMedicos.add(
                    new EquipoMedico(event.getEquipoMedicoID(),
                            event.getTipoDeEquipo(),
                            event.getInstrucion())
            );
        });


        //Agregar medicamento
        apply((MedicametoAgregado event) -> {
            var numMedicamento = cuartoHospitalizacion.meedicamentos().size();
            if (numMedicamento == 30) {
                throw new IllegalArgumentException("El limite de medicamento es por cuarto");
            }
            cuartoHospitalizacion.medicamentos.add(
                    new Medicamento(event.getMedicamentoID(),
                            event.getNombreMedicamento(),
                            event.getRegistroInvima())
            );
        });


        //Estadia de la mascota Finalizada
        apply((EstadiaMascotaFinalizada event)->{
            cuartoHospitalizacion.valoracionMascota = event.getValoracionMascota();
            cuartoHospitalizacion.estadoMascota= new EstadoMascota(EstadoMascota.Estados.ALTA);
        });

        //Finalizar turno personal medico
        apply((TurnoPersonalMedicoFinalizado event)->{
            cuartoHospitalizacion.horrarioPersonaMedico=event.getHorrarioPersonalMedico();
            cuartoHospitalizacion.estadoTurnoPersonal = new EstadoTurnoPersonal(EstadoTurnoPersonal.Estados.FINALIZO);

        });

    }
}