package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion;

import co.com.huellitasdeamor.internacion.generico.HorrarioPersonaMedico;
import co.com.huellitasdeamor.internacion.generico.Nombre;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.events.*;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.*;
import co.com.huellitasdeamor.internacion.generico.ValoracionMascota;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.MascotaID;
import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.EstadoMascota;
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
    protected MascotaID mascotaid;
    protected Set<Medicamento> medicamentos;
    protected Set<EquipoMedico>equipoMedicos;
    protected EstadoMascota estadoMascota;
    protected ValoracionMascota valoracionMascota;
    protected EstadoTurnoPersonal estadoTurnoPersonal;
    protected HorrarioPersonaMedico horrarioPersonaMedico;

    public CuartoHospitalizacion(CuartoHospitalizacionID entityId,MascotaID mascotaID,PersonalMedicoID personalMedicoID,NivelDeRiesgo nivelDeRiesgo) {
        super(entityId);
        Objects.requireNonNull(nivelDeRiesgo);
        Objects.requireNonNull(mascotaID);
        Objects.requireNonNull(personalMedicoID);
        appendChange(new CuartoHospitalizacionCreado(nivelDeRiesgo,mascotaID,personalMedicoID)).apply();
        subscribe(new CuartoHospitalizacionChange(this));
    }

    //Lanzar o afectar los estados
    private CuartoHospitalizacion(CuartoHospitalizacionID cuartoHospitalizacionID){
        super(cuartoHospitalizacionID);
        subscribe(new CuartoHospitalizacionChange(this));
    }

    public static CuartoHospitalizacion from(CuartoHospitalizacionID cuartoHospitalizacionID, List<DomainEvent> events){
        var cuartoHospitalizacion = new CuartoHospitalizacion(cuartoHospitalizacionID);
        events.forEach(cuartoHospitalizacion::applyEvent);
        return cuartoHospitalizacion;
    }

    //Agregar medicamento
    public void agregarMedicamento(MedicamentoID medicamentoID, Nombre nombreMedicamento, RegistroInvima registroInvima){
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
    public void actualizarNombreMedicamento(MedicamentoID medicamentoID, Nombre nombreMedicamento){
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

    //Finalizar estadia mascota
    public void finalizarEstadiaMascota(ValoracionMascota valoracionMascota){
        Objects.requireNonNull(valoracionMascota);
        appendChange(new EstadiaMascotaFinalizada(valoracionMascota,mascotaid)).apply();
    }

    //Finalizar turno del persona
    public void finalizarTurnoPersonal(HorrarioPersonaMedico horrarioPersonaMedico){
        Objects.requireNonNull(horrarioPersonaMedico);
        appendChange(new TurnoPersonalMedicoFinalizado(horrarioPersonaMedico,personalMedicoID)).apply();
    }

    //Obtener por id quipo medico
    protected Optional<EquipoMedico> obtenerEquipoPorid(EquipoMedicoID equipoMedicoID){
        return equipoMedicos().stream().filter(equipo->equipo.identity().equals(equipoMedicoID)).findFirst();
    }
    //Obtener por id medicamento
    protected Optional<Medicamento> obtenerMediamentoPorid(MedicamentoID medicamentoID){
        return meedicamentos().stream().filter(medicamento->medicamento.identity().equals(medicamentoID)).findFirst();
    }

    public HorrarioPersonaMedico horrarioPersonaMedico() {
        return horrarioPersonaMedico;
    }

    public Set<Medicamento> meedicamentos() {
        return medicamentos;
    }

    public Set<EquipoMedico> equipoMedicos() {
        return equipoMedicos;
    }
}
