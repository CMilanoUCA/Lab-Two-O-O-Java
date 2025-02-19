// Carson Milano
// Lab 2 (Planner)

import javax.swing.*;
import java.time.LocalDateTime;

public class EventPlanner {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Control Options");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        EventListPanel eventListPanel = new EventListPanel();
        addDefaultEvents(eventListPanel);
        frame.getContentPane().add(eventListPanel);

        frame.pack();
        frame.setVisible(true);
    }

    static void addDefaultEvents(EventListPanel events) {
    // Default Meeting
        Meeting defMeeting = new Meeting("Semester Project Team Meeting",
                LocalDateTime.of(2025, 03, 01, 12, 25),
                LocalDateTime.of(2025, 03, 01, 14, 25),
                "Torreyson Library");
        events.addEvent(defMeeting);
        // Default Deadline
        Deadline defDeadline = new Deadline ("Java Project Deadline",
                LocalDateTime.of(2025, 02, 18, 11, 59));
        events.addEvent(defDeadline);

    }  // adds some default events to
    // the EventListPanel (at least one Deadline and one Meeting), so something shows up
    // even if your add button doesn’t work.
}
