package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Funcion implements ValueObject<String> {

    private final String value;

    public Funcion(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("Debe Contener almenos una funcion");
        }
        if (this.value.length() <= 2) {
            throw new IllegalArgumentException("La funcion debe tener mas de dos caracteres");
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
        Funcion that = (Funcion) prueba;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
