package co.com.huellitasdeamor.internacion.hospitalizacion.mascota;

import co.com.huellitasdeamor.internacion.generico.Nombre;
import co.com.huellitasdeamor.internacion.generico.ValoracionMascota;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.events.*;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;

public class Mascota extends AggregateEvent<MascotaID> {

    protected OrdenMedica ordenMedica;
    protected Dueño dueño;
    protected Especie especie;
    protected Nombre nombreMascota;
    protected ValoracionMascota valaoracion;

    public Mascota(MascotaID entityId,Nombre nombreMascota,Especie especie) {
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

    public static Mascota from(MascotaID mascotaID, List<DomainEvent>events){
        var mascota = new Mascota(mascotaID);
        events.forEach(mascota::applyEvent);
        return mascota;
    }

    //actualizar Valoracion
    public void actualizarValoracion(ValoracionMascota valaoracion){
        Objects.requireNonNull(valaoracion);
        appendChange(new ValoracionActualizadad(valaoracion)).apply();
    }

    //Agrega dueño mascota
    public void agregarDueño(DueñoID dueñoID, Nombre nombreDueño, Direccion direccion, Telefono telefono){
        Objects.requireNonNull(dueñoID);
        Objects.requireNonNull(nombreDueño);
        Objects.requireNonNull(direccion);
        Objects.requireNonNull(telefono);
        appendChange(new DueñoMascotaAgregado(dueñoID,nombreDueño,direccion,telefono)).apply();
    }


            //Actualizar nombre del dueño
    public void actualizarNombreDueño(Nombre nombreDueño){
        Objects.requireNonNull(nombreDueño);
        appendChange(new NombreDueñoActualizado(nombreDueño)).apply();
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

    public Nombre nombreMascota() {
        return nombreMascota;
    }
}