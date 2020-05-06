import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class JOurs extends JFrame{
     private JLabel jEtat;

    public JOurs(int num, String nom) {
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

        jEtat = new JLabel("Je dors");
        add(jEtat);
        setEtat("Je dors");
        pack();
        setSize(160, 100);

        // nombre de voiture logeables sur une ligne
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;

        int nb = (screenWidth - 100) / 180;
        int nbx = num % nb;
        int nby = num / nb;

        setLocation(100 + 180 * nbx, 300 + 100 * nby);
        setVisible(true);
    }

    public void setEtat(String etat) {
        jEtat.setText(etat);
        
        if (etat.equals("J'attends à l'entrée...")) {
            getContentPane().setBackground(Color.red);
        }
        if (etat.equals("Je dors")) {
            getContentPane().setBackground(Color.blue);
        }
        if (etat.equals("Je prends le miel")) {
            getContentPane().setBackground(Color.green);
        }
        

    }
}