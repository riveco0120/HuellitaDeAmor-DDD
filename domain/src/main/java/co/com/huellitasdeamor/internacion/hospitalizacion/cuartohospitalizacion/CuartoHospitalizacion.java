package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion;

import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.events.*;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.*;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.Mascota;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.MascotaID;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.PersonalMedico;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.PersonalMedicoID;
import co.com.sofka.domain.generic.AggregateEvent;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class CuartoHospitalizacion extends AggregateEvent<CuartoHospitalizacionID> {

    protected NivelDeRiesgo nivelDeRiesgo;
    protected PersonalMedicoID personalMedicoID;
    protected Set<MascotaID> mascotasIds;
    protected Set<Medicamento> medicamentos;
    protected Set<EquipoMedico>equipoMedicos;

    public CuartoHospitalizacion(CuartoHospitalizacionID entityId,NivelDeRiesgo nivelDeRiesgo) {
        super(entityId);
        Objects.requireNonNull(nivelDeRiesgo);
        appendChange(new CuartoHospitalizacionCreado(nivelDeRiesgo)).apply();
    }


    //Agregar Mascota
    public void agregarMascota(MascotaID mascotaID){
        Objects.requireNonNull(mascotaID);
        appendChange(new MascotaAgregada(mascotaID)).apply();
    }


    //Agregar medicamento
    public void agregarMedicamento(MedicamentoID medicamentoID, NombreMedicamento nombreMedicamento, RegistroInvima registroInvima){
        Objects.requireNonNull(medicamentoID);
        Objects.requireNonNull(nombreMedicamento);
        Objects.requireNonNull(registroInvima);
        appendChange(new MedicametoAgregado(medicamentoID,nombreMedicamento,registroInvima)).apply();

    }

    //Agregar Equipo medico

    public void agregarEquipoMedico(EquipoMedicoID equipoMedicoID,TipoDeEquipo tipoDeEquipo,Instrucion instrucion){
        Objects.requireNonNull(equipoMedicoID);
        Objects.requireNonNull(tipoDeEquipo);
        Objects.requireNonNull(instrucion);
        appendChange(new EquipoMedicoAgregado(equipoMedicoID,tipoDeEquipo,instrucion)).apply();

    }
    //Agregar Personal medico
    public void agregarPersonalMedico(PersonalMedicoID personalMedicoID){
        Objects.requireNonNull(personalMedicoID);
        appendChange(new PersonaMedicoAgregado(personalMedicoID)).apply();
    }

    //Eliminar Mascota
    public void eliminarMascota(MascotaID mascotaID){
        Objects.requireNonNull(mascotaID);
        appendChange(new MascotaEliminada(mascotaID)).apply();
    }

    //Eliminar medicamento
    public void eliminarMedicamento(MedicamentoID medicamentoID){
        Objects.requireNonNull(medicamentoID);
        appendChange(new MedicamentoEliminado(medicamentoID)).apply();
    }

    //Eliminar equipo medico
    public void eliminarEquipoMedico(EquipoMedicoID equipoMedicoID){
        Objects.requireNonNull(equipoMedicoID);
        appendChange(new EquipoMedicoEliminado(equipoMedicoID)).apply();
    }

    //Actualizar NombreMedicamento
    public void actualizarNombreMedicamento(MedicamentoID medicamentoID, NombreMedicamento nombreMedicamento){
        Objects.requireNonNull(medicamentoID);
        Objects.requireNonNull(nombreMedicamento);
        appendChange(new NombreMedicamentoActualizado(medicamentoID,nombreMedicamento)).apply();
    }

    //Actualizar Registro invima medicamento
    public void actualizarRegistroInvima(MedicamentoID medicamentoID, RegistroInvima registroInvima){
        Objects.requireNonNull(medicamentoID);
        Objects.requireNonNull(registroInvima);
        appendChange(new RegistroInvimaActualizado(medicamentoID,registroInvima)).apply();
    }

    //Actualizando Instrucciones equipo medico
    public void actualizarIntrucionesEquipoMedico(EquipoMedicoID equipoMedicoID,Instrucion instrucion){
        Objects.requireNonNull(equipoMedicoID);
        Objects.requireNonNull(instrucion);
        appendChange(new InstrucionesEquipoActualizadas(equipoMedicoID,instrucion)).apply();
    }

    //Actualizando Tipo de equipo medico
    public void actualizarTipoEquipoMedico(EquipoMedicoID equipoMedicoID,TipoDeEquipo tipoDeEquipo){
        Objects.requireNonNull(equipoMedicoID);
        Objects.requireNonNull(tipoDeEquipo);
        appendChange(new TipoDEEquipoActualizadas(equipoMedicoID,tipoDeEquipo)).apply();
    }

    public NivelDeRiesgo nivelDeRiesgo() {
        return nivelDeRiesgo;
    }

    public PersonalMedicoID apersonalMedicoID() {
        return personalMedicoID;
    }

    public Set<MascotaID> mascotasIds() {
        return mascotasIds;
    }

    public Set<Medicamento> meedicamentos() {
        return medicamentos;
    }

    public Set<EquipoMedico> quipoMedicos() {
        return equipoMedicos;
    }
}
