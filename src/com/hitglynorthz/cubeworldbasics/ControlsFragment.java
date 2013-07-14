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
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;

public class ControlsFragment extends Fragment implements OnItemClickListener {
	String[] controls_items;

	@Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.controls_layout, container,false);

        //List Equipment
        final ListView listControls = (ListView) view.findViewById(R.id.listControls);

        // Coloca el texto como Header de la lista, para que haga Scroll junto con ella.
        // Evita los problemas de meter un ListView en un ScrollView, y ahorra medir los hijos para decidir la altura.
        listControls.setHeaderDividersEnabled(true);
        TextView header = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.item_list_about, listControls, false);
        header.setText(R.string.controls_about);
        header.setLayoutParams(new ListView.LayoutParams(ListView.LayoutParams.MATCH_PARENT, ListView.LayoutParams.WRAP_CONTENT));
        listControls.addHeaderView(header, null, false);

        controls_items = getResources().getStringArray(R.array.controls_items);
        ArrayAdapter<String> adapterEquipment = new ArrayAdapter<String>(getActivity(), R.layout.item_list_control, controls_items);
        listControls.setAdapter(adapterEquipment);
        listControls.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            	/*Intent it = new Intent(getActivity(), SingleListItem.class);
                it.putExtra("title", controls_items[position]);
                startActivity(it);*/
            }
        });
        
        return view;
    }

	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
		Toast.makeText(getActivity(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
	}

}
