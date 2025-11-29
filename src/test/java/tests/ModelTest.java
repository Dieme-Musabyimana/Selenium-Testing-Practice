package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ModelHandling;

public class ModelTest extends BaseTest {

    @Test
    public void testClosePopup() {

        ModelHandling modal = new ModelHandling(driver);

        modal.closePopupIfPresent();

    }
}
