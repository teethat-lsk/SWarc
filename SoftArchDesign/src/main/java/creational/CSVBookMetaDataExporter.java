package creational;

import java.io.IOException;
import java.io.PrintStream;

public class CSVBookMetaDataExporter extends BookMetadataExporter{
    private CSVBookMetadataFormatter formatter;

    public CSVBookMetaDataExporter() throws IOException {
        formatter = new CSVBookMetadataFormatter();
    }

    @Override
    public void export(PrintStream stream) {
        output = formatter.getMetadataString();
        super.export(stream);
    }

    @Override
    public void add(Book b) {
        formatter.append(b);
    }

    @Override
    public void remove(Book b) {
        super.remove(b);
    }
}
