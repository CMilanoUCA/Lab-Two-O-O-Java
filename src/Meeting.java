import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Meeting extends Event implements Completable {
    String location;                // represents the location of the event.
    LocalDateTime end;              // the time the meeting is over.
    boolean complete;

    public Meeting(String name, LocalDateTime start, LocalDateTime end, String location) {
        super(name, start);         // Calls Event and constructs "name" and "start"
        this.end = end;
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

    LocalDateTime getEndDateTime() {
        return this.end;
    }   // returns the endDateTime

    Duration getDuration() {
        return Duration.between(super.getDateTime(), end);
    }   // returns the duration of the meeting, (dateTime – endDateTime)

    String getLocation() {
        return location;
    }   // returns the location of the meeting.

    void setEndDateTime(LocalDateTime end) {
        this.end = end;
    }   // sets the end of the meeting.

    void setLocation(String location) {
        this.location = location;
    }   // sets the location of the meeting.
}
