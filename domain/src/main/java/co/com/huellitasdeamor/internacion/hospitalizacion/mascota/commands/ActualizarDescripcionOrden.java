package co.com.huellitasdeamor.internacion.hospitalizacion.mascota.commands;

import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.DescripcionOrden;
import co.com.huellitasdeamor.internacion.hospitalizacion.mascota.valueobject.MascotaID;
import co.com.sofka.domain.generic.Command;

public class ActualizarDescripcionOrden extends Command {
    private final MascotaID mascotaID;
    private final DescripcionOrden descripcionOrden;

    public ActualizarDescripcionOrden(MascotaID mascotaID, DescripcionOrden descripcionOrden) {
        this.mascotaID = mascotaID;
        this.descripcionOrden = descripcionOrden;
    }

    public MascotaID getMascotaID() {
        return mascotaID;
    }

    public DescripcionOrden getDescripcionOrden() {
        return descripcionOrden;
    }
}
