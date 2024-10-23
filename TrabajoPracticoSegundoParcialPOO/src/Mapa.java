public class Mapa {
    private int filas;
    private int columnas;
    private int pointerX;
    private int pointerY;
    private boolean[][] visited;

    public Mapa(int filas, int columnas, int pointerX, int pointerY) {
        this.filas = filas;
        this.columnas = columnas;
        this.pointerX = pointerX;
        this.pointerY = pointerY;
        visited = new boolean[filas][columnas];
        visited[pointerX][pointerY] = true; //Asegura que la posicion inicial del jugador no se pueda pasar dos veces
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public void setPointerX(int pointerX) {
        this.pointerX = pointerX;
    }

    public void setPointerY(int pointerY) {
        this.pointerY = pointerY;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public int getPointerX() {
        return pointerX;
    }

    public int getPointerY() {
        return pointerY;
    }

    public boolean[][] getVisited() {
        return visited;
    }
}
