package com.proyecto.roger.mascotas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

import com.proyecto.roger.mascotas.RV.MascotasFavoritas;
import com.proyecto.roger.mascotas.RV.RecyclerViewFragment;
import com.proyecto.roger.mascotas.adaptadores.PageAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tl;
    private ViewPager vp;



    ImageButton ib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tl = (TabLayout) findViewById(R.id.tabLayout);
        vp = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();

        if(toolbar !=null){
            setSupportActionBar(toolbar);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.mAbout:
                Intent intent = new Intent(this,Contacto.class);
                startActivity(intent);
                break;
            case R.id.mSettings:
                Intent intent2 = new Intent(this,AcercaDe.class);
                startActivity(intent2);
                break;
            case R.id.topmascotas:
                Intent intent3 = new Intent(this,TopMascotas.class);
                startActivity(intent3);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new MascotasFavoritas());
        return fragments;
    }

    private void setUpViewPager(){
        vp.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tl.setupWithViewPager(vp);
        tl.getTabAt(0).setIcon(R.drawable.ic_caseta);
        tl.getTabAt(1).setIcon(R.drawable.ic_animalito);
    }


}
