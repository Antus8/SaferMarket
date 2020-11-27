package com.example.asuper;

public class Beacon {

    private String codice;
    private String locazione;

    public Beacon(String codice, String locazione){
        this.codice = codice;
        this.locazione = locazione;
    }
    /*private BeaconManager mBeaconManager;
    public void onResume() {
        super.onResume();
        mBeaconManager = BeaconManager.getInstanceForApplication(this.getApplicationContext());
        //Riconosce il mainframe UID dell’EddystoneBeacon:
        mBeaconManager.getBeaconParsers().add(new BeaconParser().
                setBeaconLayout(BeaconParser.EDDYSTONE_UID_LAYOUT));
        mBeaconManager.bind(this);
    }

    @Override
    public void onBeaconServiceConnect() {
        Identifier myBeaconNamespaceId = Identifier.parse("NameSpaceID del Beacon");
        Identifier myBeaconInstanceId = Identifier.parse("IstanceID del beacon");
        Region region = new Region("my-beacon-region", myBeaconNamespaceId, myBeaconInstanceId, null);
        mBeaconManager.addMonitorNotifier(this);
        try {
            mBeaconManager.startMonitoringBeaconsInRegion(region);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void didEnterRegion (Region region) {
        //incrementare contatore in supermercato
        //1° BEACON VICINO L'ENTRATA
    }

    public void didExitRegion (Region region) {
        //decrementare contatore in supermercato
        //2° BEACON VICINO L'USCITA
    }

    public void didDetermineStateForRegion (int state, Region region) {
        //POSSIBILE IMPLEMENTAZIONE (?)
        //Non utile ai fini della nostra applicazione
    }

    @Override
    public void onPause() {
        super.onPause();
        mBeaconManager.unbind(this);
    }

     */
}