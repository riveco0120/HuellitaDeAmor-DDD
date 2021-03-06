package co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DescripcionOrden implements ValueObject<String> {

    private final String value;

    public DescripcionOrden(String value){
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
        DescripcionOrden that = (DescripcionOrden) prueba;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
