package builder;

import model.Viaje;

// PATRÓN BUILDER
// Problema: los viajes tienen muchas opciones opcionales (wifi, mascota, equipaje...)
// Si las ponemos en el constructor quedaría: new Viaje(true, false, true, false, true, 2) — muy confuso
// Solución: Builder permite configurar paso a paso de forma legible
public class ViajeBuilder {

    private Viaje viaje; // El viaje que vamos construyendo

    // Constructor: recibe el viaje ya creado por Factory y lo va a configurar
    public ViajeBuilder(Viaje viaje) {
        this.viaje = viaje;
        System.out.println("[Builder] Iniciando configuración del viaje...");
    }

    // Cada método configura una opción y devuelve "this" para poder encadenar llamadas
    public ViajeBuilder setWifi(boolean wifi) {
        this.viaje.setWifi(wifi);
        return this; // permite encadenar: .setWifi(true).setMascota(false)
    }

    public ViajeBuilder setMascota(boolean mascota) {
        this.viaje.setMascota(mascota);
        return this;
    }

    public ViajeBuilder setAireAcondicionado(boolean ac) {
        this.viaje.setAireAcondicionado(ac);
        return this;
    }

    public ViajeBuilder setEquipaje(boolean equipaje) {
        this.viaje.setEquipaje(equipaje);
        return this;
    }

    public ViajeBuilder setMusica(boolean musica) {
        this.viaje.setMusica(musica);
        return this;
    }

    public ViajeBuilder setNumeroPasajeros(int n) {
        this.viaje.setNumeroPasajeros(n);
        return this;
    }

    // build() es el último paso: termina la configuración y devuelve el viaje listo
    public Viaje build() {
        System.out.println("[Builder] Viaje configurado: " + viaje);
        return viaje;
    }
}