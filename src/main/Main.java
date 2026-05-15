package main;

import app.App;

// PUNTO DE ENTRADA DEL PROGRAMA
// Solo llama a App para que ejecute el flujo completo
// Así el main queda limpio y simple
public class Main {

    public static void main(String[] args) {
        App app = new App();
        app.ejecutarFlujoCompleto();
    }
}