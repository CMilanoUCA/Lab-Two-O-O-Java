import java.time.LocalDateTime;

public class Deadline extends Event implements Completable { //HOW TO WRITE??
    Deadline(String name, LocalDateTime deadline) {
        this.name = name;
        this.dateTime = deadline;
    } // Constructor

    @Override
    String getName() {
        return name;
    }

    boolean complete; // holds a Boolean representing whether the task this deadline tracks is complete.

    public void complete() {
        complete = true;
    }  // sets the complete boolean to true;

    public boolean isComplete() {
        return complete;
    }  // returns the complete boolean.
}
