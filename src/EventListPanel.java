import javax.swing.*;

public class EventListPanel extends JPanel {
    ArrayList<Event> events {

    }   // a list of the events to be listed.

    JPanel controlPanel {

    }   // holds the controls for the event display.

    JPanel displayPanel {

    }   // a panel to hold the EventPanels corresponding to the events.

    JComboBox sortDropDown {

    }   // A drop down that will sort the events in the list
    // by name, date, or by the same qualities but in reverse order.
    // Add the listener for this comboBox as using a lambda function.

    JCheckBox filterDisplay {

    }   // a set of checkboxes that allow the user to filter the
    // displayed events, removing complete tasks, deadlines, or meetings.
    // Add the listener for the filterDisplay as an anonymous class.

    JButton addEventButton {

    }   // a button that opens an AddEventModal.

}
