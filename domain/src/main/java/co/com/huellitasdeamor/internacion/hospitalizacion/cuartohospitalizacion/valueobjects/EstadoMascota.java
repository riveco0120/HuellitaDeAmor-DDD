package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class EstadoMascota implements ValueObject<EstadoMascota.Estados>{

    private final Estados value;

    public EstadoMascota(Estados value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Estados value() {
        return value();
    }

    public enum Estados {
        INGRESO,OBSERVACION,ALTA,POR_INICIAR
    }
}
