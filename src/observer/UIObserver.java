package observer;

public class UIObserver implements Observador {

    @Override
    public void notificar(String evento) {
        System.out.println("[Observer][UI] Actualizando interfaz → " + evento);
    }
}