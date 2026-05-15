package observer;

// Cambia de clase abstracta a interfaz
// para que ViajeContexto pueda hacer "implements Observable"
public interface Observable {

    void agregarObservador(Observador o);

    void quitarObservador(Observador o);

    void notificarObservadores(String evento);
}