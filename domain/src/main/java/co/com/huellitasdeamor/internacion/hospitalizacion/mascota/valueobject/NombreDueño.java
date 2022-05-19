package co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreDueño implements ValueObject<String> {

    private final String value;

    public NombreDueño(String value){
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }
}
