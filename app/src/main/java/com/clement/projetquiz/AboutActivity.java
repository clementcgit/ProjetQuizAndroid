package com.clement.projetquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class AboutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        donnerDescr();
    }

    public void donnerDescr()
    {
        //définition des règles du jeu
        TextView tv = (TextView) findViewById(R.id.txtDescr);
        String descr = "\n-> Chaque réponse a une et une seule bonne réponse\n" +
                " -> Vous devez toucher celle que vous considérez bonne\n" +
                " -> Vous avez à dispotion deux jokers pour vous aider";
        tv.setText(descr);
    };

    public void retourMain(View v)
    {
        Intent intent = new Intent(this,MainActivity.class);
        this.startActivity(intent);
    }

}
