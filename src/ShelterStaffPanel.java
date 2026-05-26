import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 * Η κλάση ShelterStaffPanel αναπαριστά το περιβάλλον διεπαφής του προσωπικού του καταφυγίου.
 * Χρησιμοποιεί BorderLayout ως κεντρική διάταξη, JTabbedPane για τον διαχωρισμό των 
 * διοικητικών λειτουργιών σε καρτέλες, και περιλαμβάνει πλήρη υποστήριξη αποσύνδεσης.
 */
public class ShelterStaffPanel extends JPanel {

    // --- Γραφικά Στοιχεία Κεφαλίδας (North) ---
    private JPanel headerPanel;
    private JLabel titleLabel;
    private JButton logoutButton;

    // --- Κεντρικό Σύστημα Καρτελών (Center) ---
    private JTabbedPane tabbedPane;

    // --- Καρτέλα 1: Στοιχεία Καταφυγίου ---
    private JPanel shelterTab;
    private JLabel shelterNameLabel;
    private JTextField shelterNameField;
    private JLabel shelterPhoneLabel;
    private JTextField shelterPhoneField;
    private JLabel shelterAddressLabel;
    private JTextField shelterAddressField;
    private JButton updateShelterButton;

    // --- Καρτέλα 2: Διαχείριση Χρηστών & Ζώων ---
    private JPanel managementTab;
    private JPanel animalFormPanel;
    private JTextField animalNameField;
    private JTextField animalAgeField;
    private JComboBox<String> animalTypeComboBox;
    private JButton addAnimalButton;

    private JPanel userFormPanel;
    private JTextField usernameField;
    private JComboBox<String> userRoleComboBox;
    private JButton createUserButton;

    // --- Καρτέλα 3: Αιτήσεις Υιοθεσίας ---
    private JPanel applicationsTab;
    private JTable applicationsTable;
    private JScrollPane tableScrollPane;
    private JPanel actionButtonPanel;
    private JButton approveButton;
    private JButton rejectButton;

    /**
     * Κατασκευαστής της κλάσης ShelterStaffPanel.
     * Αρχικοποιεί όλα τα γραφικά στοιχεία και κατασκευάζει τη δομή των καρτελών.
     */
    public ShelterStaffPanel() {
        // Ορισμός της κεντρικής διάταξης του Panel
        setLayout(new BorderLayout(10, 10));

        // ==========================================
        // 1. ΔΗΜΙΟΥΡΓΙΑ ΚΕΦΑΛΙΔΑΣ (NORTH)
        // ==========================================
        headerPanel = new JPanel(new BorderLayout());
        
        titleLabel = new JLabel("Πάνελ Διαχείρισης Προσωπικού");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        
        logoutButton = new JButton("Αποσύνδεση");

        headerPanel.add(titleLabel, BorderLayout.WEST);
        headerPanel.add(logoutButton, BorderLayout.EAST);
        add(headerPanel, BorderLayout.NORTH);

        // ==========================================
        // 2. ΔΗΜΙΟΥΡΓΙΑ ΣΥΣΤΗΜΑΤΟΣ ΚΑΡΤΕΛΩΝ (CENTER)
        // ==========================================
        tabbedPane = new JTabbedPane();

        // --- ΚΑΡΤΕΛΑ 1: Στοιχεία Καταφυγίου (GridBagLayout) ---
        shelterTab = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        shelterNameLabel = new JLabel("Όνομα Καταφυγίου:");
        shelterNameField = new JTextField("Το Καταφύγιό μας", 20);
        shelterPhoneLabel = new JLabel("Τηλέφωνο Επικοινωνίας:");
        shelterPhoneField = new JTextField("2101234567", 20);
        shelterAddressLabel = new JLabel("Διεύθυνση Καταφυγίου:");
        shelterAddressField = new JTextField("Λεωφόρος Αθηνών 100", 20);
        updateShelterButton = new JButton("Ενημέρωση Στοιχείων");

        // Τοποθέτηση στοιχείων Καρτέλας 1
        gbc.gridx = 0; gbc.gridy = 0; shelterTab.add(shelterNameLabel, gbc);
        gbc.gridx = 1; shelterTab.add(shelterNameField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1; shelterTab.add(shelterPhoneLabel, gbc);
        gbc.gridx = 1; shelterTab.add(shelterPhoneField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2; shelterTab.add(shelterAddressLabel, gbc);
        gbc.gridx = 1; shelterTab.add(shelterAddressField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        shelterTab.add(updateShelterButton, gbc);

        // --- ΚΑΡΤΕΛΑ 2: Διαχείριση Χρηστών & Ζώων (GridLayout 2x1) ---
        managementTab = new JPanel(new GridLayout(2, 1, 10, 10));

        // Υπο-πάνελ Α: Προσθήκη Ζώου
        animalFormPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 15));
        animalFormPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Προσθήκη Νέου Ζώου"));
        
        animalNameField = new JTextField(10);
        animalAgeField = new JTextField(5);
        String[] animalTypes = {"DOG", "CAT", "BIRD"};
        animalTypeComboBox = new JComboBox<>(animalTypes);
        addAnimalButton = new JButton("Προσθήκη Ζώου");

        animalFormPanel.add(new JLabel("Όνομα:"));
        animalFormPanel.add(animalNameField);
        animalFormPanel.add(new JLabel("Ηλικία:"));
        animalFormPanel.add(animalAgeField);
        animalFormPanel.add(new JLabel("Είδος:"));
        animalFormPanel.add(animalTypeComboBox);
        animalFormPanel.add(addAnimalButton);

        // Υπο-πάνελ Β: Εγγραφή Χρήστη
        userFormPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 15));
        userFormPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Εγγραφή Νέου Χρήστη"));
        
        usernameField = new JTextField(12);
        String[] roles = {"VET", "ADOPTER"};
        userRoleComboBox = new JComboBox<>(roles);
        createUserButton = new JButton("Δημιουργία Χρήστη");

        userFormPanel.add(new JLabel("Username:"));
        userFormPanel.add(usernameField);
        userFormPanel.add(new JLabel("Ρόλος:"));
        userFormPanel.add(userRoleComboBox);
        userFormPanel.add(createUserButton);

        managementTab.add(animalFormPanel);
        managementTab.add(userFormPanel);

        // --- ΚΑΡΤΕΛΑ 3: Αιτήσεις Υιοθεσίας (BorderLayout) ---
        applicationsTab = new JPanel(new BorderLayout(5, 5));
        
        String[] columnNames = {"ID Αίτησης", "Όνομα Adopter", "Όνομα Ζώου", "Κατάσταση"};
        Object[][] dummyData = {
            {"A101", "Μαρία Οικονόμου", "Rex (DOG)", "PENDING"},
            {"A102", "Δημήτρης Παπαδόπουλος", "Bella (CAT)", "PENDING"}
        };
        
        DefaultTableModel tableModel = new DefaultTableModel(dummyData, columnNames);
        applicationsTable = new JTable(tableModel);
        tableScrollPane = new JScrollPane(applicationsTable);
        applicationsTab.add(tableScrollPane, BorderLayout.CENTER);

        // Νότιο τμήμα Καρτέλας 3: Κουμπιά Έγκρισης/Απόρριψης
        actionButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
        approveButton = new JButton("Έγκριση");
        rejectButton = new JButton("Απόρριψη");
        actionButtonPanel.add(approveButton);
        actionButtonPanel.add(rejectButton);
        applicationsTab.add(actionButtonPanel, BorderLayout.SOUTH);

        // Προσθήκη όλων των καρτελών στο JTabbedPane
        tabbedPane.addTab("Στοιχεία Καταφυγίου", shelterTab);
        tabbedPane.addTab("Διαχείριση Χρηστών & Ζώων", managementTab);
        tabbedPane.addTab("Αιτήσεις Υιοθεσίας", applicationsTab);

        add(tabbedPane, BorderLayout.CENTER);

        // ==========================================
        // 3. ΛΟΓΙΚΗ ΑΠΟΣΥΝΔΕΣΗΣ (LOGOUT ACTION)
        // ==========================================
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ανάκτηση του MainFrame και επιστροφή στο LOGIN
                MainFrame parentFrame = (MainFrame) SwingUtilities.getWindowAncestor(ShelterStaffPanel.this);
                if (parentFrame != null) {
                    parentFrame.showPanel("LOGIN");
                }
            }
        });
    }
}