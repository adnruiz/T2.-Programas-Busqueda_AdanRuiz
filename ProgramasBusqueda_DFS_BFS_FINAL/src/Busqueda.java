import java.io.*;
import java.util.*;

public class Busqueda {
	//Variable que alamcena la cantidad de nodos
	private int Nodos;
	private LinkedList<Integer> listaNodosRec[];
	
	
	
	//cosntructor de la clase:
	@SuppressWarnings("unchecked")
	public Busqueda(int nodos) {
		Nodos = nodos;
		listaNodosRec = new LinkedList[nodos];
		
		for (int i = 0; i < nodos; i++) {
			listaNodosRec[i] = new LinkedList<>();
		}
	}
	
	//metodo para agreagar aristas a los nodos
	public void agregarArista(int nodo, int arista) {
		listaNodosRec[nodo].add(arista);
	}
	
	//mmetodo para el Algoritmo Depth First Search
	public void algoritmoDFS(int nodo, boolean visitado[]) {
		//establecemos el nodo actual como visitado y se imprime
		visitado[nodo] = true;
		System.out.println(nodo + " ");
		
		//creamos un iterator para recorrer y eliminar los elementos
		Iterator<Integer> listaRecorrerAristas = listaNodosRec[nodo].listIterator();
		
		//Recorremos lsita de aristas mientras que tengamos algo dentro de esta.
		while(listaRecorrerAristas.hasNext()) {
			//pasamos el valor del siguiente elemento en el Iterator y se hace una comparacion para verificar si ha sido visitado,
			//de lo contrario establecemos el elemento como visitado.
			int i  = listaRecorrerAristas.next();
			if(!visitado[i]) {
				algoritmoDFS(i, visitado);
			}//if
		}//while	
	}//metodo DFS

	//metodo para hacer el recorrido DFS
	public void dfs(int nodo) {
		//se establecen todos los nodos cono no visitados.
		boolean visitados[] = new boolean[Nodos];
		
		algoritmoDFS(nodo, visitados);
	}
	
	//----------------------------------------------------Breadth first Search-----------------------------------------------
	
	public void algoritmoBFS(int nodo) {
		//se establecen todos los nodos cono no visitados.
		boolean visitados[] = new boolean[Nodos];
		
		//Creamos la lista queue para BFS
		LinkedList<Integer> queue = new LinkedList<>();
		
		//establecemos el nodo actual como visitado y se agrega a nuestro Queue
		visitados[nodo]= true;
		queue.add(nodo);
		
		//mientras que el tamaño de nuestra lista queue no se cero
		while(queue.size() != 0) {
			//establecemos el valor del nodo al valor que obtenemos mediante el metodo poll de nuestra lsita queue, este metodo devuelve y 
			//elimina el elemento al frente del contenedor (FIFO)
			nodo = queue.poll();
			System.out.println(nodo + " ");
			//Se obtinen todas las aristas de de los nodos
			Iterator<Integer>  listaRecorrerAristas = listaNodosRec[nodo].listIterator();

			while(listaRecorrerAristas.hasNext()) {
				int i = listaRecorrerAristas.next();
				if (!visitados[i]) {
					visitados[i]=true;
					queue.add(i);
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner src = new Scanner(System.in);
		
		int aristas, aux, aux2 =0;
		
		System.out.println("Ingresa el numero de nodos");
		int numNodos = src.nextInt();		
		Busqueda busq = new Busqueda(numNodos);
		for (int i = 0; i < numNodos; i++) {
			System.out.println("Ingresa la cantidad de aristas del nodo: " + (i+1));
			aristas = src.nextInt();
			for (int j = 0; j < aristas; j++) {
				System.out.println("Ingresa a que nodo se dirige la arista: " + (j+1) + " del nodo " +(i+ 1));
				busq.agregarArista(i, src.nextInt());				
			}
		}
		
		
		System.out.println("Que algoritmo de busqueda utlizara en su grafo?  \n(Ingrese el numero correspondiente a la opcion)");
		System.out.println("1.- Depth Firt Search");
		System.out.println("2.-Breadth First Search");
		aux = src.nextInt();
		
		if (aux == 1) {
			System.out.println("Ingrese desde que nodo partira la busqueda: ");
			aux2=src.nextInt();
			 System.out.println("Stack utilizando el algoritmo DFS: ");
			 busq.dfs(aux2);
		}else if (aux == 2) {
			System.out.println("Ingrese desde que nodo partira la busqueda: ");
			aux2=src.nextInt();
			System.out.println("Stack utilizando el algoritmo BFS: ");
	        busq.algoritmoBFS(aux2);
		}
		

	}

}