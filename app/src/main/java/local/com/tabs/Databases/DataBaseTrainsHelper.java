package local.com.tabs.Databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static local.com.tabs.Databases.ConstantesTrains.CAMPO_DAY;
import static local.com.tabs.Databases.ConstantesTrains.CAMPO_DIST;
import static local.com.tabs.Databases.ConstantesTrains.CAMPO_ID;
import static local.com.tabs.Databases.ConstantesTrains.CAMPO_MONTH;
import static local.com.tabs.Databases.ConstantesTrains.CAMPO_TIME;
import static local.com.tabs.Databases.ConstantesTrains.CAMPO_TRAIN;
import static local.com.tabs.Databases.ConstantesTrains.CAMPO_YEAR;
import static local.com.tabs.Databases.ConstantesTrains.DATABASE_NAME;
import static local.com.tabs.Databases.ConstantesTrains.DATABASE_VERSION;
import static local.com.tabs.Databases.ConstantesTrains.TRAINS_TABLE;

/**
 * Created by user on 15/03/2018.
 */

public class DataBaseTrainsHelper extends SQLiteOpenHelper {




    private static final String CREATE_TABLE_TRAIN =
            "CREATE TABLE " + TRAINS_TABLE +
                    " (" + CAMPO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    CAMPO_TRAIN + " TEXT NOT NULL, " +
                    CAMPO_TIME + " TEXT NOT NULL, " +
                    CAMPO_DIST  + " TEXT NOT NULL, " +
                    CAMPO_DAY  + " TEXT NOT NULL, " +
                    CAMPO_MONTH  + " TEXT NOT NULL, " +
                    CAMPO_YEAR  + " TEXT NOT NULL)";

    private static final String DELETE_TABLE_TRAIN =
            "DROP TABLE IF EXIST " + TRAINS_TABLE;



    public DataBaseTrainsHelper(Context context) {
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
        db.execSQL(CREATE_TABLE_TRAIN);

    }

    private void deleteTables(SQLiteDatabase db) {
        db.execSQL(DELETE_TABLE_TRAIN);

    }
}


