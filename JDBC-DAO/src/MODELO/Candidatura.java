package MODELO;

import java.util.Scanner;

public class Candidatura {
    Scanner scan = new Scanner(System.in);
    int candidaturaId;
    int eleccioId;
    String codiCandidatura;
    String nomCurt;
    String nomLlarg;
    String codiAcProvincia;
    String codiAcCA;
    String codiAcNacional;

    public Candidatura(int eleccioId, String codiCandidatura, String nomCurt, String nomLlarg, String codiAcProvincia, String codiAcCA, String codiAcNacional) {
        if (comprobarEleccioId(eleccioId)) {
            setEleccioId(eleccioId);
        }

        if (comprobarCodiCandidatura(codiCandidatura)) {
            setCodiCandidatura(codiCandidatura);
        }

        if (comprobarNomCurt(nomCurt)) {
            setNomCurt(nomCurt);
        }

        if (comprobarNomLlarg(nomLlarg)) {
            setNomLlarg(nomLlarg);
        }

        if (comprobarCodiAcProvincia(codiAcProvincia)) {
            setCodiAcProvincia(codiAcProvincia);
        }

        if (comprobarCodiAcCA(codiAcCA)) {
            setCodiAcCA(codiAcCA);
        }

        if (comprobarCodiAcNacional(codiAcNacional)) {
            setCodiAcNacional(codiAcNacional);
        }
    }

    public Candidatura() {

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

    public boolean comprobarNomLlarg(String nomLlarg) {
        while (nomLlarg.length() > 150) {
            System.out.println("El nombre largo de la candidatura no puede tener más de 255 caracteres");
            nomLlarg = scan.nextLine();
        }
        return true;
    }

    public boolean comprobarCodiAcProvincia(String codiAcProvincia) {
        while (codiAcProvincia.length() > 6) {
            System.out.println("El código de la provincia no puede tener más de 6 caracteres");
            codiAcProvincia = scan.nextLine();
        }
        return true;
    }

    public boolean comprobarCodiAcCA(String codiAcCA) {
        while (codiAcCA.length() > 6) {
            System.out.println("El código de la comunidad autónoma no puede tener más de 6 caracteres");
            codiAcCA = scan.nextLine();
        }
        return true;
    }

    public boolean comprobarCodiAcNacional(String codiAcNacional) {
        while (codiAcNacional.length() > 6) {
            System.out.println("El código de la nacionalidad no puede tener más de 6 caracteres");
            codiAcNacional = scan.nextLine();
        }
        return true;
    }

    @Override
    public String toString(){
        System.out.printf("candidatura_id: %2d | eleccio_id: %2d | codi_candidatura: %6s | nom_curt: %50s |" +
                " nom_llarg: %150s | codi_acumulacio_provincia: %6s | codi_acumulacio_ca: %6s | " +
                "codi_acumulacio_nacional: %6s\n", candidaturaId, eleccioId, codiCandidatura, nomCurt, nomLlarg,
                codiAcProvincia, codiAcCA, codiAcNacional);
        return null;
    }

    //Getters y Setters
    public void setCandidaturaId(int id) {
        this.candidaturaId = id;
    }

    public int getCandidaturaId() {
        return candidaturaId;
    }
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
