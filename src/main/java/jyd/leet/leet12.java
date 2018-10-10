package jyd.leet;

import java.io.UnsupportedEncodingException;

public class leet12 {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String aName = "http://fpriv.17doubao.com/test/policyContract/png/2018%E5%B9%B408%E6%9C%8825/%E8%AF%AD%E9%9F%B3_20180825024332480.png?Expires=1535265812&OSSAccessKeyId=obTuyP8GflR8U3nO&Signature=WjeWtttfRtA/Ioh1r2cPXQyFyY4%3D";
        //String newName=new String(aName.getBytes(),"GBK");

        int index = aName.indexOf("?");
        String fileName = aName.substring(0, index);
        fileName = fileName.substring(fileName.lastIndexOf("/")+1);
        //System.out.println("newName ==== " + newName);
        //fileName = aName.substring(aName.lastIndexOf("/")+1, index);
        System.out.println(fileName);
    }


    public static int romanToInt(String s) {
        char[] ss = s.toCharArray();

        return 0;
    }
}
