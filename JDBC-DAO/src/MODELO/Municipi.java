package MODELO;

public class Municipi {
    private int id;
    private String nom;
    private String codi_ine;
    private int provincia;
    private String districte;

    public Municipi(int provincia, String nom, String codi_ine, String districte){
        this.nom = nom;
        this.provincia = provincia;
        this.codi_ine = codi_ine;
        this.districte = districte;
    }
    public Municipi(){

    }
    // GETTERS I SETTERS
    public void setId(int id){
        this.id = id;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setProvincia(int provincia) { this.provincia = provincia; }
    public void setCodi_ine(String codi_ine){
        this.codi_ine = codi_ine;
    }
    public void setDistricte(String districte) { this.districte = districte; }
    public int getId(){
        return this.id;
    }
    public String getNom(){
        return this.nom;
    }
    public int getProvincia() { return this.provincia; }
    public String getCodi_ine(){
        return this.codi_ine;
    }
    public String getDistricte() { return this.districte; }
    @Override
    public String toString(){
        System.out.printf("municipi_id: %2d | nom: %100s | codi_ine: %3s | provincia_id: %2d | districte: %5s\n", id, nom, codi_ine, provincia, districte);
        return null;
    }
}
