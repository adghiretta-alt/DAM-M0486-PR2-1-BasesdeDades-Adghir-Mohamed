package cat.iesesteveterradas.model;

public class Personatge {

    private int id;
    private String nom;
    private double atac;
    private double defensa;
    private int idFaccio;

    public Personatge(int id, String nom, double atac, double defensa, int idFaccio) {
        this.id = id;
        this.nom = nom;
        this.atac = atac;
        this.defensa = defensa;
        this.idFaccio = idFaccio;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public double getAtac() {
        return atac;
    }

    public double getDefensa() {
        return defensa;
    }

    public int getIdFaccio() {
        return idFaccio;
    }

    @Override
    public String toString() {
        return "Personatge{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", atac=" + atac +
                ", defensa=" + defensa +
                ", idFaccio=" + idFaccio +
                '}';
    }
}