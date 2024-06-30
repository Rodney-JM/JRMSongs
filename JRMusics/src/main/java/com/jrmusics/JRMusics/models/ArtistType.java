package com.jrmusics.JRMusics.models;

public enum ArtistType {
    SOLO("solo"),
    PAIR("pair"),
    BAND("band");

    private String artistType;

    ArtistType(String artistType){
        this.artistType = artistType;
    }

    public static ArtistType fromString(String text){
        for(ArtistType a : ArtistType.values()) {
            if (a.artistType.equalsIgnoreCase(text)) {
                return a;
            }
        }
        throw new IllegalArgumentException("This artist type don't exists, try again...");
    }
}
