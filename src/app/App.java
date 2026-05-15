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

        // PASO 1: Singleton
        RideApp sistema = RideApp.getInstance();

        // PASO 2: Nombre del pasajero
        String nombrePasajero = "";
        while (nombrePasajero.isEmpty()) {
            System.out.print("Ingresa el nombre del pasajero: ");
            nombrePasajero = scanner.nextLine().trim();
            if (nombrePasajero.isEmpty())
                System.out.println("⚠  El nombre no puede estar vacío.");
        }

        // PASO 3: Tipo de viaje
        String[] tiposValidos = {"economico", "premium", "moto", "compartido"};
        String tipoViaje = "";
        while (tipoViaje.isEmpty()) {
            System.out.println("Tipos disponibles: economico, premium, moto, compartido");
            System.out.print("Selecciona el tipo de viaje: ");
            tipoViaje = scanner.nextLine().trim().toLowerCase();
            if (!esValido(tipoViaje, tiposValidos)) {
                System.out.println("⚠  Tipo inválido. Escribe exactamente una de las opciones.");
                tipoViaje = "";
            }
        }

        sistema.recibirSolicitud(nombrePasajero, tipoViaje);
        System.out.println();

        // PASO 4: Factory
        Viaje viaje = ViajeFactory.crearViaje(tipoViaje);
        System.out.println();

        // PASO 5: Builder — si es moto no se piden opciones, va directo con 1 pasajero
        if (tipoViaje.equals("moto")) {
            System.out.println("--- Moto: sin opciones adicionales, 1 pasajero ---");
            viaje = new ViajeBuilder(viaje)
                    .setNumeroPasajeros(1)
                    .build();
        } else {
            System.out.println("--- Configura las opciones del viaje ---");
            boolean wifi  = pedirOpcion("¿Desea Wifi? (s/n): ");
            boolean ac    = pedirOpcion("¿Desea Aire Acondicionado? (s/n): ");
            boolean music = pedirOpcion("¿Desea Música? (s/n): ");
            boolean equip = pedirOpcion("¿Lleva Equipaje? (s/n): ");
            boolean masco = pedirOpcion("¿Viaja con Mascota? (s/n): ");

            int pasajeros = 0;
            while (pasajeros < 1 || pasajeros > 4) {
                System.out.print("¿Cuántos pasajeros? (1-4): ");
                try {
                    pasajeros = Integer.parseInt(scanner.nextLine().trim());
                    if (pasajeros < 1 || pasajeros > 4)
                        System.out.println("⚠  Solo se permiten entre 1 y 4 pasajeros.");
                } catch (NumberFormatException e) {
                    System.out.println("⚠  Ingresa un número válido (1, 2, 3 o 4).");
                }
            }

            viaje = new ViajeBuilder(viaje)
                    .setWifi(wifi).setAireAcondicionado(ac).setMusica(music)
                    .setEquipaje(equip).setMascota(masco).setNumeroPasajeros(pasajeros)
                    .build();
        }

        System.out.println();

        // PASO 6: Conductor
        String nombreConductor = "";
        while (nombreConductor.isEmpty()) {
            System.out.print("Ingresa el nombre del conductor asignado: ");
            nombreConductor = scanner.nextLine().trim();
            if (nombreConductor.isEmpty())
                System.out.println("⚠  El nombre del conductor no puede estar vacío.");
        }

        // PASO 7: State + Observer
        ViajeContexto contexto = new ViajeContexto();
        contexto.agregarObservador(new PasajeroObserver(nombrePasajero));
        contexto.agregarObservador(new ConductorObserver(nombreConductor));
        contexto.agregarObservador(new UIObserver());
        System.out.println();

        // PASO 8: Menú dinámico según estado
        CentralViajesMediator mediator = new CentralViajesMediator();
        boolean corriendo = true;

        while (corriendo) {
            String estado = contexto.getEstado().getNombre();

            System.out.println("--- Acciones disponibles [Estado: " + estado + "] ---");

            switch (estado) {
                case "Solicitado":
                    System.out.println("1. Buscar conductor y asignar viaje");
                    System.out.println("3. Cancelar viaje");
                    break;
                case "Asignado":
                    System.out.println("2. Iniciar viaje");
                    System.out.println("3. Cancelar viaje");
                    break;
                case "EnCamino":
                    System.out.println("4. Finalizar viaje");
                    break;
                case "Finalizado":
                    System.out.println("El viaje ha finalizado. No hay acciones disponibles.");
                    corriendo = false;
                    break;
                case "Cancelado":
                    System.out.println("El viaje fue cancelado. No hay acciones disponibles.");
                    corriendo = false;
                    break;
            }

            if (!corriendo) break;

            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            String opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "1":
                    if (estado.equals("Solicitado")) {
                        mediator.asignarConductor(nombrePasajero, nombreConductor, contexto);
                    } else {
                        System.out.println("⚠  Esa opción no está disponible ahora.");
                    }
                    break;
                case "2":
                    if (estado.equals("Asignado")) {
                        contexto.iniciarViaje();
                    } else {
                        System.out.println("⚠  Esa opción no está disponible ahora.");
                    }
                    break;
                case "3":
                    if (estado.equals("Solicitado") || estado.equals("Asignado")) {
                        contexto.cancelarViaje();
                    } else {
                        System.out.println("⚠  Esa opción no está disponible ahora.");
                    }
                    break;
                case "4":
                    if (estado.equals("EnCamino")) {
                        contexto.finalizarViaje();
                    } else {
                        System.out.println("⚠  Esa opción no está disponible ahora.");
                    }
                    break;
                case "0":
                    corriendo = false;
                    break;
                default:
                    System.out.println("⚠  Opción inválida. Elige solo entre las opciones mostradas.");
            }
            System.out.println();
        }

        // RESULTADO FINAL
        System.out.println("============================================");
        System.out.println("[App] Estado final: " + contexto.getEstado().getNombre());
        System.out.println("[App] Viaje: " + viaje.toString());
        System.out.println("============================================");
    }

    private boolean pedirOpcion(String pregunta) {
        while (true) {
            System.out.print(pregunta);
            String resp = scanner.nextLine().trim().toLowerCase();
            if (resp.equals("s") || resp.equals("n")) return resp.equals("s");
            System.out.println("⚠  Escribe solo 's' para sí o 'n' para no.");
        }
    }

    private boolean esValido(String valor, String[] opciones) {
        for (String op : opciones) {
            if (op.equals(valor)) return true;
        }
        return false;
    }
}