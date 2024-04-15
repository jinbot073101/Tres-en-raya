public class Casilla {

    private Jugador jugador;

    public void marcar(Jugador jugador) {
        this.jugador = jugador;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public String toString(){
        return null;
    }

    public char getSimbolo() {
        if (jugador != null) {
            return jugador.getSimbolo();
        } else {
            return '-';
        }
    }

}
