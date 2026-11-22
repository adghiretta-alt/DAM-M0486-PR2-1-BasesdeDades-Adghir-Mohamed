package cat.iesesteveterradas.model;

public class Faccio {

    private int id;
    private String nom;
    private String resum;

    public Faccio(int id, String nom, String resum) {
        this.id = id;
        this.nom = nom;
        this.resum = resum;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getResum() {
        return resum;
    }

    @Override
    public String toString() {
        return "Faccio{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", resum='" + resum + '\'' +
                '}';
    }
}