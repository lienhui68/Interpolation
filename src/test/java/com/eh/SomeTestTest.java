package com.eh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by David Li on 2016/4/9.
 */
public class SomeTestTest {
    private Logger logger = LoggerFactory.getLogger(SomeTestTest.class);
    
    @BeforeMethod
    public void setUp() throws Exception {

    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    @Test
    public void testMain() throws Exception {
        logger.info("test");
    }
}