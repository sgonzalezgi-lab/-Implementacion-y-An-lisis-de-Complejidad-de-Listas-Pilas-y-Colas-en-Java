package com.mycompany.listquantification;

public class SinglyLinkedList<T extends Comparable<T>> implements List<T>{
    SingleNode<T> head;
    
    SinglyLinkedList(){
        this.head=null;
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
    }
    @Override
    public void pushBack(T val){
        SingleNode<T> newNode = new SingleNode<>(val);
        if(head==null){
            head=newNode;
        }else{
            SingleNode<T> tem=head;
            while(tem.next!=null){
                tem=tem.next;
            }
            tem.next=newNode;
        }
    }
    @Override
    public T popFront(){
        if(isEmpty()){
            throw new RuntimeException("The list is empty");
        }
        T Node = head.value;
        head=head.next;
        return Node;
    }
    @Override
    public T popBack(){
        if(isEmpty()){
            throw new RuntimeException("The list is empty");
        }
        T Node=head.value;
        if(head.next==null){
            Node=head.value;
            head=null;
            return Node;
        }
        SingleNode<T> tem=head;
        while(tem.next.next!=null){
            tem=tem.next;
        }
        
        Node=tem.next.value;
        tem.next=null;
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
        SingleNode<T> tem=head;
        while(tem.next!=null){
            tem=tem.next;
        }
        return tem.value;
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
    
    //add functions to delete(by element and by reference)
    //add a function to print the list
    
}