package com.example.connessionepulsazione;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


public class MainActivity extends AppCompatActivity {

    private View layout_connessione_beacon;
    private ImageView imageBeacon, Animazione, Animazione2;
    private Handler handlerAnimationCIMG;
    private boolean abled;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        abled = false;
        count = 0;
        init();

        Glide.with(getBaseContext()).load(R.drawable.beacon_technology)
                .apply(new RequestOptions().
                        circleCrop()).into(imageBeacon);



        findViewById(R.id.buttonConnetti).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(abled == false){
                TextView connetti = (TextView) findViewById(R.id.textView2);
                connetti.setVisibility(View.VISIBLE);
                abled = true;
                startTask();
                }
            }
        });

       /* findViewById(R.id.buttonInterrompiConnessione).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopTask();
                abled = false;
            }
        }); */

    }

    private void init() {
        this.handlerAnimationCIMG = new Handler();
        this.layout_connessione_beacon = findViewById(R.id.layoutConnessione);
        this.imageBeacon = findViewById(R.id.imageBeacon);
        this.Animazione = findViewById(R.id.Animazione);
        this.Animazione2 = findViewById(R.id.Animazione2);
    }

    private void startTask() {
        this.runnableAnim.run();
        this.layout_connessione_beacon.setVisibility(View.VISIBLE);
    }

    private void stopTask() {
        this.handlerAnimationCIMG.removeCallbacks(runnableAnim);
        this.layout_connessione_beacon.setVisibility(View.GONE);
        TextView connesso = (TextView) findViewById(R.id.textView);
        connesso.setVisibility(View.VISIBLE);
    }


    private Runnable runnableAnim = new Runnable() {
        @Override
        public void run() {


            Animazione.animate().scaleX(2f).scaleY(2f).alpha(0f).setDuration(600).withEndAction(new Runnable() {
                @Override
                public void run() {
                    Animazione.setScaleX(1f);
                    Animazione.setScaleY(1f);
                    Animazione.setAlpha(1f);
                }
            });
            Animazione2.animate().scaleX(3f).scaleY(3f).alpha(0f).setDuration(650).withEndAction(new Runnable() {
                @Override
                public void run() {
                    Animazione2.setScaleX(1f);
                    Animazione2.setScaleY(1f);
                    Animazione2.setAlpha(1f);
                }
            });
            handlerAnimationCIMG.postDelayed(runnableAnim, 800);
            count = count + 1;
            if(count == 5){
                count = 0;
                stopTask();
                abled = false;
            }
        }
    };
}

