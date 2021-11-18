package com.example.cp4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

class list
{
    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public double getPack() {
        return pack;
    }

    public void setPack(double pack) {
        this.pack = pack;
    }


    @Override
    public String toString() {
        return "list{" +
                "college='" + college + '\'' +
                ", branch='" + branch + '\'' +
                ", pack=" + pack +
                ", rank=" + rank +
                '}';
    }

    public list(String college, String branch, double pack, int rank) {
        this.college = college;
        this.branch = branch;
        this.pack = pack;
        this.rank = rank;
    }

    private String college;
    private String branch;
    private double pack;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    int rank;



}


public class Lister extends AppCompatActivity {
    private RecyclerView r1;
    private RecyclerView.Adapter mad;
    private RecyclerView.LayoutManager lm;
    ArrayList<tuple> fat;
    HashMap<String,Double> jolly;
    ArrayList<String> a1;
    ArrayList<list> xx;
   class comp3 implements Comparator<list>
   {

       @Override
       public int compare(list o1, list o2) {
           return (o1.rank-o2.rank);
       }
   }
    class comp4 implements Comparator<list>
    {

        @Override
        public int compare(list o1, list o2) {
            return (o2.rank-o1.rank);
        }
    }
    class comp2 implements Comparator<list>
    {

        @Override
        public int compare(list o1, list o2) {
            double cn= (o2.getPack()-o1.getPack());
            if(cn>0)
                return 1;
            if(cn<0)
                return -1;
            return (int)cn;
        }
    }
    class comp1 implements Comparator<list>
    {

        @Override
        public int compare(list o1, list o2) {
            double cn= (o1.getPack()-o2.getPack());
            if(cn>0)
                return 1;
            if(cn<0)
                return -1;
            return (int)cn;
        }
    }
    class compaz implements Comparator<list>
    {

        @Override
        public int compare(list o1, list o2) {
            int r1=o1.getCollege().compareTo(o2.getCollege());
            if(r1!=0)
                return r1;
            return o1.getBranch().compareTo(o2.getBranch());
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lister);
        Intent ini=getIntent();
        fat= (ArrayList<tuple>) ini.getSerializableExtra("uto");
        jolly= (HashMap<String, Double>) ini.getSerializableExtra("jolly");
        a1=(ArrayList<String>)ini.getSerializableExtra("a1");
        xx=new ArrayList<>();
        for(tuple t:fat)
            xx.add(new list(t.getName(),t.getBranch(),jolly.getOrDefault(t.getName(),0.0),t.getClosing()));
        r1=findViewById(R.id.lis);
        lm=new LinearLayoutManager(this);
        r1.setLayoutManager(lm);
        mad =new myadp(this,xx);
        r1.setAdapter(mad);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater mi=getMenuInflater();
        mi.inflate(R.menu.m1,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id._1:
                r1=findViewById(R.id.lis);
                lm=new LinearLayoutManager(this);
                r1.setLayoutManager(lm);
                mad =new myadp(this,xx);
                r1.setAdapter(mad);
                Collections.sort(xx,new comp1());
                return true;
            case R.id._2:
                r1=findViewById(R.id.lis);
                lm=new LinearLayoutManager(this);
                r1.setLayoutManager(lm);
                mad =new myadp(this,xx);
                r1.setAdapter(mad);
                Collections.sort(xx,new comp2());
                return true;
            case R.id._3:
                r1=findViewById(R.id.lis);
                lm=new LinearLayoutManager(this);
                r1.setLayoutManager(lm);
                mad =new myadp(this,xx);
                r1.setAdapter(mad);
                Collections.sort(xx,new comp3());
                return true;
            case R.id._4:
                Collections.sort(xx,new comp4());
                r1=findViewById(R.id.lis);
                lm=new LinearLayoutManager(this);
                r1.setLayoutManager(lm);
                mad =new myadp(this,xx);
                r1.setAdapter(mad);
                return true;
            case R.id.A_Z:
                Collections.sort(xx,new compaz());
                r1=findViewById(R.id.lis);
                lm=new LinearLayoutManager(this);
                r1.setLayoutManager(lm);
                mad =new myadp(this,xx);
                r1.setAdapter(mad);
                return true;
            case R.id.gr:
                Intent ini=new Intent(getApplicationContext(),Barc.class);
                ini.putExtra("a1",(Serializable)a1);
                ini.putExtra("jolly",(Serializable)jolly);
                ini.putExtra("fat",(Serializable)fat);
                Lister.this.startActivity(ini);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}