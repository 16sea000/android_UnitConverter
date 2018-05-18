package lk.ac.cmb.sci.edp.unitconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Converter extends AppCompatActivity {

    TextView lbl_first;
    TextView lbl_second;
    String str_first;
    String str_second;
    EditText et_first;
    EditText et_second;
    Double mul_first;
    Double mul_second;
    NumberFormat nf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        lbl_first = (TextView)findViewById(R.id.lbl_first);
        lbl_second = (TextView)findViewById(R.id.lbl_second);
        et_first = (EditText) findViewById(R.id.et_first);
        et_second = (EditText) findViewById(R.id.et_second);
        nf = new DecimalFormat("##.##############");

        String extra = getIntent().getStringExtra("type");
        if(extra.equals("cm_km")){

            Converter.this.setTitle("CM <-> KM Convector");

            str_first = "CM";
            str_second = "KM";
            mul_first = 0.00001;
            mul_second = 100000.0;
        }else if(extra.equals("mg_kg")){

            Converter.this.setTitle("MG <-> KG Convector");

            str_first = "MG";
            str_second = "KG";
             mul_first = 0.000001;
             mul_second = 1000000.0;
        }if(extra.equals("m_in")){

            Converter.this.setTitle("M <-> IN Convector");

            str_first = "M";
            str_second = "IN";
             mul_first = 39.3701;
            mul_second = 0.0254;
        }

        lbl_first.setText(str_first);
        lbl_second.setText(str_second);

        et_first.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {

                String val_string = s.toString();
                if(et_first.hasFocus() && val_string.length() != 0){
                    Converter.this.setTitle(str_first + " to "+ str_second +" Mode");
                    Double val = Double.parseDouble(val_string);
                    if(!val.equals(0.00)){
                        val *= mul_first;
                    }
                    et_second.setText(nf.format(val));
                }
            }
        });

        et_second.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {

                String val_string = s.toString();
                if(et_second.hasFocus() && val_string.length() != 0){
                    Converter.this.setTitle(str_second + " to "+ str_first +" Mode");
                    Double val = Double.parseDouble(val_string);
                    if(!val.equals(0.00)){
                        val *= mul_second;
                    }
                    et_first.setText(nf.format(val));
                }

            }
        });

    }
}
