package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener
{
    String[] continents={"-Continent-","Africa","Asia","Europe","N. America", "Oceania","S. America"}; //N.=North    S.=South

    String[][] countries={{"-Country-","Angola","Botswana","Cameroon","Egypt","Eritrea","Liberia","Senegal","S. Africa"},
                          {"-Country-","India","Israel","Japan","Nepal","Philippines","Sri Lanka","S. Korea","Taiwan"},
                          {"-Country-","Albania","Belgium","Finland","France","Germany","Norway","Spain","United Kingdom"},
                          {"-Country-","Anguila","Bahamas","Belize","Canada","Cayman Islands","Greenland","St. Martin","United States"},
                          {"-Country-","Australia","Cook Islands","French Polynesia","Guam","New Caledonia","New Zealand","Niue","Samoa"},
                          {"-Country-","Argentina","Bolivia","Brazil","Chile","Falkland Islands","French Guiana","Peru","Uruguay"}};

    String[][] citiesAfrica={{"Luanda","N'dalatando","Lobito","Lubango","New Lisbon"},
                             {"Gaborone","Francistown","Maun","Lobatse","Selebi Phikwe"},
                             {"Yaounde","Douala","Bamenda","Bafoussam","Garoua"},
                             {"Cairo","Alexandria","Luxor","Aswan","Giza"},
                             {"Asmara","Mitsiwa","Barentu","Akordat","Adi Ugri"},
                             {"Monrovia","Gantu","Zwedru","Kakatu","Harper"},
                             {"Dakar","Ziguinchor","Kaolack","Saint Louis","Tambaccounada"},
                             {"Cape Town","Johannesburg","Durban","Pretoria","Port Elizabeth"}};

    String[][] populationsAfrica={{"2,571,861","168,832","393,079","776,246","713,134"},
                                  {"Gaborone","Francistown","Maun","Lobatse","Selebi Phikwe"},
                                  {"Yaounde","Douala","Bamenda","Bafoussam","Garoua"},
                                  {"Cairo","Alexandria","Luxor","Aswan","Giza"},
                                  {"Asmara","Mitsiwa","Barentu","Akordat","Adi Ugri"},
                                  {"Monrovia","Gantu","Zwedru","Kakatu","Harper"},
                                  {"Dakar","Ziguinchor","Kaolack","Saint Louis","Tambaccounada"},
                                  {"Cape Town","Johannesburg","Durban","Pretoria","Port Elizabeth"}};

    String[][] areasAfrica={{"116 km^2","1,030 km^2","989 km^2","3,147 km^2","2,711 km^2"},
                            {"Gaborone","Francistown","Maun","Lobatse","Selebi Phikwe"},
                            {"Yaounde","Douala","Bamenda","Bafoussam","Garoua"},
                            {"Cairo","Alexandria","Luxor","Aswan","Giza"},
                            {"Asmara","Mitsiwa","Barentu","Akordat","Adi Ugri"},
                            {"Monrovia","Gantu","Zwedru","Kakatu","Harper"},
                            {"Dakar","Ziguinchor","Kaolack","Saint Louis","Tambaccounada"},
                            {"Cape Town","Johannesburg","Durban","Pretoria","Port Elizabeth"}};

    Spinner continentsSpinner, countriesSpinner;
    ListView citiesListView;
    TextView populationTextView, areaTextView;

    int continent, country;
    ArrayAdapter<String> adp;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        continentsSpinner=(Spinner)findViewById(R.id.continentSpinner);
        countriesSpinner=(Spinner)findViewById(R.id.countriesSpinner);
        citiesListView=(ListView)findViewById(R.id.citiesListView);
        populationTextView=(TextView)findViewById(R.id.populationTextView);
        areaTextView=(TextView)findViewById(R.id.areaTextView);

        continentsSpinner.setOnItemSelectedListener(this);
        countriesSpinner.setOnItemSelectedListener(this);
        citiesListView.setOnItemClickListener(this);

        adp=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,continents);
        continentsSpinner.setAdapter(adp);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        populationTextView.setText("Population: "+populationsAfrica[country][position]);
        areaTextView.setText("Area: "+areasAfrica[country][position]);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        if (parent.getId()==continentsSpinner.getId())
        {
            if (position == 0) return;
            adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, countries[position - 1]);
            countriesSpinner.setAdapter(adp);
            continent=position-1;
        }
        else
        {
            if (position == 0) return;
            country=position-1;

            switch(continent)
            {
                case 0:
                    adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, citiesAfrica[position - 1]);
                    break;
            }
            citiesListView.setAdapter(adp);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }
}