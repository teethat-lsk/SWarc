package creational;

import javax.xml.parsers.ParserConfigurationException;
import java.io.PrintStream;

public class XMLBookMetadataExporter extends BookMetadataExporter {
    private XMLBookMetadataFormatter formatter;

    public XMLBookMetadataExporter() throws ParserConfigurationException {
        formatter = new XMLBookMetadataFormatter();
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
