package com.arthur.fr.rugbyvitre.enumeration;

public enum Poste {
    PREMIERELIGNE, DEUXIEMELIGNE, TROISIEMELIGNE, DEMIMELEE, DEMIOUVERTURE, TROISQUARTSCENTRE, AILIERS, ARRIERE;

    public static boolean contains(String value){
        boolean ret = false;
        for (Poste poste : Poste.values()){
            if(poste.toString().equals(value)){
                ret = true;
            }
        }
        return ret;
    }
}
