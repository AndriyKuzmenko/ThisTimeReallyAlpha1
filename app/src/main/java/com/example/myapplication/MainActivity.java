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

    String[][] countries={{"-Country-","Angola","Benin","Congo","Egypt","Ethiopia","Reunion","Senegal","S. Africa"},
                          {"-Country-","India","Israel","Japan","Nepal","Philippines","Sri Lanka","S. Korea","Taiwan"},
                          {"-Country-","Albania","Belgium","Finland","France","Germany","Norway","Spain","United Kingdom"},
                          {"-Country-","Trinidad and Tobago","El Salvador","Belize","Canada","Panama","Mexico","Honduras","United States"},
                          {"-Country-","Australia","Cook Islands","French Polynesia","Guam","New Caledonia","New Zealand","Niue","Samoa"},
                          {"-Country-","Argentina","Bolivia","Brazil","Chile","Falkland Islands","French Guiana","Peru","Uruguay"}};

    //Africa

    String[][] citiesAfrica={{"Luanda","N'dalatando","Lobito","Lubango","New Lisbon"},
                             {"Cotonou","Porto Novo","Parakou","Djougou","Bohican"},
                             {"Kinshasa","Lubumbashi","Kananga","Kolwezi","Mbuji-Mayi"},
                             {"Cairo","Alexandria","Luxor","El Mahmoudiyah","Giza"},
                             {"Addis Ababa","Dire Dawa","Bahir Dar","Hawassa","Dessie"},
                             {"Le Port","Le Tampon","St. Joseph","La Possession","Sainte-Marie"},
                             {"Dakar","Ziguinchor","Kaolack","Saint Louis","Tambaccounada"},
                             {"Cape Town","Johannesburg","Durban","Pretoria","Port Elizabeth"}};

    String[][] populationsAfrica={{"2,401,067","168,832","393,079","776,246","713,134"},
                                  {"231,626","264,320","206,667","237,040","149,271"},
                                  {"14,340,000","1,794,000","1,272,000","572,942","3,368,000"},
                                  {"9,908,788","5,200,000","506,588","24,300","8,800,000"},
                                  {"4,800,000","440,000","750,991","315,267","610,431"},
                                  {"34,128","78,629","37,644","33,020","32,940"},
                                  {"11,146,053","205,294","233,708","176,000","78,800"},
                                  {"3,740,026","5,635,127","3,720,953","2,472,612","967,677"}};

    String[][] areasAfrica={{"116 km^2","110 km^2","989 km^2","3,147 km^2","2,711 km^2"},
                            {"79 km^2","110 km^2","441 km^2","3,966 km^2","44 km^2"},
                            {"9,965 km^2","210 km^2","742.8 km^2","213 km^2","135.1 km^2"},
                            {"3,085.12 km^2","2,679 km^2","416 km^2","1,230","1,579.75 km^2"},
                            {"225.7 km^2","1,213 km^2","28 km^2","50 km^2","15.08 km^2"},
                            {"16.62 km^2","165.4 km^2","178.5 km^2","118.35 km^2","87.21 km^2"},
                            {"83 km^2","9 km^2","5,357 km^2","19,241 km^2","42,364 km^2"},
                            {"2,461 km^2","1,644.98 km^2","225.91 km^2","687.54 km^2","251.03 km^2"}};

    //Asia

    String[][] citiesAsia={{"Bombay","Bengaluru","Chennai","Kolkata","Hyderabad"},
                           {"Jerusalem","Tel Aviv","Haifa","Netnanya","Be'er Sheva"},
                           {"Tokyo","Osaka","Kyoto","Sapporo","Nagoya"},
                           {"Kathmandu","Pokhara","Lalitpur","Bhaktapur","Biratnagar"},
                           {"Manila","Quezon","Cebu City","Makati","Baguio"},
                           {"Colombo","Galle","Kandy","Jaffna","Trincomalee"},
                           {"Seoul","Busan","Incheon","Daegu","Ulsan"},
                           {"Taipei","Kaohsiung City","Tainan","Taichung","Keelung City"}};

    String[][] populationsAsia={{"18,410,000","8,426,000","7,088,000","14,850,000","6,810,000"},
                                {"874,186","435,856","279,249","209,390","204,707"},
                                {"9,273,000","2,691,000","1,475,000","1,952,000","2,296,000"},
                                {"1,003,000","264,991","226,728","81,728","204,949"},
                                {"1,780,000","2,936,000","922,611","582,602","345,366"},
                                {"752,993","93,118","125,400","88,138","99,135"},
                                {"9,776,053","3,429,000","2,923,400","2,465,000","1,166,000"},
                                {"2,646,000","2,773,000","1,881,000","2,817,000","371,878"}};

    String[][] areasAsia={{"603.4 km^2","709 km^2","463 km^2","206.1 km^2","625 km^2"},
                          {"125.1 km^2","52 km^2","63.67 km^2","28.5 km^2","117.5 km^2"},
                          {"2,194 km^2","223 km^2","827.8 km^2","1,121 km^2","326.4 km^2"},
                          {"3,085.12 km^2","464.2 km^2","37.4 km^2","16.89 km^2","58.48 km^2"},
                          {"42.88 km^2","166.2 km^2","28 km^2","50 km^2","57.5 km^2"},
                          {"37.31 km^2","16.52 km^2","28.53 km^2","20.2 km^2","7.5 km^2"},
                          {"605.2 km^2","770 km^2","1,063 km^2","883.5 km^2","1,057 km^2"},
                          {"271.8 km^2","2,952 km^2","2192 km^2","2,215 km^2","132.8 km^2"}};

    //Europe

    String[][] citiesEurope={{"Tirana","Berat","Durres","Gjirokaster","Vlore"},
                             {"Brussels","Bruges","Ghent","Antwerp","Leuven"},
                             {"Helsinki","Turku","Tampere","Oulu","Espoo"},
                             {"Paris","Marseilee","Strasborg","Bordeaux","Nice"},
                             {"Berlin","Munich","Humburg","Frankfurt","Cologne"},
                             {"Bergen","Oslo","Stavanger","Trondheim","Tromso"},
                             {"Madrid","Barcelona","Seville","Granada","Bilbao"},
                             {"London","Edinburgh","Oxford","Bristol","Manchester"}};

    String[][] populationsEurope={{"418,495","100,000","113,249","19,836","104,827"},
                                  {"174,383","117,260","248,358","498,473","100,224"},
                                  {"613,695","186,756","226,696","199,526","272,193"},
                                  {"2,161,000","861,635","277,270","249,712","342,522"},
                                  {"3,645,000","1,472,000","1,841,000","753,056","1,086,000"},
                                  {"271,949","634,293","130,754","182,035","71,590"},
                                  {"3,223,000","620,000","688,711","232,208","345,821"},
                                  {"8,982,000","482,005","152,450","467,099","553,230"}};

    String[][] areasEurope={{"41.8 km^2","6.3 km^2","338.3 km^2","5.25 km^2","647.9 km^2"},
                            {"32.61 km^2","138 km^2","156.2 km^2","204.5 km^2","56.63 km^2"},
                            {"213.8 km^2","243.4 km^2","523.4 km^2","1,410 km^2","312 km^2"},
                            {"105.4 km^2","240.6 km^2","78.26 km^2","49.36 km^2","71.92 km^2"},
                            {"891.8 km^2","310.4 km^2","755.2 km^2","248.3 km^2","405.2 km^2"},
                            {"445.4 km^2","454 km^2","71.35 km^2","321.8 km^2","2,521 km^2"},
                            {"604.3 km^2","101.9 km^2","688,711 km^2","88.02 km^2","41.6 km^2"},
                            {"1,572 km^2","264 km^2","45.59 km^2","110 km^2","115.6 km^2"}};

    //North America

    String[][] citiesNAmerica={{"Arima","Chaguanas Borough","Point Fortin","Sangre Grande","Penal"},
                               {"San Salvador","San Miguel","Sonsonate","Usulutan","Soyapango"},
                               {"Belize City","San Pedro","Belmopan","San Ignacio","Punta Gordon"},
                               {"Toronto","Vancouver","Montreal","Ottawa","Calgary"},
                               {"Panama City","Tocumen","David","Santiago","Chitre"},
                               {"Mexico City","Guadalajara","Ciudad Juarez","Tijuana","Merida"},
                               {"San Pedro Sula","La Ceiba","Comayagua","Atlantida","El Progreso"},
                               {"New York","San Francisco","Chicago","Washington D.C.","Los Angeles"}};

    String[][] populationsNAmerica={{"33,606","83,489","20,161","18,127","12,281"},
                                    {"238,244","265,921","72,951","73,064","283,223"},
                                    {"57,169","11,767","13,939","17,878","5,351"},
                                    {"2,930,000","675,218","1,780,270","994,837","1,336,000"},
                                    {"477,328","74,952","82,907","88,997","9,092"},
                                    {"8,855,000","1,495,000","1,321,000","1,301,000","776,615"},
                                    {"719,064","197,267","144,785","449,822,208","188,366"},
                                    {"8,399,000","883,305","2,706,000","684,498","3,990,0000"}};

    String[][] areasNAmerica={{"12 km^2","59 km^2","23.88 km^2","13.5 km^2","9.66 km^2"},
                              {"72.25 km^2","594 km^2","232.5 km^2","139.8 km^2","29.72 km^2"},
                              {"35.67 km^2","71.22 km^2","32.78 km^2","6 km^2","56.1 km^2"},
                              {"630.2 km^2","115 km^2","431.5 km^2","2,790 km^2","825.3 km^2"},
                              {"275 km^2","65.3 km^2","755.2 km^2","44.2 km^2","91 km^2"},
                              {"1,485 km^2","187.9 km^2","321.2 km^2","637 km^2","14,827 km^2"},
                              {"840 km^2","640 km^2","834 km^2","4,251 km^2","547.5 km^2"},
                              {"783.8 km^2","121.4 km^2","606.1 km^2","177 km^2","1,302 km^2"}};

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
        switch(continent)
        {
            case 0:
                populationTextView.setText("Population: " + populationsAfrica[country][position]);
                areaTextView.setText("Area: " + areasAfrica[country][position]);
                break;
            case 1:
                populationTextView.setText("Population: " + populationsAsia[country][position]);
                areaTextView.setText("Area: " + areasAsia[country][position]);
                break;
            case 2:
                populationTextView.setText("Population: " + populationsEurope[country][position]);
                areaTextView.setText("Area: " + areasEurope[country][position]);
                break;
            case 3:
                populationTextView.setText("Population: " + populationsNAmerica[country][position]);
                areaTextView.setText("Area: " + areasNAmerica[country][position]);
                break;
        }
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
                case 1:
                    adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, citiesAsia[position - 1]);
                    break;
                case 2:
                    adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, citiesEurope[position - 1]);
                    break;
                case 3:
                    adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, citiesNAmerica[position - 1]);
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