/**
 * @(#)Test4.java, 3月 09, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jiyingda.test;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jiyingda
 */
public class Test4 {

    public static void main(String[] args) throws IOException {
        run();
    }

    public static void run() throws IOException {

        long st = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 4; i++) {
            executorService.execute(() -> {
                while (true) {
                    try {
                        doPost();
                        Thread.sleep(10);
                    } catch (UnirestException | InterruptedException e) {
                        System.out.println("error");
                    }
                    long et = System.currentTimeMillis();
                    if (et - st > 300000) {
                        System.out.println("============");
                        return;
                    }
                }
            });
        }

    }

    static String[] list = new String[]{
            "不是吃就是读","王世焘","借一条船去远方","昵称未设置","伴你多久","那些你跟冒险的梦","冯冯88","下一站z","xi敏-","周小杰","刘怡凡","lannon","朱俞维","抱紧一点","纵是举案齐眉","忠杰","剧已到终","我们家不拆","想好了再换","梦在手心在涯","梓健zz","404548741","哈皮咯","没有花香没有树高","kiaile","tsung","caiguotong","_why_","努力keep沉默","小琦77","从量变到质变","奋斗的学沫","第六冠","椅子的爱","王彦杰","俗哀","哈哈嘻嘻咦惹","刷题小能手","男子","杨翻书爱学习","旭日ye","yefeng","toshiba","香香小公主","努力努力不放弃","7sylvia","骚年崛起吧i","对大家思考","-冰冰","滴答滴答滴滴答答","hbbbxx","xzx小翔","大头锌","杨正华","c瓜","阿文cy","阳光之旅","我遇见了你","kevin旅","骨兒","zjmkebi","lu y5","继梦轻扬","青春依然堕落","杨沐蒽","fzh心如止水","天幻","ming12808","凋零-凋谢","绿岛小夜曲","像神一样的男生","levi_moore","emery","bad-things","韦霞霞","solo风","咆哮哥","临门一脚","董美怡","戏子m","向右或向左","朱宝萍","大家都加油吧","偶林曼","yes-i-do","李相宇","黯_念","玉菠","124格子","yzl1","zmone","你是傻叼","妤儿","ct123","yangp622","执殇绾青丝","zgaokai","vinnjia","君语焉","叫我福建","殇莫","瑶紫","luonnnn","参团子","gjzx","mikagg","软红","mengnan","jh5464","奇怪那么怪","哦恩","1彭思源1","浅鑫","郭小晨","f墨痕","漠简嫣","frown_","邓珺阳","李浩平","我有两个4","小薇儿","顾城的诗","吴橙子宝贝","欢欢成才sx","wanwanl","浅笑7","calvin-c","心有林夕l","乌镇柚28","entenal","朱明杰776825","杨大玲","想你的时候有些寂寞","张嘉木","深蓝年代","决算天下","李佳霖","学翔14翔","弱肉强食尼玛逼","菜鸟学神","幻影之梦","gfdhkbc","我是宝琳我要free","frf","mvp_zhong","培兴","提取哦耶","柠檬薄荷红茶","细细是我","凹凹11","无常山人","april_first","俊大帅","学霸郑子薇","sazikey","cqkhuntoria","赵浅汐","wbz","52la","洪鈺珍","流逝的年华wuu","为陈徐努力","进击的雪球","壮哉我大一中","吧咯计划","任我飞","一世春秋","w我不要做学渣","perfect情缘","telltheturth","学学学333333333","学霸_永不言败","李贤惠","水羽","柚小西","郭晟","rainie1","-gege","蘑茹","小小小小小瘦子","ttjz","l081","巴洛克先森","傻乎乎的你","司利剑","12346r","胖妮","波罗的海的风","紫色冰晶","妖妖ln","红姬","_atolis","傻叉叉","杨彬彬-","末日旋律","周殿清","imlina2","小不点r","先森沃芗旎","子丰","容我在等历史转身","我是学渣请不要这样","薪火之舞","v高考","我叫蛋蛋","captain阿铎","失无所失-","karl_zz","794申","艾瑟依拉姆","他不再","女神star","紫韵那些曾经","eason可尧李","郁小郁","王沫沫","被幻想妈妈宠坏的孩子","杨勇鑫","念www","啊噢啊","桐华","giants-win","放肆的青春jack","丿n丶z丨","yourths","京中天地","veronica_菲","3724","蘇打小姐","少儿部羊羊羊","就这样一直坚持下去","yaolx","坤宝贝","将心比心无语","abuse_","潇跪","你的属相变成风","年少恋歌","爱做梦的幻想家","镜中人人","歌小帆同学","sut林夕","吴海明106","学习l","为了跟你在一起","l蓝","暖曈","吾乃神明","iris-vip","爱me","墨安李浦仲在诗","深爱及海_","邱彤就是要上本科","爱sammy","我是学霸欣","凉凉凉凉凉初透","尘飞扬","fljgo","琉璃心愿","1coco","ufifif","有病的我","越来越近","陈欣悦","乐池","背后的蓝天","简囖","切糕小王子","638d","疯狂的学霸111","qwepoi","麝鹿i","tang3","烂泥巴cc","时间在左我在右","z辰","爱久久爱","神盾局的咸鱼","狐虎","xu瓜瓜","nnez罗莹莹","沒勇氣小姐i","lxy423","十四弟","把莉","龙猫8","g_y","ld飞鹰","楼墨","darblg","故城夜祷","落薇丶","nie情痴","2_darling","梁yt","change475","漂亮的学霸","画是无言的诗","何冰汐","午安丶","决战高考yang","失落的心","gyq要考大学","追逐23","雨后的向日葵","周子覃","刘锐瑛","g神","静空之夜","dyflpl","昔日的回忆","快乐心情","fy等我","heqiwen_","奋斗hard","我只想考到中山大学","酷毙的小鸟","future未来的我","am11","佳宾","假回眸","于广金","高三小易","figtinglove","哦1005","炽夏","不在乎我的你我已不在乎","柒轩","嘛哩嘛哩哄哈哈","muuuu","库拉索","笨笨郭","melon_l","素颜如水_流年未逝","千子miss","单丹","莹479","xy_lx","欣笑阳","大草爱小草","manyny","幻-","奔pao","燕子dc339","学鱼","梦想家笑笑","scar_xu","xt哥哥","for_world","迷惘的我","蔡太太","wcngzz","bly1996","根本停不下来o","无敌ctata","小小透明","伟大的书记","黯煠","你真烦","待及格","恒晨","空话","miraclesky","cccaaa","rainhan","王雅男","紫色控的妹纸","林l丽婷","tony007","trllby","wzl123","大斌神","梦羽清柔","荣杰","jjjjjjoker","松岛大哥","蓝诺柒","杨羊羽","待政治如初恋","慕竹","松果e","无所谓00","司令丶","a都有","静听风叹息","荒废够了","朱新蒙1994","浅黑色","华西","樱酒","卡农呵","让风继续吹","妹妹妹妹","rainbow_-霞","多尔","某某555","2545","bgm","姜春辉","十三格格","alur","没有什么能让你输","一直陪我可好","air-alimjan","相知是美","吃吧林俊杰","张凯然","z旭","鲤鸢","zzqgy","小云云天下无敌","奔厦门","我403","urmoon","杏仁1973","刘甚咸","考为中华之崛起而读书","写不尽的温柔","吴振发","廷月","爱棒棒糖i","wyf_","我爱蜡笔小新","果果邦","心静茹水","krisyeol丶","槿郁熙沫","yyyk","孤独的自卑者你怕吗","陌煜涵","夏日静","嘉嘉嘉嘉嘉_芮","张入元","kavincal","冰多多","莫忘初衷high","吴鑫瑶","冇时间饮汤啊","猿猴题库1111","猫绿袖","谁是谁的谁2","阿耶","_angel","嗯一","fbhhm","苦逼高三党求不撞名","昵称未设置","absor","困住的野兽","天道酬勤未来路","yunturenshi","lilijin","那场雨很凄凉、樱花泪很美","钱柳竹","高考辉煌家乐","烂土豆","熙雪嫣","我在哪","蒋二员长","刘文辉_","学霸丫","颂心非","菜菜gen","陈大狗","天朝好骚年","tianjun","花落惊鸿","郭伟祥","englishlover","来罐葡萄酱","change田洁","陆煊","大芒果象","beile0","莫大婷","祺尧","杀进牢笼","yoyofong","靳颖琪","女神在哪里","mists","321yl","向着美院的方向","我要我的广中医","逆袭的柠檬","淡定追梦","yinxc","姐的范儿你学不来","妹丁","小祥g","承诺遗弃","0218小宇宙","素素荷","高三狗汪汪汪","沙漠7","徐梓弹弹","019","学渣又何妨","蓝深川","蓝宝宝","九折","kalista","丰沙","张飞机同学","那年的小逗比","玖囍","花花兮","就是学酥","优雅别致的疯子范","刘梦涛","鹿白","眼泪的朦胧是浅灰的惆怅","bryant_jh","梁振兴","fightsl","williamfans","子捻","人猿泰山","xwyxb","只想要个二本","天之浪子","我不是要叫这个名的","恒远教育","绿宝宝","学渣的无辜","beatingheart","thyonly","211sean","小瑜丝","才华924","征服语文","清明见鬼","我相信1","tcadx","繁夜未央-","18973298318","我是蓝胖子","bohemian","hi20145","戴韦韦","迅国","sicktcl","不完整","kkkristine","没有故事的男同学","kaiko伊一","俊国","逆世界","叶子姐","幻天_1","gsn-","l丶p的执着","高考我来了12138","陈庆之你好","詹梦","1刘宇航","hardstudy","lqr","卢秋宏","海苔","胖子ss","杀出第一名","bearxlee","南飞","hybrids","你好哇习题","苏区","陈二呆","带泪的鱼笑泪","will-in-fall","fcland","木江","wildgirl21","znx","zyy9999","静态","温乐乐","楠宝宝","白开水最长情","嘴硬","苏燕婷有逆袭的决心","你懂的微笑","晓语半年","黄bb","smile浩","陈的的","possible969","真爱遗憾","唯忆style","黎明lm","为棋","阿慕童mlki","浮生落寞","麦森森","珏蝶","晓春或许就这么吧","谢伟02","大忙人","相遇那年夏季","念安959","过客喀","沉默萧声","欣嘉嘉","未来还有未来丶","迷恋你的香","芊代翎","辉煌腾达","dean炎炎","wow赵","吴亚珂","yunwei","时刻都要变优秀的路怡帆","d-ym","海树","一年一度开","张玉奇","郑佳玲超级无敌宇宙最强大","日荑","猫内内","clean_wind","侯木子","question127","兮哈哈","背了壳的蜗牛","涛涛max","骤雨","高熳","小甘同学在九班","阿芙乐尔_","小neinei","草编的幸福","liuli1996","哈哈找到你了","黄昕慧","叫我如烟","nostalgia11","俩麽","pax白","死神他姐","逆风_飞翔","789512346","幻影绝迹","gdr","请忘记我还一个人","大蓝朋友","文孝","饭饭大大","魅惑灬断魂","雨后的彩虹w-x","我是你爸爸2","锦晞","太极星辰","qura","百变","dls357","重庆西安","stesunny","929152517","似乎卡","日光倾城_-","rebecca0804","凉_蚊子","我叫碗碗","_yms","孤要这江山","加油wmf","德玛西亚z","紫旋","奔跑的麋鹿","予璃","纸被听说","大逆乌六中准高三","toconvert","sk1996","胡晨曦","暖阳w","陈太帅","小太阳的wh","撕打腻真爱粉","文绾","我追逐的快乐","逆越时光去爱你","你会是要考大学的人","武鹏程以为可以重头再来","hotel","瑞哥哥哥哥哥i","--sunny","梦之所存","小小七步軥","蜗牛何必呢","安子yvonne","梦想在不远处ww","xlllllllx","嗨到枯萎","ier","786396815","无尤悠","默哀哈","踏进理想","梦萌萌萌萌","carolvane","给未来自己一个最好的交代","好好好好高","那时年少那时光","会发光的本小姐","lpy910","范才孝","every12","cream9695","努力去奋斗","zzzql","lzq13","新景黎","多想笨的想个天才","轰轰烈烈辣椒酱","何加焉","mk昆昆","wfy666","微笑浅尝辄止","旧了时光凉了心","蛋汤老师","林洋康","labi","x-zh","明亮的心","小枫a","知识消费","罗zm","丁鹏元","penngy","freak_","扣复","simptenber","蓝色筱诺","421--hl","o_o胃到用时方恨小","随遇而安mm","活出自己的调调","卖萌小嘟嘟","旭娴","帅j登场","chenchuan","小楼残月","wyzr","davey_","edward1995","熊伟仡","柳元奎","clloo","zero0man","琴琴琴琴","逃课咯","eric950612","再玩则完","冲刺本","是谁乱了我的心","6782014","beekinwu","张爱唐","qmartinred","zwxxier","二胖tfsxjv","学霸__-","已习惯沉默","我健健康康","赵小美","cfdccg","沉默回眸","徐徐夏","考完滚蛋","1515478","苏凉七","mydol","落君zi","wsowyq","吉米sj","evw","加油9509","张蕾kk","蓝色少年是阿雾","现代化","赵盼盼","航航xx","大章鱼1996","仔仔高考","高考给力啊","2014sd","李永奇","yeyeye1","raikiri","sifenly","我要上大学st","贾文浩","热血军魂","zsxzz","tufei","王三多","力量帝丶","小陌灬","h娴","锋空间里","杨叔叔","飘飞的白云","我要考大学-oxy","ajxx","1998lyl","莫火萍","为了自己的大学","潜伏-猎物","绝不呼救-","信仰yj","院燕","小披风","skullhong16","tagf","祁娟","kayichann","six442","香蕉儿","异类存在","嫣然笑尽美如诗","1996329jcl","吴育生","oniyh","lsyforever","劳law","leejahui","pan星","axiaoq","看书","高安琪","付之笑谈中","吃肉的猪猪","尼哪","冥冥s小疯子","卖女孩的小火柴2333","星空心雨","云羽梦","我会弯腰","故事细腻hs","zouyun","盛年","我要去青岛","邱丽凤","你完全无视我","兰兰爱你","刘海生","gys6310","胡边歌声萦绕","sally倩","水底鱼儿慢慢游","咧嘴呼啦啦","blue_berry","傻傻爱v","笔直的烟","蕉溪"
    };

    public static String getName() {
        int idx = (int)(Math.random() * list.length);
        return list[idx];
    }

    public static void doPost() throws UnirestException {
        Unirest.setTimeouts(3000, 3000);
        HttpResponse<String> response = Unirest.post("http://es-cn-6ja21yyqk000wnq1c.elasticsearch.aliyuncs.com:9200/user-index/_search")
                .header("Connection", "keep-alive")
                .header("Authorization", "Basic ZWxhc3RpYzpURWxhc3RpYzQ1Ng==")
                .header("Accept", "application/json, text/javascript, */*; q=0.01")
                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.192 Safari/537.36")
                .header("Content-Type", "application/json")
                .header("Origin", "chrome-extension://ffmkiejjmecolpfloofpjologoblkegm")
                .header("Accept-Language", "zh-CN,zh;q=0.9")
                .body("{\"query\":{\"bool\":{\"must\":[{\"match\":{\"nameLowerCase\":\"" + getName() + "\"}}],\"must_not\":[],\"should\":[]}},\"from\":0,\"size\":10,\"sort\":[],\"aggs\":{}}")
                .asString();
        //System.out.println(JSON.toJSONString(response.getBody()));
        System.out.println(Thread.currentThread().getName() + "  " + response.getStatus() + response.getBody());

    }
}