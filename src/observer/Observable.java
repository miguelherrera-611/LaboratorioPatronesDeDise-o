package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Observable — base del patrón Observer.
 *
 * ¿Por qué clase abstracta y no interfaz?
 * Porque Observable SÍ tiene estado propio (la lista de observadores)
 * y comportamiento compartido (suscribir, desuscribir, notificar).
 * No queremos repetir esa lógica en cada clase observable.
 *
 * ¿Quién extiende Observable?
 * Cualquier clase que necesite emitir eventos — en RideApp,
 * el Viaje o el RideApp central extenderán esta clase.
 */
public abstract class Observable {

    // Lista de todos los observadores suscritos
    private List<Observador> observadores = new ArrayList<>();

    /**
     * Agrega un observador a la lista.
     * Desde este momento recibirá todas las notificaciones.
     */
    public void suscribir(Observador observador) {
        observadores.add(observador);
        System.out.println("[Observer] Suscrito: "
                + observador.getClass().getSimpleName());
    }

    /**
     * Elimina un observador de la lista.
     * Deja de recibir notificaciones.
     */
    public void desuscribir(Observador observador) {
        observadores.remove(observador);
        System.out.println("[Observer] Desuscrito: "
                + observador.getClass().getSimpleName());
    }

    /**
     * Notifica a TODOS los observadores suscritos.
     *
     * ¿Por qué protected y no public?
     * Porque solo las subclases deben poder emitir eventos.
     * Nadie externo debería llamar notificar() directamente.
     *
     * @param evento  nombre del evento
     * @param mensaje descripción del evento
     */
    protected void notificar(String evento, String mensaje) {
        System.out.println("[Observer] Notificando evento: " + evento);
        for (Observador obs : observadores) {
            obs.actualizar(evento, mensaje);
        }
    }
}