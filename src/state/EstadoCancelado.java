package state;

// Estado: el viaje fue cancelado, no se puede hacer nada
public class EstadoCancelado implements EstadoViaje {

    private ViajeContexto contexto;

    public EstadoCancelado(ViajeContexto contexto) {
        this.contexto = contexto;
    }

    @Override
    public void iniciarViaje() {
        System.out.println("[State] El viaje fue cancelado. No se puede iniciar.");
    }

    @Override
    public void finalizarViaje() {
        System.out.println("[State] El viaje fue cancelado. No se puede finalizar.");
    }

    @Override
    public void cancelarViaje() {
        System.out.println("[State] El viaje ya está cancelado.");
    }

    @Override
    public String getNombre() { return "Cancelado"; }
}