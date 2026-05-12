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

// Esta clase conecta todos los patrones juntos
// Es el "director de orquesta" del flujo completo del sistema
public class App {

    public void ejecutarFlujoCompleto() {

        System.out.println("============================================");
        System.out.println("         BIENVENIDO A RIDEAPP");
        System.out.println("============================================\n");

        // --------------------------------------------------
        // PASO 1: Singleton — obtener la única instancia del sistema
        // --------------------------------------------------
        RideApp sistema = RideApp.getInstance();
        sistema.recibirSolicitud("Carlos", "premium");

        System.out.println();

        // --------------------------------------------------
        // PASO 2: Factory — crear el tipo de viaje
        // --------------------------------------------------
        Viaje viaje = ViajeFactory.crearViaje("premium");

        System.out.println();

        // --------------------------------------------------
        // PASO 3: Builder — configurar las opciones del viaje
        // --------------------------------------------------
        viaje = new ViajeBuilder(viaje)
                .setWifi(true)
                .setAireAcondicionado(true)
                .setEquipaje(false)
                .setMascota(false)
                .setMusica(true)
                .setNumeroPasajeros(1)
                .build();

        System.out.println();

        // --------------------------------------------------
        // PASO 4: State + Observer — crear el contexto del viaje y suscribir observadores
        // --------------------------------------------------
        ViajeContexto contexto = new ViajeContexto(); // Estado inicial: Solicitado

        // Observer: suscribimos a quienes quieren ser notificados
        contexto.agregarObservador(new PasajeroObserver("Carlos"));
        contexto.agregarObservador(new ConductorObserver("Juan"));
        contexto.agregarObservador(new UIObserver());

        System.out.println();

        // --------------------------------------------------
        // PASO 5: Mediator — asignar conductor (cambia estado a Asignado + notifica)
        // --------------------------------------------------
        CentralViajesMediator mediator = new CentralViajesMediator();
        mediator.asignarConductor("Carlos", "Juan", contexto);

        System.out.println();

        // --------------------------------------------------
        // PASO 6: State — iniciar el viaje (cambia estado a EnCamino + notifica)
        // --------------------------------------------------
        System.out.println("[App] Iniciando el viaje...");
        contexto.iniciarViaje();

        System.out.println();

        // --------------------------------------------------
        // PASO 7: State — finalizar el viaje (cambia estado a Finalizado + notifica)
        // --------------------------------------------------
        System.out.println("[App] Finalizando el viaje...");
        contexto.finalizarViaje();

        System.out.println();

        // --------------------------------------------------
        // RESULTADO FINAL
        // --------------------------------------------------
        System.out.println("============================================");
        System.out.println("[App] Estado final del viaje: " + contexto.getEstado().getNombre());
        System.out.println("============================================");
    }
}