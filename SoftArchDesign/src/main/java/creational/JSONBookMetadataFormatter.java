package creational;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Arrays;

public class JSONBookMetadataFormatter implements BookMetadataFormatter {

    private JSONObject thisObject;
    private JSONArray thisArray;
    public JSONBookMetadataFormatter(){
        this.reset();
    }

    @Override
    public BookMetadataFormatter reset() {
        // Please implement this method. You may create additional methods as you see fit.
        this.thisObject = new JSONObject();
        this.thisArray = new JSONArray();
        try {
            this.thisObject.put(Book.class.getSimpleName() + "s",this.thisArray);
        }catch(UnsupportedOperationException error){
            error.printStackTrace();
        }

        return null;
    }

    @Override
    public BookMetadataFormatter append(Book b) {
        // Please implement this method. You may create additional methods as you see fit.
        try {
            JSONObject tmp = new JSONObject();
            JSONArray authors = new JSONArray();
            authors.addAll(Arrays.asList(b.getAuthors()));
            tmp.put(Book.Metadata.getValue(Book.Metadata.ISBN),b.getISBN());
            tmp.put(Book.Metadata.getValue(Book.Metadata.PUBLISHER),b.getPublisher());
            tmp.put(Book.Metadata.getValue(Book.Metadata.TITLE),b.getTitle());
            tmp.put(Book.Metadata.getValue(Book.Metadata.AUTHORS),authors);
            this.thisArray.add(tmp);
        }catch (Exception error){
            error.printStackTrace();
        }


        return this;
    }

    @Override
    public String getMetadataString() {
        // Please implement this method. You may create additional methods as you see fit.
        return thisObject.toString();
    }
}
