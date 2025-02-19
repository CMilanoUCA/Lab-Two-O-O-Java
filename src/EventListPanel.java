import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.function.Predicate;

public class EventListPanel extends JPanel {
    ArrayList<Event> events; // a list of the events to be listed.
    JPanel controlPanel;     // holds the controls for the event display.
    JPanel displayPanel;     // a panel to hold the EventPanels corresponding to the events.

    final String[] SORT_OPTIONS = {"NAME", "REVERSE_NAME", "DATE", "REVERSE_DATE"};
    JComboBox sortDropDown = new JComboBox(SORT_OPTIONS);  // A drop down that will sort the events in the list
    // by name, date, or by the same qualities but in reverse order.
    // Add the listener for this comboBox as using a lambda function.

    final String[] FILTERS = {"DEADLINES ONLY", "MEETINGS ONLY", "SHOW COMPLETED"};
    JCheckBox filterDisplay; // a set of checkboxes that allow the user to filter the
    // displayed events, removing complete tasks, deadlines, or meetings.
    // Add the listener for the filterDisplay as an anonymous class.

    JButton addEventButton;   // a button that opens an AddEventModal.
    Map<String, Predicate<Event>> filters;
    ArrayList<JCheckBox> filterBoxes;

    public EventListPanel() {
        setPreferredSize(new Dimension(1200, 700));
        setBackground(new Color(128, 0, 128));

        // Set Control Panel Size
        controlPanel = new JPanel();
        controlPanel.setPreferredSize(new Dimension(150, 400));
        events = new ArrayList<>();

        // Add Event Button
        addEventButton = new JButton("Add Event");
        addEventButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        addEventButton.addActionListener(e -> {
            new AddEventModel(this);
        });
        controlPanel.add(addEventButton);

        sortDropDown.setFont(new Font("Arial", Font.BOLD, 30));
        sortDropDown.addActionListener(e -> {
                    if (sortDropDown.getSelectedItem().equals(SORT_OPTIONS[0]))
                    {  // NAME
                        events.sort((a1, a2) -> a1.getName().compareToIgnoreCase(a2.getName()));
                    }
                    if (sortDropDown.getSelectedItem().equals(SORT_OPTIONS[1]))
                    {   // REVERSE_NAME
                        events.sort((a1, a2) -> a1.getName().compareToIgnoreCase(a2.getName()) * -1);
                    }
                    if (sortDropDown.getSelectedItem().equals(SORT_OPTIONS[2]))
                    {   // DATE
                        Collections.sort(events);
                    }
                    if (sortDropDown.getSelectedItem().equals(SORT_OPTIONS[3]))
                    {   // REVERSE_DATE
                        Collections.sort(events, Collections.reverseOrder());
                    }
                    updateDisplay();
                });
        add(sortDropDown);
        add(controlPanel);

        // Display Panel to Display Events
        displayPanel = new JPanel();
        displayPanel.setPreferredSize(new Dimension(700, 650));
        displayPanel.setBackground(Color.DARK_GRAY);
        add(displayPanel);
    }

    public void addEvent(Event event) { // Adds an Event
        events.add(event);
        updateDisplay();
    }

    public boolean isComplete(Event event) {
        boolean isComplete = false;
        for (JCheckBox filter : filterBoxes) {
            if (filter.isSelected()) {
                Predicate<Event> pred = filters.get(filter.getText());
                if (pred.test(event)) {
                    isComplete = true;
                }
            }
        }
        return isComplete;
    }

    public void updateDisplay() {
        displayPanel.removeAll();
        for (Event event : events) {
            displayPanel.add(new EventPanel(event));
        }
        revalidate();
        repaint();
    }
}