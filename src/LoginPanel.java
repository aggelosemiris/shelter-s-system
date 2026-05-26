import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Η κλάση LoginPanel αναπαριστά την οθόνη σύνδεσης της εφαρμογής.
 * Κληρονομεί από την JPanel και χρησιμοποιεί το GridBagLayout για την
 * κεντραρισμένη και ομοιόμορφη τοποθέτηση των γραφικών στοιχείων.
 */
public class LoginPanel extends JPanel {

    // Δήλωση όλων των γραφικών στοιχείων ως private
    private JLabel titleLabel;
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton loginButton;

    /**
     * Κατασκευαστής της κλάσης LoginPanel.
     * Αρχικοποιεί το layout, τα στοιχεία διεπαφής (UI components) και 
     * τοποθετεί τα στοιχεία στην οθόνη με τα κατάλληλα περιθώρια.
     */
    public LoginPanel() {
        // Ορισμός του GridBagLayout για τον κεντρικό έλεγχο της διάταξης
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Αρχικοποίηση των γραφικών στοιχείων
        titleLabel = new JLabel("Πλατφόρμα Υιοθεσίας Κατοικιδίων");
        // Μεγάλη γραμματοσειρά για τον τίτλο
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); 

        usernameLabel = new JLabel("Όνομα Χρήστη:");
        usernameField = new JTextField(15);

        passwordLabel = new JLabel("Κωδικός:");
        passwordField = new JPasswordField(15);

        loginButton = new JButton("Σύνδεση");

        // Ρύθμιση περιθωρίων (top, left, bottom, right) ώστε να μην είναι κολλημένα
        gbc.insets = new Insets(10, 10, 10, 10);

        // -- Τοποθέτηση του Τίτλου --
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Ο τίτλος θα απλώνεται σε 2 στήλες
        gbc.anchor = GridBagConstraints.CENTER;
        add(titleLabel, gbc);

        // -- Τοποθέτηση Ετικέτας "Όνομα Χρήστη" --
        gbc.gridy = 1;
        gbc.gridwidth = 1; // Επαναφορά σε 1 στήλη
        gbc.anchor = GridBagConstraints.EAST; // Στοίχιση δεξιά για τις ετικέτες
        add(usernameLabel, gbc);

        // -- Τοποθέτηση Πεδίου "Όνομα Χρήστη" --
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST; // Στοίχιση αριστερά για τα πεδία
        add(usernameField, gbc);

        // -- Τοποθέτηση Ετικέτας "Κωδικός" --
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        add(passwordLabel, gbc);

        // -- Τοποθέτηση Πεδίου "Κωδικός" --
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(passwordField, gbc);

        // -- Τοποθέτηση Κουμπιού "Σύνδεση" --
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2; // Το κουμπί κεντραρισμένο σε 2 στήλες
        gbc.anchor = GridBagConstraints.CENTER;
        add(loginButton, gbc);

        // -- Προσθήκη Λογικής στο Κουμπί Σύνδεσης --
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ανάγνωση δεδομένων από τα πεδία
                String username = usernameField.getText();
                // Το getPassword επιστρέφει char[], οπότε το μετατρέπουμε σε String
                String password = new String(passwordField.getPassword());
                
                // Κλήση της μεθόδου χειρισμού λογικής
                handleLogin(username, password);
            }
        });
    }

    /**
     * Επεξεργάζεται τα στοιχεία σύνδεσης (Dummy Logic).
     * * @param username Το όνομα χρήστη που πληκτρολογήθηκε.
     * @param password Ο κωδικός πρόσβασης που πληκτρολογήθηκε.
     */
    private void handleLogin(String username, String password) {
        // Βρίσκουμε το κεντρικό παράθυρο
        MainFrame parentFrame = (MainFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        
        if (parentFrame != null) {
            // Αν είναι Adopter
            if (username.equals("adopter") && password.equals("123")) {
                parentFrame.showPanel("ADOPTER");
            } 
            // Αν είναι Ιατρός (Vet)
            else if (username.equals("vet") && password.equals("123")) {
                parentFrame.showPanel("VET");
            } //Αν ειναι Staff
            else if (username.equals("staff") && password.equals("123")) {
                parentFrame.showPanel("STAFF");
            }
            // Αν τα στοιχεία είναι λάθος
            else {
                javax.swing.JOptionPane.showMessageDialog(this, "Λάθος Όνομα Χρήστη ή Κωδικός!", "Σφάλμα", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
           
        }
    }
}