import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Το κεντρικό παράθυρο της εφαρμογής (JFrame).
 * Χρησιμοποιεί CardLayout για την εναλλαγή των διαφόρων JPanels.
 */
public class MainFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainContainer;

    public MainFrame() {
        setTitle("Καταφύγιο Ζώων - Σύστημα Διαχείρισης");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 1. Αρχικοποίηση του CardLayout και του κεντρικού Container
        cardLayout = new CardLayout();
        mainContainer = new JPanel(cardLayout);

        // 2. Δημιουργία των Panels
        LoginPanel loginPanel = new LoginPanel();
        AdopterPanel adopterPanel = new AdopterPanel();
        VetPanel vetPanel = new VetPanel(); 
        ShelterStaffPanel staffPanel = new ShelterStaffPanel(); // ΠΡΟΣΘΗΚΗ: Δημιουργία του VetPanel

        // 3. Προσθήκη των Panels στο mainContainer με ένα "όνομα" (String)
        mainContainer.add(loginPanel, "LOGIN");
        mainContainer.add(adopterPanel, "ADOPTER");
        mainContainer.add(vetPanel, "VET");
        mainContainer.add(staffPanel, "STAFF");

        // Προσθήκη του container στο κεντρικό παράθυρο
        add(mainContainer);

        // 4. Ορίζουμε να εμφανίζεται η οθόνη σύνδεσης αρχικά
        cardLayout.show(mainContainer, "LOGIN");
    }

    /**
     * Μέθοδος που καλείται από τα διάφορα πάνελ για να αλλάξουν την οθόνη.
     * @param panelName Το όνομα της οθόνης που θέλουμε να εμφανιστεί (π.χ. "ADOPTER")
     */
    public void showPanel(String panelName) {
        cardLayout.show(mainContainer, panelName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = new MainFrame();
                frame.setVisible(true);
            }
        });
    }
}