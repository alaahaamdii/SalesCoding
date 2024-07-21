import com.project.Command;
import com.project.PrintReceiptCommand;
import com.project.Product;
import com.project.Receipt;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class PrintReceiptCommandTest {
    @Test
    public void testExecute() {
        Receipt receipt = new Receipt();
        receipt.addProduct(new Product("book", 12.49, false, true,1), 0);

        Command printReceiptCommand = new PrintReceiptCommand(receipt);
        printReceiptCommand.execute();

        assertEquals(1, receipt.getProducts().size());
    }
}
