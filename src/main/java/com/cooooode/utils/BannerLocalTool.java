package com.cooooode.utils;

import com.cooooode.BannerColor;
import com.cooooode.BannerType;
import com.cooooode.annotation.Banner;

import java.io.*;
import java.net.URL;

/**
 * @program: banner
 * @description:
 * @author: vua
 * @create: 2020-01-19 19:11
 */
public class BannerLocalTool {
    private final static int MAX_LEN = 12;

    public static void printAfterGet(Banner banner, boolean save) {
        String name = banner.name();
        BannerType type = banner.type();
        BannerColor color = banner.color();
        int[] position = type.getPosition();

        String fileName = type.getName() + "/word";

        int row = type.getRow();
        int col = type.getCol();
        char[][] _banner = new char[row][name.length() * MAX_LEN];

        char[][] resource = load(fileName, row, col);
        int index;
        int buoy = 0;
        for (int i = 0; i < name.length(); i++) {
            index = name.substring(i, i + 1).toUpperCase().charAt(0) - 'A';
            for (int j = 0; j < row; j++) {
                for (int z = position[index]; z < position[index + 1]; z++) {
                    _banner[j][buoy + (z - position[index])] = resource[j][z];
                }

            }
            buoy += (position[index + 1] - position[index]);
        }
        System.out.print(color.getPrefix());
        for (char[] cs : _banner) {
            for (char c : cs) {
                if (c != 0)
                    System.out.print(c);
            }
            System.out.println();
        }
        System.out.print(color.getSuffix());
        if (save) save(name, type, _banner, buoy);
    }

    public static void save(String name, BannerType type, char[][] banner, int buoy) {
        createDir();
        String fileName = Thread.currentThread().getClass().getResource("/banner/").getPath() + name + "(" + type.getName() + ")";
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(new File(
                        fileName
                )))
        ) {
            for (char[] cs : banner) {
                writer.write(cs, 0, buoy);
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void createDir(){
        String dir=Thread.currentThread().getClass().getResource("/").getPath()+"/banner";
        File file=new File(dir);
        if(!file.exists())
            file.mkdir();
    }
    public static void print(Banner banner) {

        String name = banner.name();
        BannerType type = banner.type();
        BannerColor color = banner.color();
        String fileName = "banner/" + name + "(" + type.getName() + ")";
        try (
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(BannerLocalTool.class.getClassLoader().getResourceAsStream(fileName)));
        ) {
            String line = "";
            System.out.print(color.getPrefix());
            while ((line = reader.readLine()) != null) {
                System.out.println(line);

            }
            System.out.print(color.getSuffix());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static char[][] load(String fileName, int row, int col) {
        InputStream in = BannerLocalTool.class.getClassLoader().getResourceAsStream(fileName);

        char[][] resource = new char[row][col];
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(in))
        ) {
            for (int i = 0; i < row; i++) {
                String line = reader.readLine();
                resource[i] = line.substring(0, col).toCharArray();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resource;
    }

    public static boolean exist(Banner banner) {
        String name = banner.name();
        BannerType type = banner.type();
        String fileName = "/banner/" + name + "(" + type.getName() + ")";

        URL url =Thread.currentThread().getClass().getResource(fileName);
        return url != null;
    }
}
