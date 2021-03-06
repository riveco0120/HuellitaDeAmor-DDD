package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico;

import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.AuxiliarVeterinarioID;
import co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject.Funcion;
import co.com.huellitasdeamor.internacion.generico.Nombre;
import co.com.sofka.domain.generic.Entity;

public class AuxiliarVeterinario extends Entity<AuxiliarVeterinarioID> {

    private  Nombre nombre;
    private  Funcion funcion;

    public AuxiliarVeterinario(AuxiliarVeterinarioID entityId, Nombre nombre, Funcion funcion) {
        super(entityId);
        this.nombre = nombre;
        this.funcion = funcion;
    }

    public Nombre nombre() {
        return nombre;
    }

}
