public class ArrayStack<T> implements MyStack<T>{
    T[] values;
    int capacity;
    private int size;
    
    ArrayStack(){
        capacity=2;
        values=(T[]) new Object[capacity];
        size=0;
    }
    private void resize(){
        if(size>=capacity){
            T[] newArray = (T[]) new Object[capacity*2];
            for(int i=0;i<size;i++){
                newArray[i]=values[i];
            }
            
            capacity*=2;
            values=newArray;
        }
    }
    
    @Override
    public void push(T elem){
        resize();
        values[size]=elem;
        size++;
    }
    
    @Override
    public T pop(){
        if(isEmpty()){
        throw new RuntimeException("Stack is empty");
        }
        T val= values[--size];
        return val;
    }
    @Override
    public T peek(){
        if(isEmpty()){
        throw new RuntimeException("Stack is empty");
        }
        return values[size-1];
    }
    
    @Override
    public boolean isEmpty(){
        return size<=0;
    }
    @Override
    public void delete(T elem){
        for(int i=size-1;i>=0;i--){
            if(values[i].equals(elem)){
                for(int j=i;j<size-1;j++){
                    values[j]=values[j+1];
                }
                size--;
                return;
            }
        }
    }
    
    @Override
    public int size(){
        return size;
    }
    
    public void clean(){
        capacity=2;
        values=(T[]) new Object[capacity];
        size=0;
    }
}
