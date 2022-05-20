package co.com.huellitasdeamor.internacion.hospitalizacion.cuartohospitalizacion.valueobjects;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoDeEquipo implements ValueObject<String> {

    private final String value;

    public TipoDeEquipo(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("Este campo es obligatorio");
        }
        if (this.value.length() <= 2) {
            throw new IllegalArgumentException("debe tener mas de dos caracteres");
        }
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object prueba) {
        if (this == prueba) return true;
        if (prueba == null || getClass() != prueba.getClass()) return false;
        TipoDeEquipo that = (TipoDeEquipo) prueba;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
