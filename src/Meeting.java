import java.time.LocalDateTime;

public class Meeting extends Event implements Completable {
    String location;                // represents the location of the event.
    LocalDateTime end;              // the time the meeting is over.
    boolean complete;

    public Meeting(String name, LocalDateTime start, LocalDateTime end, String location) {
        super(name, start);         // Calls Event and constructs "name" and "start"
        this.dateTime = end;
        this.location = location;
    }  // Constructor

    @Override
    String getName() {
        return name;
    }

    public void complete() {
        complete = true;
    }   // sets the complete boolean to true;

    public boolean isComplete()  {
        return complete;
    }  // returns the complete boolean.

    LocalDateTime getEndTime() {

    }   // returns the endDateTime

    Duration getDuration() {

    }   // returns the duration of the meeting, (dateTime – endDateTime)

    String getLocation() {

    }   // returns the location of the meeting.

    void setEndTime(Date end) {

    }   // sets the end of the meeting.

    void setLocation(String location) {

    }   // sets the location of the meeting.
}
