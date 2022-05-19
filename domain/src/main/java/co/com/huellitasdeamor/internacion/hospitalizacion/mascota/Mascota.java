package co.com.huellitasdeamor.internacion.hospitalizacion.mascota;

import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.events.*;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.*;
import co.com.sofka.domain.generic.AggregateEvent;

import java.util.Objects;

public class Mascota extends AggregateEvent<MascotaID> {

    protected OrdenMedica ordenMedica;
    protected Dueño dueño;
    protected Especie especie;
    protected NombreMascota nombreMascota;

    public Mascota(MascotaID entityId,NombreMascota nombreMascota,Especie especie) {
        super(entityId);
        Objects.requireNonNull(nombreMascota);
        Objects.requireNonNull(especie);
        appendChange(new MascotaCreada(nombreMascota,especie)).apply();
    }

    //Lanzar o afectar los estados
    private Mascota(MascotaID mascotaID){
        super(mascotaID);
        subscribe(new MascotaChange(this));
    }

    //Agrega dueño mascota
    public void agregarDueño(DueñoID dueñoID, NombreDueño nombreDueño,Direccion direccion, Telefono telefono){
        Objects.requireNonNull(dueñoID);
        Objects.requireNonNull(nombreDueño);
        Objects.requireNonNull(direccion);
        Objects.requireNonNull(telefono);
        appendChange(new DueñoMascotaAgregado(dueñoID,nombreDueño,direccion,telefono)).apply();
    }

    //Agregar orden medica
    public void agregarOrdenMedica(OrdenMedicaID ordenMedicaID,FechaOrdenMedica fechaOrdenMedica,ResultadoExamene resultadoExamene, DescripcionOrden descripcionOrden){
        Objects.requireNonNull(ordenMedicaID);
        Objects.requireNonNull(fechaOrdenMedica);
        Objects.requireNonNull(resultadoExamene);
        Objects.requireNonNull(descripcionOrden);
        appendChange(new OrdenMedicaAgregada(ordenMedicaID,fechaOrdenMedica,resultadoExamene,descripcionOrden)).apply();
    }

    //Actualizar nombre mascota
     public void actualizarNombreMascota(NombreMascota nombreMascota){
        Objects.requireNonNull(nombreMascota);
        appendChange(new NombreMascotaActualizado(nombreMascota)).apply();
     }

     //Actualizar especie de la mascota
    public void actualizarEspecie(Especie especie){
        Objects.requireNonNull(especie);
        appendChange(new EspecieActualizada(especie)).apply();
    }

    //Actualizar nombre del dueño
    public void actualizarNombreDueño(NombreDueño nombreDueño){
        Objects.requireNonNull(nombreDueño);
        appendChange(new NombreDueñoActualizado(nombreDueño)).apply();
    }

    //Actualizar Resultado de la orden
    public void actualizarResultadoOrden(ResultadoExamene resultadoExamene){
        Objects.requireNonNull(resultadoExamene);
        appendChange(new ResultadoExameneActualizado(resultadoExamene)).apply();
    }
    //Actualiar Descripcion de la orden

    public void actualizarDescripcionOrden(DescripcionOrden descripcionOrden){
        Objects.requireNonNull(descripcionOrden);
        appendChange(new DescripcionOrdenActualizada(descripcionOrden)).apply();
    }

    public OrdenMedica ordenMedica() {
        return ordenMedica;
    }

    public Dueño dueño() {
        return dueño;
    }

    public Especie especie() {
        return especie;
    }

    public NombreMascota nombreMascota() {
        return nombreMascota;
    }
}