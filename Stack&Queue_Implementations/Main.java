import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] sizes = {10, 100, 1000, 10000, 100000, 1000000, 10000000};
        int operations = 10000;
        Random rand = new Random();

        System.out.println("---- QUEUE ----");
        for (int n : sizes) {
            ArrayQueue<Integer> queue = new ArrayQueue<>();

            // Fill queue with random numbers
            for (int i = 0; i < n; i++) {
                queue.enqueue(rand.nextInt(1000000));
            }

            // Measure Enqueue
            long totalEnq = 0;
            for (int i = 0; i < operations; i++) {
                long start = System.nanoTime();
                queue.enqueue(rand.nextInt(1000000));
                long end = System.nanoTime();
                totalEnq += (end - start);
                queue.dequeue(); // Compensation
            }

            // Measure Dequeue
            long totalDeq = 0;
            for (int i = 0; i < operations; i++) {
                long start = System.nanoTime();
                queue.dequeue();
                long end = System.nanoTime();
                totalDeq += (end - start);
                queue.enqueue(rand.nextInt(1000000)); // Compensation
            }

            // Measure Front 
            long totalFront = 0;
            //We save front operations for a good division later
            int frontOperations = operations/100;
            for (int i = 0; i < operations/100; i++) {
                long start = System.nanoTime();
                queue.front();
                long end = System.nanoTime();
                totalFront += (end - start);
            }

            // Measure Delete
            
            long totalDelete = 0;
            if(n<=10000000){
                for (int i = 0; i < operations ; i++) { 
                    Integer target = rand.nextInt(n);
                    int oldSize=queue.size(); //keeping track of the size to check if the element was truly remove
                    long start = System.nanoTime();
                    queue.delete(target);
                    long end = System.nanoTime();
                    totalDelete += (end - start);
                    //We only compensate if the element was truly remove
                    if(queue.size()<oldSize){
                        queue.enqueue(target);
                    }
                }
            }
            
            //Measure Size
            long totalSize = 0;
            for(int i=0; i<operations; i++){
                long start = System.nanoTime();
                queue.size();
                long end = System.nanoTime();
                totalSize += (end-start);
            }
            
            //Measure isEmpty
            long totalIsEmpty =0;
            for(int i=0; i<operations; i++){
                long start = System.nanoTime();
                queue.isEmpty();
                long end = System.nanoTime();
                totalIsEmpty += (end-start);
            }
            
            System.out.println("Size: " + n);
            System.out.println("Avg Enqueue: " + (totalEnq / operations) + " ns");
            System.out.println("Avg Dequeue: " + (totalDeq / operations) + " ns");
            System.out.println("Avg Front:   " + (totalFront / frontOperations) + " ns");
            if (n <= 10000000) System.out.println("Avg Delete:  " + (totalDelete /operations) + " ns");
            System.out.println("Avg Size: "+ (totalSize/operations)+ " ns");
            System.out.println("Avg isEmpty: "+(totalIsEmpty/operations)+ " ns");
            System.out.println("---------------------------");
            queue.clean();
        }

        System.out.println("---- STACK TESTS ----");
        for (int n : sizes) {
            ArrayStack<Integer> stack = new ArrayStack<>();
            for (int i = 0; i < n; i++) stack.push(rand.nextInt(1000000));

            // Measure Push
            long totalPush = 0;
            for (int i = 0; i < operations; i++) {
                long start = System.nanoTime();
                stack.push(rand.nextInt(1000000));
                long end = System.nanoTime();
                totalPush += (end - start);
                stack.pop();
            }

            // Measure Pop
            long totalPop = 0;
            for (int i = 0; i < operations; i++) {
                long start = System.nanoTime();
                stack.pop();
                long end = System.nanoTime();
                totalPop += (end - start);
                stack.push(8);
            }

            // Measure Peek
            long totalPeek = 0;
            for (int i = 0; i < operations; i++) {
                long start = System.nanoTime();
                stack.peek();
                long end = System.nanoTime();
                totalPeek += (end - start);
            }
            
            //Measure DeleteStack
            long totalDeleteStack = 0;
            if(n<=10000000){
                for(int i=0; i<operations; i++){
                    Integer target = rand.nextInt(n);
                    int oldSize = stack.size(); //keeping track of the original Size
                    long start = System.nanoTime();
                    stack.delete(target);
                    long end = System.nanoTime();
                    totalDeleteStack += (end-start);
                    if(stack.size()<oldSize){
                        stack.push(target);
                    }
                }
            }
            
            //measure SizeStack
            long totalSizeStack = 0;
            for(int i=0; i<operations; i++){
                long start = System.nanoTime();
                stack.size();
                long end = System.nanoTime();
                totalSizeStack += (end-start);
            }
            
            //measure isEmptyStack
            long totalIsEmptyStack = 0;
            for(int i=0; i<operations; i++){
                long start = System.nanoTime();
                stack.isEmpty();
                long end = System.nanoTime();
                totalIsEmptyStack += (end-start);
            }
            System.out.println("Size: " + n);
            System.out.println("Avg Push: " + (totalPush / operations) + " ns");
            System.out.println("Avg Pop:  " + (totalPop / operations) + " ns");
            System.out.println("Avg Peek: " + (totalPeek / operations) + " ns");
            if(n<=10000000) System.out.println("Avg Delete: " + (totalDeleteStack/operations)+" ns");
            System.out.println("Avg Size: "+ (totalSizeStack/operations) + " ns");
            System.out.println("Avg isEmpty: "+(totalIsEmptyStack/operations)+ " ns");
            System.out.println("---------------------------");
        }
    }
}
