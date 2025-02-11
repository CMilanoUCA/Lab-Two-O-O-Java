public class Event {
    Event(String name, LocalDateTime dateTime) {
        this.name = name;

    } // Constructor; optional

    String name {

    }  // Name of the event.

    LocalDateTime dateTime {

    } // the time and date the event starts.

    string getName() {

    } // abstract method that returns the name

    LocalDateTime getDateTime() {

    } // method that returns the dateTime.

    void setDateTime(LocalDateTime dateTime) {

    } // sets the dateTime.

    void setName(String name) {

    } // sets the name of the Event.

    int compareTo(Event e) {

    }  // compares the date of this Event to the incoming event and returns
    // a positive int if this event comes later, a negative int if this event comes before,
    // and 0 if the two have the same dateTime.

}
