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
