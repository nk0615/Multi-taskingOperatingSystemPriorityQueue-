package priorityQueue;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.*;
import org.junit.Test;

public class TasksCreator1 {
    
    private PriorityQueueMain CPU1;

    @Rule
    public final ExpectedException exception = ExpectedException.none();
    
    @Test
    public void test1() {

	CPU1 = new PriorityQueueMain(6);
	
	Task A = new Task("(A)sublime Text  ", 5, 1); //creating tasks (not in the heap)
	Task B = new Task("(B)Itunes        ", 18, 2);
	Task C = new Task("(C)Counter Strike", 20, 3);
	Task D = new Task("(D)IntelliJ      ", 59, 4);
	Task E = new Task("(E)MS word       ", 39, 5);
	Task F = new Task("(F)Visual Studio ", 3, 6);
	
	CPU1.maxHeapInsert(A);
	CPU1.maxHeapInsert(B);
	CPU1.maxHeapInsert(C);
	//System.out.println("-----------CPU1 after Task A, B, C have been inserted--------");
	//CPU1.prints();
	
	assertEquals(C, CPU1.heapMaximum());

	CPU1.maxHeapInsert(D);
	CPU1.maxHeapInsert(E);
	CPU1.maxHeapInsert(F);
	System.out.println("-----------CPU1 after Task ABCDEF have been inserted--------");
	CPU1.prints();
	//assertEquals(D, CPU1.heapMaximum());
	
	
	assertEquals(D, CPU1.heapExtractMax());
	
	
	CPU1.increaseAllPriority();
	System.out.println("-----------CPU1 after 1st job being extracted--------");
	CPU1.prints();
	
	
	assertEquals(E, CPU1.heapExtractMax());
	assertEquals(C, CPU1.heapExtractMax());
	assertEquals(B, CPU1.heapExtractMax());
	assertEquals(A, CPU1.heapExtractMax());
	assertEquals(F, CPU1.heapExtractMax());//CPU1 is empty
	

	exception.expect(IndexOutOfBoundsException.class);
	CPU1.heapExtractMax();
    }
}
