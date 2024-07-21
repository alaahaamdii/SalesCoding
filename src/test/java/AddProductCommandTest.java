import com.project.*;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class AddProductCommandTest {

    @Test
    public void testExecute() {
        Receipt receipt = new Receipt();
        Product product = new Product("music CD", 14.99, false, false,1);
        TaxCalculator taxCalculator = new BasicTaxCalculator();

        Command addProductCommand = new AddProductCommand(receipt, product, taxCalculator);
        addProductCommand.execute();

        assertEquals(1, receipt.getProducts().size());
        assertEquals("music CD", receipt.getProducts().get(0).getName());
    }
}



