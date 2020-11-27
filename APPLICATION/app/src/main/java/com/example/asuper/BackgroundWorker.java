package com.example.asuper;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ParseException;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BackgroundWorker extends AsyncTask <String, Void, String> {
    private Context context;
    private String tipo;
    private AlertDialog alertDialog;
    public String result;

    BackgroundWorker(Context ctx){
        context = ctx;
        result = "";
    }

    @Override
    protected String doInBackground(String[] params) {
        tipo = params[0];
        String server_url = "http://192.168.1.59/connessioneadb/server.php";
        String post_data = "";
        try {
            URL url = new URL(server_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            switch(tipo){
                case "login":{
                    String email = params[1];
                    String password = params[2];
                    post_data = URLEncoder.encode("service","UTF-8")+"="+URLEncoder.encode("login","UTF-8")+"&"
                            + URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"
                            +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                    break;
                }
                case "registrazione":{
                    String nome = params[1];
                    String cognome = params[2];
                    String email = params[3];
                    String password = params[4];
                    String indirizzo = params[5];

                    System.out.println(nome+cognome+email+password+indirizzo);

                    post_data = URLEncoder.encode("service","UTF-8")+"="+URLEncoder.encode("registrazione","UTF-8")+"&"
                            + URLEncoder.encode("nome","UTF-8")+"="+URLEncoder.encode(nome,"UTF-8")+"&"
                            + URLEncoder.encode("cognome","UTF-8")+"="+URLEncoder.encode(cognome,"UTF-8")+"&"
                            + URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"
                            + URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")+"&"
                            + URLEncoder.encode("indirizzo","UTF-8")+"="+URLEncoder.encode(indirizzo,"UTF-8");

                    System.out.println(post_data);

                    break;
                }
                case "prodotti":{
                    String nome_prodotto = params[1];
                    post_data = URLEncoder.encode("service","UTF-8")+"="+URLEncoder.encode("prodotti","UTF-8")+"&"
                            + URLEncoder.encode("prodotto","UTF-8")+"="+URLEncoder.encode(nome_prodotto,"UTF-8");
                    break;
                }
                case "prodotto":{
                    post_data = URLEncoder.encode("service","UTF-8")+"="+URLEncoder.encode("prodotto","UTF-8");
                    break;
                }
                case "supermercati":{
                    post_data = URLEncoder.encode("service","UTF-8")+"="+URLEncoder.encode("supermercati","UTF-8");
                    break;
                }
                case "entra":{
                    String email = params[1];
                    String beacon_id = params[2];
                    post_data = URLEncoder.encode("service","UTF-8")+"="+URLEncoder.encode("entra","UTF-8")+"&"
                            + URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"
                            +URLEncoder.encode("beacon","UTF-8")+"="+URLEncoder.encode(beacon_id,"UTF-8");
                    break;
                }
                case "esci":{
                    String email = params[1];
                    String beacon_id = params[2];
                    post_data = URLEncoder.encode("service","UTF-8")+"="+URLEncoder.encode("esci","UTF-8")+"&"
                            + URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"
                            +URLEncoder.encode("beacon","UTF-8")+"="+URLEncoder.encode(beacon_id,"UTF-8");
                    break;
                }
            }
            //devo mettere in encoding i parametri

            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();

            //PER GESTIRE LA RISPOSTA
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
            String result = "";
            String line;

            while((line = bufferedReader.readLine())!=null){
                result = result + line;
            }
            this.result = result;
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            System.out.println("Received: "+result);
            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Status");
    }

    @Override
    protected void onPostExecute(String result) {
        if(result!=null) {
            System.out.println(result);
            switch (tipo) {
                case "login": {
                    if (result.equals("1")) {
                        Toast.makeText(this.context, "Benvenuto", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(context, HomeFragment.class);
                        context.startActivity(i);
                    } else {
                        alertDialog.setMessage("Utente non registrato!");
                        alertDialog.show();
                    }
                    break;
                }
                case "registrazione": {
                    System.out.println(result);
                    if (result.equals("1")) {
                        Toast.makeText(this.context, "Registrazione avvenuta con successo!\nFai il LOGIN", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(context, login.class);
                        context.startActivity(i);
                    } else {
                        Toast.makeText(this.context, "Errore durante la registrazione!", Toast.LENGTH_LONG).show();
                        signup.email.setText("");
                        signup.password.setText("");
                    }
                    break;
                }
                case "prodotti": {
                    System.out.println(result);
                    StringTokenizer st = new StringTokenizer(result, ";");
                    String id, nome, via, civico, cap;
                    int numpersone;
                    while (st.hasMoreTokens()) {
                        String utente = st.nextToken();
                        StringTokenizer s = new StringTokenizer(utente, "/");
                        id = s.nextToken();
                        nome = s.nextToken();
                        via = s.nextToken();
                        civico = s.nextToken();
                        cap = s.nextToken();
                        numpersone = Integer.valueOf(s.nextToken());
                        System.out.println("Utente: " + nome + " " + via + " " + civico + " " + cap + " " + numpersone);
                    }
                    break;
                }
                case "prodotto": {
                    System.out.println(result);
                    ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
                    StringTokenizer st = new StringTokenizer(result, ";");
                    String nome;
                    while (st.hasMoreTokens()) {
                        nome = st.nextToken();
                        prodotti.add(new Prodotto("","",nome));
                    }
                    //TODO: set prodotti as a class member and launch Ricerca_Prodotto activity
                    Ricerca_Prodotto.prodotti = prodotti;
                    Intent i = new Intent (this.context, Ricerca_Prodotto.class);
                    this.context.startActivity(i);
                    break;
                }
                case "supermercati": {
                    System.out.println(result);
                    StringTokenizer st = new StringTokenizer(result, ";");
                    String id, nome, via, civico, cap;
                    ArrayList<Supermarket> sup = new ArrayList<Supermarket>();
                    int numpersone;
                    while (st.hasMoreTokens()) {
                        String supermarket = st.nextToken();
                        StringTokenizer s = new StringTokenizer(supermarket, "/");
                        id = s.nextToken();
                        nome = s.nextToken();
                        via = s.nextToken();
                        civico = s.nextToken();
                        cap = s.nextToken();
                        numpersone = Integer.valueOf(s.nextToken());
                        Beacon beacon_ing = new Beacon(s.nextToken(), "ingresso");
                        Beacon beacon_ex = new Beacon(s.nextToken(), "uscita");
                        sup.add(new Supermarket(id,nome,via,civico,cap,numpersone,beacon_ing,beacon_ex));
                    }
                    //TODO: launch activity ricerca supermercato
                    Ricerca_Supermercato.supermarkets = sup;
                    Intent i = new Intent(this.context, Ricerca_Supermercato.class);
                    this.context.startActivity(i);
                    break;
                }
                case "entra": {
                    Toast.makeText(this.context, "Aggiornamento effettuato", Toast.LENGTH_LONG).show();
                    break;
                }
                case "esci": {
                    Toast.makeText(this.context, "Aggiornamento effettuato", Toast.LENGTH_LONG).show();
                    break;
                }
            }
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        //super.onProgressUpdate(values)
        //setProgressValue(0);
    }

    public String getResult(){
        return this.result;
    }

}


