import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EventPanel extends JPanel {
    Event event;            // the event that this panel displays.

    JButton completeButton; // a button that completes the Event (sets the complete variable to true).
    // Note, this should only appear on events that implement Completable.

    EventPanel(Event event) {  // Constructor
        this.event = event;
        setPreferredSize(new Dimension(670, 50));
        completeButton = new JButton("Complete");
        setBackground(Color.BLUE);

        JLabel nameLabel = new JLabel("Event: " + event.getName());
        nameLabel.setFont(nameLabel.getFont().deriveFont(Font.BOLD));
        add(nameLabel);
    }

    // EventPanel should display the data of the Event:
        // name, time, name, duration (if applicable),
        // location (if applicable), and completion status.
        // You can decide whether to drawStrings in the paintComponent function
        // or to add labels and have them display.
}
