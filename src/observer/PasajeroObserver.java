package observer;

/**
 * PasajeroObserver — observador concreto.
 *
 * Implementa Observador y define cómo reacciona
 * un pasajero ante cada evento del viaje.
 */
public class PasajeroObserver implements Observador {

    private String nombre;

    public PasajeroObserver(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(String evento, String mensaje) {

        switch (evento) {
            case "VIAJE_SOLICITADO":
                System.out.println("[Pasajero - " + nombre + "] "
                        + "Tu viaje fue recibido. Buscando conductor...");
                break;
            case "CONDUCTOR_ASIGNADO":
                System.out.println("[Pasajero - " + nombre + "] "
                        + "¡Conductor asignado! " + mensaje);
                break;
            case "VIAJE_INICIADO":
                System.out.println("[Pasajero - " + nombre + "] "
                        + "Tu viaje ha comenzado. ¡Buen viaje!");
                break;
            case "VIAJE_FINALIZADO":
                System.out.println("[Pasajero - " + nombre + "] "
                        + "Viaje completado. " + mensaje);
                break;
            case "VIAJE_CANCELADO":
                System.out.println("[Pasajero - " + nombre + "] "
                        + "Tu viaje fue cancelado. " + mensaje);
                break;
            default:
                System.out.println("[Pasajero - " + nombre + "] "
                        + "Notificación: " + mensaje);
        }
    }

    public String getNombre() {
        return nombre;
    }
}