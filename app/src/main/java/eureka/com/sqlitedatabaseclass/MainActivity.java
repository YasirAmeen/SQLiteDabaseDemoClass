package eureka.com.sqlitedatabaseclass;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    /*  SQLiteOpenHelper sqLiteOpenHelper;
        SQLiteDBHelper sqLiteDBHelper;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.my_btn);

        final SQLiteDatabase myDB = openOrCreateDatabase("user.db",MODE_PRIVATE,null);

        String CreateTablequery = "CREATE TABLE IF NOT EXISTS profile ( " +
                "PersonID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "LastName varchar(25)," +
                "FirstName varchar(25), " +
                "Address varchar(50), City varchar(25) " +
                ")";


        //Cursor curson = myDB.query("")
        myDB.execSQL(CreateTablequery);

/*

        sqLiteOpenHelper = new SQLiteDBHelper(this);
        final SQLiteDatabase sqdb = sqLiteOpenHelper.getReadableDatabase();


        final ContentValues values = new ContentValues();
        values.put(SQLiteDBHelper.COLUMN_FULLNAME,"Ehsana ilahi");
        values.put(SQLiteDBHelper.COLUMN_EMAIL,"ehsanilahi77@gmail.com");
        values.put(SQLiteDBHelper.COLUMN_PASSWORD,"abcd12345");
        values.put(SQLiteDBHelper.COLUMN_MOBILE,"03451234567");



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            long id = sqdb.insert(SQLiteDBHelper.TABLE_NAME,null,values);
                Toast.makeText(MainActivity.this, "data is stored at row " + id, Toast.LENGTH_SHORT).show();
            }
        });

*/



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Cursor resultSet = myDB.rawQuery("SELECT * FROM profile",null);
                resultSet.moveToFirst();

                String fetchedName = "";

                while (resultSet.moveToNext()) {
                    String name = resultSet.getString(1);

                    fetchedName = fetchedName +", "+ name;
                }
                Toast.makeText(MainActivity.this, ""+fetchedName, Toast.LENGTH_SHORT).show();

                //  myDB.execSQL("INSERT INTO profile (LastName, FirstName, Address, City) VALUES('Nazar','Adeel','Pakistan','Karachi')");

                //Toast.makeText(MainActivity.this, "data is stored at row " + id, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
