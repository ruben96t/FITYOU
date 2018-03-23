package local.com.tabs.Databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static local.com.tabs.Databases.ConstantesWeight.CAMPO_DAY;
import static local.com.tabs.Databases.ConstantesWeight.CAMPO_ID;
import static local.com.tabs.Databases.ConstantesWeight.CAMPO_MONTH;
import static local.com.tabs.Databases.ConstantesWeight.CAMPO_YEAR;
import static local.com.tabs.Databases.ConstantesWeight.DATABASE_NAME;
import static local.com.tabs.Databases.ConstantesWeight.DATABASE_VERSION;
import static local.com.tabs.Databases.ConstantesWeight.CAMPO_WEIGHT;
import static local.com.tabs.Databases.ConstantesWeight.WEIGHTS_TABLE;


/**
 * Created by user on 15/03/2018.
 */

public class DataBaseWeightsHelper extends SQLiteOpenHelper {




    private static final String CREATE_TABLE_WEIGHT =
            "CREATE TABLE " + WEIGHTS_TABLE +
                    " (" + CAMPO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    CAMPO_WEIGHT + " TEXT NOT NULL, " +
                    CAMPO_DAY  + " TEXT NOT NULL, " +
                    CAMPO_MONTH  + " TEXT NOT NULL, " +
                    CAMPO_YEAR  + " TEXT NOT NULL)";

    private static final String DELETE_TABLE_WEIGHT =
            "DROP TABLE IF EXIST " + WEIGHTS_TABLE;



    public DataBaseWeightsHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Invocamos al metodo createTable
        createTables(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //Eliminamos la tabla...
        deleteTables(db);
        //...y la volvemos a crear.
        createTables(db);
    }


    // TODO: Usamos un metodo para crear nuestra tabla.
    // Con el parametro "db" que es de tipo SQL que hemos creado arriba de tipo String.
    private void createTables(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_WEIGHT);

    }

    private void deleteTables(SQLiteDatabase db) {
        db.execSQL(DELETE_TABLE_WEIGHT);

    }
}