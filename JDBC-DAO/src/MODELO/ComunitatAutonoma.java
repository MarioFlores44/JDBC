package MODELO;

public class ComunitatAutonoma {
    private int comunitat_aut_id;
    private String nom;
    private String codi_ine;

    public ComunitatAutonoma(int comunitat_aut_id, String nom, String codi_ine){
        this.comunitat_aut_id = comunitat_aut_id;
        this.nom = nom;
        this.codi_ine = codi_ine;
    }

    public ComunitatAutonoma(){
        
    }

    // GETTERS I SETTERS
    public void setId(int comunitat_aut_id){
        this.comunitat_aut_id = comunitat_aut_id;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setCodi_ine(String codi_ine){
        this.codi_ine = codi_ine;
    }
    public int getId(){
        return this.comunitat_aut_id;
    }
    public String getNom(){
        return this.nom;
    }
    public String getCodi_ine(){
        return this.codi_ine;
    }
    @Override
    public String toString(){
        return "id:" + comunitat_aut_id + "| nom:" + nom + "| codi ine:" + codi_ine;
    }
}
