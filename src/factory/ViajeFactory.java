package factory;

import model.Viaje;

public class ViajeFactory {

    private ViajeFactory() {
    }

    public static Viaje crearViaje(String tipo) {
        String t = tipo.trim().toLowerCase();
        System.out.println("[Factory] Creando viaje tipo: " + t);

        switch (t) {
            case "economico":
                return new ViajeEconomico();
            case "premium":
                return new ViajePremium();
            case "moto":
                return new ViajeMoto();
            case "compartido":
                return new ViajeCompartido();
            default:
                throw new IllegalArgumentException(
                        "[Factory] Tipo desconocido: " + tipo);
        }
    }
}