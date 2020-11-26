package com.example.asuper;

public class Beacon {

    //dichiarazione stringhe
    private String codice;
    private String locazione;

    //crea oggetto
    public Beacon(String codice, String locazione) {
        this.codice = codice;
        this.locazione = locazione;
    }

    //get e set
    public void setCodice(String codice){
        this.codice = codice;
    }
    public String getCodice(){
        return codice;
    }
    public void setLocazione(String locazione) {
    this.locazione= locazione;
    }
    public String getLocazione() {
    return locazione;
    }

    public Beacon getBeacon (){
        return this;
    }
}

