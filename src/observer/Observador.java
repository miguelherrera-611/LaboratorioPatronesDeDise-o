package observer;

// Cambia actualizar() por notificar()
// para coincidir con lo que llama ViajeContexto
public interface Observador {

    void notificar(String evento);
}