package com.cooooode;

public enum BannerType {

    Ansi("Ansi", 6,217,new int[]{0,8,16,24,32,40,48,57,65,68,76,84,92,103,113,123,130,139,147,155,164,173,182,192,200,209,217}),
    Doom("Doom", 6,184,new int[]{0,7,14,21,28,35,42,49,56,63,70,77,84,92,99,106,113,120,127,134,141,148,155,163,170,177,184}),
    Crawford2("Crawford2", 7, 187, new int[]{0, 7, 14, 21, 28, 35, 42, 49, 56, 62, 69, 76, 83, 92, 99, 106, 113, 120, 127, 134, 142, 149, 156, 166, 173, 180, 187}),
    Modular("Modular",7,231,new int[]{0,9,18,27,36,45,54,63,72,77,86,95,104,113,122,131,140,149,159,168,177,186,195,204,213,222,231}),
    Graffiti("Graffiti",6,273,new int[]{0,11,22,33,44,55,66,77,88,93,103,113,123,134,145,156,167,178,189,200,211,221,232,244,253,263,273});

    private final String name;
    private final int row;
    private final int col;

    private final int[] position;

    private BannerType(String name, int row, int col, int[] position) {
        this.name = name;
        this.row = row;
        this.col = col;
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public int[] getPosition() {
        return this.position;
    }
}
