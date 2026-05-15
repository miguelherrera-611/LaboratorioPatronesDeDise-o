package mediator;

import state.EstadoAsignado;
import state.ViajeContexto;

// PATRÓN MEDIATOR
// Problema: el pasajero no debería hablar directamente con el conductor (ni al revés)
// Solución: la central de viajes coordina todo — es el intermediario
public class CentralViajesMediator {

    public void asignarConductor(String nombrePasajero, String nombreConductor, ViajeContexto viaje) {
        System.out.println("[Mediator] Central de viajes procesando solicitud...");
        System.out.println("[Mediator] Pasajero '" + nombrePasajero + "' solicita conductor.");
        System.out.println("[Mediator] Conductor asignado: " + nombreConductor);

        // Cambia estado a Asignado — esto ya notifica a los observers automáticamente
        viaje.setEstado(new EstadoAsignado(viaje));

        // NO llamamos notificarObservadores aquí de nuevo para evitar duplicados
    }
}