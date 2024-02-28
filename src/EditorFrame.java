import javax.swing.*;
import java.awt.BorderLayout;

public class EditorFrame extends JFrame {

    private FormPanel formPanel;
    private BarraStrumentiEditor barraStrumentiEditor;
    private TableFrame tableFrame;

    public EditorFrame(TableFrame tableFrame, Persona persona, Integer row) {

        super("Nuovo Contatto");
        this.tableFrame = tableFrame;

        setLayout(new BorderLayout());

        if (persona != null) {
            setTitle("Modifica Contatto");
            formPanel = new FormPanel(persona);
        } else {
            setTitle("Nuovo Contatto");
            formPanel = new FormPanel();
        }

        barraStrumentiEditor = new BarraStrumentiEditor();
        barraStrumentiEditor.setButtonListener(new ButtonListener() {
            @Override
            public void onButton(String button) {
                if (button.equals("Salva")) {

                    salvaContatto(row);

                } else if (button.equals("Annulla")) {

                    dispose();
                }
            }
        });

        add(formPanel, BorderLayout.CENTER);
        add(barraStrumentiEditor, BorderLayout.PAGE_END);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    
    private void salvaContatto(int row){
        String nome = formPanel.getNome().trim();
        String cognome = formPanel.getCognome().trim();
        String indirizzo = formPanel.getIndirizzo().trim();
        String telefono = formPanel.getTelefono().trim();
        Integer eta = formPanel.getEta();

        Persona persona = new Persona(nome, cognome, indirizzo, telefono, eta);

        try {
            tableFrame.save(persona, row);
        } catch (Exception e) {
            e.printStackTrace();
        }
        dispose();
    }
}
