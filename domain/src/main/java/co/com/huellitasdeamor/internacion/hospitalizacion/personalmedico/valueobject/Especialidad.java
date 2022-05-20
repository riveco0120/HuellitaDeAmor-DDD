package co.com.huellitasdeamor.internacion.hospitalizacion.personalmedico.valueobject;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Especialidad implements ValueObject<String> {

    private final String value;

    public Especialidad(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("Debe Contener almenos una especialidad");
        }
        if (this.value.length() <= 2) {
            throw new IllegalArgumentException("La especialidad debe tener mas de dos caracteres");
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
        Especialidad that = (Especialidad) prueba;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
