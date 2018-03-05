package com.clement.projetquiz;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RatingBar;


public class OptionsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        /* quand l'utilisateur arrive dans les options, son choix précédent
        de difficulté et couleur de fond des réponses lui sont remontrés
        si c'est la première fois qu'il va dans les options, il aura
        les options par défaut : difficulté 2 et couleur de fond des réponse bleu */
        SharedPreferences sp = getSharedPreferences("optionPref", 0);
        int diffi = sp.getInt("diffi", 2);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.difficulte);
        ratingBar.setRating(diffi);
        String couleur = sp.getString("couleur", "bleu");
        RadioButton radioB = (RadioButton) findViewById(R.id.radioBleu);
        RadioButton radioRouge = (RadioButton) findViewById(R.id.radioRouge);
        RadioButton radioN = (RadioButton) findViewById(R.id.radioNoir);
        RadioButton radioRose = (RadioButton) findViewById(R.id.radioRose);
        if (couleur.equals("bleu"))
        {
            radioB.setChecked(true);
        }
        else if (couleur.equals("rouge"))
        {
            radioRouge.setChecked(true);
        }
        else if (couleur.equals("noir"))
        {
            radioN.setChecked(true);
        }
        else if (couleur.equals("rose"))
        {
            radioRose.setChecked(true);
        }
    }

    /* fonction qui prend la difficulté et la couleur de fond des réponses
    choisit par l'utilistaur et qui les sauvegardent dans la SharedPreferences optionPref */
    public void saveOptions()
    {
        RatingBar ratingBar = (RatingBar) findViewById(R.id.difficulte);
        int diff = (int) ratingBar.getRating();
        //si le nombre d'étoiles est égal à 0 alors on met la difficulté à 1
        if (diff == 0)
        {
            diff = 1;
        }

        SharedPreferences sp = getSharedPreferences("optionPref", 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("diffi", diff);

        String couleur = "";
        //on stocke dans couleur la couleur choisit par l'utilisateur
        RadioButton radioB = (RadioButton) findViewById(R.id.radioBleu);
        RadioButton radioRouge = (RadioButton) findViewById(R.id.radioRouge);
        RadioButton radioN = (RadioButton) findViewById(R.id.radioNoir);
        RadioButton radioRose = (RadioButton) findViewById(R.id.radioRose);
        if (radioB.isChecked())
        {
            couleur = "bleu";
        }
        else if (radioRouge.isChecked())
        {
            couleur = "rouge";
        }
        else if (radioN.isChecked())
        {
            couleur = "noir";
        }
        else if (radioRose.isChecked())
        {
            couleur = "rose";
        }
        editor.putString("couleur", couleur);

        editor.commit();
    }

    /* ouvre une alerte qui donne des indications à l'utilisateur si
    il clique sur le bouton "?" */
    public void ouvrirHelp(View v)
    {
        String msg = "Difficulté :\n-> 1 étoile = facile : 5 vies et 2 jokers à chaque question" +
                "\n-> 2 étoiles = normal : 3 vies et 2 jokers pour le jeu\n" +
                "-> 3 étoiles = difficile : 1 seule vie et aucun joker" +
                "\nLa difficulté n'influence pas le  score, voyez-la comme un challenge." +
                "\n\nVous pouvez choisir la couleur de fond des réponses parmi 4 couleurs proposées.";
        AlertDialog.Builder monAlerte = new AlertDialog.Builder(this);
        monAlerte.setIcon(android.R.drawable.ic_menu_help);
        monAlerte.setTitle("Détails des options");
        monAlerte.setMessage(msg);
        monAlerte.setPositiveButton("Fermer", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        monAlerte.create();
        monAlerte.show();
    }

    //appel de la fonction saveOptions et retour à la MainActivity
    public void returnMain(View v)
    {
        saveOptions();
        Intent intent = new Intent(this,MainActivity.class);
        this.startActivity(intent);
    }

    /* si l'utilisateur clique sur le bouton Retour de son téléphone alors
    la fonction saveOptions est appelée avant de finir l'activité */
    @Override
    public void onBackPressed()
    {
        saveOptions();
        finish();
    }

}
