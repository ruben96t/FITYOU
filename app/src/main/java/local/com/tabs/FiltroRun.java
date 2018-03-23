/*package local.com.tabs;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

*//**
 * Created by user on 19/03/2018.
 *//*

public class FiltroRun extends AppCompatActivity {

    TextView mostrarTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filtrorun_lay);

        DBTrains gestion = new DBTrains(this);

        Cursor c = gestion.getTrains("Run");

        mostrarDatos(c);
        gestion.close();
    }

    public void mostrarDatos(Cursor c) {

        mostrarTexto = findViewById(R.id.textView2);

        if (c == null) {

            mostrarTexto.setText("No trainings registered");

        } else {

            int cuenta = c.getCount();
            int aux = 0;
            String datos="";
            int[][] datosArr = new int[cuenta][2];

            if (c.moveToFirst()) {
                do {
                    Log.d("TAG", "Nombre: " + c.getString(1));

                    datos +="\nTiempo: " + c.getInt(2) +
                            "\nDay: " + c.getInt(4) +
                            "\nMes: " + c.getInt(5) +
                            "\nAño: " + c.getInt(6) +
                            "\n\n";
                    //Recogemos en el array el dato de tiempo
                    datosArr[aux][0]= c.getInt(2);
                    //Recogemos el dato de día.
                    datosArr[aux][1]= c.getInt(4);

                    aux++;


                } while (c.moveToNext() && aux <cuenta);
            }

            mostrarTexto.setText(datos);
        }
    }


    public void verDiary (View view){
        Intent intent = new Intent(this, Diary.class);
        startActivity(intent);

    }


}*/
