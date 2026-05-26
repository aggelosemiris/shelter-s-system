import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 * Η κλάση VetPanel αναπαριστά το περιβάλλον διεπαφής του κτηνιάτρου.
 * Περιλαμβάνει πλέον και λειτουργία αποσύνδεσης (Logout).
 */
public class VetPanel extends JPanel {

    // Γραφικά στοιχεία βορείου τμήματος (Τίτλος & Logout)
    private JPanel headerPanel;
    private JLabel titleLabel;
    private JButton logoutButton; // Νέο κουμπί Logout

    // Γραφικά στοιχεία κεντρικού τμήματος (Πίνακας Ζώων)
    private JTable animalTable;
    private JScrollPane scrollPane;

    // Γραφικά στοιχεία νοτίου τμήματος (Φόρμα Εισαγωγής)
    private JPanel formPanel;
    private JLabel descriptionLabel;
    private JTextField descriptionField;
    private JLabel dateLabel;
    private JTextField dateField;
    private JButton addButton;

    /**
     * Κατασκευαστής της κλάσης VetPanel.
     */
    public VetPanel() {
        setLayout(new BorderLayout(10, 10));

        // --- Βόρειο Τμήμα (North): Τίτλος και Αποσύνδεση ---
        headerPanel = new JPanel(new BorderLayout());
        
        titleLabel = new JLabel("Πάνελ Κτηνιάτρου - Ιατρικοί Φάκελοι", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        
        logoutButton = new JButton("Αποσύνδεση");

        // Τοποθετούμε τον τίτλο στο κέντρο και το κουμπί Logout στα δεξιά της μπάρας
        headerPanel.add(titleLabel, BorderLayout.CENTER);
        headerPanel.add(logoutButton, BorderLayout.EAST);
        
        add(headerPanel, BorderLayout.NORTH);

        // --- Κεντρικό Τμήμα (Center): Πίνακας Ζώων ---
        String[] columnNames = {"ID Ζώου", "Όνομα", "Είδος", "Τελευταία Ιατρική Πράξη"};
        Object[][] dummyData = {
            {"1", "Rex", "DOG", "Εμβολιασμός (15/05/2026)"},
            {"2", "Bella", "CAT", "Στείρωση (10/04/2026)"},
            {"3", "Tweety", "BIRD", "Έλεγχος (01/05/2026)"},
            {"4", "Max", "DOG", "Καμία Πράξη"}
        };

        DefaultTableModel model = new DefaultTableModel(dummyData, columnNames);
        animalTable = new JTable(model);
        scrollPane = new JScrollPane(animalTable);
        add(scrollPane, BorderLayout.CENTER);

        // --- Νότιο Τμήμα (South): Φόρμα Εισαγωγής Νέας Πράξης ---
        formPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));

        descriptionLabel = new JLabel("Περιγραφή Πράξης:");
        descriptionField = new JTextField(15);
        dateLabel = new JLabel("Ημερομηνία:");
        dateField = new JTextField(10);
        addButton = new JButton("Προσθήκη στο Ιστορικό");

        formPanel.add(descriptionLabel);
        formPanel.add(descriptionField);
        formPanel.add(dateLabel);
        formPanel.add(dateField);
        formPanel.add(addButton);

        add(formPanel, BorderLayout.SOUTH);

        // --- Λογική Κουμπιού Αποσύνδεσης ---
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Επιστροφή στην οθόνη LOGIN
                MainFrame parentFrame = (MainFrame) SwingUtilities.getWindowAncestor(VetPanel.this);
                if (parentFrame != null) {
                    parentFrame.showPanel("LOGIN");
                }
            }
        });
    }
}