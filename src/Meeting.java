public class Meeting extends Event, implements Completable {
    Meeting(String name, LoaclDateTime start, LocaldateTime end:, String location) {

    }  // Constructor

    LocalDateTime endDateTime {

    }  // the time the meeting is over.

    String location {

    }   // represents the location of the event.

    void complete() {

    }   // sets the complete boolean to true;

    boolean isComplete()  {
        return false;
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
