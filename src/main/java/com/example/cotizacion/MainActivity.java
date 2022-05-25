package com.example.cotizacion;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.view.View;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    private TextView lblNumCotizacion;
    private TextView lblDescripcion;
    private TextView lblPrecio;
    private TextView lblPorcentaje;
    private TextView lblPlazo;
    private TextView lblDatos;
    private EditText txtNumCotizacion;
    private EditText txtDescripcion;
    private EditText txtPrecio;
    private EditText txtPorcentaje;
    private EditText txtPlazo;
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
        lblNumCotizacion=(TextView) findViewById(R.id.lblNumCotizacion);
        lblDescripcion=(TextView) findViewById(R.id.lblDescripcion);
        lblPrecio=(TextView) findViewById(R.id.lblPrecio);
        lblPorcentaje=(TextView) findViewById(R.id.lblPorcentaje);
        lblPlazo=(TextView) findViewById(R.id.lblPlazo);
        lblDatos=(TextView) findViewById(R.id.lblDatos);
        txtNumCotizacion=(EditText) findViewById(R.id.txtNumCotizacion);
        txtDescripcion=(EditText) findViewById(R.id.txtDescripcion);
        txtPrecio=(EditText) findViewById(R.id.txtPrecio);
        txtPorcentaje=(EditText) findViewById(R.id.txtPorcentaje);
        txtPlazo=(EditText) findViewById(R.id.txtPlazo);
        btnCotizacion=(Button) findViewById(R.id.btnCotizacion);
        btnCerrar=(Button) findViewById(R.id.btnCerrar);
        btnLimpiar=(Button) findViewById(R.id.btnLimpiar);
        lblNumCotizacion.setText("Capture el numero de cotizacion");
        lblDescripcion.setText("Capture la descripcion del auto");
        lblPrecio.setText("Capture el precio del auto");
        lblPorcentaje.setText("Capture el porcentaje inicial del auto");
        lblPlazo.setText("Capture el plazo (meses) del auto");

        btnCotizacion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int numCotizacion=Integer.parseInt(txtNumCotizacion.getText().toString());
                String descripcion=txtDescripcion.getText().toString();
                int precio= Integer.parseInt(txtPrecio.getText().toString());
                int porcentaje=Integer.parseInt(txtPorcentaje.getText().toString());
                int plazo=Integer.parseInt(txtPlazo.getText().toString());
                Cotizacion cotizacion=new Cotizacion(numCotizacion,descripcion,precio,porcentaje,plazo);
                lblDatos.setText(cotizacion.toString()+
                        "\nPago inicial: $"+cotizacion.calculoInicial()+ "\n Total a financiar: $"+
                        cotizacion.totalFinanciar()+"\n Pago mensual: $"+cotizacion.pagoMensual());

            }
        });
        btnCerrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Cerrar();
            }
        });
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                txtNumCotizacion.setText("");
                txtDescripcion.setText("");
                txtPrecio.setText("");
                txtPorcentaje.setText("");
                txtPlazo.setText("");
                lblDatos.setText("");
            }
        });
    }
}
