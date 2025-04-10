
package todo1;

public class Task {
    private int id;
    private String name;
    private String description;
    private String priority;
    private boolean isCompleted;

    // Constructor
    public Task(int id, String name, String description, String priority, boolean isCompleted) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.isCompleted = isCompleted;
    }

    // Getters & Setters (Encapsulation)
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getPriority() { return priority; }
    public boolean isCompleted() { return isCompleted; }
}

