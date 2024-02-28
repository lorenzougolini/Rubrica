import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

public class BarraStrumentiPrincipale extends JPanel implements ActionListener {

    private JButton bottoneNuovo;
    private JButton bottoneModifica;
    private JButton bottoneElimina;

    private ButtonListener buttonListener;
    
    public BarraStrumentiPrincipale(){

        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        bottoneNuovo = new JButton("Nuovo");
        bottoneModifica = new JButton("Modifica");
        bottoneElimina = new JButton("Elimina");

        bottoneNuovo.addActionListener(this);
        bottoneModifica.addActionListener(this);
        bottoneElimina.addActionListener(this);
        
        add(bottoneNuovo);
        add(bottoneModifica);
        add(bottoneElimina);
        
        setVisible(true);
    
    }

    public void setButtonListener(ButtonListener buttonListener){
        this.buttonListener = buttonListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();

        if (clicked == bottoneNuovo) {
            buttonListener.onButton("Nuovo");

        } else if (clicked == bottoneModifica) {
            buttonListener.onButton("Modifica");
            
        } else if (clicked == bottoneElimina) {
            buttonListener.onButton("Elimina");
        }
    }
}
