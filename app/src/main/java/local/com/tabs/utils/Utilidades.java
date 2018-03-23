package local.com.tabs.utils;

import android.app.DatePickerDialog;
import android.content.Context;
import android.util.Log;
import android.widget.DatePicker;

import java.util.Calendar;

import local.com.tabs.models.Fecha;


/**
 * Created by user on 15/03/2018.
*/
public class Utilidades {

    Fecha fecha;

    public Fecha fecha (Context context){

        final Calendar calendar = Calendar.getInstance();
        int yearC = calendar.get(Calendar.YEAR);
        int monthC = calendar.get(Calendar.MONTH);
        int dayC = calendar.get(Calendar.DAY_OF_MONTH);



        new DatePickerDialog(
                context,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        //la fecha seleccionada la
                        //guardamos en la variable
                        /*fecha = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;*/

                        fecha = new Fecha(dayOfMonth, monthOfYear, year);
                        Log.d("TAG","" + dayOfMonth );
                    }
                },
                yearC,
                monthC,
                dayC).show();

        return fecha;
    }
}

