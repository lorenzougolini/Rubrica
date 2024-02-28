import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

public class TableFrame extends JFrame{

    static ArrayList<Persona> rubrica = new ArrayList<Persona>();

    private TablePanel tablePanel;
    private BarraStrumentiPrincipale barraStrumentiPrincipale;

    public TableFrame(){

        super("Rubrica");
        
        setLayout(new BorderLayout());

        tablePanel = new TablePanel();
        barraStrumentiPrincipale = new BarraStrumentiPrincipale();

        barraStrumentiPrincipale.setButtonListener(new ButtonListener() {
            @Override
            public void onButton(String button) {
                if (button.equals("Nuovo")) {

                    apriEditor();

                } else if (button.equals("Modifica")) {

                    Integer row = tablePanel.getSelectedRow();

                    if (row == -1) {
                        JOptionPane.showMessageDialog(null, "Seleziona un contatto da modificare");
                        return;
                    };

                    Persona p = rubrica.get(row);
                    modificaContatto(p, row);
                    tablePanel.clearSelection();

                } else if (button.equals("Elimina")) {

                    Integer row = tablePanel.getSelectedRow();

                    if (row == -1) {
                        JOptionPane.showMessageDialog(null, "Seleziona un contatto da eliminare");
                        return;
                    };

                    Persona p = rubrica.get(row);
                    int option = JOptionPane.showConfirmDialog(null, String.format("Eliminare la persona %s %s?", p.getNome(), p.getCognome()), "Conferma eliminazione", JOptionPane.YES_NO_OPTION);

                    if (option == JOptionPane.YES_OPTION){
                        rimuoviContatto(row);
                        tablePanel.clearSelection();
                    } else {
                        tablePanel.clearSelection();
                        return;
                    }
                }
            }
        });

        add(tablePanel, BorderLayout.CENTER);
        add(barraStrumentiPrincipale, BorderLayout.PAGE_END);

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);

        try {
            loadFile();
            loadTableRows();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void loadFile() throws FileNotFoundException {

        Scanner scanFile = new Scanner(new File("rubrica.txt"));

        while (scanFile.hasNextLine()) {

            String line = scanFile.nextLine();
            String[] data = line.split(";");
            Persona p = new Persona(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]));
            rubrica.add(p);

            if (scanFile.hasNext("") == true) break;
        }
        scanFile.close();

    }

    public void loadTableRows(){

        for (Persona persona : rubrica){
            tablePanel.addRow(persona.getNome(), persona.getCognome(), persona.getTelefono());
        }
    }

    public void save(Persona persona, Integer row) {
        
        if (row != -1) {

            rubrica.set(row, persona);
            tablePanel.updateRow(persona.getNome(), persona.getCognome(), persona.getTelefono(), row);
        
        } else {

            rubrica.add(persona);
            tablePanel.addRow(persona.getNome(), persona.getCognome(), persona.getTelefono());
        
        }

        try {
            saveRubrica();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    private void apriEditor() {
        EditorFrame editorFrame = new EditorFrame(this, null, -1);
        editorFrame.setVisible(true);
    }

    private void modificaContatto(Persona persona, Integer row){
        EditorFrame editorFrame = new EditorFrame(this, persona, row);
        editorFrame.setVisible(true);
    }

    private void rimuoviContatto(Integer row){

        Persona persona = rubrica.get(row);
        rubrica.remove(persona);
        tablePanel.removeRow(row);
        try {
            saveRubrica();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveRubrica() throws FileNotFoundException {

        PrintStream writeToFile = new PrintStream(new FileOutputStream("rubrica.txt"));
        for (Persona persona : rubrica){
            writeToFile.append(persona.toString()).append("\n");
        }
        writeToFile.close();
        
    }

}
