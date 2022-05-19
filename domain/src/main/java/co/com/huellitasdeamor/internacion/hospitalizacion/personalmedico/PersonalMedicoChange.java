package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico;

import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.events.*;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.Horrario;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.Nombre;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class PersonalMedicoChange extends EventChange {
    public PersonalMedicoChange(PersonalMedico personalMedico){
        //Para crear PersonalMedico
        apply((PersonalMedicoCreado event)->{
            personalMedico.horrario=event.getHorrario();
            personalMedico.auxiliarVeterinarios = new HashSet<>();
        });

        //Agregando auxiliar veterinario
        apply((AuxiliarAgregado event)->{
            var numFunciones =personalMedico.auxiliarVeterinarios().size();
            if(numFunciones==4){
                throw new IllegalArgumentException("No puede haber mas de 4 auxiliares por equipo de trabajo");
            }
            personalMedico.auxiliarVeterinarios.add(
                    new AuxiliarVeterinario(
                            event.getEntityId(),
                            event.getNombre(),
                            event.getFuncion()
                    )
            );
        });

        //Actualizar funcion veterinario
        apply((FuncioDeAuxiliarAlctualizado event)->{
            var auxiliar= personalMedico.obtenerAuxiliar(event.getAuxiliarVeterinarioID()).orElseThrow(()->
                    new IllegalArgumentException("No se encontro un auxiliar con esa identificacion")
            );
            auxiliar.actualizarFuncion(event.getFuncion());
        });

        //Actualizar nombre auxiliar
        apply((NombreDeAuxiliarAlctualizado event)->{
            var auxiliar = personalMedico.obtenerAuxiliar(event.getEntityId()).orElseThrow(()->
                    new IllegalArgumentException("No se encontro un auxiliar con esa identificacion"));
            auxiliar.actualizarNombreAuxiliar(event.getNombre());
        });

        //Agregar veterinario
        apply((VeterinarioAgregado event)->{
            personalMedico.veterinario = new Veterinario(
                    event.getEntityId(),
                    event.getNombre(),
                    event.getEspecialidad()
            );
        });

        //Cambiar nombre veterinario
        apply((HorrarioCambiado event)->{
            personalMedico.horrario=event.getHorrario();

        });

        //Eliminar auxiliar
        apply((AuxiliarVEterinarioEliminado event)->{
            var auxiliar = personalMedico.obtenerAuxiliar(event.getAuxiliarVeterinarioID()).orElseThrow(
                    ()-> new IllegalArgumentException("No se encontro un auxiliar con esa identificacion"));
            personalMedico.auxiliarVeterinarios.remove(auxiliar);

        });


    }
}
