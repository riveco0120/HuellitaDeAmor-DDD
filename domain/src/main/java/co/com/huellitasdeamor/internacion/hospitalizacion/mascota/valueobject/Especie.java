package co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Especie implements ValueObject<String> {

    private final String value;

    public Especie(String value){
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }
}
