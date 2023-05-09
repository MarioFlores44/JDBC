package MODELO;

public class Municipi {
    private int id;
    private String nom;
    private String codi_ine;
    private int provincia;
    private String districte;

    public Municipi(int id, int provincia, String nom, String codi_ine, String districte){
        this.id = id;
        this.nom = nom;
        this.provincia = provincia;
        this.codi_ine = codi_ine;
        this.districte = districte;
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
        return "id:" + id + "| nom:" + nom + "| Provincia:" + provincia + "| codi ine:" + codi_ine + "| districte:" + districte;
    }
}
