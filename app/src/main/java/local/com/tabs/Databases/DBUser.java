package local.com.tabs.Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by user on 15/03/2018.
 */

public class DBUser {
    //Atributos
    private SQLiteDatabase db = null;
    //Decalramos e instanciamos nuestra calse anteriormente creada.
    private DataBaseUserHelper dbhelper = null;
    //Contexto
    Context context;

    // TODO: Constructor de nuestra clase para instanciar la clase database contactos y usar los metodos para escribir en nuestra base de datos
    public DBUser(Context contexto) {
        this.context = contexto;
        //crea una instancia del helper
        dbhelper = new DataBaseUserHelper(context);
        //crea un objeto SQLiteDatabase para operar
        //contra la base de datos
        db = dbhelper.getWritableDatabase();
    }

    //TODO: Cerramos la base de datos.
    public void close() {
        dbhelper.close();
    }

    //TODO: Usamos un objeto de tipo ContentValues para guardar las keys de cada campo de nuestrio entrenamiento e instertarlo en la tabla de base de datos.
    public long insertUser(User u ){
        ContentValues initialValues=new ContentValues();
        initialValues.put("name", u.getName());
        initialValues.put("age", u.getAge());
        initialValues.put("height", u.getHeight());
        initialValues.put("sex", u.getSex());
        initialValues.put("targetweight", u.getTargetweight());

        // hacemos referencia a la tabla mediante nuestra constante.
        //Inserta el contacto en la base de datos.
        return db.insert(ConstantesUser.USER_TABLE, null, initialValues);
    }
    public Cursor getUserData () {

        //Todo el return es un Cursor. Objeto que tiene data
        return db.query("" + ConstantesUser.USER_TABLE + "",
                new String[]{ConstantesUser.CAMPO_ID,
                        ConstantesUser.CAMPO_NAME,
                        ConstantesUser.CAMPO_AGE,
                        ConstantesUser.CAMPO_HEIGHT,
                        ConstantesUser.CAMPO_SEX,
                        ConstantesUser.CAMPO_TARGETWEIGHT},

                null, null, null, null, null);
    }


}