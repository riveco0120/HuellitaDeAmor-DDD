package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion;

import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.events.*;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.*;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.MascotaID;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.PersonalMedicoID;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
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

    //Lanzar o afectar los estados
    private CuartoHospitalizacion(CuartoHospitalizacionID cuartoHospitalizacionID){
        super(cuartoHospitalizacionID);
        subscribe(new CuartoHospitalizacionChange(this));
    }

    //factoria
    public static CuartoHospitalizacion from(CuartoHospitalizacionID cuartoHospitalizacionID, List<DomainEvent> events){
        var cuartoHospitalizacion = new CuartoHospitalizacion(cuartoHospitalizacionID);
        events.forEach(cuartoHospitalizacion::applyEvent);
        return cuartoHospitalizacion;
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
        appendChange(new InstrucionesEquipoActualizada(equipoMedicoID,instrucion)).apply();
    }

    //Actualizando Tipo de equipo medico
    public void actualizarTipoEquipoMedico(EquipoMedicoID equipoMedicoID,TipoDeEquipo tipoDeEquipo){
        Objects.requireNonNull(equipoMedicoID);
        Objects.requireNonNull(tipoDeEquipo);
        appendChange(new TipoDeEquipoActualizado(equipoMedicoID,tipoDeEquipo)).apply();
    }

    //Obtener por id quipo medico
    protected Optional<EquipoMedico> obtenerEquipoPorid(EquipoMedicoID equipoMedicoID){
        return equipoMedicos().stream().filter(equipo->equipo.identity().equals(equipoMedicoID)).findFirst();
    }
    //Obtener por id medicamento
    protected Optional<Medicamento> obtenerMediamentoPorid(MedicamentoID medicamentoID){
        return meedicamentos().stream().filter(medicamento->medicamento.identity().equals(medicamentoID)).findFirst();
    }

    /*
    //obtener mascota por id
    protected Optional<Mascota> obtenerMascotaPorId(MascotaID mascotaID){
        return meedicamentos().stream().filter(mascota->mascota.identity().equals(mascotaID)).findFirst();
    }
    */

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

    public Set<EquipoMedico> equipoMedicos() {
        return equipoMedicos;
    }
}
