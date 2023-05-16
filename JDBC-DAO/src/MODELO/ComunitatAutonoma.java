package MODELO;

public class ComunitatAutonoma {
    private int comunitat_aut_id;
    private String nom;
    private String codi_ine;

    public ComunitatAutonoma(String nom, String codi_ine){
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
        System.out.printf("comunitat_aut_id: %2d | nom: %45s | codi_ine: %2s\n", comunitat_aut_id, nom, codi_ine);
        return null;
    }
}
