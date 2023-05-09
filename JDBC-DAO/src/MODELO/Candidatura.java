package MODELO;

import java.util.Scanner;

public class Candidatura {
    Scanner scan = new Scanner(System.in);
    int eleccioId;
    String codiCandidatura;
    String nomCurt;
    String nomLlarg;
    String codiAcProvincia;
    String codiAcCA;
    String codiAcNacional;

    public Candidatura(int eleccióId, String codiCandidatura, String nomCurt, String nomLlarg, String codiAcProvincia, String codiAcCA, String codiAcNacional) {
        if (comprobarEleccioId(eleccioId)) {
            setEleccioId(eleccioId);
        }
        if (comprobarCodiCandidatura(codiCandidatura)) {
            setCodiCandidatura(codiCandidatura);
        }
        if (comprobarNomCurt(nomCurt)) {
            setNomCurt(nomCurt);
        }
        this.nomLlarg = nomLlarg;
        this.codiAcProvincia = codiAcProvincia;
        this.codiAcCA = codiAcCA;
        this.codiAcNacional = codiAcNacional;
    }

    // Comprobantes
    public boolean comprobarEleccioId(int eleccioId) {
        while (eleccioId < 0) {
            System.out.println("El id de la elección no puede ser negativo");
            eleccioId = scan.nextInt();
        }
        return true;
    }

    public boolean comprobarCodiCandidatura(String codiCandidatura) {
        while (codiCandidatura.length() > 6) {
            System.out.println("El código de la candidatura no puede tener más de 6 caracteres");
            codiCandidatura = scan.nextLine();
        }
        return true;
    }

    public boolean comprobarNomCurt(String nomCurt) {
        while (nomCurt.length() > 50) {
            System.out.println("El nombre corto de la candidatura no puede tener más de 50 caracteres");
            nomCurt = scan.nextLine();
        }
        return true;
    }



    @Override
    public String toString(){
        return "eleccioId:" + eleccioId + "| codiCandidatura:" + codiCandidatura + "| nomCurt:" + nomCurt + "| nomLlarg:" + nomLlarg + "| codiAcProvincia:" + codiAcProvincia + "| codiAcCA:" + codiAcCA + "| codiAcNacional:" + codiAcNacional;
    }

    //Getters y Setters
    public void setEleccioId(int id) {
        this.eleccioId = id;
    }

    public int getEleccioId() {
        return eleccioId;
    }

    public void setCodiCandidatura(String codiCandidatura) {
        this.codiCandidatura = codiCandidatura;
    }

    public String getCodiCandidatura() {
        return codiCandidatura;
    }

    public void setNomCurt(String nomCurt) {
        this.nomCurt = nomCurt;
    }

    public String getNomCurt() {
        return nomCurt;
    }

    public void setNomLlarg(String nomLlarg) {
        this.nomLlarg = nomLlarg;
    }

    public String getNomLlarg() {
        return nomLlarg;
    }

    public void setCodiAcProvincia(String codiAcProvincia) {
        this.codiAcProvincia = codiAcProvincia;
    }

    public String getCodiAcProvincia() {
        return codiAcProvincia;
    }

    public void setCodiAcCA(String codiAcCA) {
        this.codiAcCA = codiAcCA;
    }

    public String getCodiAcCA() {
        return codiAcCA;
    }

    public void setCodiAcNacional(String codiAcNacional) {
        this.codiAcNacional = codiAcNacional;
    }

    public String getCodiAcNacional() {
        return codiAcNacional;
    }

}
