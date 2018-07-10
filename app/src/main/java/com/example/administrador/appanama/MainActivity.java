package com.example.administrador.appanama;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int time = 30;
    ImageView imgPrincipal;
    MediaPlayer sMoneda;
    Button mapa, llamar, btn_llamar;
    LinearLayout linearLayout;
    RadioGroup radioMazatlan, radioMochis, radioRosario, radioVillaunion, radioEscuinapa, radioCuliacan;
    TextView txt_mazatlan, txt_culiacan, txt_escuinapa, txt_rosario, txt_villaunion, txt_mochis;
    TextView txt_tel_villa1, txt_tel_villa2,txt_tel_rosario1,txt_tel_mochis1,txt_tel_es1;
    TextView txt_tel_cu1,txt_tel_cu2,txt_tel_cu3,txt_tel_cu4,txt_tel_cu5,txt_tel_cu6,txt_tel_cu7,txt_tel_cu8;
    TextView txt_tel1,txt_tel2,txt_tel3,txt_tel4,txt_tel5;
    Integer num_ciudad = 0;
    View alertLayout;
    RadioButton radioSexButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.icon_panama_mini);


        setContentView(R.layout.activity_main);
        mapa = (Button) findViewById(R.id.btn_mapa);
        llamar = (Button) findViewById(R.id.btn_llamar);

        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Mapa.class);
                startActivity(intent);
            }
        });
        llamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();
                alertLayout = inflater.inflate(R.layout.layout_llamar, null);
                btn_llamar = (Button) alertLayout.findViewById(R.id.btn_llamar);
                //zonas
                txt_mazatlan = (TextView) alertLayout.findViewById(R.id.txt_mazatlan);
                txt_culiacan = (TextView) alertLayout.findViewById(R.id.txt_culiacan);
                txt_escuinapa = (TextView) alertLayout.findViewById(R.id.txt_escuinapa);
                txt_rosario = (TextView) alertLayout.findViewById(R.id.txt_rosario);
                txt_villaunion = (TextView) alertLayout.findViewById(R.id.txt_villaunion);
                txt_mochis = (TextView) alertLayout.findViewById(R.id.txt_mochis);
                //group radios
                radioMazatlan = (RadioGroup) alertLayout.findViewById(R.id.radioMazatlan);
                radioMochis = (RadioGroup) alertLayout.findViewById(R.id.radioMochis);
                radioRosario = (RadioGroup) alertLayout.findViewById(R.id.radioRosario);
                radioVillaunion = (RadioGroup) alertLayout.findViewById(R.id.radioVillaunion);
                radioEscuinapa = (RadioGroup) alertLayout.findViewById(R.id.radioEscuinapa);
                radioCuliacan = (RadioGroup) alertLayout.findViewById(R.id.radioCuliacan);
                //contenedor
                linearLayout = (LinearLayout) alertLayout.findViewById(R.id.layout1);
                //telefonos
                txt_tel_villa1 = (TextView) alertLayout.findViewById(R.id.txt_tel_villa1);
                txt_tel_villa2 = (TextView) alertLayout.findViewById(R.id.txt_tel_villa2);
                txt_tel_rosario1 = (TextView) alertLayout.findViewById(R.id.txt_tel_rosario1);
                txt_tel_mochis1 = (TextView) alertLayout.findViewById(R.id.txt_tel_mochis1);
                txt_tel_es1 = (TextView) alertLayout.findViewById(R.id.txt_tel_es1);
                txt_tel_cu1 = (TextView) alertLayout.findViewById(R.id.txt_tel_cu1);
                txt_tel_cu2 = (TextView) alertLayout.findViewById(R.id.txt_tel_cu2);
                txt_tel_cu3 = (TextView) alertLayout.findViewById(R.id.txt_tel_cu3);
                txt_tel_cu4 = (TextView) alertLayout.findViewById(R.id.txt_tel_cu4);
                txt_tel_cu5 = (TextView) alertLayout.findViewById(R.id.txt_tel_cu5);
                txt_tel_cu6 = (TextView) alertLayout.findViewById(R.id.txt_tel_cu6);
                txt_tel_cu7 = (TextView) alertLayout.findViewById(R.id.txt_tel_cu7);
                txt_tel_cu8 = (TextView) alertLayout.findViewById(R.id.txt_tel_cu8);
                txt_tel1 = (TextView) alertLayout.findViewById(R.id.txt_tel1);
                txt_tel2 = (TextView) alertLayout.findViewById(R.id.txt_tel2);
                txt_tel3 = (TextView) alertLayout.findViewById(R.id.txt_tel3);
                txt_tel4 = (TextView) alertLayout.findViewById(R.id.txt_tel4);
                txt_tel5 = (TextView) alertLayout.findViewById(R.id.txt_tel5);

                //subrayado
                txt_mazatlan.setPaintFlags(txt_mazatlan.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                txt_culiacan.setPaintFlags(txt_culiacan.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                txt_escuinapa.setPaintFlags(txt_escuinapa.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                txt_rosario.setPaintFlags(txt_rosario.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                txt_villaunion.setPaintFlags(txt_villaunion.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                txt_mochis.setPaintFlags(txt_mochis.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                ver_telefonos(0);
                txt_culiacan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ver_telefonos(0);
                        ver_telefonos(1);

                    }
                });
                txt_escuinapa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ver_telefonos(0);
                        ver_telefonos(2);

                    }
                });
                txt_mazatlan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ver_telefonos(0);
                        ver_telefonos(3);

                    }
                });
                txt_mochis.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ver_telefonos(0);
                        ver_telefonos(4);

                    }
                });

                txt_rosario.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ver_telefonos(0);
                        ver_telefonos(5);

                    }
                });
                txt_villaunion.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ver_telefonos(0);
                        ver_telefonos(6);

                    }
                });
                btn_llamar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        llamar();
                    }
                });
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle(getString(R.string.lbl_sucursales));
                alert.setIcon(R.drawable.icon_panama_mini);
                alert.setView(alertLayout);
                alert.setCancelable(false);
                alert.setNegativeButton(getString(R.string.lbl_salir), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(), getString(R.string.lbl_gracias), Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog dialog = alert.create();
                dialog.show();
            }
        });
        anuncios();
    }

    public void llamar() {
        switch (num_ciudad) {
            case 1:
                int selectedIdC = radioCuliacan.getCheckedRadioButtonId();
                final RadioButton selectedRadioButtonC = (RadioButton) alertLayout.findViewById(selectedIdC);
                Integer telefonoC = Integer.valueOf(selectedRadioButtonC.getText().toString().substring(0, 1));
                switch (telefonoC){
                    case 1:
                        llamar_telefono(txt_tel_cu1.getText().toString());
                        break;
                    case 2:
                        llamar_telefono(txt_tel_cu2.getText().toString());
                        break;
                    case 3:
                        llamar_telefono(txt_tel_cu3.getText().toString());
                        break;
                    case 4:
                        llamar_telefono(txt_tel_cu4.getText().toString());
                        break;
                    case 5:
                        llamar_telefono(txt_tel_cu5.getText().toString());
                        break;
                    case 6:
                        llamar_telefono(txt_tel_cu6.getText().toString());
                        break;
                    case 7:
                        llamar_telefono(txt_tel_cu7.getText().toString());
                        break;
                    case 8:
                        llamar_telefono(txt_tel_cu8.getText().toString());
                        break;
                }
                break;
            case 2:
                llamar_telefono(txt_tel_es1.getText().toString());
                break;
            case 3:
                int selectedIdM = radioMazatlan.getCheckedRadioButtonId();
                final RadioButton selectedRadioButtonM = (RadioButton) alertLayout.findViewById(selectedIdM);
                Integer telefonoM = Integer.valueOf(selectedRadioButtonM.getText().toString().substring(0, 1));
                switch (telefonoM){
                    case 1:
                        llamar_telefono(txt_tel1.getText().toString());
                        break;
                    case 2:
                        llamar_telefono(txt_tel2.getText().toString());
                        break;
                    case 3:
                        llamar_telefono(txt_tel3.getText().toString());
                        break;
                    case 4:
                        llamar_telefono(txt_tel4.getText().toString());
                        break;
                    case 5:
                        llamar_telefono(txt_tel5.getText().toString());
                        break;
                }
                break;
            case 4:
                llamar_telefono(txt_tel_mochis1.getText().toString());
                break;
            case 5:
                llamar_telefono(txt_tel_rosario1.getText().toString());
                break;
            case 6:
                int selectedIdV = radioVillaunion.getCheckedRadioButtonId();
                final RadioButton selectedRadioButtonV = (RadioButton) alertLayout.findViewById(selectedIdV);
                Integer telefonoV = Integer.valueOf(selectedRadioButtonV.getText().toString().substring(0, 1));
                if (telefonoV == 1) {
                    llamar_telefono(txt_tel_villa1.getText().toString());
                 }else {
                    llamar_telefono(txt_tel_villa2.getText().toString());
                 }
                 break;
         }
    }

    @SuppressLint("MissingPermission")
    public String llamar_telefono(String numero){
        String telefono_final;
        telefono_final=numero.replaceAll("[\\s\\-()]", "");
        Intent i = new Intent(Intent.ACTION_CALL);
        i.setData(Uri.parse(telefono_final));
        startActivity(i);
        return numero;
    }

    public void ver_telefonos(Integer zona){
        switch(zona){
            case 0:
                txt_mazatlan.setTextColor(Color.parseColor("#b1b1af"));
                txt_culiacan.setTextColor(Color.parseColor("#b1b1af"));
                txt_escuinapa.setTextColor(Color.parseColor("#b1b1af"));
                txt_rosario.setTextColor(Color.parseColor("#b1b1af"));
                txt_villaunion.setTextColor(Color.parseColor("#b1b1af"));
                txt_mochis.setTextColor(Color.parseColor("#b1b1af"));
                linearLayout.setVisibility(View.INVISIBLE);
                radioMazatlan.setVisibility(View.GONE);
                radioMochis.setVisibility(View.GONE);
                radioRosario.setVisibility(View.GONE);
                radioVillaunion.setVisibility(View.GONE);
                radioEscuinapa.setVisibility(View.GONE);
                radioCuliacan.setVisibility(View.GONE);
                num_ciudad=0;
                break;
            case 1:
                txt_culiacan.setTextColor(Color.parseColor("#4f17bf"));
                linearLayout.setVisibility(View.VISIBLE);
                radioCuliacan.setVisibility(View.VISIBLE);
                num_ciudad=1;
                break;
            case 2:
                txt_escuinapa.setTextColor(Color.parseColor("#4f17bf"));
                linearLayout.setVisibility(View.VISIBLE);
                radioEscuinapa.setVisibility(View.VISIBLE);
                num_ciudad=2;
                break;
            case 3:
                txt_mazatlan.setTextColor(Color.parseColor("#4f17bf"));
                linearLayout.setVisibility(View.VISIBLE);
                radioMazatlan.setVisibility(View.VISIBLE);
                num_ciudad=3;
                break;
            case 4:
                txt_mochis.setTextColor(Color.parseColor("#4f17bf"));
                linearLayout.setVisibility(View.VISIBLE);
                radioMochis.setVisibility(View.VISIBLE);
                num_ciudad=4;
                break;
            case 5:
                txt_rosario.setTextColor(Color.parseColor("#4f17bf"));
                linearLayout.setVisibility(View.VISIBLE);
                radioRosario.setVisibility(View.VISIBLE);
                num_ciudad=5;
                break;
            case 6:
                txt_villaunion.setTextColor(Color.parseColor("#4f17bf"));
                linearLayout.setVisibility(View.VISIBLE);
                radioVillaunion.setVisibility(View.VISIBLE);
                num_ciudad=6;
                break;
        }
    }

    public void anuncios(){
        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                if (time==30){
                    setTitleColor(Color.BLACK);
                    setTitle(getString(R.string.promocion_1));
                }
                if (time==20){
                    setTitleColor(Color.BLACK);
                    setTitle(getString(R.string.promocion_2));
                }
                if (time==10){
                    setTitleColor(Color.BLACK);
                    setTitle(getString(R.string.promocion_3));
                }
                if (time==4){
                    setTitleColor(Color.BLACK);
                    setTitle(getString(R.string.promocion_4));
                }
                time--;
            }
            public void onFinish() {
            }

        }.start();
    }
}
