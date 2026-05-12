package factory;

import model.Viaje;

public class ViajePremium extends Viaje {

    public ViajePremium() {
        super("Premium", 18000.0, 3);
    }

    @Override
    public String obtenerCaracteristicas() {
        return "Vehículo de lujo, conductor calificado, agua incluida";
    }
}