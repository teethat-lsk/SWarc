package creational;

import java.io.PrintStream;

public class JSONBookMetadataExporter extends BookMetadataExporter {
    private JSONBookMetadataFormatter formatter;

    public JSONBookMetadataExporter(){
        formatter = new JSONBookMetadataFormatter();
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
