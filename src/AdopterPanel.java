import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 * Η κλάση AdopterPanel αναπαριστά το περιβάλλον διεπαφής του υποψήφιου θετού γονέα.
 * Περιλαμβάνει πλέον και λειτουργία αποσύνδεσης (Logout).
 */
public class AdopterPanel extends JPanel {

    // Γραφικά στοιχεία βορείου τμήματος (Αναζήτηση & Logout)
    private JPanel northPanel;
    private JPanel searchSubPanel;
    private JLabel searchLabel;
    private JComboBox<String> typeComboBox;
    private JButton searchButton;
    private JButton logoutButton; // Νέο κουμπί Logout

    // Γραφικά στοιχεία κεντρικού τμήματος (Πίνακας Ζώων)
    private JTable animalTable;
    private JScrollPane scrollPane;

    // Γραφικά στοιχεία νοτίου τμήματος (Αίτηση)
    private JPanel southPanel;
    private JButton adoptButton;
    private JLabel statusLabel;

    /**
     * Κατασκευαστής της κλάσης AdopterPanel.
     */
    public AdopterPanel() {
        setLayout(new BorderLayout(10, 10));

        // --- Βόρειο Τμήμα (North): Αναζήτηση και Αποσύνδεση ---
        northPanel = new JPanel(new BorderLayout());
        
        // Υπο-πάνελ αριστερά για την αναζήτηση
        searchSubPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchLabel = new JLabel("Αναζήτηση ανά Είδος:");
        String[] types = {"ΟΛΑ", "DOG", "CAT", "BIRD"};
        typeComboBox = new JComboBox<>(types);
        searchButton = new JButton("Αναζήτηση");
        
        searchSubPanel.add(searchLabel);
        searchSubPanel.add(typeComboBox);
        searchSubPanel.add(searchButton);

        // Κουμπί αποσύνδεσης στα δεξιά
        logoutButton = new JButton("Αποσύνδεση");

        northPanel.add(searchSubPanel, BorderLayout.WEST);
        northPanel.add(logoutButton, BorderLayout.EAST);
        
        add(northPanel, BorderLayout.NORTH);

        // --- Κεντρικό Τμήμα (Center): Πίνακας Ζώων ---
        String[] columnNames = {"ID", "Όνομα", "Είδος", "Ηλικία"};
        Object[][] dummyData = {
            {"1", "Rex", "DOG", 3},
            {"2", "Bella", "CAT", 2},
            {"3", "Tweety", "BIRD", 1},
            {"4", "Max", "DOG", 5}
        };

        DefaultTableModel model = new DefaultTableModel(dummyData, columnNames);
        animalTable = new JTable(model);
        scrollPane = new JScrollPane(animalTable);
        add(scrollPane, BorderLayout.CENTER);

        // --- Νότιο Τμήμα (South): Αίτηση Υιοθεσίας ---
        southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        adoptButton = new JButton("Αίτηση Υιοθεσίας");
        statusLabel = new JLabel("Κατάσταση Αίτησης: ΚΑΜΙΑ");

        southPanel.add(adoptButton);
        southPanel.add(statusLabel);
        add(southPanel, BorderLayout.SOUTH);

        // --- Λογική Κουμπιού Αποσύνδεσης ---
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Επιστροφή στην οθόνη LOGIN
                MainFrame parentFrame = (MainFrame) SwingUtilities.getWindowAncestor(AdopterPanel.this);
                if (parentFrame != null) {
                    parentFrame.showPanel("LOGIN");
                }
            }
        });
    }
}