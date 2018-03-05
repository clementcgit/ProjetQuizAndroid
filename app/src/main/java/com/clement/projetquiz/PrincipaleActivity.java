package com.clement.projetquiz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class PrincipaleActivity extends ActionBarActivity {

    int difficulte = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principale);

        SharedPreferences sp = getSharedPreferences("optionPref", 0);

        /* on stocke dans la variable difficulté la difficulté choisi par l'utilisateur
        dans les Options, si on ne la trouve pas elle est mise à 2 */
        int diffi = sp.getInt("diffi", 2);
        if (diffi == 1)
        {
            difficulte = 1;
        }
        if (diffi == 2)
        {
            difficulte = 2;
        }
        if (diffi == 3)
        {
            difficulte = 3;
        }

         /* on met la couleur de fond des réponses en prennant celle choisi
        par l'utilisateur dans les Options, si on ne la trouve pas c'est bleu */
        String couleur = sp.getString("couleur", "bleu");
        Button boutonA = (Button) findViewById(R.id.rA);
        Button boutonB = (Button) findViewById(R.id.rB);
        Button boutonC = (Button) findViewById(R.id.rC);
        Button boutonD = (Button) findViewById(R.id.rD);
        switch (couleur)
        {
            case "bleu":
                boutonA.setBackgroundColor(Color.parseColor("#000064"));
                boutonB.setBackgroundColor(Color.parseColor("#000064"));
                boutonC.setBackgroundColor(Color.parseColor("#000064"));
                boutonD.setBackgroundColor(Color.parseColor("#000064"));
                break;
            case "rouge":
                boutonA.setBackgroundColor(Color.parseColor("#640000"));
                boutonB.setBackgroundColor(Color.parseColor("#640000"));
                boutonC.setBackgroundColor(Color.parseColor("#640000"));
                boutonD.setBackgroundColor(Color.parseColor("#640000"));
                break;
            case "noir":
                boutonA.setBackgroundColor(Color.BLACK);
                boutonB.setBackgroundColor(Color.BLACK);
                boutonC.setBackgroundColor(Color.BLACK);
                boutonD.setBackgroundColor(Color.BLACK);
                break;
            case "rose":
                boutonA.setBackgroundColor(Color.parseColor("#9933CC"));
                boutonB.setBackgroundColor(Color.parseColor("#9933CC"));
                boutonC.setBackgroundColor(Color.parseColor("#9933CC"));
                boutonD.setBackgroundColor(Color.parseColor("#9933CC"));
                break;
        }

        /* si la difficulté est égale à 3 alors on enlève les jokers */
        if (difficulte == 3)
        {
            Button joker5050 = (Button)findViewById(R.id.j5050);
            Button jokerPublic = (Button)findViewById(R.id.jpublic);
            joker5050.setVisibility(View.GONE);
            jokerPublic.setVisibility(View.GONE);
        }

        StartGame();
    }

    int n = 0;
    /* le boolean b est a l'état "true" si l'utilisateur a cliqué sur le bouton "Joker 50/50"
    sinon il est a l'état "false" */
    boolean b = false;

    private void StartGame()
    {
        //on initialise les paramètres avec la catégorie choisit et la difficulté
        new Param(CategoriesActivity.catego, difficulte);
        poserQuestion();
        TextView t = (TextView) findViewById(R.id.sev);
        t.setText("Score : " + Integer.toString(Param.Score) + " Vies : " + Integer.toString(Param.Vies));
    }

    private void ouvrirResultats()
    {
        Intent intent = new Intent(this,ResultatsActivity.class);
        this.startActivity(intent);
    }

    private void poserQuestion()
    {
        if (Param.listQuestions.size() != 0)
        {
            /* si la liste de questions n'est pas vide alors on choisit aléatoirement une
            question  parmi la liste de questions */
            n = new Random().nextInt(Param.listQuestions.size());
            Button bA = (Button)findViewById(R.id.rA);
            Button bB = (Button)findViewById(R.id.rB);
            Button bC = (Button)findViewById(R.id.rC);
            Button bD = (Button)findViewById(R.id.rD);
            TextView tvi = (TextView)findViewById(R.id.question);

            /* on affiche la question dans le TextView question
            et les réponses dans les boutons réponses associées */
            tvi.setText(Param.listQuestions.get(n).getIntitule());
            bA.setText(Param.listQuestions.get(n).getRepA());
            bB.setText(Param.listQuestions.get(n).getRepB());
            bC.setText(Param.listQuestions.get(n).getRepC());
            bD.setText(Param.listQuestions.get(n).getRepD());
        }
        else
        {
            /* si il n'y a plus de questions dans la liste de questions alors
            on appelle la fonction ouvrirResultats */
            ouvrirResultats();
        }
    }

    private void gerant()
    {
        if (Param.Vies == 0)
        {
            //si le nombre de vies est égal à 0 alors on appelle la fonction ouvrirResultats
            ouvrirResultats();
        }

        else
        {
            poserQuestion();

            /* si l'utilisateur a cliqué sur le bouton "Joker 50/50" alors
            on remet tous les boutons en visible et on met b à l'état "false" */
            if (b == true)
            {
                Button bA = (Button)findViewById(R.id.rA);
                Button bB = (Button)findViewById(R.id.rB);
                Button bC = (Button)findViewById(R.id.rC);
                Button bD = (Button)findViewById(R.id.rD);
                bA.setVisibility(View.VISIBLE);
                bB.setVisibility(View.VISIBLE);
                bC.setVisibility(View.VISIBLE);
                bD.setVisibility(View.VISIBLE);
                b = false;
            }

            /* si la difficulté est à 1 alors on réactive les jokers
            à la fin de chaque question en les mettant en visible*/
            if (difficulte == 1)
            {
                Button joker5050 = (Button)findViewById(R.id.j5050);
                Button jokerPublic = (Button)findViewById(R.id.jpublic);
                if (joker5050.getVisibility() == View.INVISIBLE)
                {
                    joker5050.setVisibility(View.VISIBLE);
                }
                if (jokerPublic.getVisibility() == View.INVISIBLE)
                {
                    jokerPublic.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    public void gererOnClick(View v)
    {

        char rep = '\u0000'; //null character

        //rep stocke la reponse choisi par l'utilisateur
        if (v.getId() == R.id.rA)
        {
            rep = 'a';
        }
        else if (v.getId() == R.id.rB)
        {
            rep = 'b';
        }
        else if (v.getId() == R.id.rC)
        {
            rep = 'c';
        }
        else if (v.getId() == R.id.rD)
        {
            rep = 'd';
        }

        /* si la réponse chosi par l'utilisateur est bonne
        alors on incrémente son score */
        if (rep == Param.listQuestions.get(n).getBonneRep())
        {
            Param.Score++;
        }
        //sinon on décrémente son nombre de vies
        else
        {
            Param.Vies--;
        }

        //on affiche le score de l'utilisateur et son nombre de vies dans un TextView
        TextView t = (TextView) findViewById(R.id.sev);
        t.setText("Score : " + Integer.toString(Param.Score) + " Vies : " + Integer.toString(Param.Vies));

        Param.listQuestions.remove(n);
        gerant();
    }

    public void jokerPublic(View v)
    {
        char bonneRep = Param.listQuestions.get(n).getBonneRep();
        /*la bonne réponse a 40% de chance d'etre tirée, les autres ont 20% chacune */
        List<Character> listProba = new ArrayList<Character>();
        for (int i = 0; i < 4 ; i++)
        {
            //on ajouter dans listProba 4 fois la bonne réponse
            listProba.add(bonneRep);
        }
        //on ajoute dans listProba chaque mauvaise réponse 2 fois
        if (bonneRep == 'a')
        {
            listProba.add('b');
            listProba.add('b');
            listProba.add('c');
            listProba.add('c');
            listProba.add('d');
            listProba.add('d');
        }
        else if (bonneRep == 'b')
        {
            listProba.add('a');
            listProba.add('a');
            listProba.add('c');
            listProba.add('c');
            listProba.add('d');
            listProba.add('d');
        }
        else if (bonneRep == 'c')
        {
            listProba.add('a');
            listProba.add('a');
            listProba.add('b');
            listProba.add('b');
            listProba.add('d');
            listProba.add('d');
        }
        else if (bonneRep == 'd')
        {
            listProba.add('a');
            listProba.add('a');
            listProba.add('b');
            listProba.add('b');
            listProba.add('c');
            listProba.add('c');
        }

        /* on fixe le nombre de personnes dans le public à 100 pour pouvoir
        faire simplement des pourcentages */
        int nombrePersonnes = 100;

        List<Character> listLettres = new ArrayList<Character>();
        /* chaque personne choisit aléatoirement une lettre dans listProba,
        puis cette lettre est ajoutée à la liste de lettres listLettres */
        for(int i = 0; i < nombrePersonnes; i++)
        {
            int j = new Random().nextInt(10);
            listLettres.add(listProba.get(j));
        }

        /* on crée 4 compteurs : un pour chaque lettre de listLettre
        et on l'incrémente à chacune de ses occurences */
        int cpta = 0;
        int cptb = 0;
        int cptc = 0;
        int cptd = 0;
        for (char tempo : listLettres)
        {
            if(tempo == 'a')
            {
                cpta++;
            }
            else if(tempo == 'b')
            {
                cptb++;
            }
            else if(tempo == 'c')
            {
                cptc++;
            }
            else if (tempo == 'd')
            {
                cptd++;
            }
        }

        /*/ on met les pourcentages dans un message */
        String msg = "Le public pense que :\n";
        msg += "\""+Param.listQuestions.get(n).getRepA()+"\" : "+ cpta + "%\n"
                +"\""+Param.listQuestions.get(n).getRepB()+"\" : "+ cptb + "%\n"
                +"\""+Param.listQuestions.get(n).getRepC()+"\" : "+ cptc + "%\n"
                +"\""+Param.listQuestions.get(n).getRepD()+"\" : "+ cptd + "%\n";

        /*/ on met le message dans une alerte */
        AlertDialog.Builder monAlerte = new AlertDialog.Builder(this);
        monAlerte.setMessage(msg);
        monAlerte.setPositiveButton("Fermer", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        monAlerte.setIcon(android.R.drawable.ic_menu_send);
        monAlerte.setTitle("Avis du public");
        monAlerte.create();
        monAlerte.show();
        Button joker = (Button)findViewById(R.id.jpublic);
        if (difficulte == 1)
        {
            joker.setVisibility(View.INVISIBLE);
        }
        else if (difficulte == 2)
        {
            joker.setVisibility(View.GONE);
        }
    }

    public void joker5050(View v)
    {
        Button bA = (Button)findViewById(R.id.rA);
        Button bB = (Button)findViewById(R.id.rB);
        Button bC = (Button)findViewById(R.id.rC);
        Button bD = (Button)findViewById(R.id.rD);
        char bonneRep = Param.listQuestions.get(n).getBonneRep();

        /* si la bonne réponse est 'a' alors aléatoirement deux des boutons parmi
        les trois autres seront mis en non cliquables
        même raisonnement si la bonne réponse est une autre lettre */
        if (bonneRep == 'a')
        {
            List<Button> lb = new ArrayList<Button>();
            lb.add(bB);
            lb.add(bC);
            lb.add(bD);
            for (int i = 0; i < 2; i++)
            {
                int j = new Random().nextInt(lb.size());
                lb.get(j).setVisibility(View.INVISIBLE);
                lb.remove(j);
            }
        }
        else if (bonneRep == 'b')
        {
            List<Button> lb = new ArrayList<Button>();
            lb.add(bA);
            lb.add(bC);
            lb.add(bD);
            for (int i = 0; i < 2; i++)
            {
                int j = new Random().nextInt(lb.size());
                lb.get(j).setVisibility(View.INVISIBLE);
                lb.remove(j);
            }
        }
        else if (bonneRep == 'c')
        {
            List<Button> lb = new ArrayList<Button>();
            lb.add(bA);
            lb.add(bB);
            lb.add(bD);
            for (int i = 0; i < 2; i++)
            {
                int j = new Random().nextInt(lb.size());
                lb.get(j).setVisibility(View.INVISIBLE);
                lb.remove(j);
            }
        }
        else if (bonneRep == 'd')
        {
            List<Button> lb = new ArrayList<Button>();
            lb.add(bA);
            lb.add(bB);
            lb.add(bC);
            for (int i = 0; i < 2; i++)
            {
                int j = new Random().nextInt(lb.size());
                lb.get(j).setVisibility(View.INVISIBLE);
                lb.remove(j);
            }
        }
        Button joker = (Button)findViewById(R.id.j5050);
        if (difficulte == 1)
        {
            joker.setVisibility(View.INVISIBLE);
        }
        else if (difficulte == 2)
        {
            joker.setVisibility(View.GONE);
        }
        b = true;
    }

}
