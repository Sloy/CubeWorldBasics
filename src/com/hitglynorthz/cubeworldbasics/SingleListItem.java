package com.hitglynorthz.cubeworldbasics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class SingleListItem extends Activity {
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.single_item_layout);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        
		//this.overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
        
        TextView txtTitle = (TextView) findViewById(R.id.txtTitle);
        TextView txtAbout = (TextView) findViewById(R.id.txtAbout);
        
        Intent i = getIntent();
        // getting attached intent data
        String title = i.getStringExtra("title");
        setTitle(title);
        // displaying selected product name
        txtTitle.setText(title);

        String a = title.toString().toLowerCase().replaceAll(" ", "_");
        String about = a + "_about";
		int stringR = getResources().getIdentifier(about, "string", getPackageName());
		if(stringR !=0 ) {
			String content = getString(stringR);
			txtAbout.setText(content); 
		}else{
			txtAbout.setText("about not found xD");			
		}
        
	}
    
    @Override 
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
		    break;
		}
		return true; /** true -> consumimos el item, no se propaga*/
	}

}
