package com.d.regex;


import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple RegexApplication.
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
        String cmp = "abcabcabcabc";
        System.out.println(cmp.matches("[abc+]"));
    }
}
