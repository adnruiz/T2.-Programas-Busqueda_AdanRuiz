

public class DFS {
	
	static void algoritmoDFS(Nodo nodo) {
		if(nodo == null) {
			return;
		}
		System.out.println(nodo.data);
		algoritmoDFS(nodo.izquierda);
		algoritmoDFS(nodo.derecha);
	}
	
	
}
