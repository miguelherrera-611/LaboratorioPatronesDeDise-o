package observer;

public class TestObserver {

    public static void main(String[] args) {

        System.out.println("=== TEST OBSERVER ===\n");

        // Crear observadores
        PasajeroObserver pasajero = new PasajeroObserver("Tati");
        ConductorObserver conductor = new ConductorObserver("Carlos");
        UIObserver ui = new UIObserver();

        // Crear un observable de prueba
        Observable fuente = new Observable() {
        };

        // Suscribir observadores
        fuente.suscribir(pasajero);
        fuente.suscribir(conductor);
        fuente.suscribir(ui);

        System.out.println();

        // Simular eventos del flujo del viaje
        fuente.notificar("VIAJE_SOLICITADO", "Origen: Calle 50");
        System.out.println();

        fuente.notificar("CONDUCTOR_ASIGNADO", "Carlos está en camino");
        System.out.println();

        fuente.notificar("VIAJE_INICIADO", "Destino: Aeropuerto");
        System.out.println();

        fuente.notificar("VIAJE_FINALIZADO", "Tarifa: $18.000");
    }
}