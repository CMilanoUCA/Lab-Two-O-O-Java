public class Deadline extends Event, implements Completable { //HOW TO WRITE??
    Deadline(String name, LocalDateTime deadline) {

    } // Constructor

    boolean complete {

    }  // holds a Boolean representing whether the task this deadline tracks is complete.

    void complete() {

    }  // sets the complete boolean to true;

    boolean isComplete() {
        return false;
    }  // returns the complete boolean.
}
