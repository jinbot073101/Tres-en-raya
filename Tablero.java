public class Tablero {

    public Casilla[][] casillas;

    public Tablero() {
        casillas = new Casilla[3][3];
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                casillas[i][j] = new Casilla(); 
            }
        }
    }

    public void marcarCasilla(int fila, int columna, Jugador jugador) {
        if (casillas[fila][columna].getJugador() == null) {
            casillas[fila][columna].marcar(jugador);
        } else {
            System.out.println("Casilla ocupada. Seleccione una casilla diferente.");
        }
    }

    public boolean hayGanador() {
        // Verificar líneas horizontales
        for (int i = 0; i < 3; i++) {
            if (casillas[i][0].getJugador() != null &&
                casillas[i][0].getSimbolo() == casillas[i][1].getSimbolo() &&
                casillas[i][0].getSimbolo() == casillas[i][2].getSimbolo()) {
                return true;
            }
        }
    
        // Verificar líneas verticales
        for (int j = 0; j < 3; j++) {
            if (casillas[0][j].getJugador() != null &&
                casillas[0][j].getSimbolo() == casillas[1][j].getSimbolo() &&
                casillas[0][j].getSimbolo() == casillas[2][j].getSimbolo()) {
                return true;
            }
        }
    
        // Verificar diagonales
        if (casillas[0][0].getJugador() != null &&
            casillas[0][0].getSimbolo() == casillas[1][1].getSimbolo() &&
            casillas[0][0].getSimbolo() == casillas[2][2].getSimbolo()) {
            return true;
        }
        if (casillas[0][2].getJugador() != null &&
            casillas[0][2].getSimbolo() == casillas[1][1].getSimbolo() &&
            casillas[0][2].getSimbolo() == casillas[2][0].getSimbolo()) {
            return true;
        }
    
        return false;
    }
    public boolean tableroLleno(){
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                if (casillas[i][j].getJugador() == null) {
                    return false; 
                }
            }
        }
        return true; 
    } 

    public void mostrarTablero(){
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                char valor = casillas[i][j].getSimbolo(); 
                System.out.print(valor + " | ");
            }
            System.out.println();
        }
    }
}

