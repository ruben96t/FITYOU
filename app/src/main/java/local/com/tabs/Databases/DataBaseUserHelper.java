package local.com.tabs.Databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static local.com.tabs.Databases.ConstantesUser.CAMPO_AGE;
import static local.com.tabs.Databases.ConstantesUser.CAMPO_HEIGHT;
import static local.com.tabs.Databases.ConstantesUser.CAMPO_ID;
import static local.com.tabs.Databases.ConstantesUser.CAMPO_NAME;
import static local.com.tabs.Databases.ConstantesUser.CAMPO_SEX;
import static local.com.tabs.Databases.ConstantesUser.CAMPO_TARGETWEIGHT;
import static local.com.tabs.Databases.ConstantesUser.DATABASE_NAME;
import static local.com.tabs.Databases.ConstantesUser.DATABASE_VERSION;
import static local.com.tabs.Databases.ConstantesUser.USER_TABLE;

/**
 * Created by user on 15/03/2018.
 */

public class DataBaseUserHelper extends SQLiteOpenHelper {




    private static final String CREATE_TABLE_USER =
            "CREATE TABLE " + USER_TABLE +
                    " (" + CAMPO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    CAMPO_NAME + " TEXT NOT NULL, " +
                    CAMPO_AGE + " TEXT NOT NULL, " +
                    CAMPO_HEIGHT  + " TEXT NOT NULL, " +
                    CAMPO_SEX  + " TEXT NOT NULL, " +
                    CAMPO_TARGETWEIGHT  + " TEXT NOT NULL)";

    private static final String DELETE_TABLE_USER =
            "DROP TABLE IF EXIST " + USER_TABLE;



    public DataBaseUserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //deleteTables(db);
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
        db.execSQL(CREATE_TABLE_USER);

    }

    private void deleteTables(SQLiteDatabase db) {
        db.execSQL(DELETE_TABLE_USER);

    }
}


