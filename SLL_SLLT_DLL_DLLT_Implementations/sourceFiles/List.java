package com.mycompany.listquantification;

public interface List<T>{
    void pushFront(T value);
    void pushBack(T value);
    T popFront();
    T popBack();
    boolean isEmpty();
    T topFront();
    T topBack();
    Node<T> find(T value);
    void addBefore(Node<T> node, T value);
    void addAfter(Node<T> node, T value);
    void eraseByReference(Node<T> node);
    void eraseByValue(T val);
    int size();
    Node<T> getHead();
}