package com.llorca.androidversion;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] names, andlevel, andversion, andreleased, anddescription;
    ListView list;
    int[] cLogo = {R.drawable.and1, R.drawable.and2,R.drawable.and3,R.drawable.and4, R.drawable.and5,R.drawable.and6,
            R.drawable.and7, R.drawable.and8, R.drawable.and9,R.drawable.and10,R.drawable.and11,
            R.drawable.and12, R.drawable.and13, R.drawable.and14, R.drawable.and15};

    ArrayList<Android> androidList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        names = getResources().getStringArray(R.array.androidnames);
        andlevel = getResources().getStringArray(R.array.level);
        andversion = getResources().getStringArray(R.array.version);
        andreleased = getResources().getStringArray(R.array.released);
        anddescription = getResources().getStringArray(R.array.description);

        list = findViewById(R.id.lvColleges);
        for(int i = 0; i < names.length; i++){
            androidList.add(new Android(cLogo[i], names[i], andlevel[i], andversion[i], andreleased[i], anddescription[i]));
        }
        list = findViewById(R.id.lvColleges);
        AndroidAdapter adapter = new AndroidAdapter(this, R.layout.items ,androidList);
        list.setAdapter(adapter);
        // list.position
        list.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        // Toast.makeText(this, names[i], Toast.LENGTH_LONG).show();

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle(androidList.get(i).getName());
        dialog.setIcon(androidList.get(i).getLogo());
        dialog.setMessage(androidList.get(i).getDescription());
        dialog.setNeutralButton("CLOSE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick (DialogInterface dialog,int which){
                dialog.dismiss();
            }
        });
        dialog.create().show();

    }
}
