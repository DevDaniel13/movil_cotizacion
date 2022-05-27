package com.example.cotizacion;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.view.View;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    private EditText txtNum;
    private EditText txtDescripcion;
    private EditText txtPrecio;
    private EditText txtPorcentaje;
    private EditText txtPlazo;
    private TextView lblDatos;
    private Button btnCotizacion;
    private Button btnCerrar;
    private Button btnLimpiar;

    private void Cerrar(){
        AlertDialog.Builder confirmar=new AlertDialog.Builder(this);
        confirmar.setTitle("¿Cerrar APP?");
        confirmar.setMessage("Se descartara toda la informacion ingresada");
        confirmar.setPositiveButton("Confirmar",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialogInterface, int i){
                finish();
            }
        });
        confirmar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialogInterface, int i){

            }
        });
        confirmar.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNum=(EditText) findViewById(R.id.txtNum);
        txtDescripcion=(EditText) findViewById(R.id.txtDescripcion);
        txtPrecio=(EditText) findViewById(R.id.txtPrecio);
        txtPorcentaje=(EditText) findViewById(R.id.txtPorcentaje);
        txtPlazo=(EditText) findViewById(R.id.txtPlazo);
        lblDatos=(TextView) findViewById(R.id.lblDatos);
        btnCotizacion=(Button) findViewById(R.id.btnCotizacion);
        btnCerrar=(Button) findViewById(R.id.btnCerrar);
        btnLimpiar=(Button) findViewById(R.id.btnLimpiar);
        btnCotizacion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(txtNum.getText().toString().matches("") || txtDescripcion.getText().toString().matches("") || txtPrecio.getText().toString().matches("") || txtPorcentaje.getText().toString().matches("") || txtPlazo.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this,"Existe un dato invalido",Toast.LENGTH_SHORT).show();
                }else{
                    int id=Integer.parseInt(txtNum.getText().toString());
                    String descripcion=txtDescripcion.getText().toString();
                    int precio= Integer.parseInt(txtPrecio.getText().toString());
                    int porcentaje=Integer.parseInt(txtPorcentaje.getText().toString());
                    int plazo=Integer.parseInt(txtPlazo.getText().toString());
                    Cotizacion cotizacion=new Cotizacion(id,descripcion,precio,porcentaje,plazo);
                    lblDatos.setText(cotizacion.toString()+
                            "\nPago inicial: $"+cotizacion.calculoInicial()+ "\n Total a financiar: $"+
                            cotizacion.totalFinanciar()+"\n Pago mensual: $"+cotizacion.pagoMensual());
                }
            }
        });
        btnCerrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Cerrar();
            }
        });
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                txtNum.setText("");
                txtDescripcion.setText("");
                txtPrecio.setText("");
                txtPorcentaje.setText("");
                txtPlazo.setText("");
                lblDatos.setText("");
            }
        });
    }
}