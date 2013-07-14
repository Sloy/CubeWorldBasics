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
import android.widget.TextView;
import android.widget.Toast;

public class ControlsFragment extends Fragment implements OnItemClickListener {
	String[] controls_items;
	
	@Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState)
    {       
        View view = inflater.inflate(R.layout.controls_layout, container,false);
        
        //List Equipment
        final ListView listControls = (ListView) view.findViewById(R.id.listControls);
        controls_items = getResources().getStringArray(R.array.controls_items);
        ArrayAdapter<String> adapterEquipment = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, controls_items);
        listControls.setAdapter(adapterEquipment);
        listControls.setOnItemClickListener(new OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position,long id){
            	/*Intent it = new Intent(getActivity(), SingleListItem.class);
                it.putExtra("title", controls_items[position]);
                startActivity(it);*/
            }
        });
        ListSizeHelper.setListViewHeightBasedOnChildren(listControls);
        
        return view;
    }

	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
		Toast.makeText(getActivity(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
	}

}
