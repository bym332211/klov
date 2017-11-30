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
}
