package org.konurbaev;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ConsumerTest {
    @Test
    public void testNewConsumer(){
        Assert.assertNotNull(new Consumer(new Queue()));
    }
}
