package assignments.example.depthoffieldcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class CalcDoFActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_do_f);
        setTitle("Calculate DoF");   // Changes the title


    }

    public static Intent makeIntent (Context context) {
        return new Intent (context, AddLensActivity.class);
    }
}