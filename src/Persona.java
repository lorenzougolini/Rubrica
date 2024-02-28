public class Persona {
    
    String nome;
    String cognome;
    String indirizzo;
    String telefono;
    Integer eta;

    public Persona(String nome, String cognome, String indirizzo, String telefono, Integer eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.telefono = telefono;
        this.eta = eta;
    }

    @Override
    public String toString() {
        return  nome + ";" + cognome + ";" + indirizzo + ";" + telefono + ";" + eta;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getTelefono() {
        return telefono;
    }

    public Integer getEta() {
        return eta;
    }
}
