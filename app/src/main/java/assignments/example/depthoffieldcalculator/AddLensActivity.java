package assignments.example.depthoffieldcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

// Code found at [https://www.youtube.com/watch?v=NSM3DbgJ0tw]

public class AddLensActivity extends AppCompatActivity {

    EditText exMake;
    EditText exFocLength;
    EditText exAperture;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lens);
        setTitle("Lens Details");   // Changes the title

        exMake = (EditText) findViewById(R.id.exMake);
        exFocLength = (EditText) findViewById(R.id.exFocLength);
        exAperture = (EditText) findViewById(R.id.exAperture);

        Button btnSave = (Button) findViewById(R.id.save);
        Button btnCancel = (Button) findViewById(R.id.cancel);

        // Code found at [https://www.youtube.com/watch?v=AD5qt7xoUU8&feature=share]
        //               [https://codechacha.com/ko/java-throw-and-throws/]
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_make = exMake.getText().toString();
                String user_focLength = exFocLength.getText().toString();
                String user_aperture = exAperture.getText().toString();

                try {
                    int focLength = Integer.parseInt(user_focLength);
                    double aperture = Double.parseDouble(user_aperture);

                    // Enforcing the constraints on user input
                    if ((focLength > 0) && (aperture >= 1.4) && (user_make.length() > 0)) {
                        Intent saveIntent = MainActivity.makeIntent(AddLensActivity.this,
                                user_make, focLength, aperture);
                        startActivity(saveIntent);
                    }
                    else {
                        Toast.makeText(AddLensActivity.this,
                                "You should enter non-negative number for focal length and aperture.",
                                Toast.LENGTH_SHORT).show();
                        finish();
                    }
                } catch (NumberFormatException e) {  // throws exception when user didn't put a number
                    Toast.makeText(AddLensActivity.this,
                            "Invalid text. You should enter number for focal length and aperture.",
                            Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public static Intent makeIntent (Context context) {
        return new Intent (context, AddLensActivity.class);
    }
}