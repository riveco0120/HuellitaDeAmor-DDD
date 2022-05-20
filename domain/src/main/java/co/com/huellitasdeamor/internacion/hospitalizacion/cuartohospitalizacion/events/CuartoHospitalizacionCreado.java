package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.events;


import co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects.NivelDeRiesgo;
import co.com.sofka.domain.generic.DomainEvent;

public class CuartoHospitalizacionCreado extends DomainEvent {

    private final NivelDeRiesgo nivelDeRiesgo;

    public CuartoHospitalizacionCreado(NivelDeRiesgo nivelDeRiesgo) {
        super("hullitadeamor.cuartohospitalizacion.cuartohospitalizacioncreado");
        this.nivelDeRiesgo=nivelDeRiesgo;
    }

    public NivelDeRiesgo getNivelDeRiesgo() {
        return nivelDeRiesgo;
    }
}