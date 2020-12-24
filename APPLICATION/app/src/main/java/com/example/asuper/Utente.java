package com.example.asuper;

public class Utente {

    //dichiarazione stringhe
    private String email;
    private String nome;
    private String cognome;
    private String password;
    private String via;
    private String civico;
    private String cap;

    //crea oggetto
    public Utente(String email, String nome, String cognome, String password, String via, String civico, String cap) {
    this.email=email;
    this.nome=nome;
    this.cognome=cognome;
    this.password=password;
    this.via=via;
    this.civico=civico;
    this.cap=cap;
    }

    public Utente(String email, String nome, String cognome, String via) {
        this.email=email;
        this.nome=nome;
        this.cognome=cognome;
        this.via=via;
    }

    public Utente(String email, String password){
        this.email = email;
        this.password = password;
    }

    //get e set
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getCognome() {
        return cognome;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public void setVia(String via) {
        this.via = via;
    }
    public String getVia() {
        return via;
    }

    public void setCivico(String civico) {
        this.civico = civico;
    }
    public String getCivico() {
        return civico;
    }


    public void setCap(String cap) {
        this.cap = cap;
    }
    public String getCap() {
        return cap;
    }


}
