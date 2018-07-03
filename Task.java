package priorityQueue;

//This is the class for task objects

public class Task  { 

    private String taskName;
    private int key; // priority value
    private int id;
    
    public Task(String taskName, int key, int id) {
	this.taskName = taskName;
	this.key = key;
	this.id = id;
    }
    
    public void setName(String name) {
	this.taskName = name;
    }
    public String getName() {
	return this.taskName;
    }
  
    public void setKey(int key) {
	this.key = key;
    }
    public int getKey() {
	return this.key;
    }
    
    public void setId(int id) {
	this.id = id;
    }
    public int getId() {
	return this.id;
    }
}
