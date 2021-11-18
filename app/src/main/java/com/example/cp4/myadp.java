package com.example.cp4;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class myadp extends RecyclerView.Adapter<myadp.ViewHolder>
{
    public static class ViewHolder extends RecyclerView.ViewHolder {


        public TextView getTcollege() {
            return tcollege;
        }

        public void setTcollege(TextView tcollege) {
            this.tcollege = tcollege;
        }

        public TextView getTbranch() {
            return tbranch;
        }

        public void setTbranch(TextView tbranch) {
            this.tbranch = tbranch;
        }

        public TextView getTpackage() {
            return tpackage;
        }

        public void setTpackage(TextView tpackage) {
            this.tpackage = tpackage;
        }

        TextView tcollege;
        TextView tbranch;
        TextView tpackage;
        ConstraintLayout l1;
        public TextView getTrank() {
            return trank;
        }

        public void setTrank(TextView trank) {
            this.trank = trank;
        }

        TextView trank;
        ConstraintLayout lt;
        public ViewHolder(View view)
        {
            super(view);
            trank=view.findViewById(R.id.text_rank);
            tcollege=view.findViewById(R.id.text_college);
            tbranch=view.findViewById(R.id.text_branch);
            tpackage=view.findViewById(R.id.text_package);
            l1=(ConstraintLayout) view.findViewById(R.id.ooxy);
        }


    }
    Context c;

    public myadp(Context c, List<list> fatman) {
        this.c = c;
        this.fatman = fatman;
    }

    List<list> fatman;

    public Context getC() {
        return c;
    }

    public void setC(Context c) {
        this.c = c;
    }

    public List<list> getFatman() {
        return fatman;
    }

    public void setFatman(List<list> fatman) {
        this.fatman = fatman;
    }

    @NonNull
    @Override
    public myadp.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View vat= LayoutInflater.from(parent.getContext()).inflate(R.layout.entrylook,parent,false);
        ViewHolder vh=new ViewHolder(vat);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        String a1=String.valueOf(fatman.get(position).getPack());
       holder.tpackage.setText(a1);
        holder.tbranch.setText(fatman.get(position).getBranch());
        holder.tcollege.setText(fatman.get(position).getCollege());
        holder.trank.setText(String.valueOf(fatman.get(position).getRank()));
        holder.l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent ini=new Intent(c,cp.class);
                ini.putExtra("tpackage",holder.getTcollege().getText().toString().trim());
                c.startActivity(ini);
            }
        });

    }
    @Override
    public int getItemCount() {
        return fatman.size();
    }
}
