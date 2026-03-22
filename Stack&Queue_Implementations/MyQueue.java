public interface MyQueue<T>{
    public void enqueue(T value);
    public T dequeue();
    public T front();
    public boolean isEmpty();
    public int size();
    public void delete(T elem);
}
