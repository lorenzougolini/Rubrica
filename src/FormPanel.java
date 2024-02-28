import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;

public class FormPanel extends JPanel {

    private JLabel labelNome;
    private JLabel labelCognome;
    private JLabel labelTelefono;
    private JLabel labelIndirizzo;
    private JLabel labelEta;

    private JTextField textNome;
    private JTextField textCognome;
    private JTextField textTelefono;
    private JTextField textIndirizzo;
    private JTextField textEta;

    public FormPanel() {

        setPreferredSize(new Dimension(300, 100));
        setLayout(new GridBagLayout());

        labelNome = new JLabel("Nome: ");
        labelCognome = new JLabel("Cognome: ");
        labelTelefono = new JLabel("Telefono: ");
        labelIndirizzo = new JLabel("Indirizzo: ");
        labelEta = new JLabel("Età: ");

        textNome = new JTextField(20);
        textCognome = new JTextField(20);
        textTelefono = new JTextField(20);
        textIndirizzo = new JTextField(20);
        textEta = new JTextField(20);

        defineLayout();

    }

    public FormPanel(Persona persona) {

        setPreferredSize(new Dimension(300, 100));
        setLayout(new GridBagLayout());

        labelNome = new JLabel("Nome: ");
        labelCognome = new JLabel("Cognome: ");
        labelTelefono = new JLabel("Telefono: ");
        labelIndirizzo = new JLabel("Indirizzo: ");
        labelEta = new JLabel("Età: ");

        textNome = new JTextField(persona.getNome(), 20);
        textCognome = new JTextField(persona.getCognome(), 20);
        textTelefono = new JTextField(persona.getTelefono(), 20);
        textIndirizzo = new JTextField(persona.getIndirizzo(), 20);
        textEta = new JTextField(persona.getEta().toString(), 20);

        defineLayout();

    }

    private void defineLayout() {
        
        // Border bordoInterno = BorderFactory.createTitledBorder("Inserisci i dati del nuovo contatto");
        // Border bordoEsterno = BorderFactory.createEmptyBorder(0, 5, 5, 5);
        // Border bordoFinale = BorderFactory.createCompoundBorder(bordoEsterno, bordoInterno);
        // setBorder(bordoFinale);

        // layout
        GridBagConstraints gc = new GridBagConstraints();

        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 0.02;
        gc.weighty = 0.02;
        add(labelNome, gc);
        
        gc.gridx = 1;
        gc.gridy = 0;
        gc.weightx = 0.02;
        gc.weighty = 0.02;
        add(textNome, gc);
        
        gc.gridx = 0;
        gc.gridy = 1;
        gc.weightx = 0.02;
        gc.weighty = 0.02;
        add(labelCognome, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.weightx = 0.02;
        gc.weighty = 0.02;
        add(textCognome, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        gc.weightx = 0.02;
        gc.weighty = 0.02;
        add(labelTelefono, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        gc.weightx = 0.02;
        gc.weighty = 0.02;
        add(textTelefono, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        gc.weightx = 0.02;
        gc.weighty = 0.02;
        add(labelIndirizzo, gc);

        gc.gridx = 1;
        gc.gridy = 3;
        gc.weightx = 0.02;
        gc.weighty = 0.02;
        add(textIndirizzo, gc);

        gc.gridx = 0;
        gc.gridy = 4;
        gc.weightx = 0.02;
        gc.weighty = 0.02;
        add(labelEta, gc);

        gc.gridx = 1;
        gc.gridy = 4;
        gc.weightx = 0.02;
        gc.weighty = 0.02;
        add(textEta, gc);
    }

    public String getNome() {
        return textNome.getText();
    }
    
    public String getCognome() {
        return textCognome.getText();
    }
    
    public String getTelefono() {
        return textTelefono.getText();
    }
    
    public String getIndirizzo() {
        return textIndirizzo.getText();
    }

    public Integer getEta() {
        return Integer.parseInt(textEta.getText());
    }

}
