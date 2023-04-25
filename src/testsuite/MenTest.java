package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        // Open browser and launch Url
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart() throws InterruptedException {
        // Mouse Hover on Men Menu
        mouseHover(By.xpath("//span[normalize-space()='Men']"));
        // Mouse Hover on Bottoms
        mouseHover(By.xpath("//a[@id='ui-id-18']"));
        // Click on Pants
        mouseHoverAndClick(By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));
        // Mouse Hover on product name Cronus Yoga Pant and click on size 32.
        mouseHover(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        mouseHoverAndClick(By.xpath("(//div[@class='swatch-option text'])[1]"));
        // Mouse Hover on product name Cronus Yoga Pant and click on colour Black.
        mouseHoverAndClick(By.xpath("(//div[@class='swatch-option color'])[1]"));
        // Mouse Hover on product name Cronus Yoga Pant and click on ‘Add To Cart’ Button.
        mouseHover(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        mouseHoverAndClick(By.xpath("(//span[contains(text(),'Add to Cart')])[1]"));
        Thread.sleep(1000);
        // Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        String expectedMessage = "You added Cronus Yoga Pant to your shopping cart.";
        String actualMessage = getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        verifyTwoTextMessage(expectedMessage, actualMessage);
        // Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        // Verify the text ‘Shopping Cart.’
        expectedMessage = "Shopping Cart";
        actualMessage = getTextFromElement(By.xpath("//span[@class='base']"));
        verifyTwoTextMessage(expectedMessage, actualMessage);
        // Verify the product name ‘Cronus Yoga Pant’
        expectedMessage = "Cronus Yoga Pant";
        actualMessage = getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"));
        verifyTwoTextMessage(expectedMessage, actualMessage);
        // Verify the product size ‘32’
        expectedMessage = "32";
        actualMessage = getTextFromElement(By.xpath("//dd[contains(text(),'32')]"));
        verifyTwoTextMessage(expectedMessage, actualMessage);
        // Verify the product colour ‘Black’
        expectedMessage = "Black";
        actualMessage = getTextFromElement(By.xpath("//dd[contains(text(),'Black')]"));
        verifyTwoTextMessage(expectedMessage, actualMessage);

    }

    @After
    public void tearDown() {
        // Close all open tabs
        closeBrowser();
    }

}
