package archive;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.sound.midi.SysexMessage;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class PurchasesArchiveTest {

    private PurchasesArchive archive;
    private ByteArrayOutputStream fakeOutput;
    private PrintStream standartPrintStream;

    @Before
    public void setUp() throws Exception {
        archive = new PurchasesArchive();

        fakeOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(fakeOutput));
    }

    @After
    public void tearDown() throws Exception {
        archive = null;

        System.setOut(System.out);
    }

    @Test
    public void printItemPurchaseStatistics() {

    }

    @Test
    public void getHowManyTimesHasBeenItemSold() {
    }

    @Test
    public void putOrderToPurchasesArchive() {

    }
}