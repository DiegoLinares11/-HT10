import java.util.HashMap;

public class grafo {
    private HashMap<String, Integer> nodos;
    private Integer[][] matriz;
    private String[][] caminos;
    private Integer[][] matrizFloyd;
    private String[][] caminosFloyd;
    private HashMap<Integer, String> nodosReves;

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
        int tam = nodos.size();
        matrizFloyd = new Integer[tam][tam];
        caminosFloyd = new String[tam][tam];
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                matrizFloyd[i][j] = matriz[i][j];
                caminosFloyd[i][j] = caminos[i][j];
            }
        }

        for (int k = 0; k < nodos.size(); k++) {
            for (int j = 0; j < nodos.size(); j++) {
                for (int i = 0; i < nodos.size(); i++) {
                    if (matrizFloyd[i][j] != null && matrizFloyd[i][k] != null && matrizFloyd[k][j] != null) {
                        if (matrizFloyd[i][j] > (matrizFloyd[i][k] + matrizFloyd[k][j])) {
                            matrizFloyd[i][j] = matrizFloyd[i][k] + matrizFloyd[k][j];
                            caminosFloyd[i][j] = nodosReves.get(k + 1);
                        }
                    }
                    if (matrizFloyd[i][j] == null && !(matrizFloyd[i][k] == null || matrizFloyd[k][j] == null)) {
                        matrizFloyd[i][j] = matrizFloyd[i][k] + matrizFloyd[k][j];
                        caminosFloyd[i][j] = nodosReves.get(k + 1);
                    }
                }
            }

        }
    }

    public void setCaminos() {
    }

    public void setInterrupcion() {
    }
}
