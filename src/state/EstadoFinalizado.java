package state;

public class EstadoFinalizado implements EstadoViaje {

    // contexto eliminado — este estado no hace transiciones
    public EstadoFinalizado(ViajeContexto contexto) {
        // estado terminal, no necesita referencia al contexto
    }

    @Override
    public void iniciarViaje() {
        System.out.println("[State] El viaje ya finalizó. No se puede iniciar de nuevo.");
    }

    @Override
    public void finalizarViaje() {
        System.out.println("[State] El viaje ya finalizó.");
    }

    @Override
    public void cancelarViaje() {
        System.out.println("[State] El viaje ya finalizó. No se puede cancelar.");
    }

    @Override
    public String getNombre() {
        return "Finalizado";
    }
}