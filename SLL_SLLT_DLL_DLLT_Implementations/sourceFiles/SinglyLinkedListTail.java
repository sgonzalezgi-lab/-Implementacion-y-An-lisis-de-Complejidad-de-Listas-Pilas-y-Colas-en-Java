package com.mycompany.listquantification;

public class SinglyLinkedListTail<T extends Comparable<T>> implements List<T>{
    SingleNode<T> head;
    SingleNode<T> tail;
    
    SinglyLinkedListTail(){
        this.head=null;
        this.tail=null;
    }
    
    @Override
    public boolean isEmpty(){
        return head==null;
    }
    @Override
    public void pushFront(T val){
        SingleNode<T> newNode = new SingleNode<>(val);
        newNode.next = head;
        head=newNode;
        if(tail==null){
            tail=head;
        }
    }
    @Override
    public void pushBack(T val){
        SingleNode<T> newNode = new SingleNode<>(val);
        if(head==null){
            head=newNode;
            tail=newNode;
        }else{
            tail.next=newNode;
            tail=newNode;
        }
    }
    @Override
    public T popFront(){
        if(isEmpty()){
            throw new RuntimeException("The list is empty");
        }
        T Node = head.value;
        head=head.next;
        if(head==null){
            tail=null;
        }
        return Node;
    }
    @Override
    public T popBack(){
        if(isEmpty()){
            throw new RuntimeException("The list is empty");
        }
        T Node=head.value;
        if(head==tail){
            Node=head.value;
            head=null;
            tail=null;
            return Node;
        }
        SingleNode<T> tem=head;
        while(tem.next!=tail){
            tem=tem.next;
        }
        
        Node=tail.value;
        tem.next=null;
        tail=tem;
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
    public SingleNode<T> find(T val){
        SingleNode<T> tem=head;
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
        SingleNode<T> Node = (SingleNode<T>) node;
        SingleNode<T> newNode = new SingleNode<>(val);
        if(head==Node){
            newNode.next=head;
            head=newNode;
            return;
        }
        SingleNode<T> tem=head;
        while(tem.next!=null&&tem.next!=Node){
            tem=tem.next;
        }
        
        if(tem.next==Node){
            newNode.next=Node;
            tem.next=newNode;
        }else{
            throw new RuntimeException("that node is not in the list");
        }
        
    }
    
    @Override
    public void addAfter(Node<T> node,T val){
        SingleNode<T> Node = (SingleNode<T>) node;
        SingleNode<T> newNode = new SingleNode<>(val);
        newNode.next=Node.next;
        Node.next=newNode;
        if(tail==Node){
            tail=newNode;
        }
    }
    @Override
    public int size(){
        int counter=0;
        SingleNode<T> tem=head;
        while(tem!=null){
            tem=tem.next;
            counter++;
        }
        return counter;
    }
    
    @Override
    public void eraseByReference(Node<T> node) 
    {
        SingleNode<T> tem=head;
        SingleNode<T> prev = head;
        while(tem!=null){
            if(tem.value.compareTo(node.value)!=0){
                prev=tem;
                tem=tem.next;
            }else{
                break;
            }
        }
        
        if (tem == null) 
        {
            System.out.println("ERROR: Value not found. Please revise");
            return;
        }
        
        
        prev.next = tem.next;
    }
    
    @Override
    public void eraseByValue(T val) 
    {
        SingleNode<T> tem=head;
        SingleNode<T> prev = head;
        while(tem!=null){
            if(tem.value.compareTo(val)!=0){
                prev=tem;
                tem=tem.next;
            }else{
                break;
            }
        }
        
        if (tem == null) 
        {
            System.out.println("ERROR: Value not found. Please revise");
            return;
        }
        
        
        prev.next = tem.next;
    }
    
    @Override
    public Node<T> getHead() {
        return head;
    }
}