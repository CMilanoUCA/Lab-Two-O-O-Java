import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EventPanel extends JPanel {
    Event event;            // the event that this panel displays.

    JButton completeButton; // a button that completes the Event (sets the complete variable to true).
    // Note, this should only appear on events that implement Completable.

    EventPanel(Event event) {  // Constructor
        this.event = event;
        setPreferredSize(new Dimension(670, 68));
        completeButton = new JButton("Complete");
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.CYAN);

        String[] attributes = event.getAttributes();
        for (String attribute : attributes) {
            JLabel label = new JLabel(attribute);
            label.setFont(label.getFont().deriveFont(Font.BOLD));
            add(label);
        }
    }

    // EventPanel should display the data of the Event:
        // name, time, name, duration (if applicable),
        // location (if applicable), and completion status.
        // You can decide whether to drawStrings in the paintComponent function
        // or to add labels and have them display.
}
