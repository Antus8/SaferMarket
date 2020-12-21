package com.example.asuper;

public class Prodotto {

        //dichiarazione stringhe
        private String idSupermarket;
        private String codice;
        private String nome;


        //crea oggetto
        public Prodotto( String idSupermarket, String codice, String nome) {
            this.idSupermarket=idSupermarket;
            this.codice=codice;
            this.nome=nome;


        }

        //get e set
        public void setidSupermarket(String idSupermarket) {
            this.idSupermarket = idSupermarket;
        }
        public String getidSupermarket() {
            return idSupermarket;
        }

        public void setCodice(String codice) {
            this.codice = codice;
        }
        public String getCodice() {
            return codice;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }
        public String getNome() {
            return nome;
        }


    }

