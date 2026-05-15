package state;

// Estado: el viaje fue solicitado pero aún no tiene conductor asignado
// Acciones permitidas: solo cancelar
public class EstadoSolicitado implements EstadoViaje {

    private ViajeContexto contexto;

    public EstadoSolicitado(ViajeContexto contexto) {
        this.contexto = contexto;
    }

    @Override
    public void iniciarViaje() {
        // No se puede iniciar sin conductor asignado primero
        System.out.println("[State] No se puede iniciar: el viaje aún no tiene conductor asignado.");
    }

    @Override
    public void finalizarViaje() {
        System.out.println("[State] No se puede finalizar: el viaje ni siquiera ha iniciado.");
    }

    @Override
    public void cancelarViaje() {
        System.out.println("[State] Viaje cancelado desde estado Solicitado.");
        contexto.setEstado(new EstadoCancelado(contexto));
    }

    @Override
    public String getNombre() { return "Solicitado"; }
}