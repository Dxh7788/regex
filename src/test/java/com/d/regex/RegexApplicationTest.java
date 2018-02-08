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
}
