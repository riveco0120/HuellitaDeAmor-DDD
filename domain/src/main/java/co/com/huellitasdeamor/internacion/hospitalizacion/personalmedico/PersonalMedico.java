package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico;

import co.com.huellitasdeamor.internacion.generico.HorrarioPersonaMedico;
import co.com.huellitasdeamor.internacion.generico.Nombre;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.events.*;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class PersonalMedico extends AggregateEvent<PersonalMedicoID> {

    protected HorrarioPersonaMedico horrario;
    protected Veterinario veterinario;
    protected Set<AuxiliarVeterinario> auxiliarVeterinarios;


    public PersonalMedico(PersonalMedicoID entityId, HorrarioPersonaMedico horrario) {
        super(entityId);
        Objects.requireNonNull(horrario);
        appendChange(new PersonalMedicoCreado(horrario)).apply();
        subscribe(new PersonalMedicoChange(this));
    }

    //Lanzar o afectar los estados
    private PersonalMedico(PersonalMedicoID personalMedicoID){
        super(personalMedicoID);
        subscribe(new PersonalMedicoChange(this));
    }

    public static PersonalMedico from(PersonalMedicoID personalMedicoID, List<DomainEvent> events){
        var personalmedico = new PersonalMedico(personalMedicoID);
        events.forEach(personalmedico::applyEvent);
        return personalmedico;
    }

    //Agregar Auxiliar veterinario
    public void agregarAuxiliar(AuxiliarVeterinarioID entityId, Nombre nombre, Funcion funcion){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(funcion);
        appendChange(new AuxiliarAgregado(entityId,nombre,funcion)).apply();
    }

    //Agregar Veterinario
    public void agregarVeterinario(VeterinarioID entityId, Nombre nombre, Especialidad especialidad){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(especialidad);
        appendChange(new VeterinarioAgregado(entityId,nombre,especialidad));
    }

    //Actualizar Horrario del personal medico
    public void actualizarHorrario(HorrarioPersonaMedico horrario){
        Objects.requireNonNull(horrario);
        appendChange(new HorrarioActualizado(horrario)).apply();

    }

        //Actualizar Especialidad veterinario
    public void actualizarEspecialidadVeterinario(Especialidad especialidad){
        Objects.requireNonNull(especialidad);
        appendChange(new EspecialidadVeterinarioActualizada(especialidad));
    }

       //Eliminar Auxiliar
    public void eliminarAuxiliarVeterinario(AuxiliarVeterinarioID entityId){
        Objects.requireNonNull(entityId);
        appendChange(new AuxiliarVEterinarioEliminado(entityId)).apply();
    }

    //Encontrar el auxiliar por id
  protected Optional<AuxiliarVeterinario> obtenerAuxiliar(AuxiliarVeterinarioID auxiliarVeterinarioID){
        return auxiliarVeterinarios().stream().filter(auxiliar->auxiliar.identity().equals(auxiliarVeterinarioID)).findFirst();
    }

    public Set<AuxiliarVeterinario> auxiliarVeterinarios() {
        return auxiliarVeterinarios;
    }
}
