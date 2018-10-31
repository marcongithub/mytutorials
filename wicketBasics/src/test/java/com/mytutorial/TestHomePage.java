package com.mytutorial;

import junit.framework.TestCase;
import org.apache.wicket.util.tester.WicketTester;

import com.wicketTutorial.HomePage;
import com.wicketTutorial.WicketApplication;
import org.junit.Test;

/**
 * Simple test using the WicketTester
 */
public class TestHomePage extends TestCase {
    private WicketTester tester;

    @Override
    public void setUp() {
        tester = new WicketTester(new WicketApplication());
    }


    @Test
    public void testRenderMyPage() {
        //start and render the test page
        tester.startPage(HomePage.class);

        //assert rendered page class
        tester.assertRenderedPage(HomePage.class);

        //assert rendered label component
        tester.assertLabel("message", "If you see this message wicket is properly configured and running");
    }
}
