package com.mycompany.listquantification;

public class DobleNode<T> extends Node<T> {
	DobleNode<T> next;
	DobleNode<T> prev;
	DobleNode(T value) {
		super(value);
		next=null;
		prev=null;
	}
}