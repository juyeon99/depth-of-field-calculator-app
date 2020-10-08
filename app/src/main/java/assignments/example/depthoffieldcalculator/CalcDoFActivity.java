package assignments.example.depthoffieldcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CalcDoFActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_do_f);
        setTitle("Calculate DoF");   // Changes the title

        Intent intent = getIntent();
        final String make = intent.getStringExtra("make");
        final int focLength = intent.getIntExtra("Focal Length", 0);
        final double aperture = intent.getDoubleExtra("Aperture", 0);
        TextView lensDetail = (TextView) findViewById(R.id.lens_details);
        lensDetail.setText(make + " " + focLength + "mm F" + aperture);

    }

    public static Intent makeIntent (Context context) {
        return new Intent (context, CalcDoFActivity.class);
    }
}