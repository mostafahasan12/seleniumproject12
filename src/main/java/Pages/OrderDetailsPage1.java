package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage1  extends pageBase {
	public OrderDetailsPage1(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "a.button-2.pdf-invoice-button")
    private WebElement pdfInvoiceLink;
	
    @FindBy(css = "a.button-2.print-order-button")
    private WebElement printInvoiceLnk;

    public void PrintOrderDetails() {
        clickbutton(printInvoiceLnk);
    }

    public void DownloadPDFInvoice() throws InterruptedException {
        clickbutton(pdfInvoiceLink);
//        Thread.sleep(2000);
    }

}
