package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Especialidad implements ValueObject<String> {

    private final String value;

    public Especialidad(String value){
        this.value= Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }
}
