/*	Program: Multi-tasking Operating System
 * 	Language: Java
 * 	Date: Apr 2018
 * 
 * 	Simulation of a simple CPU Process Scheduling System using the min priority queue approach
 * 	with 2 unit tests
 */


package priorityQueue;
import java.util.*;


public class PriorityQueueMain {
    
    private ArrayList<Task> CPUTask; //ArrayList approach
    
    //Constructor #1: insert task one by one, use maxHeapInsert() to build the heap
    public PriorityQueueMain(int capacity) {
	CPUTask = new ArrayList<Task>(capacity);
    }
    
    //Constructor #2: insert an existing list of task, use maxHeapify to build the heap
    public PriorityQueueMain(Collection<Task> collection) {
	CPUTask = new ArrayList<Task>(collection);
	
       for(int i = CPUTask.size()/2; i >= 0; i--) 
       {
	   maxHeapify(i);
       }
    }
    
    //BuildMaxHeap() builds MaxHeap from ArrayList
    public void buildMaxHeap() {
	int heapSize = CPUTask.size()-1;
	if(heapSize < 0) {
	    throw new IndexOutOfBoundsException("A negative amount of tasks in CPU should not happen");
	}
	if(heapSize ==0) { //additional condition when tree is empty
	    throw new IndexOutOfBoundsException("No tasks in CPU at this moment");
	}
	for (int i = (CPUTask.size()-1)/2; i >= 0; i--) {
	    maxHeapify(i);
	}
    }
    
    //maxHeapify()
    public void maxHeapify(int i) {
	int l = left(i);
	int r = right(i);
	int largest;
	if(l <= CPUTask.size()-1 && CPUTask.get(l).getKey() > CPUTask.get(i).getKey()) { 
	//if left child is smaller than the size of the list and the priority of index l > priority of index i
	    largest = l;
	}
	else largest = i;
	
	if(r <= CPUTask.size()-1 && CPUTask.get(r).getKey() > CPUTask.get(largest).getKey()) {
	    largest = r;
	}
	
	if(largest != i) {
	    exchange(i, largest);
	    maxHeapify(largest);
	}
    }
    //insert a new task into CPU
    public void maxHeapInsert(Task objectKey) {
	int key = objectKey.getKey();
	//A.heap-size = A.heap-size+1 -- N/A in ArrayList
	objectKey.setKey(-99999);
	CPUTask.add(objectKey);
	heapIncreaseKey(CPUTask.size()-1, key);
    }
    
    //return the root node (type: Task)
    public Task heapMaximum() {
	return CPUTask.get(0);
    }
    
    //Change task priority (increase only)
    public void heapIncreaseKey(int i, int newKey) {
	if(newKey < CPUTask.get(i).getKey()) {
	    throw new IllegalArgumentException("Error: New key is smaller than current key");
	}
	CPUTask.get(i).setKey(newKey);
	while(i > 0 && CPUTask.get(parent(i)).getKey() < CPUTask.get(i).getKey()) {
	    exchange(i, parent(i));
	    i = parent(i);
	}
    }
    
    //delete node with highest priority from the tree
    public Task heapExtractMax() {
	if(CPUTask.size()-1 < 0) {
	    throw new IndexOutOfBoundsException("Heap Underflow");
	}
	Task max = CPUTask.get(0);
	
	CPUTask.set(0, CPUTask.get(CPUTask.size()-1)); //set the root node to last index
	
	CPUTask.remove(CPUTask.size()-1);
	maxHeapify(0);
	return max;
    }
    
    //heapSort() is used to print the new CPUTask list
    public void heapSort() {
	ArrayList<Task> newCPU = new ArrayList<Task>(CPUTask.size());
	
	if (CPUTask.size() == 0) {
	    throw new IndexOutOfBoundsException("The list is empty");
	}
	if (CPUTask.size() <= 0) {
	    throw new IndexOutOfBoundsException("Heap Underflow");
	}
	//buildMaxHeap();
	for(int i = CPUTask.size()-1; i >= 1; i--) {
	    exchange(0, i);
	    newCPU.add(0, CPUTask.get(i));
	    CPUTask.remove(i);
	    maxHeapify(0);
	}
	
	newCPU.add(0, CPUTask.get(0));
	
	CPUTask = newCPU;
    }
    
    //This method exchanges 2 Task nodes
    public void exchange(int from, int to) {
	Task tmp = CPUTask.get(from);
	CPUTask.set(from, CPUTask.get(to));
	CPUTask.set(to, tmp);
    }
    
    //Define left & right children and parents of the heap
    private int parent(int i){
	return (i-1)/2;
    }
    private int left(int i) {
	return i * 2 + 1;
    }
    private int right(int i) {
	return (i + 1) * 2;
    }
   
   
   //Whenever a task is done, increase the priority of existing waiting tasks.
    public void increaseAllPriority() {
	for(int i = CPUTask.size() -1; i >= 0; i--) {
	    heapIncreaseKey(i, CPUTask.get(i).getKey()+5);
	}
    }
    
    //prints the title & content of the heap
    public void prints() {
	System.out.println("Current Tasks(ID, Priority) of the CPU: \n" + toString());
    }

    
    public String toString() {
	String s = new String();
	for(int i = 0; i <= CPUTask.size()-1; i++) {
	    s +=  CPUTask.get(i).getName() + " "+ "(" + Integer.toString(CPUTask.get(i).getId()) +", " + CPUTask.get(i).getKey() + ")" + "\n" ;
	}
	return s;
    }
}
