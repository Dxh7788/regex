package com.d.regex;


import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple RegexApplication.
 *
 * 正则基本表达式{n,m}.
 * + 代表{1,}
 * * 代表{0,}
 * ? 代表{0,1}
 * {n} 代表匹配n次,次数固定
 */
public class RegexApplicationTest
{
    /**
     * Rigourous Test :-)
     */
    @Test
    public void testApp()
    {
        assertTrue( true );
    }

    @Test
    public void testSympolPlus(){
        String cmp = "abcccc";
        System.out.println(cmp.matches("abc+"));
        System.out.println(cmp.matches("abc*"));
        System.out.println(cmp.matches("abc?"));
        System.out.println(cmp.matches("[*.*]"));
    }

    @Test
    public void testSimpleRegex(){
        String compile = "abc";
        Pattern pattern = Pattern.compile("^[a-z]*$");
        Matcher matcher= pattern.matcher(compile);
        System.out.println(matcher.matches());
        System.out.println(matcher.group(0));
    }
    @Test
    public void emailRegexTest(){
        String regex = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        String[] mails = {"wuyajingyg2016@163.com","wuyajingyg201.163.com","wuyajingyg2012@baidu.com",
        "@wuyajingyg2011@a12.com","wuyajingyg2018@com"};
        Pattern pattern = Pattern.compile(regex);
        for (int i=0;i!=mails.length;i++){
            Matcher matcher = pattern.matcher(mails[i]);
            if (matcher.matches()){
                System.out.println(matcher.group());
            }
        }
    }
    @Test
    public void simpleEmailTest(){
        String regex = "^\\w+@\\d+.\\w+$";
        String input = "abc@123.com";
        System.out.println(input.matches(regex));
    }
    /**
     * (?<=) 匹配以str开头的字符串
     * (?:) 非获取匹配，匹配pattern但不获取匹配结果，不进行存储供以后使用
     * (?=) 非获取匹配，正向肯定预查
     * (?!) 非获取匹配，反向否定预查
     * (?<=) 非获取匹配，反向肯定预查
     * (?<!) 非获取匹配，反向否定预查，与正向否定预查类似，只是方向相反
     * */
    @Test
    public void divTest(){
        String regex = "<div class=\"selectPeriodicalList project-float fl\" onclick= (.*)";
        String input = "<div class=\"selectPeriodicalList project-float fl\" onclick= window.open(\"/html/12312321\")";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            String comma = matcher.group(1);
            System.out.println(comma);
            String commaRegex = "(?<=\\(\"/html/)[^\\)]+(?=\")";
            Pattern commaPattern = Pattern.compile(commaRegex);
            Matcher commaMather = commaPattern.matcher(comma);
            while (commaMather.find()){
                System.out.println("项目编号为:"+commaMather.group());
            }
        }
        System.out.println(pattern.matcher(input).groupCount());
    }
}
