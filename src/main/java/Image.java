import sun.misc.BASE64Decoder;

import java.awt.*;
import java.io.IOException;
import java.util.concurrent.ThreadPoolExecutor;

public class Image {
    public static void main(String... args) throws IOException {
        String ss = "279669\t陈沛聪\n" +
                "289395\t刘志华\n" +
                "298300\t柳思羽\n" +
                "365474\t张东旭\n" +
                "365475\t黄建东\n" +
                "381512\t黄允斌\n" +
                "413576\t姚佳\n" +
                "413577\t孙艳\n" +
                "436266\t陈志刚\n" +
                "440134\t李媛婷\n" +
                "446436\t袁慧静\n" +
                "446438\t叶碧欣\n" +
                "446440\t钟玉风\n" +
                "446452\t王可萍\n" +
                "446456\t余亚\n" +
                "448867\t王燕\n" +
                "472929\t洪倩倩\n" +
                "472930\t刘永霞\n" +
                "494228\t吴国鹏\n" +
                "497697\t杨菊花\n" +
                "525724\t黄晋伟\n" +
                "529589\t刘建彬\n" +
                "564047\t廖焜\n" +
                "571467\t梁慰\n" +
                "618099\t王锋锐\n" +
                "618103\t黄继标\n" +
                "620737\t谢丹\n" +
                "621856\t陈岚\n" +
                "624483\t丁文俊\n" +
                "645516\t夏丰\n" +
                "653555\t邱碧娟\n" +
                "663290\t陈涛\n" +
                "671700\t黎健\n" +
                "678366\t曾秀秀\n" +
                "678824\t李秋花\n" +
                "707141\t俞国华\n" +
                "718650\t余娜\n" +
                "753651\t申亚龙\n" +
                "3701199\t廖婷婷\n" +
                "4578020\t李媛婷\n" +
                "4578021\t姚佳\n" +
                "4578023\t张雅祺\n" +
                "4685578\t林艳玲\n" +
                "4752078\t边春梅\n" +
                "17710056\t王晔\n" +
                "17710059\t张建国\n" +
                "17710061\t汪晓丹\n" +
                "17710064\t叶善容\n" +
                "17710066\t杨洁\n" +
                "17710077\t吴小兰\n" +
                "17729959\t程海艳\n" +
                "27588369\t刘志华\n" +
                "27629826\t戴双燕\n" +
                "27629828\t肖俊萍\n" +
                "27701286\t金俐";
        /*String str = "";
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] b = decoder.decodeBuffer(str);*/
        /*System.out.println(Color.WHITE.getRGB());
        System.out.println("" + Color.WHITE);
        String ssss = "[2,3,4]";
        System.out.println(ssss.substring(1,ssss.length()-1));;*/
        //ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();

        String[] s = ss.split("\n");
        for(int i = 0; i < s.length; i++){
            //insert into broker_outsource_user set name='257332' where cname='陈斌'
            String a = s[i];
            String[] pp = a.split("\t");
            System.out.println("update broker_outsource_user set name='" + pp[0] + "' where cname='" + pp[1] + "';");

        }
    }
}
