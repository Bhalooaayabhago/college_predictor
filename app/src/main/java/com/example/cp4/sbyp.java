package com.example.cp4;

import java.util.ArrayList;
import java.util.Comparator;

class sbyp implements Comparator<ctop>
{

    @Override
    public int compare(ctop o1, ctop o2) {
        return STOI(o1.getPay())-STOI(o2.getPay());
    }
    int STOI(String s)
    {
        ArrayList<Character> f=new ArrayList<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch==' ')
                break;
            f.add(ch);
        }
        int mul=1;
        int ans=0;
        for(int i=f.size()-1;i>=0;i--)
        {
            int curr=(int) f.get(i);
            curr-=48;
            ans+=(curr*mul);
            mul*=10;
        }
        return ans;
    }

}