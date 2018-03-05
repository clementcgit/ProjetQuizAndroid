package com.clement.projetquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ResultatsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultats);

        /* on affiche dans un TextView un message à l'utilisateur
        qui dépend de si il a gagné ou perdu */
        String str;
        if(Param.Vies != 0)
        {
            str = "Vous avez gagné !";
        }
        else
        {
            str = "Vous avez perdu !";
        }
        TextView tv = (TextView)findViewById(R.id.status);
        //on affiche aussi son score et son nombre de vies restantes
        tv.setText(str + "\n\nScore : " + Integer.toString(Param.Score) + "/" + Param.total + "\nVies : " + Integer.toString(Param.Vies));
    }

    //on stocke le pseudo de l'utilisateur dans pseudoJ
    String pseudoJ;

    public void prendrePeudo(View v) {
        TextView tv = (TextView) findViewById(R.id.pseudo);
        pseudoJ = tv.getText().toString();
        /* si la longueur du pseudo est inférieure à 1 ou supérieure à 10
        on affiche une alerte Toast à l'utilisateur lui disant de revoir la
        longueur de son pseudo*/
        if ((pseudoJ.length() < 1) || (pseudoJ.length() > 10))
        {
            String msg = "La longeur du pseudo doit être entre 1 et 10";
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        }
        else
        {
            sauvegarder();
        }
    }

    //sauvegarde de la catégorie, du score et du pseudo
    public void sauvegarder()
    {
        //création de la SharedPreferences
        SharedPreferences sharedPref= getSharedPreferences("mypref", 0);
        //création de l'éditor
        SharedPreferences.Editor editor= sharedPref.edit();

        String pseudo = "pseudo";
        int cpt = 0;

        while(sharedPref.getString(pseudo+cpt, null) != null)
        {
            cpt++;
        }
        /* on stocke le pseudo, le score et la catégorie dans
        la SharedPreferences mypref */
        editor.putString(pseudo+cpt, pseudoJ);
        editor.putInt("score"+cpt, Param.Score);
        editor.putString("categorie"+cpt, CategoriesActivity.catego);

        //on fait le commit
        editor.commit();

        //puis on réouvre la MainActivity
        Intent intent = new Intent(this,MainActivity.class);
        this.startActivity(intent);
    }

    /* si l'utilisateur clique sur le bouton retour de son téléphone
    il sera redirigé vers CategoriesActivity */
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this,CategoriesActivity.class);
        this.startActivity(intent);
    }

}
