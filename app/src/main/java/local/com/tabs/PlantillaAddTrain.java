/*package local.com.tabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class PlantillaAddTrain extends AppCompatActivity {

    ArrayList<Train> myTrain;
    int time;
    int dist;
    int day;
    int month;
    int year;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void insertRunDb(View v) {

        String train = "Run";
        String auxtime = ((EditText) this.findViewById(R.id.editTextTime)).getText().toString();
        String auxdist = ((EditText) this.findViewById(R.id.editTextDist)).getText().toString();
        String auxday = ((EditText) this.findViewById(R.id.editTextDay)).getText().toString();
        String auxmonth = ((EditText) this.findViewById(R.id.editTextMonth)).getText().toString();
        String auxyear = ((EditText) this.findViewById(R.id.editTextYear)).getText().toString();

        //IMPORTANTE!!! Cuando usamos editText vacíos el resultado para el código NO ES NULL!!, ES ("")


        if ((auxtime.equals("")) || (auxdist.equals("")) || (auxday.equals("")) || (auxmonth.equals("")) || (auxyear.equals(""))) {

            Toast.makeText(this, "Complete all fields", Toast.LENGTH_LONG).show();


        } else {

            //edad = Integer.parseInt(((EditText)this.findViewById(R.id.editTextEdad)).getText().toString());
            time = Integer.parseInt(auxtime);
            dist = Integer.parseInt(auxdist);
            day = Integer.parseInt(auxday);
            month = Integer.parseInt(auxmonth);
            year = Integer.parseInt(auxyear);

            Train t = new Train(train, time, dist, day, month, year);

            //Lo añadimos a la coleccion
            DBTrains dbtrain = new DBTrains(this);
            dbtrain.insertTrain(t);

            //cerrramos la base de datos
            dbtrain.close();
            Toast.makeText(this, "Training saved", Toast.LENGTH_LONG).show();
            //this.finish();



        }

    }

    public void verTrains (View view) {

        Intent intent = new Intent (this, FiltroRun.class);
        startActivity(intent);

    }


}*/
