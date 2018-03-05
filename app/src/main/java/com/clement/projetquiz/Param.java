package com.clement.projetquiz;

import java.util.ArrayList;

/**
 * Created by Clement on 26/03/2015.
 */

/* Dans Param on a : le score de l'utilisateur (ou nombres de points),
le nombre de vies, la liste de questions et le total de questions. */
public class Param {
    public static int Score;
    public static int Vies;
    public static ArrayList<Question> listQuestions;
    public static int total;

    //constructeur de Param qui prend en paramètres d'entrée la catégorie et la difficulté
    public Param(String catego, int diffi)
    {
        Score = 0;

        // diffi est la difficulté, on met le nombre de vies en fonction de la difficulté
        if (diffi == 1)
        {
            Vies = 5;
        }
        else if (diffi == 2)
        {
            Vies = 3;
        }
        else if (diffi == 3)
        {
            Vies = 1;
        }

        //on donne à l'utilisateur les questions correspondant à la catégorie qu'il a choisi
        if (catego.equals("culture"))
        {
            listQuestions = new ArrayList<Question>() {{
                add(new Question("Quelle est la couleur du cheval blanc d'Henry IV ?", "blanc", "rouge", "vert", "gris", 'a'));
                add(new Question("Quand a eu lieu la Révolution Française?", "1987", "1789", "1978", "1897", 'b' ));
                add(new Question("Dates de la Seconde Guerre Mondiale ?", "1940-1945", "1939-1944", "1939-1945", "1939-1946", 'c'));
                add(new Question("Laquelle de ces propositions est considérée comme le 13 ème signe du zodiaque ?",
                        "héritière", "draumadaire", "théière", "serpentaire", 'd' ));
                add(new Question("Que signifie GMT ?", "Greenwich Mean Time", "Greenwich Meridian Time",
                        "Greenwich Mondial Time", "Greenwich Mean Troll", 'a'));
                add(new Question("Quel est le prénom de César ?", "Jules", "Caïus", "Jean", "Alexandre", 'b'));
                add(new Question("En maths i² = ?", "1", "42", "-1", "12", 'c'));
                add(new Question("Quelle est la catégorie du palmier ?", "arbres", "plantes grimpantes", "algues", "herbes géantes", 'd'));
                add(new Question("Quelle est la capitale de l'Australie ?", "Canberra", "Sydney", "Melbourne", "Munich", 'a'));
                add(new Question("Quelle couleur n'est pas primaire ?", "rouge", "blanche", "jaune", "bleu", 'b'));
                add(new Question("Chez l'Homme combien de % d'os sont situés dans les pieds ?", "15%", "20%", "25%", "30%", 'c'));
                add(new Question("Comment s'appellent les habitants du Guatelama ?", "Guatémaliens", "Guatémalais",
                        "Guatémalis", "Guatémaltèques", 'd'));
                add(new Question("Quelle est la 5ème saveur de base ?", "umami", "alcool", "fade", "crémeux", 'a'));
                add(new Question("Quel est le naufrage le plus important ?", "Titanic", "Lancastria", "Victoria", "Costa", 'b'));
                add(new Question("Quel pays n'est pas un pays fondateur de l'Union Européenne ?", "Belgique", "Italie", "Royaume-Uni", "Luxembourg", 'c'));
                add(new Question("A quel âge est la majorité sexuelle en Espagne ?", "13", "14", "15", "16", 'a'));
                add(new Question("Quel est le vrai nom de Chuck Norris ?", "Charlie Norris", "Carlos Ray Norris", "Charles Norris", "Claude Norris", 'b'));
                add(new Question("Par combien de tunnel(s) sont reliés la France et l'angleterre ?", "1", "2", "3", "4", 'c'));
                add(new Question("Où est né Einstein ?", "Autriche", "France", "Allemagne", "Suisse", 'c'));
                add(new Question("Combien de temps a duré la guerre de 100 ans ?", "100", "108", "112", "116", 'd'));
                add(new Question("Quelle est la bonne ortographe du mot ?", "mer tyrhénienne", "mer tyrrhénienne",
                        "mer tyrrénienne", "mer tirrhénienne", 'b'));
                add(new Question("Combien un humain a-t-il de paire de côtes ?", "8", "10", "12", "14", 'c'));
                add(new Question("Lequel de ces éléments n'est pas un fruit ?", "Tomate", "Piment", "Ananas", "Petits Pois", 'd'));
                add(new Question("Quel couple est un couple de nombres premiers ?", "(19;71)", "(11;22)", "(8,15)", "(42;97)", 'a'));
                add(new Question("Qui a ecrit Les Misérables ?", "Emile Zola", "Victor Hugo", "Jean Luc", "Georges Gustave", 'b'));
                add(new Question("De quel animal les Iles Canaries tiennent-elles leur nom ?", "canari", "chat", "chien", "canard", 'c'));
                add(new Question("Laquelle de ces propositions n'est pas une marque ?", "Jacuzzi", "Klaxon", "Jaguar", "Tomate", 'd'));
                add(new Question("Comment s'appelle le symbole # ?", "croisillon", "dièse", "hashtag", "4-barres", 'a'));
                add(new Question("Quelle est la première lettre des billets de banque de France ?", "F", "U", "X", "C", 'b'));
            }};
        }
        else if (catego.equals("info"))
        {
            listQuestions = new ArrayList<Question>() {{
                add(new Question("Quand a été créé Microsoft Corporation ?", "1975", "1976", "1977", "1978", 'a'));
                add(new Question("Quel est le plus ancien système d'exploitation ?", "MSDOS", "UNIX", "Linux", "Mac OS", 'b'));
                add(new Question("Lequel de ces constructeurs a sorti la tablette tactile en premier ?", "HP", "Asus", "Apple", "Samsung", 'c'));
                add(new Question("Laquelle de ces propositions n'est pas un langage de programmation ?", "Java", "Python", "Ruby", "Sapphire", 'd'));
                add(new Question("En quel langage est codé le noyau d'UNIX ?", "C", "C++", "C--", "C#", 'a'));
                add(new Question("Quel est le raccourci pour rechercher ?", "ctrl + c", "ctrl + f", "ctrl + v", "ctrl + z", 'b'));
                add(new Question("Combien y a-t-il d'IP différentes en IPv4 ?", "1,1 milliards", "2,1 milliards", "4,3 milliards", "8,6 milliards", 'c'));
                add(new Question("Combien faut-il d'octet pour stocker un double ?", "2", "4", "6", "8", 'd'));
                add(new Question("Lequel de ses protocole n'est pas sécurisé ?", "HTTP", "SFTP", "HTTPS", "SSH", 'a'));
                add(new Question("Quelle est la commande pour créer un dossier sous Linux ?", "mkfil", "mkdir", "mkdo", "mkmk", 'b'));
                add(new Question("Android est basé sur un : ", "Linux OS", "MSDOS", "noyau Linux", "iOS", 'c'));
                add(new Question("Qui n'est pas un IDE ?", "Eclipse", "Netbeans", "Code::Blocks", "Java", 'd'));
                add(new Question("Laquelle de ses distributions n'est pas basée sur Débian ?", "Fedora", "Ubuntu", "Xandros", "Linspire", 'a'));
                add(new Question("Quelle commande Windows permet de savoir son adresse IP ?", "monip", "ipconfig", "ifconfig", "myip", 'b'));
                add(new Question("Que signifie RAM ?", "Root Access Memory", "Random Arbitrary Memory",
                        "Random Access Memory", "Random Access Mouse", 'c'));
                add(new Question("Que fait le raccourcis Windows + L ?", "ferme la session", "éteint le PC", "veille prolongée", "verouille la session", 'd'));
                add(new Question("Quel acronyme désigne les techniques permettant de répartir des données sur plusieurs disques durs ?",
                        "RAID", "ROAD", "RIMP", "ROAH", 'a'));
                add(new Question("De combien de bits est composée une adresse MAC ?", "46 bits", "48 bits", "50 bits", "52 bits", 'b'));
                add(new Question("Laquelle de ses propositions n'est pas une couche OSI ?", "Application", "Session", "Sécurité", "Transport", 'c'));
                add(new Question("Quelle est la taille d'un octet?", "2 bits", "4 bits", "6 bits", "8 bits", 'd'));
            }};
        }
        else if (catego.equals("jeux"))
        {
            listQuestions = new ArrayList<Question>() {{
                add(new Question("Qui est le premier Pokémon du Pokédex ?", "Bulbizarre", "Mew", "Salameche", "Carapuce", 'a'));
                add(new Question("Comment s'appelle le héros de Half Life ?", "Morgan Freeman", "Gordon Freeman", "Georges Freeman", "Gab Freeman", 'b'));
                add(new Question("Quand est sorti le premier jeu Pokémon ?", "1994", "1995", "1996", "1997", 'c'));
                add(new Question("Quelle est la première console portable de Nintendo ?", "Game Boy", "PlayStation Portable", "Famicom", "Game and Watch", 'd'));
                add(new Question("Comment s'appelle l'IA qui dirige le centre dans Portal ?", "GLaDOS", "GLeDOS", "GLiDOS", "GLoDOS", 'a'));
                add(new Question("Comment s'appelle le frère du célèbre plombier Mario ?", "Silvio", "Luigi", "Wario", "Boo", 'b'));
                add(new Question("Comment s'appelle le robot dans la série de jeu Borderlands ?", "C3PO", "R2D2", "Claptrap", "Terminator", 'c' ));
                add(new Question("Qui est le héros de The Legend of Zelda ?", "Zelda", "Mario", "Midona", "Link", 'd' ));
                add(new Question("Quel est la particularité du héros Kirby ?", "tout aspirer", "aveugle", "bleu", "très grand", 'a' ));
                add(new Question("Lequel de ces jeux se joue sans dé ?", "Trivial Poursuit", "Le nain jaune", "Les petits chevaux", "La bonne paye", 'b' ));
                add(new Question("Combien de cartes sont présentes dans un jeu Uno ?", "58", "78", "108", "156", 'c' ));
                add(new Question("Combien de \"E\" sont présents dans le Scrabble ?", "12", "13", "14", "15", 'd' ));
                add(new Question("Dans quel jeu de cartes l'As est le plus fort ?", "Bridge", "Tarot", "Président", "Le nain jaune", 'a' ));
                add(new Question("Lequel de ces jeux n'est pas dans la Française Des Jeux ?", "Loto", "PMU", "Euro Millions", "Illiko", 'b' ));
                add(new Question("Qui présente \"Qui veut gagner des millions\" ?", "Laurence Buccolini", "Julien Lepers",
                        "Jean-Pierre Foucault", "Cristophe Dechavanne", 'c' ));
                add(new Question("Dans quel jeu est présent l'Excuse ?", "La bataille", "Poker", "Blackjack", "Tarot", 'd' ));
                add(new Question("Quelle est la rue la plus chère du Monopoly ?", "Rue de la Paix", "Rue de Vaugirard",
                        "Rue de Paradis", "Avenue des Champs-Elysées", 'a' ));
                add(new Question("Dans quel GTA était présent le célèbre héros Carl Johnson ?", "GTA 3", "San Andréas", "GTA 4", "GTA 5", 'b' ));
                add(new Question("Dans un jeu de cartes traditionnel quel roi est représenté de profil ?", "trèfle", "pique", "carreau", "coeur", 'c' ));
                add(new Question("Quel est le genre de la série Final Fantasy ?", "simulation", "STR", "FPS", "RPG", 'd' ));
            }};
        }

        /* on stocke le nombre total de questions pour la catégorie choisi,
        on s'en servira dans ResultatsActivity */
        total = listQuestions.size();
    }
}
