package app;

import singleton.RideApp;
import factory.ViajeFactory;
import builder.ViajeBuilder;
import mediator.CentralViajesMediator;
import observer.PasajeroObserver;
import observer.ConductorObserver;
import observer.UIObserver;
import state.ViajeContexto;
import model.Viaje;
import java.util.Scanner;

public class App {

    private Scanner scanner = new Scanner(System.in);

    public void ejecutarFlujoCompleto() {

        System.out.println("============================================");
        System.out.println("         BIENVENIDO A RIDEAPP");
        System.out.println("============================================\n");

        // --------------------------------------------------
        // PASO 1: Singleton
        // --------------------------------------------------
        RideApp sistema = RideApp.getInstance();

        // --------------------------------------------------
        // PASO 2: Datos del pasajero y tipo de viaje
        // --------------------------------------------------
        System.out.print("Ingresa el nombre del pasajero: ");
        String nombrePasajero = scanner.nextLine();

        System.out.println("Tipos de viaje disponibles: economico, premium, moto, compartido");
        System.out.print("Selecciona el tipo de viaje: ");
        String tipoViaje = scanner.nextLine();

        sistema.recibirSolicitud(nombrePasajero, tipoViaje);
        System.out.println();

        // --------------------------------------------------
        // PASO 3: Factory
        // --------------------------------------------------
        Viaje viaje;
        try {
            viaje = ViajeFactory.crearViaje(tipoViaje);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("Tipo inválido. Se usará económico por defecto.");
            viaje = ViajeFactory.crearViaje("economico");
        }
        System.out.println();

        // --------------------------------------------------
        // PASO 4: Builder — opciones del viaje
        // --------------------------------------------------
        System.out.println("--- Configura las opciones del viaje ---");
        boolean wifi = pedirOpcion("¿Desea Wifi? (s/n): ");
        boolean ac = pedirOpcion("¿Desea Aire Acondicionado? (s/n): ");
        boolean music = pedirOpcion("¿Desea Música? (s/n): ");
        boolean equip = pedirOpcion("¿Lleva Equipaje? (s/n): ");
        boolean masco = pedirOpcion("¿Viaja con Mascota? (s/n): ");

        System.out.print("¿Cuántos pasajeros? (1-4): ");
        int pasajeros = 1;
        try {
            pasajeros = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido. Se usará 1 pasajero.");
        }

        viaje = new ViajeBuilder(viaje)
                .setWifi(wifi)
                .setAireAcondicionado(ac)
                .setMusica(music)
                .setEquipaje(equip)
                .setMascota(masco)
                .setNumeroPasajeros(pasajeros)
                .build();

        System.out.println();

        // --------------------------------------------------
        // PASO 5: Nombre del conductor
        // --------------------------------------------------
        System.out.print("Ingresa el nombre del conductor asignado: ");
        String nombreConductor = scanner.nextLine();

        // --------------------------------------------------
        // PASO 6: State + Observer
        // --------------------------------------------------
        ViajeContexto contexto = new ViajeContexto();

        contexto.agregarObservador(new PasajeroObserver(nombrePasajero));
        contexto.agregarObservador(new ConductorObserver(nombreConductor));
        contexto.agregarObservador(new UIObserver());

        System.out.println();

        // --------------------------------------------------
        // PASO 7: Mediator
        // --------------------------------------------------
        CentralViajesMediator mediator = new CentralViajesMediator();
        mediator.asignarConductor(nombrePasajero, nombreConductor, contexto);

        System.out.println();

        // --------------------------------------------------
        // PASO 8: Menú de acciones
        // --------------------------------------------------
        boolean corriendo = true;
        while (corriendo) {
            System.out.println("--- Acciones disponibles ---");
            System.out.println("1. Iniciar viaje");
            System.out.println("2. Finalizar viaje");
            System.out.println("3. Cancelar viaje");
            System.out.println("4. Ver estado actual");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");

            String opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "1":
                    contexto.iniciarViaje();
                    break;
                case "2":
                    contexto.finalizarViaje();
                    break;
                case "3":
                    contexto.cancelarViaje();
                    break;
                case "4":
                    System.out.println("[App] Estado actual: "
                            + contexto.getEstado().getNombre());
                    break;
                case "0":
                    corriendo = false;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
            System.out.println();
        }

        // --------------------------------------------------
        // RESULTADO FINAL
        // --------------------------------------------------
        System.out.println("============================================");
        System.out.println("[App] Estado final: " + contexto.getEstado().getNombre());
        System.out.println("[App] Viaje: " + viaje.toString());
        System.out.println("============================================");
    }

    // Método auxiliar para preguntas s/n
    private boolean pedirOpcion(String pregunta) {
        System.out.print(pregunta);
        String resp = scanner.nextLine().trim().toLowerCase();
        return resp.equals("s") || resp.equals("si") || resp.equals("sí");
    }
}