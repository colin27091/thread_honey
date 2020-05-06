import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class JRuche extends JFrame{
     private JLabel jEtat;
     private JLabel jMiel;

    public JRuche(int num, String nom) {
        super(nom);
        //fermeture avec croix rouge
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        // creation des composants
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        jEtat = new JLabel("Vide");
        add(jEtat);
        setEtat("Vide");
        jMiel = new JLabel("poids de miel = 0g");
        add(jMiel);
        pack();
        setSize(160, 100);

        // nombre de voiture logeables sur une ligne
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;

        int nb = (screenWidth - 100) / 180;
        int nbx = num % nb;
        int nby = num / nb;

        setLocation(100 + 180 * nbx, 200 + 100 * nby);
        setVisible(true);
    }

    public void setMiel(int poidsMiel) {
        jMiel.setText("poids de miel = "+poidsMiel+"g");
    }
    public void setEtat(String etat) {
        jEtat.setText(etat);
        
        if (etat.equals("Vide")) {
            getContentPane().setBackground(Color.green);
        }
        if (etat.equals("Occupée")) {
            getContentPane().setBackground(Color.red);
        }

    }
}
