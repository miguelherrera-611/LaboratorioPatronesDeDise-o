package state;

public class EstadoEnCamino implements EstadoViaje {

    private ViajeContexto contexto;

    public EstadoEnCamino(ViajeContexto contexto) {
        this.contexto = contexto;
    }

    @Override
    public void iniciarViaje() {
        System.out.println("[State] El viaje ya está en curso.");
    }

    @Override
    public void finalizarViaje() {
        System.out.println("[State] Viaje finalizado. ¡Llegaron al destino!");
        contexto.setEstado(new EstadoFinalizado(contexto));
    }

    @Override
    public void cancelarViaje() {
        System.out.println("[State] No se puede cancelar: el viaje ya está en curso.");
    }

    @Override
    public String getNombre() { return "EnCamino"; }
}