package co.com.huellitasdeamor.internacion.hospitalizacion.mascota;

import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.events.*;
import co.com.huellitasdeamor.internacion.generico.ValoracionMascota;
import co.com.sofka.domain.generic.EventChange;

public class MascotaChange extends EventChange {
    public MascotaChange(Mascota mascota){
        //Para crear Mascota
        apply((MascotaCreada event)->{
            mascota.nombreMascota=event.getNombreMascota();
            mascota.especie=event.getEspecie();
            mascota.valaoracion=  new ValoracionMascota(0D);
        });
        //Para Agregar Dueño
        apply((DueñoMascotaAgregado event)->{
            mascota.dueño = new Dueño(
                    event.getDueñoID(),
                    event.getNombreDueño(),
                    event.getDireccion(),
                    event.getTelefono()
            );
        });

        //Para agregar orden medica
        apply((OrdenMedicaAgregada event)->{
            mascota.ordenMedica = new OrdenMedica(
                    event.getOrdenMedicaID(),
                    event.getFechaOrdenMedica(),
                    event.getResultadoExamene(),
                    event.getDescripcionOrden()
            );
        });

        //Para actualizar nombre de la mascota
        apply((NombreMascotaActualizado event)->{
            mascota.nombreMascota = event.getNombreMascota();
        });

        //Actualizar especie mascota
        apply((EspecieActualizada event)->{
            mascota.especie=event.getEspecie();
        });
        //Actualizar nombre del dueño
        apply((NombreDueñoActualizado event)->{
           var dueño =mascota.dueño;
           dueño.actualizarNombreDueño(event.getNombreDueño());
        });

        //Actualizar Resultados examenes
        apply((ResultadoExameneActualizado event)->{
            var examen = mascota.ordenMedica;
            examen.actualizarResultadoExamenes(event.getResultadoExamene());
        });

        //Actualizar Descripcion de los examenes
        apply((DescripcionOrdenActualizada event)->{
            var descripcion = mascota.ordenMedica;
            descripcion.actualiarDescripcion(event.getDescripcionOrden());
        });

        //Actualizar Valoracion
        apply((ValoracionActualizadad event)->{
            mascota.valaoracion=event.getValoracion();
        });
    }
}
