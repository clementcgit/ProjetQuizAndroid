package com.clement.projetquiz;

/**
 * Created by Clement on 04/04/2015.
 */

/* définition de la classe Question
Une question a 5 String : un intitulé, une réponse A, une réponse B, une réponse C et une réponse D
on stocke la bonne réponse dans un char*/

public class Question
{
    private String intitule;
    private String repA;
    private String repB;
    private String repC;
    private String repD;
    private char bonneRep;

    //constructeur de Question
    public Question(String intitule, String repA, String repB, String repC, String repD, char bonneRep)
    {
        this.intitule = intitule;
        this.repA = repA;
        this.repB = repB;
        this.repC = repC;
        this.repD = repD;
        this.bonneRep = bonneRep;
    }

    //ci-dessous définition des getters :
    public String getIntitule()
    {
        return intitule;
    }
    public String getRepA()
    {
        return repA;
    }
    public String getRepB()
    {
        return repB;
    }
    public String getRepC()
    {
        return repC;
    }
    public String getRepD()
    {
        return repD;
    }
    public char getBonneRep()
    {
        return bonneRep;
    }
}
