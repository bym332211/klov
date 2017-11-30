package sample;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Test
@Listeners({ReportListener.class})
public class SampleTest {

    public void case1() {
        Assert.assertEquals("a", "a");
    }

    public void case2() {
        Assert.assertEquals("a", "");
    }

    public void case3() {
        Assert.assertEquals("a", "a");
    }

    public void case4() throws Exception {
        Exception e = new RuntimeException("case4 Exception");
        throw e;
    }

    public void case5() {
        Assert.assertEquals("a", "a");
    }
}
