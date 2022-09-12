package com.company.tests;

import com.company.EncoderDecoder;
import org.junit.Assert;
import org.junit.Test;

public class EncoderDecoderTest {
    @Test
    public void test() {
        EncoderDecoder encoderDecoder = new EncoderDecoder('B');
        Assert.assertEquals("BGDKKN VNQKC", encoderDecoder.encode("HELLO WORLD"));
        Assert.assertEquals("HELLO WORLD", encoderDecoder.decode("BGDKKN VNQKC"));

        encoderDecoder.changeOffset('F');
        Assert.assertEquals("FC/GGJ RJMG.", encoderDecoder.encode("HELLO WORLD"));
        Assert.assertEquals("HELLO WORLD", encoderDecoder.decode("FC/GGJ RJMG."));

    }
}
