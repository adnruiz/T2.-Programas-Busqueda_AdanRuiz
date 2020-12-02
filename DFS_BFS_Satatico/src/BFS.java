import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	
	static void algortimoBFS(Nodo nodo) {
		
		Queue<Nodo> queue = new LinkedList<Nodo>();
		queue.add(nodo);
		
		while(!queue.isEmpty()) {
			nodo = queue.remove();
			System.out.println(nodo.data + " ");
			
			if(nodo.izquierda != null) {
				queue.add(nodo.izquierda);
			}
			if(nodo.derecha != null) {
				queue.add(nodo.derecha);
			}
		}
	}
	
}
