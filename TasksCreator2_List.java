package priorityQueue;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TasksCreator2_List {

    private PriorityQueueMain CPU2;
    
    @Test
    public void test() {
	Task A, B, C, D, E, F, G, H; //8 tasks
	ArrayList<Task> alt = new ArrayList<Task>();
	
	alt.add(A = new Task("(A)FireFox", 60, 1));
	alt.add(B = new Task("(B)IE     ", 50, 2));
	alt.add(C = new Task("(C)Chrome ", 79, 3));
	alt.add(D = new Task("(D)Eclipse", 99, 4));
	alt.add(E = new Task("(E)Eclipse", 77, 5));
	alt.add(F = new Task("(F)Eclipse", 39, 6));
	alt.add(G = new Task("(G)Eclipse", 49, 7));
	alt.add(H = new Task("(H)Eclipse", 84, 8));
	
	CPU2 = new PriorityQueueMain(alt);
	
	System.out.println("--------------CPU2-----------------------------");
	CPU2.prints();
	
	
	assertEquals(D, CPU2.heapMaximum());
	
	
	CPU2.heapIncreaseKey(0, 2000);
	assertEquals(2000, CPU2.heapMaximum().getKey());
	System.out.println("-----------CPU2 after Task C's key has been increased--------");
	CPU2.prints();
	
	
	CPU2.heapSort();
	System.out.println("-----------CPU2 after heapsort has been carried out--------");
	CPU2.prints();
	
    }
}



