package com.company.tests;

import com.company.ReferenceTable;
import org.junit.Assert;
import org.junit.Test;

public class ReferenceTableTest {
    @Test
    public void test() {
        ReferenceTable referenceTable = new ReferenceTable('B');

        Assert.assertEquals('/', referenceTable.getEncodedChar('A'));
        Assert.assertEquals('A', referenceTable.getEncodedChar('B'));
        Assert.assertEquals('.', referenceTable.getEncodedChar('/'));
    }
}
