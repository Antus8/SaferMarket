# Beacon e SaferMarket

QUALE USEREMO?
Utilizzeremo il beacon 'Eddystone', attraverso la comunicazione con protocollo -UID. 
Per comunicare con il dispositivo utilizzeremo un ID Statico univoco con un componente Namespace a 10 byte e un componente Istance a 6 byte.

COME INTERFACCIARLO ALL'ANDROID PROJECT?
Ricordatevi di includere la libreria AAR nel file project.
Link: https://altbeacon.github.io/android-beacon-library/download.html

!!ATTENZIONE!!
Assicurarsi di avere un jcenter() entry in repositories (nel gradle space) come:

repositories {
     jcenter()
   }

Aggiungere inoltre la libreria AAR (link su linkato) come una dipendenza in questo modo:

dependencies {
     implementation 'org.altbeacon:android-beacon-library:2+'
   }

IMPLEMENTAZIONE DELLE FUNZIONI NELLA CLASSE BEACON INPROJECT.

!! PROBLEMA PER IL RISPARMIO ENERGETICO!!

public class MyApplication extends Application implements BootstrapNotifier {
    private BackgroundPowerSaver backgroundPowerSaver;

    public void onCreate() {
        super.onCreate()
        // enables auto battery saving of about 60%
        backgroundPowerSaver = new BackgroundPowerSaver(this);
    }
}

