package lk.ac.cmb.sci.edp.unitconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openConverter(View v){
        Intent i = new Intent(getApplication(), Converter.class);
        String type = v.getTag().toString();
        i.putExtra("type", type);
        startActivity(i);
    }

}
