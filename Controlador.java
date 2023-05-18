import java.util.ArrayList;
import java.util.HashMap;

public class Controlador {
    private grafo grafito;
    private ArrayList<String> lineas;
    private HashMap<String, Integer> nodos;
    private HashMap<Integer, String> nodosReves;

    public Controlador() {
        lineas = new ArrayList<String>();
        nodos = new HashMap<String, Integer>();
        nodosReves = new HashMap<Integer, String>();
    }

    public void iniciar() {
        String[] lista;
        int cont = 0;
        for (String linea : lineas) {
            lista = linea.split(" ");
            if (nodos.get(lista[0]) == null) {
                cont++;
                nodos.put(lista[0], cont);
                nodosReves.put(cont, lista[0]);
            }
            if (nodos.get(lista[1]) == null) {
                cont++;
                nodos.put(lista[1], cont);
                nodosReves.put(cont, lista[1]);
            }
        }
        grafito = new grafo(nodos, nodosReves, cont);
        for (String linea : lineas) {
            lista = linea.split(" ");
            grafito.setMatriz(nodos.get(lista[0]) - 1, nodos.get(lista[1]) - 1, Integer.valueOf(lista[2]));
        }
        grafito.Floyd();
    }

    public String imprimirCalculos(){
        return "Matriz con calculos de floyd:" + "\n" + grafito.impresionFloyd();
    }
    
    public String imprimirMatriz(){
        return "Matriz original:" + "\n" +grafito.impresionAdj();
    }
    
    public String imprimirInfo(String fila, String columna){
        return grafito.ruta(nodos.get(fila)-1, nodos.get(columna)-1);
    }
    
    public String imprimirCentro(){
        return grafito.centro();
    }
}