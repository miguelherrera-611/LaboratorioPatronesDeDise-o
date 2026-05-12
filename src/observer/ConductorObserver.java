package observer;

public class ConductorObserver implements Observador {

    private String nombre;

    public ConductorObserver(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void notificar(String evento) {
        System.out.println("[Observer][Conductor - " + nombre + "] " + evento);
    }

    public String getNombre() {
        return nombre;
    }
}