import java.util.EventObject;

public class FormEvent extends EventObject {
    private String nome;
    private String cognome;
    private String telefono;
    private String indirizzo;
    private Integer eta;
    
    public FormEvent(Object source) {
        super(source);
    }
    
    public FormEvent(Object source, String nome, String cognome, String telefono, String indirizzo, Integer eta) {
        super(source);
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
        this.indirizzo = indirizzo;
        this.eta = eta;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getCognome() {
        return cognome;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public String getIndirizzo() {
        return indirizzo;
    }

    public Integer getEta() {
        return eta;
    }
    
}