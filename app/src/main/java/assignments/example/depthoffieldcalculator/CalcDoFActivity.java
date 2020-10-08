package assignments.example.depthoffieldcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import assignments.example.depthoffieldcalculator.model.DoFCalculator;
import assignments.example.depthoffieldcalculator.model.Lens;

public class CalcDoFActivity extends AppCompatActivity {
    private String make;
    private int focLength;
    private double aperture;
    private String detail;

    private DoFCalculator DoF;

    EditText user_aperture;
    EditText user_dist;
    EditText user_coc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_do_f);
        setTitle("Calculate DoF");   // Changes the title

        displayLensDetail();

        user_aperture = (EditText) findViewById(R.id.user_aperture);
//        user_dist = (EditText) findViewById(R.id.user_dist);
//        user_coc = (EditText) findViewById(R.id.user_coc);

        Button btnCalc = (Button) findViewById(R.id.btnCalculate);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_aper = user_aperture.getText().toString();
                double selectedAperture = Double.parseDouble(user_aper);
                if (selectedAperture >= 1.4) {
//                    DoF.getDepthOfFieldInM();
//                    DoF.getNearFocalPointInM();
                    TextView nearFocDist = (TextView) findViewById(R.id.calc_nfd);
                    //nearFocDist.setText();
                }
            }
        });
    }



    public static Intent makeIntent(Context context, String make, int focLength, double aperture, String detail) {
        Intent intent = new Intent(context, CalcDoFActivity.class);
        intent.putExtra("Make", make);
        intent.putExtra("Focal Length", focLength);
        intent.putExtra("Aperture", aperture);
        intent.putExtra("Detail", detail);
        return intent;
    }

    private void displayLensDetail() {  // Details are extracted by intent
        Intent intent = getIntent();
        make = intent.getStringExtra("make");
        focLength = intent.getIntExtra("Focal Length", 0);
        aperture = intent.getDoubleExtra("Aperture", 0);
        detail = intent.getStringExtra("Detail");
        TextView lensDetail = (TextView) findViewById(R.id.lens_details);
        lensDetail.setText(detail);
    }
}