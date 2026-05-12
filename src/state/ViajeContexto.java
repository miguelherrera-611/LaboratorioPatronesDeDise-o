package state;

import observer.Observable;
import observer.Observador;
import java.util.ArrayList;
import java.util.List;

// Esta clase ES el viaje en cuanto a su ciclo de vida
// Guarda el estado actual y notifica a los observadores cuando cambia
// También implementa Observable para poder notificar eventos
public class ViajeContexto implements Observable {

    private EstadoViaje estadoActual;           // El estado en que está ahora el viaje
    private List<Observador> observadores = new ArrayList<>(); // Lista de suscritos

    public ViajeContexto() {
        // El viaje siempre empieza en estado Solicitado
        this.estadoActual = new EstadoSolicitado(this);
        System.out.println("[State] Estado inicial: " + estadoActual.getNombre());
    }

    // Cambiar estado (lo llaman los estados internamente)
    public void setEstado(EstadoViaje nuevoEstado) {
        this.estadoActual = nuevoEstado;
        System.out.println("[State] Estado actual: " + estadoActual.getNombre());
        notificarObservadores("Estado cambiado a: " + estadoActual.getNombre());
    }

    public EstadoViaje getEstado() { return estadoActual; }

    // Delegamos las acciones al estado actual
    public void iniciarViaje()   { estadoActual.iniciarViaje(); }
    public void finalizarViaje() { estadoActual.finalizarViaje(); }
    public void cancelarViaje()  { estadoActual.cancelarViaje(); }

    // --- Observer: gestión de suscritos ---
    @Override
    public void agregarObservador(Observador o) {
        observadores.add(o);
    }

    @Override
    public void quitarObservador(Observador o) {
        observadores.remove(o);
    }

    @Override
    public void notificarObservadores(String evento) {
        for (Observador o : observadores) {
            o.notificar(evento);
        }
    }
}