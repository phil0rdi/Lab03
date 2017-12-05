package com.example.philippe.lab08;

/**
 * Created by Philippe on 2017-12-02.
 */

public class Unite {
    private String name;
    private String nbBananas;
    private final int adresseImage = R.drawable.scale;

    public int getAdresseImage() {
        return adresseImage;
    }

    public Unite(String name, String nbBananas) {
        this.name = name;
        this.nbBananas = nbBananas;
    }

    public String getName() {
        return name;
    }

    public String getNbBananas() {
        return nbBananas;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNbBananas(String nbBananas) {
        this.nbBananas = nbBananas;
    }
}
