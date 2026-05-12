package state;

public class EstadoCancelado implements EstadoViaje {

    // contexto eliminado — este estado no hace transiciones
    public EstadoCancelado(ViajeContexto contexto) {
        // estado terminal, no necesita referencia al contexto
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
    public String getNombre() {
        return "Cancelado";
    }
}