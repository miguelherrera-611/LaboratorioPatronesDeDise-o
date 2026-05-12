package observer;

/**
 * Interfaz Observador — contrato del patrón Observer.
 *
 * ¿Por qué interfaz y no clase abstracta?
 * Porque Observador NO tiene atributos ni comportamiento común.
 * Solo define que cualquier observador DEBE tener un método actualizar().
 * Una interfaz es suficiente cuando solo defines el contrato.
 */
public interface Observador {

    /**
     * Método que el Observable llama automáticamente
     * cuando ocurre un evento.
     *
     * @param evento  nombre del evento ocurrido
     * @param mensaje descripción del evento
     */
    void actualizar(String evento, String mensaje);
}