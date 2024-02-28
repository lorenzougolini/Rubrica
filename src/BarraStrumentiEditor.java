import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

public class BarraStrumentiEditor extends JPanel implements ActionListener {

    private JButton bottoneSalva;
    private JButton bottoneAnnulla;

    private ButtonListener buttonListener;
    
    public BarraStrumentiEditor(){

        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        bottoneSalva = new JButton("Salva");
        bottoneAnnulla = new JButton("Annulla");

        bottoneSalva.addActionListener(this);
        bottoneAnnulla.addActionListener(this);

        add(bottoneSalva);
        add(bottoneAnnulla);

        setVisible(true);
    
    }

    public void setButtonListener(ButtonListener buttonListener){
        this.buttonListener = buttonListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();

        if (clicked == bottoneSalva) {
            buttonListener.onButton("Salva");

        } else if (clicked == bottoneAnnulla) {
            buttonListener.onButton("Annulla");
        }
    }
}
