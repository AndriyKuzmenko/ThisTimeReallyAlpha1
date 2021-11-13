package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class Main3Activity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        GraphView graph=(GraphView)findViewById(R.id.g);

        try
        {
            LineGraphSeries <DataPoint> series = new LineGraphSeries< >(new DataPoint[]
                {
                        new DataPoint(-5, 25-2),
                        new DataPoint(-4.75, 22.5625-2),
                        new DataPoint(-4.5, 20.25-2),
                        new DataPoint(-4.25, 18.0625-2),
                        new DataPoint(-4, 16-2),
                        new DataPoint(-3.75, 14.0625-2),
                        new DataPoint(-3.5, 12.25-2),
                        new DataPoint(-3.25, 10.5625-2),
                        new DataPoint(-3, 9-2),
                        new DataPoint(-2.75, 7.5625-2),
                        new DataPoint(-2.5, 6.25-2),
                        new DataPoint(-2.25, 5.0625-2),
                        new DataPoint(-2, 4-2),
                        new DataPoint(-1.75, 3.0625-2),
                        new DataPoint(-1.5, 2.25-2),
                        new DataPoint(-1.25, 1.5625-2),
                        new DataPoint(-1, 1-2),
                        new DataPoint(-0.75, 0.5625-2),
                        new DataPoint(-0.5, 0.25-2),
                        new DataPoint(-0.25, 0.0625-2),
                        new DataPoint(0, 0-2),
                        new DataPoint(0.25, 0.0625-2),
                        new DataPoint(0.5, 0.25-2),
                        new DataPoint(0.75, 0.5625-2),
                        new DataPoint(1, 1-2),
                        new DataPoint(1.25, 1.5625-2),
                        new DataPoint(1.5, 2.25-2),
                        new DataPoint(1.75, 3.0625-2),
                        new DataPoint(2, 4-2),
                        new DataPoint(2.25, 5.0625-2),
                        new DataPoint(2.5, 6.25-2),
                        new DataPoint(2.75, 7.5625-2),
                        new DataPoint(3, 9-2),
                        new DataPoint(3.25, 10.5625-2),
                        new DataPoint(3.5, 12.25-2),
                        new DataPoint(3.75, 14.0625-2),
                        new DataPoint(4, 16-2),
                        new DataPoint(4.25, 18.0625-2),
                        new DataPoint(4.5, 20.25-2),
                        new DataPoint(4.75, 22.5625-2),
                        new DataPoint(5, 25-2),
                });
            graph.addSeries(series);

            LineGraphSeries <DataPoint> series1 = new LineGraphSeries< >(new DataPoint[]
                    {
                            new DataPoint(-5, 3),
                            new DataPoint(-4, 3.5),
                            new DataPoint(-3, 4),
                            new DataPoint(-2, 4.5),
                            new DataPoint(-1, 5),
                            new DataPoint(0, 5.5),
                            new DataPoint(1, 6),
                            new DataPoint(2, 6.5),
                            new DataPoint(3, 7),
                            new DataPoint(4, 7.5),
                            new DataPoint(5, 8),
                    });
            graph.addSeries(series1);
        }
        catch (IllegalArgumentException e)
        {
            Toast.makeText(Main3Activity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    /**
     * @param item - the item that was selected
     * @return - when the user selects an item, this code will go to the specified activity.
     */

    public boolean onOptionsItemSelected(MenuItem item)
    {
        int i=item.getItemId();

        if(i==R.id.AnimationScreen)
        {
            Intent si=new Intent(this, Main2Activity.class);
            startActivity(si);
        }
        else if(i==R.id.RegisterScreen)
        {
            Intent si=new Intent(this, MainActivity.class);
            startActivity(si);
        }

        return true;
    }
}
