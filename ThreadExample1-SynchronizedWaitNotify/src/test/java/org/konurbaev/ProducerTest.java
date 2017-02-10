package org.konurbaev;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProducerTest {
    @Test
    public void testNewProducer(){
        Assert.assertNotNull(new Producer(new Queue()));
    }
}
