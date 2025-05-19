package Ejercicio1;

import Actividad1.ExceptionIsEmpty;
import Actividad1.Stack;
import Actividad2.Node;

public class StackLink<E> implements Stack<E> {
	private Node<E> first;
	private int tope;
	private int size;
	
	public StackLink(int n) {
		this.first = null;
		this.tope = -1;
		this.size = n;
	}
	
	@Override
	public void push(E x) {
		Node<E> aux = new Node<E>(x);
		if (this.isEmpty()) {
			this.first = aux;
			this.tope++;
		} else if (this.tope < this.size - 1) {
			aux.setNext(this.first);
			this.first = aux;
			this.tope++;
		}
		
	}

	@Override
	public E pop() throws ExceptionIsEmpty {
		Node<E> aux = this.first;
		if (this.isEmpty()) {
			throw new ExceptionIsEmpty("La STACKLINK esta vacia");
		} else {
			this.first = this.first.getNext();
			this.tope--;
		}
		return aux.getData();
	}


	@Override
	public E top() throws ExceptionIsEmpty {
	    if (this.isEmpty()) {
	        throw new ExceptionIsEmpty("La STACKLINK está vacía");
	    }
	    return this.first.getData();
	}


	@Override
	public boolean isEmpty() {
		return this.first == null;
	}

	@Override
	public String toString() {
		String s = "STACKLINK\n";
		Node<E> aux = this.first;
		while (aux != null) {
			s += "[ " + aux + "  | -]--->";
			aux = aux.getNext();
		}
		return s;
	}
	
}