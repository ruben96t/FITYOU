package local.com.tabs.Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by user on 15/03/2018.
 */

public class DBTrains {
    //Atributos
    private SQLiteDatabase db = null;
    //Decalramos e instanciamos nuestra calse anteriormente creada.
    private DataBaseTrainsHelper dbhelper = null;
    //Contexto
    Context context;

    // TODO: Constructor de nuestra clase para instanciar la clase database contactos y usar los metodos para escribir en nuestra base de datos
    public DBTrains (Context contexto) {
        this.context = contexto;
        //crea una instancia del helper
        dbhelper = new DataBaseTrainsHelper(context);
        //crea un objeto SQLiteDatabase para operar
        //contra la base de datos
        db = dbhelper.getWritableDatabase();
    }

    //TODO: Cerramos la base de datos.
    public void close() {
        dbhelper.close();
    }

    //TODO: Usamos un objeto de tipo ContentValues para guardar las keys de cada campo de nuestrio entrenamiento e instertarlo en la tabla de base de datos.
    public long insertTrain(Train t ){
        ContentValues initialValues=new ContentValues();
        initialValues.put("training", t.getTraining());
        initialValues.put("time", t.getTime());
        initialValues.put("dist", t.getDist());
        initialValues.put("day", t.getDay());
        initialValues.put("month", t.getMonth());
        initialValues.put("year", t.getYear());

        // hacemos referencia a la tabla mediante nuestra constante.
        //Inserta el contacto en la base de datos.
        return db.insert(ConstantesTrains.TRAINS_TABLE, null, initialValues);
    }
    public Cursor getAll () {

        //Todo el return es un Cursor. Objeto que tiene data
        return db.query("" + ConstantesTrains.TRAINS_TABLE + "",
                new String[]{ConstantesTrains.CAMPO_ID,
                        ConstantesTrains.CAMPO_TRAIN,
                        ConstantesTrains.CAMPO_TIME,
                        ConstantesTrains.CAMPO_DIST,
                        ConstantesTrains.CAMPO_DAY,
                        ConstantesTrains.CAMPO_MONTH,
                        ConstantesTrains.CAMPO_YEAR},
                null, null, null, null, null);
    }

    public Cursor getTrains(String training) {
        //Cursor c=null;
        //Cursor c=db.query("Contactos",new String[]{"Id","Nombre","Email","Edad"},"Email=?", new String[]{email}, null,null,null);

        //Creamos un cursor para guardar una query de la seleccion y un criterio para el campo training =?
        Cursor c = db.query("" + ConstantesTrains.TRAINS_TABLE + "",
                new String[]{ConstantesTrains.CAMPO_ID,
                        ConstantesTrains.CAMPO_TRAIN,
                        ConstantesTrains.CAMPO_TIME,
                        ConstantesTrains.CAMPO_DIST,
                        ConstantesTrains.CAMPO_DAY,
                        ConstantesTrains.CAMPO_MONTH,
                        ConstantesTrains.CAMPO_YEAR},
                "Training=?",
                new String[]{training}, null, null, null);
        //Cone este IF sólo se sucede en TRUE si la "query" lanzada a la base de datos consigue una coinciedencia en el mail.
        //De esa manera creara un contacto recuperando los datos del contacto encontrado.
        return c;

    }
}