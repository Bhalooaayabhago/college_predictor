package com.example.cp4;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class tuple implements Serializable
{
    private int id;
     private int category;
     private int closing;
     private String branch;
     private String name;
    tuple(int id,int category,int closing,String name,String branch)
    {
        this.id=id;
        this.category=category;
        this.closing=closing;
        this.name=name;
        this.branch=branch;
    }

    int getId()
    {
        return this.id;
    }
    int getCategory()
    {
        return this.category;
    }
    int getClosing()
    {
        return this.closing;
    }
    String getName()
    {
        return this.name;
    }
    String getBranch()
    {
        return this.branch;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public void setClosing(int closing) {
        this.closing = closing;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public String toString()
    {
        return "tuple{" +
                "id=" + id +
                ", category=" + category +
                ", closing=" + closing +
                ", branch='" + branch + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
class sortr implements Comparator<tuple>
{

    @Override
    public int compare(tuple o1, tuple o2)
    {
        return o1.getName().compareTo(o2.getName());
    }
}
class seats
{
    @SerializedName("College")
    String college;
    int adv;
    @SerializedName("Branch")
    String branch;
    @SerializedName("Jossa")
    String jossa;
    @SerializedName("Quota")
    String quota;
    @SerializedName("Gender")
    String gender;
    @SerializedName("State")
    String state;
    seats(String college,String state,String branch,String jossa,String quota,String gender,int adv)
    {
        this.state=state;
        this.college=college;
        this.branch=branch;
        this.jossa=jossa;
        this.quota=quota;
        this.adv=adv;
        this.gender=gender;
    }
    public String getCollege()
    {
        return college;
    }
    public String getBranch()
    {
        return branch;
    }

    public String getJosaa() {
        return jossa;
    }

    public String getQuota() {
        return quota;
    }

    public String getGender() {
        return gender;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setJosaa(String josaa)
    {
        this.jossa = josaa;
    }

    public void setAdv(int adv) {
        this.adv = adv;
    }

    public int getAdv() {
        return adv;
    }

    public void setQuota(String quota)
    {
        this.quota = quota;
    }

    @Override
    public String toString() {
        return "seats{" +
                "college='" + college + '\'' +
                ", adv=" + adv +
                ", branch='" + branch + '\'' +
                ", jossa='" + jossa + '\'' +
                ", quota='" + quota + '\'' +
                ", gender='" + gender + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

   /* int conint(String s)
    {
        if(s!=null)
            return Integer.parseInt(s);
        return 1000000;
    }*/
    tuple Totuple()
    {
        String gender_val[]={"Gender-Neutral","Female-only"};
        String quota_val[]={"SC","ST","OBC-NCL","OPEN","EWS"};
        String state_val[]={"OS","HS","AI"};
        Map<String,Integer> mp=new LinkedHashMap<>();
        for(int i=0;i<gender_val.length;i++)
            mp.put(gender_val[i],i);
        for(int i=0;i<quota_val.length;i++)
            mp.put(quota_val[i],i);
        for(int i=0;i<state_val.length;i++)
            mp.put(state_val[i],i%2);
        if(!mp.containsKey(state))
            mp.put(state,0);
        String hot=quota.toUpperCase().trim();
        String ho=hot;
        if(hot.equals("OBC"))
            ho="OBC-NCL";
        int category=mp.get(gender)*100;

        try {
            category = category + mp.get(ho) * 10;
        }
        catch (Exception e)
        {
            Log.d("err", hot);
        }
        category=category+mp.get(state);category+=adv*1000;
        int cutoff=0;
        cutoff=Integer.parseInt(getJosaa());
       tuple tommy=new tuple(1,category,cutoff,college,branch);
       return tommy;

    }
}

public class MainActivity extends AppCompatActivity {

    mapc x[];//global array to store state college tupel
    Set<String> maj;//
    Map<String, String> got;//map for state to package
    ArrayList<ctop> y;//college profiles in a global list
    String fg[][];
    String jsonfp(String file) {
        String json = "";
        try {
            InputStream fat = this.getAssets().open(file);
            int size = fat.available();
            byte[] buffer = new byte[size];
            fat.read(buffer);
            fat.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }
    public int calCategory(int rank,String q,String gen)
    {
        int cat=0;
        String gender_val[]={"Gender-Neutral","Female-only"};
        String quota_val[]={"SC","ST","OBC-NCL","OPEN","EWS"};
        Map<String,Integer> mp=new LinkedHashMap<>();
        for(int i=0;i<gender_val.length;i++)
            mp.put(gender_val[i],i);
        for(int i=0;i<quota_val.length;i++)
            mp.put(quota_val[i],i);
        cat=mp.get(gen)*100+mp.get(q)*10;
        return cat;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.till1).setVisibility(View.INVISIBLE);
        findViewById(R.id.till2).setVisibility(View.INVISIBLE);
        findViewById(R.id.till3).setVisibility(View.INVISIBLE);
        findViewById(R.id.till4).setVisibility(View.INVISIBLE);
        findViewById(R.id.till5).setVisibility(View.INVISIBLE);
        findViewById(R.id.button).setVisibility(View.INVISIBLE);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String kot = jsonfp("pr.json");//college profile
        String hot = jsonfp("ir.json");// nit state map
        Gson g = new Gson();
        y = new ArrayList<>();
        x = g.fromJson(hot, mapc[].class);// nit state map
        String release = "1.5";
        ctop z[] = g.fromJson(kot, ctop[].class);//college profile
        for (int i = 0; i < z.length; i++) {
            y.add(z[i]);
        }//adding college profile to a global list in main activity
        got = new LinkedHashMap<>();
        for (int i = 0; i < x.length; i++)
        {
            mapc lo = x[i];
            got.put(lo.state, lo.college);

        }// adding (state,nit) as key val pair to a global LinkedHashMap in Main Activity
        if (!prefs.getBoolean(release, false))
        {
                    helper ho = new helper(MainActivity.this);
                    String rat = jsonfp("or.json");
                    seats[] dom = g.fromJson(rat, seats[].class);// main database file
                     maj=new HashSet<>();
                    for (int i = 0; i < dom.length; i++) {
                        seats x = dom[i];
                        tuple tommy = dom[i].Totuple();
                        boolean check = ho.add(tommy);
                    }// creating database
                    Toast.makeText(MainActivity.this,"done",Toast.LENGTH_LONG);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean(release, true);
                    editor.commit();//making sure database creation is done only on first boot.

        }


        ImageView im = findViewById(R.id.imageView3);
        ValueAnimator animator = ValueAnimator.ofFloat(400f, 0f);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float fat = (float) animation.getAnimatedValue();
                im.setY(fat);
                if (fat == 0) {
                    findViewById(R.id.till1).setVisibility(View.VISIBLE);
                    findViewById(R.id.till2).setVisibility(View.VISIBLE);
                    findViewById(R.id.till3).setVisibility(View.VISIBLE);
                    findViewById(R.id.till4).setVisibility(View.VISIBLE);
                    findViewById(R.id.till5).setVisibility(View.VISIBLE);
                    findViewById(R.id.button).setVisibility(View.VISIBLE);
                    ValueAnimator vax = ValueAnimator.ofFloat(0.0f, 360.0f);
                    vax.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            float sat = (float) animation.getAnimatedValue();
                            im.setRotation(sat);
                        }
                    });
                    vax.setDuration(1000);
                    vax.setRepeatCount(ValueAnimator.INFINITE);
                    vax.start();
                }
            }
        });
        animator.setDuration(2000);
        animator.start();
        }


    /*public void upd()
    {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        if (!prefs.getBoolean("firstTime", false))
            return;
        SharedPreferences.Editor editor = prefs.edit();
        editor.remove("firstTime");
        editor.commit();

    }*/
    public class sortbyp implements Comparator<tuple> {
        Map<String, Double> jammy;

        sortbyp() {
            jammy = new LinkedHashMap<>();
            for (int i = 0; i < y.size(); i++) {
                jammy.put(y.get(i).college, Double.parseDouble(y.get(i).pay.trim()));
            }
        }

        @Override
        public int compare(tuple o1, tuple o2) {
            try {
                double u = jammy.getOrDefault(o1.getName(),0.0);
                double v = jammy.getOrDefault(o2.getName(),0.0);

                if ((u - v) > 0)
                    return 1;
                if ((u - v) < 0)
                    return -1;
                return (int) (u - v);

            } catch (Exception e) {
                Log.d("gaddar", o1.getName() + "\n" + o2.getName());

            }
            return -1000000;
        }
    }

    public class ptuple {
        tuple a;
        double paisa;

        ptuple(tuple a, double paisa) {
            this.a = a;
            this.paisa = paisa;
        }

    }
    int validate(TextInputLayout t)
    {
        t.setErrorEnabled(false);
        String job = t.getEditText().getText().toString().trim();
        if (job.equals(""))
        {
            t.setErrorEnabled(true);
            t.setError("Error");
            return -1;
        }
        return Integer.parseInt(job);
    }

    String validate(TextInputLayout t,HashSet<String> h)
    {
        String job=t.getEditText().getText().toString().trim();
        t.setErrorEnabled(true);
        if(job.equals(""))
        {
            t.setError("Error");
            return "";
        }
        for(String ho:h)
        {
            if(ho.equalsIgnoreCase(job))
            {
                t.setErrorEnabled(false);
                return ho;
            }
        }
        t.setError("Error");
        return "";
    }

    public void call(View v)
    {
        maj=new HashSet<>();
        String sad[]={"Punjab",
                "West Bengal",
                "Rajasthan",
                "Madhya Pradesh",
                "Uttar Pradesh",
                "Tripura",
                "Arunachal Pradesh",
                "Kerala",
                "Delhi",
                "West Bengal",
                "Goa",
                "Himachal Pradesh",
                "Karnataka",
                "Meghalaya",
                "Bihar",
                "Puducherry",
                "Chattisgarh",
                "Sikkim",
                "Andhra Pradesh",
                "Jharkhand",
                "Haryana",
                "Manipur",
                "Mizoram",
                "Odisha",
                "Assam",
                "Jammu & Kashmir",
                "Tamil Nadu",
                "Uttarakhand",
                "Telangana",
                "Gujarat",
                "Maharashtra"};
        for(String hooo:sad)
        {
            maj.add(hooo);
        }
        int gadv=0;
        int grank=1000;String gquota="OPEN",ggender="Gender-Neutral",gstate="Uttar Pradesh";
        Set<String> gv=new HashSet<>();
        Set<String> qv=new HashSet<>();
        String gender_val[]={"Gender-Neutral","Female-only"};
        String quota_val[]={"SC","ST","OBC-NCL","OPEN","EWS"};
        for(String sat:gender_val)
            gv.add(sat);
        for(String sat:quota_val)
            qv.add(sat);
        gadv=validate(findViewById(R.id.till5));
        gstate=validate(findViewById(R.id.till3), (HashSet<String>) maj);
        gquota=validate(findViewById(R.id.till2), (HashSet<String>) qv);
        ggender=validate(findViewById(R.id.till4), (HashSet<String>) gv);
        grank=validate(findViewById(R.id.till1));
        if(gstate.equals("")||ggender.equals("")||gquota.equals("")||grank==-1||gadv==-1)
            return;
        if(gadv>0)
            gadv=1;
        helper ho=new helper(MainActivity.this);
        int valx=1000*gadv+calCategory(grank,gquota,ggender);
        List<tuple> x=ho.query(grank,valx);
        List<tuple> uto=new ArrayList<>();
        //Collections.sort(y,new sbyp());
        Map<String,Double> jolly=new HashMap<>();
        for(int i=0;i<y.size();i++){
            jolly.put(y.get(i).college,Double.parseDouble(y.get(i).pay));
        }
        for(tuple t:x)
        {
            if(t.getName().equalsIgnoreCase(got.get(gstate)))
            {
                if(t.getCategory()%2==1)
                    uto.add(t);
            }
            else
            {
                if(t.getCategory()%2==0)
                    uto.add(t);
            }
        }
        //Collections.sort(uto,new sortr());
        List<tuple> orr=new ArrayList<>();
        for(tuple gooo:uto)
        orr.add(gooo);
        sortbyp jo=new sortbyp();
        Collections.sort(uto,jo);
        List<String> a1=new ArrayList<>();
        Set<String> a2=new HashSet<>();
        for(String oo:jolly.keySet())
        {
            a2.add(oo);
        }
        for(int i=0;i<uto.size();i++)
        {
            String obj=uto.get(i).getName();
            if(a2.contains(obj))
            {
                a1.add(obj);
                a2.remove(obj);
            }
        }
        List<ptuple> poo=new ArrayList<>();
        for(int i=0;i<uto.size();i++)poo.add(new ptuple(uto.get(i),(double)jolly.getOrDefault(uto.get(i).getName(),0.0)));
        Intent ini=new Intent(this,Lister.class);
        ini.putExtra("jolly", (Serializable) jolly);
        ini.putExtra("a1", (Serializable) a1);
        ini.putExtra("uto",(Serializable)orr);
        int uom=uto.size();
        Toast.makeText(MainActivity.this,"yes",Toast.LENGTH_SHORT).show();
        startActivity(ini);
        /*jolly-name,package ka map
        uto-full list of colleges+branch sorted by package
        a1-list of colleges
         */
    }

}