package com.hitglynorthz.cubeworldbasics.singleitem;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import com.hitglynorthz.cubeworldbasics.R;

/**
 * Activitidad encargada de mostrar un ViewPager con la información de elementos individuales en cada página, como hace Gmail con los correos abiertos.
 */
public class MultiplePagesActivity extends FragmentActivity {

    public static final String EXTRA_ITEMS_TITLES = "items_titles";
    public static final String EXTRA_POSITION = "position";

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_pages);

        String[] items = getIntent().getStringArrayExtra(EXTRA_ITEMS_TITLES);
        int current = getIntent().getIntExtra(EXTRA_POSITION, 0);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), items));
        mViewPager.setCurrentItem(current);

        //TODO: poner en el título del Action Bar la categoría que se está viendo (ej: Classes), o dejarlo vacío
    }

    /**
     * Genera un Intent para lanzar la Avtivity con los argumentos necesarios.
     * Usando este método se asegura que todos los argumentos son enviados correctamente.
     *
     * @param ctx
     * @param items
     * @param current
     * @return
     */
    public static Intent getIntent(Context ctx, String[] items, int current) {
        Intent it = new Intent(ctx, MultiplePagesActivity.class);
        it.putExtra(EXTRA_ITEMS_TITLES, items);
        it.putExtra(EXTRA_POSITION, current);
        return it;
    }

    public static class PageAdapter extends FragmentPagerAdapter {
        private String[] itemsTitles;

        public PageAdapter(FragmentManager fm, String[] itemsTitles) {
            super(fm);
            this.itemsTitles = itemsTitles;
        }

        @Override
        public Fragment getItem(int i) {
            return SingleItemFragment.getInstance(itemsTitles[i]);
        }

        @Override
        public int getCount() {
            return itemsTitles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return itemsTitles[position];
        }
    }
}
