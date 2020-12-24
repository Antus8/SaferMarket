package com.example.asuper;

public class Supermarket {

    //dichiarazione stringhe
    private String id;
    private String nome;
    private int numpersone;
    private String civico;
    private String cap;
    private String via;
    private Beacon codbeacon_ingresso;
    private Beacon codbeacon_uscita;

    //crea oggetto
    public Supermarket(String id, String nome,String via, String civico, String cap, int numpersone, Beacon codBeacon_ingresso, Beacon codBeacon_uscita) {
        this.id=id;
        this.nome=nome;
        this.numpersone=numpersone;
        this.civico=civico;
        this.cap=cap;
        this.via=via;
        this.codbeacon_ingresso=codBeacon_ingresso;
        this.codbeacon_uscita=codBeacon_uscita;

    }

    public Supermarket(String id, String nome,String via, String civico, String cap, int numpersone) {
        this.id=id;
        this.nome=nome;
        this.numpersone=numpersone;
        this.civico=civico;
        this.cap=cap;
        this.via=via;
    }

    //get e set
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public void setNumpersone(int numpersone) {
        this.numpersone= numpersone;
    }
    public int getNumpersone() {
        return numpersone;
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

    public void setVia(String via) {
        this.via = via;
    }
    public String getVia() {
        return via;
    }

    public void setBeacon_ingresso(Beacon codbeacon_ingresso) {
        this.codbeacon_ingresso = codbeacon_ingresso;
    }
    public Beacon getBeacon_ingresso() {
        return codbeacon_ingresso;
    }

    public void setBeacon_uscita(Beacon codbeacon_uscita) {
        this.codbeacon_uscita = codbeacon_uscita;
    }
    public Beacon getBeacon_uscita() {
        return codbeacon_uscita;
    }
}
