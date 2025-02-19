import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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

    JCheckBox filterDisplay; // a set of checkboxes that allow the user to filter the
    // displayed events, removing complete tasks, deadlines, or meetings.
    // Add the listener for the filterDisplay as an anonymous class.

    JButton addEventButton;   // a button that opens an AddEventModal.
    Map<String, Predicate<Event>> filters;
    ArrayList<JCheckBox> filterBoxes;

    /*
    EventListPanel() {  // Constructor
        events = new ArrayList<>();
        controlPanel = new JPanel();
        displayPanel = new JPanel();
        sortDropDown = new JComboBox();
        filterDisplay = new JCheckBox("Filter Display");
        addEventButton = new JButton("Add Event");
    }
    */


    public EventListPanel() {
        setPreferredSize(new Dimension(1200, 900));
        setBackground(Color.BLACK);

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

        //JComboBox sortDropDown = new JComboBox(SORT_OPTIONS);
        sortDropDown.setFont(new Font("Arial", Font.BOLD, 30));
        sortDropDown.addActionListener(e -> {
                    if (sortDropDown.getSelectedItem().equals(SORT_OPTIONS[0]))
                    {  // NAME
                        Collections.sort(events);
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
                    //add(sortDropDown);
                    updateDisplay();
                });
        add(sortDropDown);
/*
        filters = new HashMap<>();
        // Adding the AnimalFilters pre-mades to the list--could add more.
        filters.putAll(filterDisplay.getEventFilters());
        filterBoxes = new ArrayList<>();
        // initialize individual Checkboxes and add to ArrayList
        // for (String filter : FILTERS) {
        for ( String filter : filters.keySet()){
            JCheckBox box = new JCheckBox(filter);
            box.setFont(new Font("Arial", Font.BOLD, 30));
            box.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    updateDisplay();
                }
            });
            filterBoxes.add(box);
        }
        // Add each checkbox to the controlPanel
        for (JCheckBox filter : filterBoxes)
            controlPanel.add(filter);
*/
        add(controlPanel);

        // Display Panel to Display Events
        displayPanel = new JPanel();
        displayPanel.setPreferredSize(new Dimension(700, 650));
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