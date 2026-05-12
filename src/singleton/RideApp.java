package singleton;

// PATRÓN SINGLETON
// Problema: necesitamos UNA SOLA instancia central que maneje todo el sistema
// Si hubiera varias instancias, habría inconsistencias (viajes duplicados, etc.)
// Solución: Singleton garantiza que solo exista un objeto RideApp en toda la app
public class RideApp {

    // La única instancia (static para que sea compartida entre todos)
    private static RideApp instancia;

    // Constructor PRIVADO: nadie puede hacer "new RideApp()" desde afuera
    private RideApp() {
        System.out.println("[RideApp] Sistema RideApp iniciado.");
    }

    // Método público para obtener la instancia
    // Si no existe, la crea. Si ya existe, devuelve la misma.
    public static RideApp getInstance() {
        if (instancia == null) {
            instancia = new RideApp();
        }
        return instancia;
    }

    // Método que recibe la solicitud de viaje del pasajero
    public void recibirSolicitud(String nombrePasajero, String tipoViaje) {
        System.out.println("[RideApp] Solicitud recibida de: " + nombrePasajero + " | Tipo: " + tipoViaje);
    }
}