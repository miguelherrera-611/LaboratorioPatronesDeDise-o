package mediator;

import state.EstadoAsignado;
import state.ViajeContexto;

// PATRÓN MEDIATOR
// Problema: el pasajero no debería hablar directamente con el conductor (ni al revés)
// Solución: la central de viajes coordina todo — es el intermediario
// Así evitamos que las clases se conozcan entre sí directamente (bajo acoplamiento)
public class CentralViajesMediator {

    // El mediator recibe la solicitud del pasajero y asigna un conductor al viaje
    public void asignarConductor(String nombrePasajero, String nombreConductor, ViajeContexto viaje) {

        System.out.println("[Mediator] Central de viajes procesando solicitud...");
        System.out.println("[Mediator] Pasajero '" + nombrePasajero + "' solicita conductor.");
        System.out.println("[Mediator] Conductor '" + nombreConductor + "' asignado al viaje.");

        // Cambiamos el estado del viaje a Asignado (ya tiene conductor)
        viaje.setEstado(new EstadoAsignado(viaje));

        // Notificamos a todos los suscritos que el conductor fue asignado
        viaje.notificarObservadores("Conductor " + nombreConductor + " asignado a " + nombrePasajero);
    }
}