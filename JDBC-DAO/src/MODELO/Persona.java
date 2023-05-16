package MODELO;

public class Persona {
    public enum sexe {
        M, F
    }
    private int id;
    private String nom;
    private String cog1;
    private String cog2;

    private sexe sexe;
    private String data_naixament;
    private String dni;
    public Persona(String nom, String cog1, String cog2, sexe sexe, String data_naixament, String dni){
        this.nom = nom;
        this.cog1 = cog1;
        this.cog2 = cog2;
        this.sexe = sexe;
        this.data_naixament = data_naixament;
        this.dni = dni;
    }
    public Persona(){

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
    public void setSexe(sexe sexe){
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
        return this.cog1;
    }
    public String getCog2(){
        return this.cog2;
    }
    public String getSexe(){
        return this.sexe.toString();
    }
    public String getData_naixament(){ return this.data_naixament; }
    public String getDni(){
        return this.dni;
    }
    @Override
    public String toString(){
        System.out.printf("persona_id: %2d | nom: %30s | cog1: %30s | cog2: %30s | sexe: %2s | data_naixament: %10s | dni: %10s\n", id, nom, cog1, cog2, sexe, data_naixament, dni);
        return null;
    }
}
