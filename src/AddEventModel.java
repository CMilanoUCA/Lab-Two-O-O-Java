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
    private record Attribute(String name, JComponent component) {}
    // name = Attribute name, component = how Attribute is collected
    private ArrayList<Attribute> attributes;

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
            eventSelector.addActionListener(e -> {
                infoCollectionPanel.removeAll();
                attributes = new ArrayList<>();
                switch(eventSelector.getSelectedIndex()) {
                    case 0: // Meeting Data
                        // Attributes:
                        attributes.add(new Attribute("Name", new JTextField(9)));
                        // Start Time:
                        attributes.add(new Attribute("Start Year", new JTextField(9)));
                        attributes.add(new Attribute("Start Month", new JTextField(9)));
                        attributes.add(new Attribute("Start Day", new JTextField(9)));
                        attributes.add(new Attribute("Start Hour", new JTextField(9)));
                        attributes.add(new Attribute("Start Minute", new JTextField(9)));
                        // End Time:
                        attributes.add(new Attribute("End Year", new JTextField(9)));
                        attributes.add(new Attribute("End Month", new JTextField(9)));
                        attributes.add(new Attribute("End Day", new JTextField(9)));
                        attributes.add(new Attribute("End Hour", new JTextField(9)));
                        attributes.add(new Attribute("End Minute", new JTextField(9)));
                        attributes.add(new Attribute("Location", new JTextField(9)));
                        break;
                    case 1: // Deadline Data
                        // Attributes:
                        attributes.add(new Attribute("Name", new JTextField(9)));
                        // Deadline Date
                        attributes.add(new Attribute("Deadline Year", new JTextField(9)));
                        attributes.add(new Attribute("Deadline Month", new JTextField(9)));
                        attributes.add(new Attribute("Deadline Day", new JTextField(9)));
                        attributes.add(new Attribute("Deadline Hour", new JTextField(9)));
                        attributes.add(new Attribute("Deadline Minute", new JTextField(9)));
                        break;
                }
                // Box Layout
                infoCollectionPanel.setLayout(new GridLayout(attributes.size(), 2));
                for (Attribute attribute : attributes) {
                    infoCollectionPanel.add(new JLabel(attribute.name));
                    infoCollectionPanel.add(attribute.component);
                }
                revalidate();
                repaint();
            });

            eventSelector.setSelectedIndex(0);

            add(infoCollectionPanel);

            addEventButton = new JButton("Add Event");
            addEventButton.addActionListener(e -> {
                Event event = new Meeting("Task Assignment Meeting",
                        LocalDateTime.of(2025, 2, 22, 12, 15),
                        LocalDateTime.of(2025, 2, 22, 13, 15),
                        "Torreysson Library");;
                switch(eventSelector.getSelectedIndex()) {
                    case 0: event = new Meeting(
                            ((JTextField)(attributes.get(0).component())).getText(),
                        LocalDateTime.of(Integer.parseInt(((JTextField)(attributes.get(1).component())).getText()),
                                Integer.parseInt(((JTextField)(attributes.get(2).component())).getText()),
                                Integer.parseInt(((JTextField)(attributes.get(3).component())).getText()),
                                Integer.parseInt(((JTextField)(attributes.get(4).component())).getText()),
                                Integer.parseInt(((JTextField)(attributes.get(5).component())).getText())
                        ), LocalDateTime.of(Integer.parseInt(((JTextField)(attributes.get(6).component())).getText()),
                                Integer.parseInt(((JTextField)(attributes.get(7).component())).getText()),
                                Integer.parseInt(((JTextField)(attributes.get(8).component())).getText()),
                                Integer.parseInt(((JTextField)(attributes.get(9).component())).getText()),
                                Integer.parseInt(((JTextField)(attributes.get(10).component())).getText())
                        ),
                                (((JTextField)(attributes.get(11).component())).getText()));
                    break;
                    case 1: event = new Deadline(
                            ((JTextField)(attributes.get(0).component())).getText(),
                        LocalDateTime.of(Integer.parseInt(((JTextField)(attributes.get(1).component())).getText()),
                                Integer.parseInt(((JTextField)(attributes.get(2).component())).getText()),
                                Integer.parseInt(((JTextField)(attributes.get(3).component())).getText()),
                                Integer.parseInt(((JTextField)(attributes.get(4).component())).getText()),
                                Integer.parseInt(((JTextField)(attributes.get(5).component())).getText()))
                        );


                    break;
                }


                eventListPanel.addEvent(event);
                myself.dispose();
            });

            add(addEventButton);


        }
    }

}
