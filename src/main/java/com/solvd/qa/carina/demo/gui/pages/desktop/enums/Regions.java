package com.solvd.qa.carina.demo.gui.pages.desktop.enums;

public enum Regions {
    AFGHANISTAN("AF"),
    ARGENTINA("AR"),
    AUSTRALIA("AU"),
    BELIZE("BZ"),
    BOLIVIA("BO"),
    COLOMBIA("CO"),
    DENMARK("DK"),
    EGYPT("EG"),
    FINLAND("FI"),
    FRANCE("FR"),
    GERMANY("DE"),
    INDIA("IN"),
    JAPAN("JP"),
    RUSSIA("RU");
    // There are more regions, but this is a small example pool.

    private final String dataValue;

    Regions(String dataValue) {
        this.dataValue = dataValue;
    }

    public String getId() {
        return dataValue;
    }
}
