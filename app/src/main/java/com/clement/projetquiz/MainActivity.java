package com.clement.projetquiz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ouvrirQuestions(View v){
        Intent intent = new Intent(this,CategoriesActivity.class);
        this.startActivity(intent);
    }

    public void ouvrirScores(View v){
        Intent intent = new Intent(this,TableauActivity.class);
        this.startActivity(intent);
    }

    public void ouvrirOptions(View v){
        Intent intent = new Intent(this,OptionsActivity.class);
        this.startActivity(intent);
    }

    /* définition d'une alerte qui se déclenche si l'utilisateur clique
    sur le bouton Retour de son téléphone */
    @Override
    public void onBackPressed() {
        AlertDialog.Builder monAlerte = new AlertDialog.Builder(this);
        monAlerte.setIcon(android.R.drawable.ic_dialog_alert);
        monAlerte.setTitle("Fermeture de l'application");
        monAlerte.setMessage("Etes vous sûr de vouloir fermer le jeu ?");
        monAlerte.setPositiveButton("Oui", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });
        monAlerte.setNegativeButton("Non", null);
        monAlerte.create();
        monAlerte.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        /* si l'utilisateur clique sur "A propos" dans le munu alors il sera redirigé vers
        l'activité AboutActivity */
        if (id == R.id.action_aPropos) {
            Intent intent = new Intent(this,AboutActivity.class);
            this.startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

}
