package com.mycompany.listquantification;

public class DoublyLinkedListTail<T extends Comparable<T>> implements List<T>{
    DobleNode<T> head;
    DobleNode<T> tail;
    
    DoublyLinkedListTail(){
        this.head=null;
        this.tail=null;
    }
    
    @Override
    public boolean isEmpty(){
        return head==null;
    }
    @Override
    public void pushFront(T val){
        DobleNode<T> newNode = new DobleNode<>(val);
        if(head!=null){
            head.prev=newNode;
        }else{
            tail=newNode;
        }
        newNode.next = head;
        head=newNode;
    }
    @Override
    public void pushBack(T val){
        DobleNode<T> newNode = new DobleNode<>(val);
        if(head==null){
            head=newNode;
            tail=newNode;
        }else{
            tail.next=newNode;
            newNode.prev=tail;
            tail=newNode;
        }
    }
    @Override
    public T popFront(){
        if(isEmpty()){
            throw new RuntimeException("The list is empty");
        }
        T Node = head.value;
        if(head==tail){
            head=null;
            tail=null;
        }else{
            head=head.next;
            head.prev=null;
        }
        return Node;
        
    }
    @Override
    public T popBack(){
        if(isEmpty()){
            throw new RuntimeException("The list is empty");
        }
        T Node=tail.value;
        if(head==tail){
            head=null;
            tail=null;
        }else{
            tail.prev.next=null;
            tail=tail.prev;
        }
        return Node;
        
    }
    
    @Override
    public T topFront(){
        if(isEmpty()){
            throw new RuntimeException("The list is empty");
        }
        return head.value;
    }
    @Override
    public T topBack(){
        if(isEmpty()){
            throw new RuntimeException("The list is empty");
        }
        return tail.value;
    }
    
    @Override
    public DobleNode<T> find(T val){
        DobleNode<T> tem=head;
        while(tem!=null){
            if(tem.value.compareTo(val)!=0){
                tem=tem.next;
            }else{
                return tem;
            }
        }
        //throw new RuntimeException("there is not in the list");
        return null;
    }
    
    @Override
    public void addBefore(Node<T> node,T val){
        DobleNode<T> Node = (DobleNode<T>) node;
        DobleNode<T> newNode = new DobleNode<>(val);
        if(head==Node){
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
        }else{
            newNode.next=Node;
            newNode.prev=Node.prev;
            Node.prev.next=newNode;
            Node.prev=newNode;
        }
        
    }
    
    @Override
    public void addAfter(Node<T> node,T val){
        DobleNode<T> Node = (DobleNode<T>) node;
        DobleNode<T> newNode = new DobleNode<>(val);
        newNode.next=Node.next;
        newNode.prev=Node;
        if(newNode.next!=null){
            newNode.next.prev=newNode;
        }else{
            tail=newNode;
        }
        Node.next=newNode;
    }
    @Override
    public int size(){
        int counter=0;
        DobleNode<T> tem=head;
        while(tem!=null){
            tem=tem.next;
            counter++;
        }
        return counter;
    }
    //add functions to delete(by element and by reference)
    //add a function to print the list
    
    @Override
    public void eraseByReference(Node<T> node) 
    {
        DobleNode<T> dNode = (DobleNode)node;
        dNode.prev.next = dNode.next;
    }
    
    @Override
    public void eraseByValue(T val) 
    {
        DobleNode<T> node = find(val);
        
        if (node == null) 
        {
            System.out.println("ERROR: Value not found. Please revise");
            return;
        }
        
        
        node.prev.next = node.next;
    }
    
    @Override
    public Node<T> getHead() {
        return head;
    }
    
}