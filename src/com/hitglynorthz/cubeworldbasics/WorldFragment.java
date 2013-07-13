package com.hitglynorthz.cubeworldbasics;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class WorldFragment extends Fragment {
	String[] world_items;
	
	@Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState)
    {       
        View view = inflater.inflate(R.layout.world_layout, container,false);
        
        //List Classes
        final ListView listWorld = (ListView) view.findViewById(R.id.listWorld);
        world_items = getResources().getStringArray(R.array.world_items);
        ArrayAdapter<String> adapterWorld = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, world_items);
        listWorld.setAdapter(adapterWorld);
        listWorld.setOnItemClickListener(new OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position,long id){
            	//Toast.makeText(getActivity(), "Ha pulsado " + classes_items[position], Toast.LENGTH_SHORT).show();
            	AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            	builder.setTitle(world_items[position]);
            	builder.setMessage("asdfasdf");
                builder.setPositiveButton("OK", new OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
            }
        });
        ListSizeHelper.setListViewHeightBasedOnChildren(listWorld);
        
        return view;
    }

}