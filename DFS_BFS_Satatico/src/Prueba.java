import java.util.ArrayList;
import java.util.List;

public class Prueba {

	public static void main(String[] args) {
		try {
			Nodo arbol = muestra();
			//BFS.algortimoBFS(arbol);
			DFS.algoritmoDFS(arbol);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	private static Nodo muestra() {
		
		Nodo raiz = new Nodo("A", new Nodo("B",
				new Nodo("C"), new Nodo("D")), new Nodo("E", new Nodo("F"), new Nodo("G", new Nodo("H"), null)));
		return raiz;
	}

}
