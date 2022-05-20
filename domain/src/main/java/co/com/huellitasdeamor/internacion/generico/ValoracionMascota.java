package co.com.huellitasdeamor.internacion.generico;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ValoracionMascota implements ValueObject<Double> {
    private final Double value;

    public ValoracionMascota(Double value) {
        this.value = Objects.requireNonNull(value);
        if (this.value < 0) {
            throw new IllegalArgumentException("No puede ser un valor negativo");
        }

        if (this.value > 100) {
            throw new IllegalArgumentException("No es un promedio valido");
        }
    }

    @Override
    public Double value() {
        return value;
    }

    @Override
    public boolean equals(Object prueba) {
        if (this == prueba) return true;
        if (prueba == null || getClass() != prueba.getClass()) return false;
        ValoracionMascota that = (ValoracionMascota) prueba;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}