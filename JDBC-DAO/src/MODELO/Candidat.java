package MODELO;

public class Candidat {
    private int id;
    private int candidatura;
    private int persona;
    private int provincia;
    private int numOrdre;
    private String tipus;
    public Candidat(int candidatura, int persona, int provincia, int numOrdre, String tipus){
        this.candidatura = candidatura;
        this.persona = persona;
        this.provincia = provincia;
        this.numOrdre = numOrdre;
        this.tipus = tipus;
    }
    public Candidat(){

    }
    // GETTERS I SETTERS
    public void setId(int id){
        this.id = id;
    }
    public void setCandidatura(int candidatura){
        this.candidatura = candidatura;
    }
    public void setPersona(int persona){
        this.persona = persona;
    }
    public void setProvincia(int provincia){
        this.provincia = provincia;
    }
    public void setNumOrdre(int numOrdre){
        this.numOrdre = numOrdre;
    }
    public void setTipus(String tipus){
        this.tipus = tipus;
    }
    public int getId(){
        return this.id;
    }
    public int getCandidatura(){
        return this.candidatura;
    }
    public int getPersona(){
        return this.persona;
    }
    public int getProvincia(){
        return this.provincia;
    }
    public int getNumOrdre(){
        return this.numOrdre;
    }
    public String getTipus(){
        return this.tipus;
    }
    @Override
    public String toString(){
        return "id:" + id + "| candidatura:" + candidatura + "| persona:" + persona + "| provincia:" + provincia + "| numOrdre:" + numOrdre + "| tipus:" + tipus;
    }
}
