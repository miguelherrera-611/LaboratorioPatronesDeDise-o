package factory;

import model.Viaje;

public class ViajeEconomico extends Viaje {

    public ViajeEconomico() {
        super("Económico", 5000.0, 1);
    }

    @Override
    public String obtenerCaracteristicas() {
        return "Vehículo compacto, sin extras";
    }
}