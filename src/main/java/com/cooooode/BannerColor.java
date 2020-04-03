package com.cooooode;

public enum BannerColor {
    /*
    控制台打印颜色
     */
    Red("\033[31;0m","\033[0m"),
    Green("\033[32;0m","\033[0m"),
    Yellow("\033[33;0m","\033[0m"),
    Blue("\033[34;0m","\033[0m"),
    Purple("\033[35;0m","\033[0m");

    private String prefix;
    private String suffix;
    private BannerColor(String prefix  ,String suffix){
        this.prefix=prefix;
        this.suffix=suffix;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }
}
