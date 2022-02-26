package com.example.parcialimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.view.View.OnClickListener;


public class MainActivity extends AppCompatActivity {
    EditText edtPeso, edtAltura;
    TextView txtImc, txtInfrapeso, txtNormal, txtSobre, txtObesidad1, txtObesidad2, txtObesidad3;
    Button btnCalcular, btnBorrar;
    Button boton;
    float peso, altura, imc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtPeso = (EditText) findViewById(R.id.peso);
        edtAltura = (EditText) findViewById(R.id.altura);
        txtImc = (TextView) findViewById(R.id.imc);
        txtInfrapeso = (TextView) findViewById(R.id.infrapeso);
        txtNormal = (TextView) findViewById(R.id.normal);
        txtSobre = (TextView) findViewById(R.id.sobrepeso);
        txtObesidad1 = (TextView) findViewById(R.id.obesidad1);
        txtObesidad2 = (TextView) findViewById(R.id.obesidad2);
        txtObesidad3 = (TextView) findViewById(R.id.obesidad3);
        btnCalcular = (Button) findViewById(R.id.calcular);
        btnBorrar = (Button) findViewById(R.id.borrar);
        boton= (Button) findViewById(R.id.btnsiguiente);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(getApplicationContext(),Integrantes.class);
                startActivity(b);
            }
        });







        btnCalcular.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg) {
                    try {
                        peso = Float.parseFloat(edtPeso.getText().toString());
                        altura = Float.parseFloat(edtAltura.getText().toString());
                        imc = peso / (altura * altura);
                        txtImc.setText("IMC:  " + redondear(imc));
                        borrar();
                        if (imc < 18.5) {
                            txtInfrapeso.setBackgroundColor(Color.parseColor("#FF043970"));
                            txtInfrapeso.setTextColor(Color.parseColor("#FFF"));
                        }
                        if (imc >= 18.5 && imc < 25) {
                            txtNormal.setBackgroundColor(Color.parseColor("#FF189794"));
                            txtNormal.setTextColor(Color.parseColor("#FFF"));
                        }
                        if (imc >= 25 && imc < 30) {
                            txtSobre.setBackgroundColor(Color.parseColor("#FF0D9714"));
                            txtSobre.setTextColor(Color.parseColor("#FFF"));
                        }
                        if (imc >= 30 && imc < 35) {
                            txtObesidad1.setBackgroundColor(Color.parseColor("#FF727706"));
                            txtObesidad1.setTextColor(Color.parseColor("#FFF"));
                        }
                        if (imc >= 35 && imc < 40) {
                            txtObesidad2.setBackgroundColor(Color.parseColor("#FFB57F2F"));
                            txtObesidad2.setTextColor(Color.parseColor("#FFF"));
                        }
                        if (imc >= 40) {
                            txtObesidad3.setBackgroundColor(Color.parseColor("#FFD21506 "));
                            txtObesidad3.setTextColor(Color.parseColor("#FFF"));
                        }
                    }catch (Exception e){

                    }

            }
        });

        btnBorrar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg) {
                borrar();
                edtPeso.setText("");
                edtAltura.setText("");
                txtImc.setText("IMC: ");

            }
        });


    }

    public float redondear(float n) {
        float res;
        int valor = 0;
        valor = (int) (n * 100);
        res = (float) valor / 100;
        return res;

    }

    public void borrar() {

        txtInfrapeso.setBackgroundColor(Color.parseColor("#000"));
        txtInfrapeso.setTextColor(Color.parseColor("#FFF"));
        txtNormal.setBackgroundColor(Color.parseColor("#000"));
        txtNormal.setTextColor(Color.parseColor("#FFF"));
        txtSobre.setBackgroundColor(Color.parseColor("#000"));
        txtSobre.setTextColor(Color.parseColor("#FFF"));
        txtObesidad1.setBackgroundColor(Color.parseColor("#000"));
        txtObesidad1.setTextColor(Color.parseColor("#FFF"));
        txtObesidad2.setBackgroundColor(Color.parseColor("#000"));
        txtObesidad2.setTextColor(Color.parseColor("#FFF"));
        txtObesidad3.setBackgroundColor(Color.parseColor("#000"));
        txtObesidad3.setTextColor(Color.parseColor("#FFF"));
    }

}
