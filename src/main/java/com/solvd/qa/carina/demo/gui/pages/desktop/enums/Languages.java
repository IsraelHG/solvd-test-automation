package com.solvd.qa.carina.demo.gui.pages.desktop.enums;

public enum Languages {
    DEUTSCH("langtde"),
    ENGLISH("langten"),
    SPANISH("langtes"),
    FRENCH("langtfr"),
    ITALIAN("langtit"),
    POLISH("langtpl"),
    PORTUGUESE_PT("langtpt-PT"),
    PORTUGUESE_BR("langtpt-BR"),
    RUSSIAN("langtru"),
    ARABIC("langtar"),
    TURKISH("langttr"),
    KOREAN("langtko"),
    JAPANESE("langtja"),
    THAI("langtth");
    // There are more languages, but this is a small example pool.

    private final String id;

    Languages(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}