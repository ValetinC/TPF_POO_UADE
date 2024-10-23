import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MatrizConPuntero extends JPanel {
    private int rows = 10;
    private int cols = 10;
    private int cellSize = 50;
    private int pointerX = 0;
    private int pointerY = 0;
    private int goalX = 8;
    private int goalY = 8;
    Mapa mapa = new Mapa(rows,cols,pointerX,pointerY);
    boolean[][] visited = mapa.getVisited();

    public MatrizConPuntero() {
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) { //Movimiento del personaje mediante coordenadas X e Y
                int newX = pointerX;
                int newY = pointerY;

                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        if (pointerY > 0) newY--;
                        break;
                    case KeyEvent.VK_DOWN:
                        if (pointerY < visited[0].length - 1) newY++;
                        break;
                    case KeyEvent.VK_LEFT:
                        if (pointerX > 0) newX--;
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (pointerX < visited.length - 1) newX++;
                        break;
                }

                // Si la nueva posición no ha sido visitada
                if (!visited[newY][newX]) {
                    // Marcar como visitada
                    visited[newY][newX] = true;
                    pointerX = newX;
                    pointerY = newY;
                }
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibuja la matriz
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (visited[i][j]) {
                    g.setColor(Color.BLACK); // Casillas visitadas
                } else {
                    g.setColor(Color.WHITE); // Casillas no visitadas
                }
                g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
                g.setColor(Color.GRAY); // Color del borde
                g.drawRect(j * cellSize, i * cellSize, cellSize, cellSize);
            }
        }

        // Dibuja el puntero
        g.setColor(Color.RED);
        g.fillRect(pointerX * cellSize, pointerY * cellSize, cellSize, cellSize);

        // Dibuja la meta
        g.setColor(Color.BLUE);
        g.fillRect(goalX * cellSize, goalY * cellSize, cellSize, cellSize);
    }

    public boolean Superado (boolean [][] visited){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean [][] visitado = new boolean[10][10];
        JFrame frame = new JFrame("Matriz con Puntero");
        MatrizConPuntero matriz = new MatrizConPuntero();
        frame.add(matriz);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        matriz.requestFocusInWindow();
    }
}