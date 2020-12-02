
public class Nodo {
	Nodo izquierda;
	Nodo derecha;
	String data;
	
	//Costructor si solo se obtine el nombre del nodo
	public Nodo(String data) {
		this.data = data;
	}
	
	public Nodo(String data, Nodo izquierda, Nodo derecha) {
		this.izquierda = izquierda;
		this.derecha = derecha;
		this.data = data;
	}
}
