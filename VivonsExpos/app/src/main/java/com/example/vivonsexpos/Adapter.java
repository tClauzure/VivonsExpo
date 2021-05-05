/*package com.example.vivonsexpos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.vivonsexpos.DTO.Utilisateur;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private List<Utilisateur> listContact;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListAdapter(Context aContext, List<Utilisateur> listUtilisateur){
        this.context = aContext;
        this.listContact = listUtilisateur;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount(){
        return listContact.size();
    }

    @Override
    public Object getItem(int position){
        return listContact.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        RecyclerView.ViewHolder holder;
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.l,null);
            holder =  new RecyclerView.ViewHolder();

            convertView.setTag(holder);
        }
        else{
            holder = (RecyclerView.ViewHolder) convertView.getTag();
        }
        return convertView;
    }
}
*/