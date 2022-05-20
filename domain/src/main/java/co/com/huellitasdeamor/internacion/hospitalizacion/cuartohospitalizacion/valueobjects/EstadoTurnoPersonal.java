package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class EstadoTurnoPersonal implements ValueObject<EstadoMascota.Estados> {

    private final EstadoTurnoPersonal.Estados value;

    public EstadoTurnoPersonal(EstadoTurnoPersonal.Estados value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public EstadoMascota.Estados value() {
        return value();
    }

    public enum Estados {
        INGRESO,FINALIZO, POR_INICIAR
    }
}
