public class ArrayQueue<T> implements MyQueue<T>{
    T[] values;
    int size;
    int front;
    int capacity;
    
    ArrayQueue(){
        capacity=2;
        values= (T[]) new Object[capacity];
        front=0;
        size=0;
    }
    private void resize(){
        if(size>=capacity){
            T[] newArray = (T[]) new Object[capacity*2];
            for(int i=0;i<size;i++){
                newArray[i]=values[(front+i)%capacity];
            }
            
            capacity*=2;
            values=newArray;
            front=0;
        }
    }
    
    @Override
    public void enqueue(T value){
        resize();
        values[(front+size)%capacity]=value;
        size++;
    }
    
    @Override
    public T dequeue(){
        if(isEmpty()){
            throw new RuntimeException("is empty");
        }
        T val=values[front];
        front=(front+1)%capacity;
        size--;
        return val;
    }
    
    @Override
    public T front(){
        if(isEmpty()){
            throw new RuntimeException("is empty");
        }
        return values[front];
    }
    
    @Override
    public boolean isEmpty(){
        return size<=0;
    }
    
    @Override
    public int size(){
        return size;
    }
    
    @Override
    public void delete(T value){
        for(int i=0;i<size;i++){
            if(values[(front+i)%capacity].equals(value)){
                for(int j=i;j<size-1;j++){
                    values[(front+j)%capacity]=values[(front+j+1)%capacity];
                }
                size--;
                return;
            }
        }
    }
    
    public void clean(){
        capacity=2;
        size=0;
        front=0;
        values= (T[]) new Object[capacity];
    }
    
}
