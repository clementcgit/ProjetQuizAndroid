package com.clement.projetquiz;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;


public class CategoriesActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
    }

    //définition d'un String qui va stocker la catégorie choisit par l'utilisateur
    public static String catego;

    public void gererCatego(View v)
    {
        if (v.getId() == R.id.culture)
        {
            catego = "culture";
        }
        else if (v.getId() == R.id.informa)
        {
            catego = "info";
        }
        else if (v.getId() == R.id.jeux)
        {
            catego = "jeux";
        }
        //ouverture de l'activité PrincipaleActivity :
        Intent intent = new Intent(this,PrincipaleActivity.class);
        this.startActivity(intent);
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }

}
