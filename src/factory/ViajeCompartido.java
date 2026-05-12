package factory;

import model.Viaje;

public class ViajeCompartido extends Viaje {

    private int capacidadMaxima;

    public ViajeCompartido() {
        super("Compartido", 4000.0, 1);
        this.capacidadMaxima = 4;
    }

    @Override
    public String obtenerCaracteristicas() {
        return "Hasta " + capacidadMaxima + " pasajeros, ruta optimizada";
    }
}