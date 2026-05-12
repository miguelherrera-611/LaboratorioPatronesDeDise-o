package state;

// Estado: el conductor fue asignado, el viaje puede iniciar o cancelarse
public class EstadoAsignado implements EstadoViaje {

    private ViajeContexto contexto;

    public EstadoAsignado(ViajeContexto contexto) {
        this.contexto = contexto;
    }

    @Override
    public void iniciarViaje() {
        System.out.println("[State] Viaje iniciado. El conductor está en camino.");
        contexto.setEstado(new EstadoEnCamino(contexto));
    }

    @Override
    public void finalizarViaje() {
        System.out.println("[State] No se puede finalizar: el viaje aún no ha iniciado.");
    }

    @Override
    public void cancelarViaje() {
        System.out.println("[State] Viaje cancelado desde estado Asignado.");
        contexto.setEstado(new EstadoCancelado(contexto));
    }

    @Override
    public String getNombre() { return "Asignado"; }
}