package com.example.cp4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.robinhood.ticker.TickerUtils;
import com.robinhood.ticker.TickerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class anime implements Easing.EasingFunction
{

    @Override
    public float getInterpolation(float input)
    {
        float val=0.0f;
       // if(input<=0.5)
            val=input;
        /*else if(input<=0.9)
            val= (float) (1-input);
        else
            val=9*input-8;*/

        return val;
    }
}
class anime2 implements Easing.EasingFunction
{

    @Override
    public float getInterpolation(float input)
    {
        float val=0.0f;
        val =input*input;
        return val;
    }
}
public class Barc extends Activity {
    class phaltu implements OnChartValueSelectedListener{
        ArrayList<String> f;
        phaltu(ArrayList<String> oo)
        {
            f=oo;
        }

        @Override
        public void onValueSelected(Entry e, Highlight h) {
            int x= (int) e.getX();
            String y=f.get(x);
            TickerView taxi = findViewById(R.id.tickerView);
            taxi.setCharacterLists(TickerUtils.provideAlphabeticalList());
            taxi.setText(y);
        }

        @Override
        public void onNothingSelected() {
            return;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent ini=getIntent();
        HashMap<String,Double> jolly= (HashMap<String, Double>) ini.getSerializableExtra("jolly");
        ArrayList<String> a1=(ArrayList<String>)ini.getSerializableExtra("a1");
        setContentView(R.layout.activity_barc);
        List<BarEntry> entries = new ArrayList<>();
        int cnt=0;
        for(String zy:a1) {
            if(jolly.containsKey(zy)==true) {
                entries.add(new BarEntry(cnt++,jolly.get(zy).intValue()));
            }
        }
        BarDataSet set = new BarDataSet(entries, "Packages");
        int cols[]=new int[3];
        cols[0]=R.color.red;
        cols[1]=R.color.yellow;
        cols[2]=R.color.orange;
        set.setColors(cols,this);
        BarData data = new BarData(set);
        data.setBarWidth(0.9f);
        BarChart chart =(BarChart)findViewById(R.id.chart);
        chart.setData(data);
        phaltu fatman=new phaltu(a1);
        chart.setTouchEnabled(true);
        chart.setOnChartValueSelectedListener(fatman);
        chart.setFitBars(true);
                chart.animateXY(2000,1000,new anime2(),new anime());
    }
}