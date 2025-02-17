import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddEventModel extends JDialog {
    // The purpose of this class is to add an Event—either a Deadline or a Meeting to the planner.

    private EventListPanel eventListPanel;
    private JButton addEventButton;
    AddEventModel myself;

    /*
    AddEventModel modal;
    record Attribute(String name, JComponent value) {}
    ArrayList<Attribute> attributes;
    JPanel infoCollectorPanel;
    JComboBox<String> eventTypeComboBox;
    */

    public AddEventModel(EventListPanel eventListPanel) {
        myself = this;
        this.eventListPanel = eventListPanel;
        this.setTitle("Add Event");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.add(new addEventPanel());
        this.pack();
        this.setVisible(true);
    }

    private class addEventPanel extends JPanel {
        public addEventPanel() {
            addEventButton = new JButton("Add Event");
            addEventButton.addActionListener(e -> {
                Meeting meeting = new Meeting(meeting.getName(),
                        meeting.getDateTime(), meeting.getEndDateTime(),
                        meeting.getLocation());
                eventListPanel.addEvent(meeting);
                myself.dispose();
            });

            add(addEventButton);

            setPreferredSize(new Dimension(500, 500));
            setBackground(Color.CYAN);
        }
    }

}
