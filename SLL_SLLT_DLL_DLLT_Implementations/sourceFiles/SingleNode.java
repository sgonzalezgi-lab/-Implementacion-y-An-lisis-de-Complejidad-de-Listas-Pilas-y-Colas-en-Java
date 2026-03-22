package com.mycompany.listquantification;

public class SingleNode<T> extends Node<T>{
    SingleNode<T> next;
    
    SingleNode(T value){
        super(value);
        this.next=null;
    }
}