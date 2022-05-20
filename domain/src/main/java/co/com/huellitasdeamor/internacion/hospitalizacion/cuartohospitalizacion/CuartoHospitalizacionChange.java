package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion;

import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.events.*;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.RegistroInvima;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.PersonalMedicoID;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class CuartoHospitalizacionChange extends EventChange {
    public CuartoHospitalizacionChange(CuartoHospitalizacion cuartoHospitalizacion) {
        //Para crear CuartoHospitalizacion
        apply((CuartoHospitalizacionCreado event) -> {
            cuartoHospitalizacion.nivelDeRiesgo = event.getNivelDeRiesgo();
            cuartoHospitalizacion.mascotasIds = new HashSet<>();
            cuartoHospitalizacion.medicamentos = new HashSet<>();
            cuartoHospitalizacion.equipoMedicos = new HashSet<>();
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

        //eliminado equipo medico
        apply((EquipoMedicoEliminado event) -> {
            var equipoMedico = cuartoHospitalizacion.obtenerEquipoPorid(event.getEquipoMedicoID())
                    .orElseThrow(() -> new IllegalArgumentException("No se encontro un equipo con esta id"));
            cuartoHospitalizacion.equipoMedicos.remove(equipoMedico);
        });

        //Actualizar instruciones del equipo
        apply((InstrucionesEquipoActualizada event) -> {
            var equipo = cuartoHospitalizacion.obtenerEquipoPorid(event.getEquipoMedicoID())
                    .orElseThrow(() -> new IllegalArgumentException("No existe el equipo con esa id"));
            equipo.actualizarInstrucioneterinario(event.getInstrucion());
        });

        //Actualizar tipo del equipo
        apply((TipoDeEquipoActualizado event) -> {
            var equipo = cuartoHospitalizacion.obtenerEquipoPorid(event.getEquipoMedicoID())
                    .orElseThrow(() -> new IllegalArgumentException("No existe el equipo con esa id"));
            equipo.actualizarTipoDeEquipo(event.getTipoDeEquipo());
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

        //eliminado equipo medico
        apply((MedicamentoEliminado event) -> {
            var medicamento = cuartoHospitalizacion.obtenerMediamentoPorid(event.getMedicamentoID())
                    .orElseThrow(() -> new IllegalArgumentException("No se encontro un medicamento con esta id"));
            cuartoHospitalizacion.equipoMedicos.remove(medicamento);
        });

        //Actualizar Nombre medicamento
        apply((NombreMedicamentoActualizado event) -> {
            var medicamento = cuartoHospitalizacion.obtenerMediamentoPorid(event.getMedicamentoID())
                    .orElseThrow(() -> new IllegalArgumentException("No existe medicamento con esta id"));
            medicamento.actualizarNombreMedicamento(event.getNombreMedicamento());
        });

        //Actualizar Registro invima
        apply((RegistroInvimaActualizado event) -> {
            var registro = cuartoHospitalizacion.obtenerMediamentoPorid(event.getMedicamentoID())
                    .orElseThrow(() -> new IllegalArgumentException("No existe el equipo con esa id"));
            registro.actualizarRegistroInvima(event.getRegistroInvima());
        });

/*
        //Agregar personal medico
        apply((PersonaMedicoAgregado event)->{
            cuartoHospitalizacion.personalMedicoID= new PersonalMedicoID(
                    event.getPersonalMedicoID();
            )
        });
    }
    */
        /*
        //Mascot Agregada
        apply((MascotaAgregada evnet)->{
            var numMascota = cuartoHospitalizacion.mascotasIds().size();
            if(numMascota==5){
                throw new IllegalArgumentException("No se puede tener mas de 5 mascotas por cuarto");
            }
            cuartoHospitalizacion.medicamentos.add(
                    evnet.getMascotaID();
            );
        });

*/

        /*
    //Eliminar mascota
        apply((MascotaEliminada event)->{
            var mascota =
        });
    }*/
    }
}
