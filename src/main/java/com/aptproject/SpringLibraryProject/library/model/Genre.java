package com.aptproject.SpringLibraryProject.library.model;

public enum Genre {
    FANTASY ("Фантастика"),

    SCIENCE_FICTION("Научная фантастика"),

    DRAMA("Драма"),

    NOVEL("Роман"),

    ADVENTURE("Приключения");

    private final String genreTextDisplay;


    Genre(String genreTextDisplay) {
        this.genreTextDisplay = genreTextDisplay;
    }

    public String getGenreTextDisplay(){
        return genreTextDisplay;
    }
}
