package creational;

import java.io.PrintStream;

public abstract class BookMetadataExporter extends BookCollection {

    protected String output;
    public void export(PrintStream stream) {
        // Please implement this method. You may create additional methods as you see fit.
        stream.print(output);
    }

    @Override
    public void add(Book b) {
        super.add(b);
    }

    @Override
    public void remove(Book b) {
        super.remove(b);
    }
}
