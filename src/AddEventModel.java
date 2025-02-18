import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class AddEventModel extends JDialog {
    // The purpose of this class is to add an Event—either a Deadline or a Meeting to the planner.

    private EventListPanel eventListPanel;
    private JButton addEventButton;
    private AddEventModel myself;
    private String[] events = {"Meeting", "Deadline"};
    private JComboBox<String> eventSelector;
    private JPanel infoCollectionPanel;

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
            setPreferredSize(new Dimension(500, 500));
            setBackground(Color.CYAN);

            eventSelector = new JComboBox(events);
            //eventSelector.addActionListener(e -> {

            //});
            add(eventSelector);

            infoCollectionPanel = new JPanel();
            infoCollectionPanel.setBackground(Color.WHITE);
            infoCollectionPanel.setPreferredSize(new Dimension(480, 400));
            add(infoCollectionPanel);

            addEventButton = new JButton("Add Event");
            addEventButton.addActionListener(e -> {
                Event event;
                switch(eventSelector.getSelectedIndex()) {
                    case 0: event = new Meeting(); break;
                    case 1: event = new Deadline(); break;
                }

                Meeting meeting = new Meeting("Task Assignment Meeting",
                        LocalDateTime.of(2025, 2, 22, 12, 15),
                        LocalDateTime.of(2025, 2, 22, 13, 15),
                        "Torreysson Library");
                eventListPanel.addEvent(event);
                myself.dispose();
            });

            add(addEventButton);


        }
    }

}
