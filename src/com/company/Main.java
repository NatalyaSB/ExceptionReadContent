package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static class UrlReader {
     //Reading Directly from a URL
        public  void readContent(String url) throws Exception {

            URL oracle = new URL(url);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(oracle.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);
            in.close();
        }
        public static boolean isURL(String url) throws Exception  {
            //эта функция проверяет URL и возвращает true (допустимый URL) или false (недопустимый URL).
            try {
                new URL(url);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }
    public static void main(String[] args) throws Exception {
	//
        Scanner in = new Scanner(System.in);
        System.out.println("Введите URL:");
        String url=in.next();
        Boolean bln=false;
        UrlReader urlReader=new UrlReader();
        while (!bln){
            try {
                if (urlReader.isURL(url)) {
                    urlReader.readContent(url);
                    bln=true;
                }
                else bln=false;
            }
            catch ( Exception ex) {
                System.out.println("Exception! Введите URL:");
                url=in.next();
                bln=false;
            }
        }
    }
}
