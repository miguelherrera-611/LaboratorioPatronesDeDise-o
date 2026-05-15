package observer;

public class PasajeroObserver implements Observador {

    private String nombre;

    public PasajeroObserver(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void notificar(String evento) {
        System.out.println("[Observer][Pasajero - " + nombre + "] " + evento);
    }

    public String getNombre() {
        return nombre;
    }
}