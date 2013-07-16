package com.hitglynorthz.cubeworldbasics.singleitem;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hitglynorthz.cubeworldbasics.R;

/**
 * Fragment para mostrar información de un elemento individual.
 */
public class SingleItemFragment extends Fragment {

    public static final String EXTRA_TITLE = "title";
    private TextView txtAbout;
    private TextView txtTitle;
    private String mTitle;

    public static SingleItemFragment getInstance(String title) {
        SingleItemFragment frag = new SingleItemFragment();
        Bundle extras = new Bundle();
        extras.putString(EXTRA_TITLE, title);
        frag.setArguments(extras);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.single_item_layout, container, false);
        txtTitle = (TextView) v.findViewById(R.id.txtTitle);
        txtAbout = (TextView) v.findViewById(R.id.txtAbout);

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // getting attached intent data
        mTitle = getArguments().getString(EXTRA_TITLE);

        //getActivity().setTitle(mTitle);
        // displaying selected product name
        txtTitle.setText(mTitle);

        String a = mTitle.toString().toLowerCase().replaceAll(" ", "_");
        String about = a + "_about";
        int stringR = getResources().getIdentifier(about, "string", getActivity().getPackageName());
        if (stringR != 0) {
            String content = getString(stringR);
            txtAbout.setText(content);
        } else {
            txtAbout.setText("about not found xD");
        }
    }
}
