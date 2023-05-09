package MODELO;

public class Persona {
    private int id;
    private String nom;
    private String cog1;
    private String cog2;
    private String sexe;
    private String data_naixament;
    private String dni;
    public Persona(int id, String nom, String cog1, String cog2, String sexe, String data_naixament, String dni){
        this.id = id;
        this.nom = nom;
        this.cog1 = cog1;
        this.cog2 = cog2;
        this.sexe = sexe;
        this.data_naixament = data_naixament;
        this.dni = dni;
    }

    // GETTERS I SETTERS
    public void setId(int id){
        this.id = id;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setCog1(String cog1){
        this.cog1 = cog1;
    }
    public void setCog2(String cog2){
        this.cog2 = cog2;
    }
    public void setSexe(String sexe){
        this.sexe = sexe;
    }
    public void setData_naixament(String data_naixament){
        this.data_naixament = data_naixament;
    }
    public void setDni(String dni){
        this.dni = dni;
    }
    public int getId(){
        return this.id;
    }
    public String getNom(){
        return this.nom;
    }
    public String getCog1(){
        return this.nom;
    }
    public String getCog2(){
        return this.nom;
    }
    public String getSexe(){
        return this.nom;
    }
    public String getData_naixament(){ return this.data_naixament; }
    public String getDni(){
        return this.dni;
    }
    @Override
    public String toString(){
        return "id:" + id + "| nom:" + nom + "| cog1:" + cog1 + "| cog2:" + cog2 + "| sexe:" + sexe + "| data naixament:" + data_naixament + "| dni:" + dni;
    }
}
