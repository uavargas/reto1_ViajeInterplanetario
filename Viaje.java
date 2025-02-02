public class Viaje {
    // Atributos encapsulados
    private String planetaDestino;
    private String naveEspacial;
    private int pasajeros;
    private double progreso;
    private double tiempoViaje;

    // Constructor
    public Viaje(String planetaDestino, String naveEspacial, int pasajeros) {
        this.planetaDestino = planetaDestino;
        this.naveEspacial = naveEspacial;
        this.pasajeros = pasajeros;
        this.progreso = 0.0;
        this.tiempoViaje = 0.0;
    }
    
    //Métodos principales

    public void simular() {
        if (verificarRecursos()) {
            while (progreso < 100.0) {
                actualizarProgreso();
                manejarEventualidad();
                mostrarEstadoActual();

                try {
                    Thread.sleep(1000); // Simular tiempo real
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("\n\uD83C\uDFC1 ¡Viaje completado con éxito!");
        } else {
            System.out.println("\uD83D\uDEA8 Recursos insuficientes para iniciar el viaje");
        }
    }

    private void actualizarProgreso() {
        double avance = (Math.random() * 15) + 5; // Avance aleatorio entre 5-20%
        progreso = Math.min(progreso + avance, 100.0);
        tiempoViaje += 0.5; // Media hora por ciclo
    }

    public double getProgress() {
        return progreso;
    }

    public void manejarEventualidad() {
        // Lógica para eventos aleatorios
        if (Math.random() < 0.3) { // 30% de probabilidad de evento
            String[] eventos = {
                    "Tormenta solar detectada!",
                    "Fallos en el sistema de navegación",
                    "Alerta de meteoritos cercanos",
                    "Variación en la trayectoria"
            };
            String evento = eventos[(int) (Math.random() * eventos.length)];
            System.out.println("\n\uD83D\uDEA8 " + evento);
        }
    }

    public boolean verificarRecursos() {
        // Lógica de verificación básica
        return pasajeros > 0 &&
                !naveEspacial.isEmpty() &&
                !planetaDestino.isEmpty();
    }

    private void mostrarEstadoActual() {
        System.out.printf("\n\uD83D\uDD50 Tiempo transcurrido: %.1f horas", tiempoViaje);
        System.out.printf("\n\uD83D\uDD3A Progreso: %.2f%%", progreso);
        System.out.println("\n" + "-".repeat(50));
    }

    public String getPlanetaDestino() {
        return planetaDestino;
    }

    public void setPlanetaDestino(String planetaDestino) {
        this.planetaDestino = planetaDestino;
    }

    public String getNaveEspacial() {
        return naveEspacial;
    }

    public void setNaveEspacial(String naveEspacial) {
        this.naveEspacial = naveEspacial;
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }

    public double getProgreso() {
        return progreso;
    }

    public void setProgreso(double progreso) {
        this.progreso = progreso;
    }

    public double getTiempoViaje() {
        return tiempoViaje;
    }

    public void setTiempoViaje(double tiempoViaje) {
        this.tiempoViaje = tiempoViaje;
    }
}
