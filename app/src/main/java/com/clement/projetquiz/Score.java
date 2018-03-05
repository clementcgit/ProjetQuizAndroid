package com.clement.projetquiz;

/**
 * Created by Clement on 04/04/2015.
 */

/* définition de la classe Score qui sera utilisée dans TableauActivity
elle contient le nombre de points, le pseudo de l'utilisateur et la catégorie */

public class Score implements Comparable<Score>
{
    private int nbPts;
    private String pseudo;
    private String categorie;

    //constructeur de Score
    public Score(int nbPts, String pseudo, String categorie)
    {
        this.nbPts = nbPts;
        this.pseudo = pseudo;
        this.categorie = categorie;
    }

    /* redéfinition de l'opérateur compareTo pour comparer les Scores
    on trie d'abord par catégorie, ensuite par nombre de points */
    @Override
    public int compareTo(Score s)
    {
        int str = categorie.compareTo(s.categorie);
        int resultat = nbPts > s.nbPts ? -1 : nbPts > s.nbPts ? 1 : 0;
        return str+resultat;
    }

    //définition des getters :
    public int getNbPts()
    {
        return nbPts;
    }
    public String getPseudo()
    {
        return pseudo;
    }
    public String getCategorie()
    {
        return categorie;
    }

}