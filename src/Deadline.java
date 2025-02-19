import java.time.LocalDateTime;

public class Deadline extends Event implements Completable {
    Deadline(String name, LocalDateTime deadline) {
        super(name, deadline);
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

    public String[] getAttributes() {
        String[] attributes = new String[2];
        attributes[0] = getName();
        attributes[1] = LocalDateTime.now().toString();
        return attributes;
    }
}
