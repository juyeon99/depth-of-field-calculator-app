package assignments.example.depthoffieldcalculator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import assignments.example.depthoffieldcalculator.model.DoFCalculator;
import assignments.example.depthoffieldcalculator.model.Lens;
import assignments.example.depthoffieldcalculator.model.LensManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Code found at https://www.youtube.com/watch?v=SaXYFHYGLj4
//               https://www.youtube.com/watch?v=B1oaE0Odqes&feature=youtu.be
//               https://www.youtube.com/watch?v=eAPFgC9URqc
//               https://www.youtube.com/watch?v=aE5f1tV5nU4&feature=youtu.be
//               https://www.youtube.com/watch?v=q_gujMR2ggE&feature=youtu.be
//               https://www.youtube.com/watch?v=PRJlo1Wut0w
//               https://www.youtube.com/watch?v=evkPjPIV6cw&feature=youtu.be
//               https://www.youtube.com/watch?v=4E6DnInJLhs&feature=youtu.be
//               https://www.youtube.com/watch?v=cBDvTQHvQHw&feature=youtu.be
//               https://www.youtube.com/watch?v=B1oaE0Odqes&feature=youtu.be
//               https://www.youtube.com/watch?v=9OYNH067Xa0&feature=youtu.be
//         from Dr Brian Fraser's youtube channel

// Code found at https://www.youtube.com/watch?v=AD5qt7xoUU8&feature=share
//         from Coding in Flow

public class MainActivity extends AppCompatActivity {
    private Lens lens;
    private DoFCalculator DoF;
    private LensManager manager;
    private List<Lens> lenses = new ArrayList<>();

    private static final String EXTRA_MAKE = "make";
    private static final String EXTRA_FOC_LENGTH = "focal distance";
    private static final String EXTRA_APERTURE = "aperture";

    private String make;
    private int focLength = 0;
    private double aperture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Adding lens
                // Launch the AddLensActivity

                Intent intent = AddLensActivity.makeIntent(MainActivity.this);
                //Intent intent = new Intent(MainActivity.this, AddLensActivity.class);
                startActivityForResult(intent,42);
            }
        });
        addLens();
        populateListView();
        extractDataFromIntent();
        registerClickCallback();
    }


    // Adds the basic lenses to the list
    public void addLens() {
        lenses.add(new Lens("Canon", 1.8, 50));
        lenses.add(new Lens("Tamron", 2.8, 90));
        lenses.add(new Lens("Sigma", 2.8, 200));
        lenses.add(new Lens("Nikon", 4, 200));
    }

     // Populates the list of the lenses
    private void populateListView() {
        // Empty State
        if (lenses.size() == 0) {
            TextView select = findViewById(R.id.select);
            select.setText("No lenses to show. You can add lens pressing the red+ button on the bottom");
        }
        else {
            ArrayList<String> arrayList = new ArrayList<>();

            for (int i = 0; i < lenses.size(); i++) {
                Lens l = lenses.get(i);
                arrayList.add(l.getDescription());
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    this,
                    R.layout.listview,
                    arrayList);
            ListView list = (ListView) findViewById(R.id.listView);
            list.setAdapter(adapter);
        }
    }

    private void registerClickCallback() {
        ListView list = (ListView) findViewById(R.id.listView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView textView = (TextView) viewClicked;
                String message = "You selected:  " + textView.getText().toString();
                Toast.makeText(MainActivity. this,message, Toast.LENGTH_LONG).show();

                Intent clickIntent = CalcDoFActivity.makeIntent(MainActivity.this,
                        lenses.get(position).getMake(),
                        lenses.get(position).getFocalLengthInMM(),
                        lenses.get(position).getMaxAperture(),
                        lenses.get(position).getDescription());
                startActivity(clickIntent);
            }
        });
    }

    public static Intent makeIntent(Context context, String make, int focLength, double aperture) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(EXTRA_MAKE, make);
        intent.putExtra(EXTRA_FOC_LENGTH, focLength);
        intent.putExtra(EXTRA_APERTURE, aperture);
        return intent;
    }

    private void extractDataFromIntent() {
        Intent intent = getIntent();
        make = intent.getStringExtra(EXTRA_MAKE);
        focLength = intent.getIntExtra(EXTRA_FOC_LENGTH, 0);
        aperture = intent.getDoubleExtra(EXTRA_APERTURE, 0);
        if (focLength != 0) {
            lenses.add(new Lens(make, aperture, focLength));
            populateListView();
        }
    }




//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == 42) {
//            if (resultCode == RESULT_OK) {
//                Intent intent = getIntent();
//                make = intent.getStringExtra(EXTRA_MAKE);
//                focLength = intent.getIntExtra(EXTRA_FOC_LENGTH, 0);
//                aperture = intent.getDoubleExtra(EXTRA_APERTURE, 0);
////                assert data != null;
////                String make = data.getStringExtra("Make");
////                int focLength = data.getIntExtra("Focal Length", 0);
////                double aperture = data.getDoubleExtra("Aperture", 0);
//                lenses.add(new Lens(make, aperture, focLength));
//                populateListView();
//            }
//            if (resultCode == RESULT_CANCELED) {
//                populateListView();
//            }
//        }
//    }
}