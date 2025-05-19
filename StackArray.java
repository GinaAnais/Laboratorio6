package Actividad1;

public class StackArray<E> implements Stack<E> { //Implementación de pila usando un arreglo
	private E[] array; //Arreglo para almacenar los elementos de la pila
	private int tope; //Índice del tope de la pila
	
	public StackArray(int n) { //Constructor que inicializa el arreglo con capacidad n
		this.array = (E[]) new Object[n];
		this.tope = -1; //La pila comienza vacía
	}
	
	@Override
	public void push(E x) { //Agrega un elemento en la cima de la pila
	    if (tope == array.length - 1) {
	        throw new RuntimeException("La pila está llena"); //Lanza excepción si la pila está llena
	    }
	    array[++tope] = x;
	}

	@Override
	public E pop() throws ExceptionIsEmpty { //Elimina y retorna el elemento en la cima
		if (this.tope == -1) {
			throw new ExceptionIsEmpty("La pila se encuentra vacia"); //Lanza excepción si la pila está vacía
		}
		E aux = this.array[this.tope];
		this.array[this.tope] = null; //Elimina la referencia del elemento
		this.tope--;
		return aux;
	}

	@Override
	public E top() throws ExceptionIsEmpty { //Retorna el elemento en la cima sin eliminarlo
		if (this.tope == -1) {
			throw new ExceptionIsEmpty("La pila está vacia"); //Lanza excepción si la pila está vacía
		}
		return this.array[this.tope];
	}

	@Override
	public boolean isEmpty() { //Retorna true si la pila está vacía
		return this.tope == -1;
	}
	
	public boolean isFull() { //Retorna true si la pila está llena
		return this.tope == array.length - 1;
	}

	@Override
	public String toString() { //Devuelve una representación en texto de la pila
	    StringBuilder s = new StringBuilder("PILA (de arriba a abajo):\n");
	    for (int i = tope; i >= 0; i--) {
	        s.append("-> [").append(array[i]).append("] (").append(i).append(")\n");
	    }
	    return s.toString();
	}
}
