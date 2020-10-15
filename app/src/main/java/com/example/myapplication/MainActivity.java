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

    String[][] countries={{"Angola","Botswana","Cameroon","Egypt","Eritrea","Liberia","Senegal","S. Africa"},
                          {"India","Israel","Japan","Nepal","Philippines","Sri Lanka","S. Korea","Taiwan"},
                          {"Albania","Belgium","Finland","France","Germany","Norway","Spain","United Kingdom"},
                          {"Anguila","Bahamas","Belize","Canada","Cayman Islands","Greenland","St. Martin","United States"},
                          {"Australia","Cook Islands","French Polynesia","Guam","New Caledonia","New Zealand","Niue","Samoa"},
                          {"Argentina","Bolivia","Brazil","Chile","Falkland Islands","French Guiana","Peru","Uruguay"}};

    Spinner continentsSpinner, countriesSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        continentsSpinner=(Spinner)findViewById(R.id.continentSpinner);

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

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }
}
