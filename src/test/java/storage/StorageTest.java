package storage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class StorageTest {

    Storage storage;
    ByteArrayOutputStream mockOut = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        storage = new Storage();
        System.setOut(new PrintStream(mockOut));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(System.out);
    }

    @Test
    public void printListOfStoredItems() {
//        System.out.println("já se vypisuju");
        storage.printListOfStoredItems();
        assertEquals("STORAGE IS CURRENTLY CONTAINING:\r\n", mockOut.toString());
    }
}