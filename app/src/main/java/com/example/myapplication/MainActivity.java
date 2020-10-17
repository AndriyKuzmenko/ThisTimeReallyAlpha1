package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener
{
    String[] continents={"-Continent-","Africa","Asia","Europe","N. America", "Oceania","S. America"}; //N.=North    S.=South

    String[][] countries={{"-Country-","Angola","Botswana","Cameroon","Egypt","Eritrea","Liberia","Senegal","S. Africa"},
                          {"-Country-","India","Israel","Japan","Nepal","Philippines","Sri Lanka","S. Korea","Taiwan"},
                          {"-Country-","Albania","Belgium","Finland","France","Germany","Norway","Spain","United Kingdom"},
                          {"-Country-","Anguila","Bahamas","Belize","Canada","Cayman Islands","Greenland","St. Martin","United States"},
                          {"-Country-","Australia","Cook Islands","French Polynesia","Guam","New Caledonia","New Zealand","Niue","Samoa"},
                          {"-Country-","Argentina","Bolivia","Brazil","Chile","Falkland Islands","French Guiana","Peru","Uruguay"}};

    Spinner continentsSpinner, countriesSpinner;
    int continent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        continentsSpinner=(Spinner)findViewById(R.id.continentSpinner);
        countriesSpinner=(Spinner)findViewById(R.id.countriesSpinner);

        continentsSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<String> adp=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,continents);
        continentsSpinner.setAdapter(adp);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        if (parent.getId()==continentsSpinner.getId())
        {
            if (position == 0) return;
            ArrayAdapter<String> adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, countries[position - 1]);
            countriesSpinner.setAdapter(adp);
            continent=position-1;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }
}
