import java.util.HashMap;

public class grafo {
    private HashMap<String, Integer> nodos;
    private Integer[][] matriz;
    private String[][] caminos;

    public grafo(HashMap<String, Integer> nodos, HashMap<Integer, String> nodosReves, int n) {
        this.nodos = nodos;
        matriz = new Integer[n][n];
        caminos = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j)
                    caminos[i][j] = nodosReves.get(j + 1);
            }

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    matriz[i][j] = 0;
            }

        }
    }

    public void setMatriz(int i, int j, Integer valueOf) {
    }

    public void Floyd() {
    }

    public void setCaminos() {
    }

    public void setInterrupcion() {
    }
}
