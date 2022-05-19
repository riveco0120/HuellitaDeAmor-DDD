package co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class FechaOrdenMedica implements ValueObject<String> {

    DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");

    private final LocalDateTime fecha;

    public FechaOrdenMedica(LocalDateTime fecha) {
        this.fecha = Objects.requireNonNull(fecha);

    }

    @Override
    public String value() {
        return formato.format(fecha);

    }
}
