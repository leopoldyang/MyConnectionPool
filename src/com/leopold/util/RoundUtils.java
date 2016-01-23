package com.leopold.util;

import java.util.Random;

/**
 * Created by Administrator on 2015/10/23.
 */
public class RoundUtils {
    private static final  String[] hanzi={"年","文","章","和","马","伊","琍","首","次","合","作","锦","衣","卫","二","人","因","此","剧","相","识","并","成","为","朋","友","年","电","视","剧","奋","斗","开","拍","马","伊","琍","和","文","章","再","度","合","作","并","都","出","演","其","中","的","主","要","角","色","工","作","中","的","频","繁","接","触","使","得","两","由","朋","友","变","成","恋","人",
            "年","结","婚","女","儿","文","君","竹","出","的","生","日","为","庆","生","并","再","次","求","婚",
            "发","起","大","福","自","闭","症","关","爱","基","金","成","立","简","称","以","电","影","海","洋","天","堂","中","男","主","角","名","出","演","公","益","出","演","公","益"};
    private static final String daxie="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String xiaoxie="abcdefghijklmnopqrstuvwxzy";
    private static final String shuzi="0123456789";
    private static final Random ra=new Random();
    public static int getSex(){
       return  new Random().nextInt(2)+1;
    }
    public static String getNo(){
        char[] chars=daxie.toCharArray();
        char c1=chars[ra.nextInt(26)];
        char c2=chars[ra.nextInt(26)];
        return String.valueOf(c1)+String.valueOf(c2)+String.valueOf(System.currentTimeMillis());
    }
    public static String getHanzi(int length){
        StringBuffer sb=new StringBuffer(hanzi[ra.nextInt(hanzi.length)]);
        for(int i=0;i<length-1;i++){
            sb.append(hanzi[ra.nextInt(hanzi.length)]);
        }
        return sb.toString();
    }
    public static String getUname(){
        char[] chars=xiaoxie.toCharArray();
        StringBuffer sb=new StringBuffer(chars[ra.nextInt(26)]);
        for (int i=0;i<7;i++){
            sb.append(chars[ra.nextInt(26)]);
        }
        return sb.toString();
    }
    public static String getNum(int length){
        char[] chars=shuzi.toCharArray();
        StringBuffer sb=new StringBuffer(chars[ra.nextInt(10)]);
        for (int i=0;i<length;i++){
            sb.append(chars[ra.nextInt(10)]);
        }
        return sb.toString();
    }
}
