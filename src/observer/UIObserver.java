package observer;

/**
 * UIObserver — observador concreto.
 *
 * Simula la actualización de la interfaz gráfica.
 * En un sistema real este observer actualizaría
 * pantallas, mapas, estados visuales, etc.
 */
public class UIObserver implements Observador {

    @Override
    public void actualizar(String evento, String mensaje) {
        System.out.println("[UI] Actualizando interfaz → "
                + evento + ": " + mensaje);
    }
}