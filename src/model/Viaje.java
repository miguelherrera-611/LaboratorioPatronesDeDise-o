package model;

// Clase principal que representa un viaje
// Tiene tipo (economico, premium, etc.) y opciones extra
public class Viaje {

    private String tipo;        // Tipo de viaje: economico, premium, moto, compartido
    private boolean wifi;
    private boolean mascota;
    private boolean aireAcondicionado;
    private boolean equipaje;
    private boolean musica;
    private int numeroPasajeros;

    // Constructor básico (solo con tipo)
    public Viaje(String tipo) {
        this.tipo = tipo;
        this.numeroPasajeros = 1; // por defecto 1 pasajero
    }

    // Getters y setters
    public String getTipo() { return tipo; }

    public boolean tieneWifi() { return wifi; }
    public void setWifi(boolean wifi) { this.wifi = wifi; }

    public boolean tieneMascota() { return mascota; }
    public void setMascota(boolean mascota) { this.mascota = mascota; }

    public boolean tieneAireAcondicionado() { return aireAcondicionado; }
    public void setAireAcondicionado(boolean aireAcondicionado) { this.aireAcondicionado = aireAcondicionado; }

    public boolean tieneEquipaje() { return equipaje; }
    public void setEquipaje(boolean equipaje) { this.equipaje = equipaje; }

    public boolean tieneMusica() { return musica; }
    public void setMusica(boolean musica) { this.musica = musica; }

    public int getNumeroPasajeros() { return numeroPasajeros; }
    public void setNumeroPasajeros(int numeroPasajeros) { this.numeroPasajeros = numeroPasajeros; }

    @Override
    public String toString() {
        return "[Viaje] Tipo: " + tipo +
                " | Wifi: " + wifi +
                " | Mascota: " + mascota +
                " | AC: " + aireAcondicionado +
                " | Equipaje: " + equipaje +
                " | Música: " + musica +
                " | Pasajeros: " + numeroPasajeros;
    }
}