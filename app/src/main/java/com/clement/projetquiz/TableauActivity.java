package com.clement.projetquiz;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import static com.clement.projetquiz.Constantes.FIRST_COLUMN;
import static com.clement.projetquiz.Constantes.SECOND_COLUMN;
import static com.clement.projetquiz.Constantes.THIRD_COLUMN;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;

public class TableauActivity extends Activity {

    ArrayList<HashMap<String, String>> maList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tableau);

        /* dès que l'utilisateur arrive dans le tableau des scores,
        le tableau des scores est déjà rempli et trié */
        ListView lv = (ListView) findViewById(R.id.monTableau);
        remplir();
        listviewAdapter adapter = new listviewAdapter(this, maList);
        lv.setAdapter(adapter);
    }

    public void viderTab(View v)
    {
        AlertDialog.Builder monAlerte = new AlertDialog.Builder(this);
        monAlerte.setIcon(android.R.drawable.ic_menu_delete);
        monAlerte.setTitle("Reset scores");
        monAlerte.setMessage("Etes vous sûr de vouloir supprimer tout l'historique des scores ?");
        monAlerte.setPositiveButton("Oui", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //si l'utilisateur clique sur "Oui" alors la fonction purge est appelée
                purge();
            }
        });
        //si l'utilisateur clique sur "Non" l'alerte se ferme sans rien faire d'autre
        monAlerte.setNegativeButton("Non", null);
        monAlerte.create();
        monAlerte.show();
    }

    //sert à vider le tableau des scores
    private void purge()
    {
        SharedPreferences sharedPref= getSharedPreferences("mypref", 0);
        SharedPreferences.Editor editor= sharedPref.edit();
        editor.clear();
        editor.commit();
        remplir();
        ListView lv = (ListView) findViewById(R.id.monTableau);
        listviewAdapter adapter = new listviewAdapter(this, maList);
        lv.setAdapter(adapter);
    }

    /* sert à remplir le tableau des scores avec les données prises de la SharedPreferences mypref
    qui contient les catégories, les scores et les pseudos des utilisateurs */
    private void remplir()
    {
        List<Score> listScores = new ArrayList<Score>();

        SharedPreferences sharedPref= getSharedPreferences("mypref", 0);
        int cpt = 0;
        //on remplit listScores
        while (sharedPref.getString("pseudo"+cpt, null) != null)
        {
            listScores.add(new Score(sharedPref.getInt("score"+cpt, 0), sharedPref.getString("pseudo" + cpt, ""), sharedPref.getString("categorie"+cpt, "")));
            cpt++;
        }
        //on la trie (voir la redéfinition de compareTo dans la classe Score)
        Collections.sort(listScores);

        maList = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> tempo = new HashMap<String, String>();
        tempo.put(FIRST_COLUMN, "CATEGORIE");
        tempo.put(SECOND_COLUMN, "SCORE");
        tempo.put(THIRD_COLUMN, "PSEUDO");
        maList.add(tempo);

        //on remplit le tableau des scores
        for (Score s : listScores)
        {
            tempo = new HashMap<String, String>();
            tempo.put(FIRST_COLUMN, s.getCategorie());
            tempo.put(SECOND_COLUMN, Integer.toString(s.getNbPts()));
            tempo.put(THIRD_COLUMN, s.getPseudo());
            maList.add(tempo);
        }
    }

    public void retourner(View v)
    {
        Intent intent = new Intent(this,MainActivity.class);
        this.startActivity(intent);
    }

}
