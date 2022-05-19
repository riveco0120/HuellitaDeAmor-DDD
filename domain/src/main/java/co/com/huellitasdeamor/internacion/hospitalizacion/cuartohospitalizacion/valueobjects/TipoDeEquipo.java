package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoDeEquipo implements ValueObject<String> {

    private final String value;

    public TipoDeEquipo(String value){
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }
}
