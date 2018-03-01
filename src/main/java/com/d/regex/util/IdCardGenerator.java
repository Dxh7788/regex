package com.d.regex.util;

import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IdCardGenerator {

    public static final Map<String, Integer> areaCode = new HashMap<String, Integer>();

    static {
        IdCardGenerator.areaCode.put("北京市", 110000);
        IdCardGenerator.areaCode.put("市辖区", 110100);
        IdCardGenerator.areaCode.put("东城区", 110101);
        IdCardGenerator.areaCode.put("西城区", 110102);
        IdCardGenerator.areaCode.put("崇文区", 110103);
        IdCardGenerator.areaCode.put("宣武区", 110104);
        IdCardGenerator.areaCode.put("朝阳区", 110105);
        IdCardGenerator.areaCode.put("丰台区", 110106);
        IdCardGenerator.areaCode.put("石景山区", 110107);
        IdCardGenerator.areaCode.put("海淀区", 110108);
        IdCardGenerator.areaCode.put("门头沟区", 110109);
        IdCardGenerator.areaCode.put("房山区", 110111);
        IdCardGenerator.areaCode.put("通州区", 110112);
        IdCardGenerator.areaCode.put("顺义区", 110113);
        IdCardGenerator.areaCode.put("昌平区", 110114);
        IdCardGenerator.areaCode.put("大兴区", 110115);
        IdCardGenerator.areaCode.put("怀柔区", 110116);
        IdCardGenerator.areaCode.put("平谷区", 110117);
        IdCardGenerator.areaCode.put("县", 110200);
        IdCardGenerator.areaCode.put("密云县", 110228);
        IdCardGenerator.areaCode.put("延庆县", 110229);
        IdCardGenerator.areaCode.put("天津市", 120000);
        IdCardGenerator.areaCode.put("市辖区", 120100);
        IdCardGenerator.areaCode.put("和平区", 120101);
        IdCardGenerator.areaCode.put("河东区", 120102);
        IdCardGenerator.areaCode.put("河西区", 120103);
        IdCardGenerator.areaCode.put("南开区", 120104);
        IdCardGenerator.areaCode.put("河北区", 120105);
        IdCardGenerator.areaCode.put("红桥区", 120106);
        IdCardGenerator.areaCode.put("东丽区", 120110);
        IdCardGenerator.areaCode.put("西青区", 120111);
        IdCardGenerator.areaCode.put("津南区", 120112);
        IdCardGenerator.areaCode.put("北辰区", 120113);
        IdCardGenerator.areaCode.put("武清区", 120114);
        IdCardGenerator.areaCode.put("宝坻区", 120115);
        IdCardGenerator.areaCode.put("县", 120200);
        IdCardGenerator.areaCode.put("宁河县", 120221);
        IdCardGenerator.areaCode.put("静海县", 120223);
        IdCardGenerator.areaCode.put("蓟　县", 120225);
        IdCardGenerator.areaCode.put("河北省", 130000);
        IdCardGenerator.areaCode.put("石家庄市", 130100);
        IdCardGenerator.areaCode.put("市辖区", 130101);
        IdCardGenerator.areaCode.put("长安区", 130102);
        IdCardGenerator.areaCode.put("桥东区", 130103);
        IdCardGenerator.areaCode.put("桥西区", 130104);
        IdCardGenerator.areaCode.put("新华区", 130105);
        IdCardGenerator.areaCode.put("井陉矿区", 130107);
        IdCardGenerator.areaCode.put("裕华区", 130108);
        IdCardGenerator.areaCode.put("井陉县", 130121);
        IdCardGenerator.areaCode.put("正定县", 130123);
        IdCardGenerator.areaCode.put("栾城县", 130124);
        IdCardGenerator.areaCode.put("行唐县", 130125);
        IdCardGenerator.areaCode.put("灵寿县", 130126);
        IdCardGenerator.areaCode.put("高邑县", 130127);
        IdCardGenerator.areaCode.put("深泽县", 130128);
        IdCardGenerator.areaCode.put("赞皇县", 130129);
        IdCardGenerator.areaCode.put("无极县", 130130);
        IdCardGenerator.areaCode.put("平山县", 130131);
        IdCardGenerator.areaCode.put("元氏县", 130132);
        IdCardGenerator.areaCode.put("赵　县", 130133);
        IdCardGenerator.areaCode.put("辛集市", 130181);
        IdCardGenerator.areaCode.put("藁城市", 130182);
        IdCardGenerator.areaCode.put("晋州市", 130183);
        IdCardGenerator.areaCode.put("新乐市", 130184);
        IdCardGenerator.areaCode.put("鹿泉市", 130185);
        IdCardGenerator.areaCode.put("唐山市", 130200);
        IdCardGenerator.areaCode.put("市辖区", 130201);
        IdCardGenerator.areaCode.put("路南区", 130202);
        IdCardGenerator.areaCode.put("路北区", 130203);
        IdCardGenerator.areaCode.put("古冶区", 130204);
        IdCardGenerator.areaCode.put("开平区", 130205);
        IdCardGenerator.areaCode.put("丰南区", 130207);
        IdCardGenerator.areaCode.put("丰润区", 130208);
        IdCardGenerator.areaCode.put("滦　县", 130223);
        IdCardGenerator.areaCode.put("滦南县", 130224);
        IdCardGenerator.areaCode.put("乐亭县", 130225);
        IdCardGenerator.areaCode.put("迁西县", 130227);
        IdCardGenerator.areaCode.put("玉田县", 130229);
        IdCardGenerator.areaCode.put("唐海县", 130230);
        IdCardGenerator.areaCode.put("遵化市", 130281);
        IdCardGenerator.areaCode.put("迁安市", 130283);
        IdCardGenerator.areaCode.put("秦皇岛市", 130300);
        IdCardGenerator.areaCode.put("市辖区", 130301);
        IdCardGenerator.areaCode.put("海港区", 130302);
        IdCardGenerator.areaCode.put("山海关区", 130303);
        IdCardGenerator.areaCode.put("北戴河区", 130304);
        IdCardGenerator.areaCode.put("青龙满族自治县", 130321);
        IdCardGenerator.areaCode.put("昌黎县", 130322);
        IdCardGenerator.areaCode.put("抚宁县", 130323);
        IdCardGenerator.areaCode.put("卢龙县", 130324);
        IdCardGenerator.areaCode.put("邯郸市", 130400);
        IdCardGenerator.areaCode.put("市辖区", 130401);
        IdCardGenerator.areaCode.put("邯山区", 130402);
        IdCardGenerator.areaCode.put("丛台区", 130403);
        IdCardGenerator.areaCode.put("复兴区", 130404);
        IdCardGenerator.areaCode.put("峰峰矿区", 130406);
        IdCardGenerator.areaCode.put("邯郸县", 130421);
        IdCardGenerator.areaCode.put("临漳县", 130423);
        IdCardGenerator.areaCode.put("成安县", 130424);
        IdCardGenerator.areaCode.put("大名县", 130425);
        IdCardGenerator.areaCode.put("涉　县", 130426);
        IdCardGenerator.areaCode.put("磁　县", 130427);
        IdCardGenerator.areaCode.put("肥乡县", 130428);
        IdCardGenerator.areaCode.put("永年县", 130429);
        IdCardGenerator.areaCode.put("邱　县", 130430);
        IdCardGenerator.areaCode.put("鸡泽县", 130431);
        IdCardGenerator.areaCode.put("广平县", 130432);
        IdCardGenerator.areaCode.put("馆陶县", 130433);
        IdCardGenerator.areaCode.put("魏　县", 130434);
    }

    /**
     * 生成方法
     * @return
     */
    public static String generate() {
        StringBuilder generater = new StringBuilder();
        generater.append(randomAreaCode());
        generater.append(randomBirthday());
        generater.append(randomCode());
        generater.append(calcTrailingNumber(generater.toString().toCharArray()));
        return generater.toString();
    }

    /**
     * 随机地区
     * @return
     */
    public static int randomAreaCode() {
        int index = (int) (Math.random() * IdCardGenerator.areaCode.size());
        Collection<Integer> values = IdCardGenerator.areaCode.values();
        Iterator<Integer> it = values.iterator();
        int i = 0;
        int code = 0;
        while (i < index && it.hasNext()) {
            i++;
            code = it.next();
        }
        return code;
    }

    /**
     * 随机出生日期
     * @return
     */
    public static String randomBirthday() {
        Calendar birthday = Calendar.getInstance();
        birthday.set(Calendar.YEAR, (int) (Math.random() * 60) + 1950);
        birthday.set(Calendar.MONTH, (int) (Math.random() * 12));
        birthday.set(Calendar.DATE, (int) (Math.random() * 31));

        StringBuilder builder = new StringBuilder();
        builder.append(birthday.get(Calendar.YEAR));
        long month = birthday.get(Calendar.MONTH) + 1;
        if (month < 10) {
            builder.append("0");
        }
        builder.append(month);
        long date = birthday.get(Calendar.DATE);
        if (date < 10) {
            builder.append("0");
        }
        builder.append(date);
        return builder.toString();
    }

    /*
     * <p>18位身份证验证</p>
     * 根据〖中华人民共和国国家标准 GB 11643-1999〗中有关公民身份号码的规定，公民身份号码是特征组合码，由十七位数字本体码和一位数字校验码组成。
     * 排列顺序从左至右依次为：六位数字地址码，八位数字出生日期码，三位数字顺序码和一位数字校验码。
     * 第十八位数字(校验码)的计算方法为：
     * 1.将前面的身份证号码17位数分别乘以不同的系数。从第一位到第十七位的系数分别为：7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2
     * 2.将这17位数字和系数相乘的结果相加。
     * 3.用加出来和除以11，看余数是多少？
     * 4.余数只可能有0 1 2 3 4 5 6 7 8 9 10这11个数字。其分别对应的最后一位身份证的号码为1 0 X 9 8 7 6 5 4 3 2。
     * 5.通过上面得知如果余数是2，就会在身份证的第18位数字上出现罗马数字的Ⅹ。如果余数是10，身份证的最后一位号码就是2。
     */
    public static char calcTrailingNumber(char[] chars) {
        if (chars.length < 17) {
            return ' ';
        }
        int[] c = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
        char[] r = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2' };
        int[] n = new int[17];
        int result = 0;
        for (int i = 0; i < n.length; i++) {
            n[i] = Integer.parseInt(chars[i] + "");
        }
        for (int i = 0; i < n.length; i++) {
            result += c[i] * n[i];
        }
        return r[result % 11];
    }

    /**
     * 随机产生3位数
     * @return
     */
    public static String randomCode() {
        int code = (int) (Math.random() * 1000);
        if (code < 10) {
            return "00" + code;
        } else if (code < 100) {
            return "0" + code;
        } else {
            return "" + code;
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print(IdCardGenerator.generate());
            System.out.print("\t");
            System.out.print(IdCardGenerator.generate());
            System.out.print("\t");
            System.out.print(IdCardGenerator.generate());
            System.out.print("\t");
            System.out.println(IdCardGenerator.generate());
        }
    }
}

