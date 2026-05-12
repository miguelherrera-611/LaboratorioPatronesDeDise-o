package factory;

import model.Viaje;

public class TestFactory {

    public static void main(String[] args) {

        System.out.println("=== TEST FACTORY METHOD ===\n");

        Viaje v1 = ViajeFactory.crearViaje("premium");
        System.out.println(v1.describir());

        Viaje v2 = ViajeFactory.crearViaje("economico");
        System.out.println(v2.describir());

        Viaje v3 = ViajeFactory.crearViaje("moto");
        System.out.println(v3.describir());

        Viaje v4 = ViajeFactory.crearViaje("compartido");
        System.out.println(v4.describir());
    }
}