package factory;

import model.Viaje;

public class ViajeMoto extends Viaje {

    public ViajeMoto() {
        super("Moto", 3500.0, 2);
    }

    @Override
    public String obtenerCaracteristicas() {
        return "Moto, solo 1 pasajero, casco incluido";
    }
}