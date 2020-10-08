package assignments.example.depthoffieldcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

        Intent intent = getIntent();

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

                Intent saveIntent = new Intent();
                saveIntent.putExtra("Lens", user_make);

                try {
                    int focLength = Integer.parseInt(user_focLength);
                    double aperture = Double.parseDouble(user_aperture);

                    saveIntent.putExtra("Focal Length", focLength);
                    saveIntent.putExtra("Aperture", aperture);
                    setResult(RESULT_OK, saveIntent);
                } catch (NumberFormatException e) {  // throws exception when user didn't put a number
                    Toast.makeText(AddLensActivity.this,
                            "Please enter numbers",
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
}