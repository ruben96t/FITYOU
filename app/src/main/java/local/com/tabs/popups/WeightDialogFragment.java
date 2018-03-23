package local.com.tabs.popups;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import local.com.tabs.Databases.DBTrains;
import local.com.tabs.Databases.DBWeights;
import local.com.tabs.Databases.Train;
import local.com.tabs.Databases.Weight;
import local.com.tabs.R;

/**
 * Created by user on 19/03/2018.
 */

public class WeightDialogFragment  extends DialogFragment implements View.OnClickListener {

    TextView textViewFecha;
    EditText editTextWeight;
    EditText editTextTarget;
    Button btnSetDate;
    String fecha;
    String auxweight;
    String target;
    final Calendar c = Calendar.getInstance();
    int mYear = c.get(Calendar.YEAR);
    int mMonth = c.get(Calendar.MONTH);
    int mDay = c.get(Calendar.DAY_OF_MONTH);

    float weight;
    int dayaux;
    int monthaux;
    int yearaux;

    int dayOfMonthaux;
    int monthOfYearaux;
    int yearOfYearaux;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.pop_activity_add_peso, null);

        editTextWeight = view.findViewById(R.id.editTextCWeight);
        textViewFecha = view.findViewById(R.id.textViewWFecha);
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
        textViewFecha.setText("Today: " + fecha);

        Dialog dialog = builder.create();


        return dialog;


    }

    private void getValorBoton(int id) {
        switch (id) {
            case -1:
                //Log.d("TAG", "Valor Id Ok: " + weight + " " + fecha);
                String auxweight = editTextWeight.getText().toString();
                //target = editTextTarget.getText().toString();


                if ((auxweight.equals(""))) {

                    Toast.makeText(getActivity(), "Insert weight", Toast.LENGTH_LONG).show();


                } else {

                    weight = Float.parseFloat(auxweight);
                    dayaux = dayOfMonthaux;
                    monthaux = (monthOfYearaux + 1);
                    yearaux = yearOfYearaux;

                    Weight w = new Weight(weight, dayaux, monthaux, yearaux);

                    //Lo añadimos a la coleccion
                    DBWeights dbweight = new DBWeights(getActivity());
                    dbweight.insertWeight(w);

                    //cerrramos la base de datos
                    dbweight.close();
                    Toast.makeText(getActivity(), "Weight saved", Toast.LENGTH_LONG).show();
                    //this.finish();

                }
                break;
            case -2:
                Log.d("TAG", "Valor Id Cancel: " + id);
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonIDate:
                new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        //la fecha seleccionada la
                        //guardamos en la variable
                        fecha = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                        textViewFecha.setText("Weighing day: " + fecha);

                        dayOfMonthaux = dayOfMonth;
                        monthOfYearaux = monthOfYear;
                        yearOfYearaux = year;
                    }
                },
                        mYear,
                        mMonth,
                        mDay)
                        .show();
                Toast.makeText(getActivity(), "Hello user", Toast.LENGTH_SHORT).show();

                break;
        }
    }
}