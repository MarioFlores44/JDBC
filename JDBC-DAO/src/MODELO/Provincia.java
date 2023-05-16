package MODELO;

public class Provincia {
    private int id;
    private int CA;
    private String nom;
    private String codi_ine;
    private int numEscons;

    public Provincia(int CA, String nom, String codi_ine, int numEscons){
        this.nom = nom;
        this.CA = CA;
        this.codi_ine = codi_ine;
        this.numEscons = numEscons;
    }
    public Provincia(){

    }
    // GETTERS I SETTERS
    public void setId(int id){
        this.id = id;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setCA(int CA) { this.CA = CA; }
    public void setCodi_ine(String codi_ine){
        this.codi_ine = codi_ine;
    }
    public void setNumEscons(int numEscons) { this.numEscons = numEscons; }
    public int getId(){
        return this.id;
    }
    public String getNom(){
        return this.nom;
    }
    public int getCA() { return this.CA; }
    public String getCodi_ine(){
        return this.codi_ine;
    }
    public int getNumEscons() { return this.numEscons; }
    @Override
    public String toString(){
        System.out.printf("provincia_id: %2d | comunitat_aut_id: %2d | nom: %45s | codi_ine: %2s | numEscons: %5d\n", id, CA, nom, codi_ine, numEscons);
        return null;
    }
}
