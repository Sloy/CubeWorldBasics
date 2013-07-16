package com.hitglynorthz.cubeworldbasics;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.hitglynorthz.cubeworldbasics.singleitem.MultiplePagesActivity;

public class ClassesFragment extends Fragment {
	String[] classes_items;
	
	@Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState)
    {       
        View view = inflater.inflate(R.layout.classes_layout, container,false);
        
        //List Classes
        final ListView listClasses = (ListView) view.findViewById(R.id.listClasses);
        classes_items = getResources().getStringArray(R.array.classes_items);
        ArrayAdapter<String> adapterClasses = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, classes_items);
        listClasses.setAdapter(adapterClasses);
        listClasses.setOnItemClickListener(new OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position,long id){
            	Intent it = MultiplePagesActivity.getIntent(getActivity(), classes_items, position);
                //it.putExtra("title", classes_items[position]);
                startActivity(it);
            }
        });
        ListSizeHelper.setListViewHeightBasedOnChildren(listClasses);
        
        return view;
    }

}
