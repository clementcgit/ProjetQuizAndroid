package com.clement.projetquiz;

import java.util.ArrayList;
import java.util.HashMap;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import static com.clement.projetquiz.Constantes.FIRST_COLUMN;
import static com.clement.projetquiz.Constantes.SECOND_COLUMN;
import static com.clement.projetquiz.Constantes.THIRD_COLUMN;

/**
 * Created by Clement on 01/04/2015.
 */

/* définition de listviewAdapter qui va permettre de mettre 3 colonnes dans la ListView
qui sont la catégorie, le score et le pseudo de l'utilisateur*/
public class listviewAdapter extends BaseAdapter
{
    public ArrayList<HashMap<String, String>> list;
    Activity activity;

    public listviewAdapter(Activity activity, ArrayList<HashMap<String, String>> list) {
        super();
        this.activity = activity;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        TextView txtFirst;
        TextView txtSecond;
        TextView txtThird;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        LayoutInflater inflater =  activity.getLayoutInflater();

        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.listview_row, null);
            holder = new ViewHolder();
            holder.txtFirst = (TextView) convertView.findViewById(R.id.FirstText);
            holder.txtSecond = (TextView) convertView.findViewById(R.id.SecondText);
            holder.txtThird = (TextView) convertView.findViewById(R.id.ThirdText);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        //chaque élément de chaque colonne est en couleur noir
        holder.txtFirst.setTextColor(Color.BLACK);
        holder.txtSecond.setTextColor(Color.BLACK);
        holder.txtThird.setTextColor(Color.BLACK);

        //on met le premier element de chaque colonne en noir
        if (position == 0)
        {
            holder.txtFirst.setTypeface(null, Typeface.BOLD);
            holder.txtSecond.setTypeface(null, Typeface.BOLD);
            holder.txtThird.setTypeface(null, Typeface.BOLD);
        }

        HashMap<String, String> map = list.get(position);
        holder.txtFirst.setText(map.get(FIRST_COLUMN));
        holder.txtSecond.setText(map.get(SECOND_COLUMN));
        holder.txtThird.setText(map.get(THIRD_COLUMN));

        return convertView;
    }

}