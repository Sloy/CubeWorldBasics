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

public class ItemsFragment extends Fragment {
	String[] items_items;
	
	@Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState)
    {       
        View view = inflater.inflate(R.layout.items_layout, container,false);
        
        //List Classes
        final ListView listItems = (ListView) view.findViewById(R.id.listItems);
        items_items = getResources().getStringArray(R.array.items_items);
        ArrayAdapter<String> adapterItems = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items_items);
        listItems.setAdapter(adapterItems);
        listItems.setOnItemClickListener(new OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position,long id){
            	Intent it = new Intent(getActivity(), SingleListItem.class);
                it.putExtra("title", items_items[position]);
                startActivity(it);
            }
        });
        ListSizeHelper.setListViewHeightBasedOnChildren(listItems);
        
        return view;
    }

}
