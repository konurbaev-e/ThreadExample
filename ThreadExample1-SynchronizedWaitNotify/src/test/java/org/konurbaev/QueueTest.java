package org.konurbaev;

import org.testng.Assert;
import org.testng.annotations.Test;

public class QueueTest {
    @Test
    public void testNewQueue(){
        Assert.assertNotNull(new Queue());
    }
}
