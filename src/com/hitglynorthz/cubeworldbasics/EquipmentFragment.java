package com.hitglynorthz.cubeworldbasics;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class EquipmentFragment extends Fragment {
	String[] equipment_items;
	
	@Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState)
    {       
        View view = inflater.inflate(R.layout.equipment_layout, container,false);
        
        //List Equipment
        final ListView listEquipment = (ListView) view.findViewById(R.id.listEquipment);
        equipment_items = getResources().getStringArray(R.array.equipment_items);
        ArrayAdapter<String> adapterEquipment = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, equipment_items);
        listEquipment.setAdapter(adapterEquipment);
        listEquipment.setOnItemClickListener(new OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position,long id){
            	Intent it = new Intent(getActivity(), SingleListItem.class);
                it.putExtra("title", equipment_items[position]);
                startActivity(it);
            }
        });
        ListSizeHelper.setListViewHeightBasedOnChildren(listEquipment);
        
        return view;
    }

}
