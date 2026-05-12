package state;

// Estado final: el viaje terminó, no se puede hacer nada más
public class EstadoFinalizado implements EstadoViaje {

    private ViajeContexto contexto;

    public EstadoFinalizado(ViajeContexto contexto) {
        this.contexto = contexto;
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
    public String getNombre() { return "Finalizado"; }
}