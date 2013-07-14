package com.hitglynorthz.cubeworldbasics;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RacesFragment extends Fragment {
	String[] races_items;
	
	@Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState)
    {       
        View view = inflater.inflate(R.layout.races_layout, container,false);

        //List Races
        final ListView listRaces = (ListView) view.findViewById(R.id.listRaces);
        races_items = getResources().getStringArray(R.array.races_items);
        ArrayAdapter<String> adapterRaces = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, races_items);
        listRaces.setAdapter(adapterRaces);
        listRaces.setOnItemClickListener(new OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position,long id){
            	Intent it = new Intent(getActivity(), SingleListItem.class);
                it.putExtra("title", races_items[position]);
                startActivity(it);
            }
        });
        ListSizeHelper.setListViewHeightBasedOnChildren(listRaces);
        
        return view;
    }

}
