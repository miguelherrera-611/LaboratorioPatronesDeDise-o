package observer;

/**
 * ConductorObserver — observador concreto.
 *
 * Reacciona a los mismos eventos pero desde
 * la perspectiva del conductor.
 */
public class ConductorObserver implements Observador {

    private String nombre;

    public ConductorObserver(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(String evento, String mensaje) {

        switch (evento) {
            case "CONDUCTOR_ASIGNADO":
                System.out.println("[Conductor - " + nombre + "] "
                        + "Nuevo viaje asignado. " + mensaje);
                break;
            case "VIAJE_INICIADO":
                System.out.println("[Conductor - " + nombre + "] "
                        + "Viaje iniciado. En camino al destino.");
                break;
            case "VIAJE_FINALIZADO":
                System.out.println("[Conductor - " + nombre + "] "
                        + "Viaje finalizado. Ganancia registrada.");
                break;
            case "VIAJE_CANCELADO":
                System.out.println("[Conductor - " + nombre + "] "
                        + "El viaje fue cancelado. " + mensaje);
                break;
            default:
                break;
        }
    }

    public String getNombre() {
        return nombre;
    }
}