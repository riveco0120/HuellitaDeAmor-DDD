package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico;

import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.events.*;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class PersonalMedico extends AggregateEvent<PersonalMedicoID> {

    protected Horrario horrario;
    protected Veterinario veterinario;
    protected Set<AuxiliarVeterinario> auxiliarVeterinarios;

    public PersonalMedico(PersonalMedicoID entityId, Horrario horrario) {
        super(entityId);
        Objects.requireNonNull(horrario);
        appendChange(new PersonalMedicoCreado(horrario)).apply();
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

    //Cambiar Horrario del personal medico
    public void cambiarHorrario(Horrario horrario){
        Objects.requireNonNull(horrario);
        appendChange(new HorrarioCambiado(horrario)).apply();

    }

    //Actualizar Veterinario
    public void actualizarVeterinario(VeterinarioID entityId, Nombre nombre, Especialidad especialidad){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(especialidad);
        appendChange(new VeterinarioActualizado(entityId,nombre,especialidad));
    }

    //Actualizar funcion de auxiliar veterinario
    public void actualizarFuncionUnAuxiliar(AuxiliarVeterinarioID entityId,Funcion funcion){
        appendChange(new FuncioDeAuxiliarAlctualizado(entityId,funcion)).apply();
    }

    //Actualizar funcion de auxiliar veterinario
    public void actualizarNombreUnAuxiliar(AuxiliarVeterinarioID entityId,Nombre nombre){
        appendChange(new NombreDeAuxiliarAlctualizado(entityId,nombre)).apply();
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


    public Horrario horrario() {
        return horrario;
    }

    public Veterinario veterinario() {
        return veterinario;
    }

    public Set<AuxiliarVeterinario> auxiliarVeterinarios() {
        return auxiliarVeterinarios;
    }
}
