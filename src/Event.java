import java.time.LocalDateTime;

abstract class Event implements Comparable<Event> {
    Event(String name, LocalDateTime dateTime) {
        this.name = name;
        this.dateTime = dateTime;
    } // Constructor; optional

    String name;               // Name of the event.
    LocalDateTime dateTime;    // the time and date the event starts.

    abstract String getName(); // abstract method that returns the name

    LocalDateTime getDateTime() {
        return dateTime;
    } // method that returns the dateTime.

    void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    } // sets the dateTime.

    void setName(String name) {
        this.name = name;
    } // sets the name of the Event.

    public int compareTo(Event e) {
        return (this.dateTime.compareTo(e.getDateTime()));
    }  // compares the date of this Event to the incoming event and returns
       // a positive int if this event comes later, a negative int if this event comes before,
       // and 0 if the two have the same dateTime.

    public abstract String[] getAttributes();
}