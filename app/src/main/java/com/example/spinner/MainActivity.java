package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    //Objetos para cominicarnos con la parte grafica
    private Spinner spinnerOperaciones;
    private EditText et1, et2;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.editTextNumber);
        et2 = findViewById(R.id.editTextNumber2);
        tv1 = findViewById(R.id.tv_resulatado);

        spinnerOperaciones = findViewById(R.id.spinner);

        String[] opciones = {"Sumar", "Restar", "Multiplicar", "Dividir"};//Array de opciones que tndra nuestro spinner


        //Comunicamos el array con lo que se va a mostrar
        //El objeto adapter nos pide el contexto, tipo de spinner y el nombre del array de los elementos
        //Por defecto el tipo de spinner es el android.R.layout.simple_spinner_item, pero en esa ocasion gemos creado nuestro diseño
        //y lo hemos implementado en el spinner
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, R.layout.spinner_estilo, opciones);
        spinnerOperaciones.setAdapter(spinnerAdapter);

        //Lo que hacemos aqui es implementar la parte logica a nuestro spinner mediante un listener
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);




    }
    //Metodo que desarrolla este listener
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id){

        String opcion = (String) parent.getItemAtPosition(position);//Guardamos la posicion del spinner

        if (!(et1.getText().toString().isEmpty()) & !(et2.getText().toString().isEmpty())){
            String valor1 = et1.getText().toString();
            String valor2 = et2.getText().toString();
            int num1 = Integer.parseInt(valor1);
            int num2 = Integer.parseInt(valor2);
            int suma= 0;

            //Operaciones
            switch (opcion){
                case "Sumar":
                    suma = num1 + num2;
                    break;
                case "Restar":
                    suma = num1 - num2;
                    break;
                case "Multiplicar":
                    suma = num1 * num2;
                    break;
                case  "Dividir":
                    if(num2 == 0){

                    }else {
                        suma = num1 / num2;
                    }
                    break;
            }

            if((num2 == 0) && (opcion == "Dividir")) {
                tv1.setText("No se puede dividir por 0");
            }else {
                tv1.setText(String.valueOf(suma));
            }
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}