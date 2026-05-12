package state;

// PATRÓN STATE
// Problema: el viaje tiene distintos comportamientos según su estado
// Sin este patrón tendríamos: if(estado=="solicitado") ... else if(estado=="asignado") ... (muy feo y difícil de mantener)
// Solución: cada estado es una clase propia con sus acciones permitidas

// Interfaz base para todos los estados del viaje
public interface EstadoViaje {
    void iniciarViaje();   // Solo permitido en estado Asignado
    void finalizarViaje(); // Solo permitido en estado EnCamino
    void cancelarViaje();  // Permitido en Solicitado y Asignado
    String getNombre();    // Devuelve el nombre del estado para mostrarlo
}