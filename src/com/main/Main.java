package com.main;

import java.lang.reflect.Method;

public class Main {

    /*
    3. Génération nom de classe cpp
    4. Ajouter arguments
    5. Ajouter méthodes
     */
    public static void main(String[] args) {
        // 3 arguments possibles
        //1 -> Nom de la classe Java à traiter.
        if (args.length == 0) {
            System.out.println("Usage : java TP5 nomClassJava [nomClasseC++] [--stdout]");
            return;
        }
        String nomClasseJava = "com.isima.java.convertisseur." + args[0];
        String nomClasseCpp = args[0];
        boolean affichage = false;
        if (args.length == 2) {
            if (args[1].equals("--stdout")) {
                affichage = true;
            } else {
                nomClasseCpp = args[1];
            }
        } else if (args.length == 3) {
            if (args[1].equals("--stdout")) {
                affichage = true;
                nomClasseCpp = args[2];
            } else {
                affichage = true;
                nomClasseCpp = args[1];
            }
        }

        //Générer un .h et .cpp à partir du fichier class
        //Tous les attributs et définiton de méthodes dans le .h
        //Implémentation vide des méthodes dans le .cpp

        Class c;
        try {
            c = Class.forName(nomClasseJava);
        } catch (ClassNotFoundException e) {
            //Classe non trouvée
            System.out.println("Classe non trouvée");
            return;
        }



        System.out.println(c);
        System.out.println(c.getName());
        Method[] methods = c.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
    }
}
