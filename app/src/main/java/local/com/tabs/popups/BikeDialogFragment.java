package local.com.tabs.popups;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import local.com.tabs.Databases.DBTrains;
import local.com.tabs.Databases.Train;
import local.com.tabs.R;

/**
 * Created by user on 19/03/2018.
 */

public class BikeDialogFragment extends DialogFragment  implements View.OnClickListener{

    TextView textViewFecha;
    EditText editTextBikeT;
    EditText editTextBikeD;
    Button btnSetDate;
    String fecha;
    String runT;
    String runD;
    final Calendar c = Calendar.getInstance();
    int mYear = c.get(Calendar.YEAR);
    int mMonth = c.get(Calendar.MONTH);
    int mDay = c.get(Calendar.DAY_OF_MONTH);

    int time;
    int dist;
    int dayaux;
    int monthaux;
    int yearaux;

    int dayOfMonthaux;
    int monthOfYearaux;
    int yearOfYearaux;





    public BikeDialogFragment() {
        // Required
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.pop_activity_add_bike, null);

        editTextBikeT =  view.findViewById(R.id.editTextBT);
        editTextBikeD = view.findViewById(R.id.editTextBD);
        textViewFecha =  view.findViewById(R.id.textViewBFecha);
        btnSetDate = view.findViewById(R.id.buttonIDate);
        btnSetDate.setOnClickListener(this);

        setCancelable(false);

        builder.setView(view)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        getValorBoton(id);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //LoginDialogFragment.this.getDialog().cancel();
                        getValorBoton(id);
                    }

                });

        fecha = mDay + "/" + (mMonth + 1) + "/" + mYear;
        textViewFecha.setText("Today: " + mDay + "/" + (mMonth + 1) + "/" + mYear);

        Dialog dialog = builder.create();

        return dialog;


    }

    /**
     * Metodo para obtener el valor de un boton (DialogFragment)
     *
     * @param id
     */
    private void getValorBoton(int id) {
        switch (id) {
            case -1:
                String train = "Bike";
                String auxtime = editTextBikeT.getText().toString();
                String auxdist = editTextBikeD.getText().toString();

                if ((auxtime.equals("")) || (auxdist.equals(""))) {

                    Toast.makeText(getActivity(), "Complete all fields", Toast.LENGTH_LONG).show();


                } else {

                    //edad = Integer.parseInt(((EditText)this.findViewById(R.id.editTextEdad)).getText().toString());
                    time = Integer.parseInt(auxtime);
                    dist = Integer.parseInt(auxdist);
                    dayaux = dayOfMonthaux;
                    monthaux = (monthOfYearaux + 1);
                    yearaux = yearOfYearaux;

                    Train t = new Train(train, time, dist, dayaux, monthaux, yearaux);

                    //Lo añadimos a la coleccion
                    DBTrains dbtrain = new DBTrains(getActivity());
                    dbtrain.insertTrain(t);

                    //cerrramos la base de datos
                    dbtrain.close();
                    Toast.makeText(getActivity(), "Training saved", Toast.LENGTH_LONG).show();
                    //this.finish();



                }
                // Log.d("TAG", "Running: " + runT + " " + runD + " " + fecha);
                break;
            case -2:
                //Log.d("TAG", "Valor Id Cancel: " + id);
                break;
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonIDate:
                new DatePickerDialog(
                        getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                //la fecha seleccionada la
                                //guardamos en la variable
                                fecha = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                                textViewFecha.setText("Runnig day: " + fecha);

                                dayOfMonthaux = dayOfMonth;
                                monthOfYearaux = monthOfYear;
                                yearOfYearaux = year;
                            }
                        },
                        mYear,
                        mMonth,
                        mDay)
                        .show();
                //Toast.makeText(getActivity(), "Hello user", Toast.LENGTH_SHORT).show();


                break;
        }
    }
}
