
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.concurrent.Flow.Subscription;

public class AlphabetSubscriber extends StringSubscriber {
    private final String subscriptionType = "Alphabet";
    private final String name;
    private String message = "";
    private final String filePath;
    public AlphabetSubscriber(String name) throws IOException {

        this.name = name;
        File file = new File("src/main/java/Output/"+this.name+".txt");
        file.createNewFile();
        this.filePath = file.getPath();
    }
    @Override
    public StringSubscriber subscribe(StringPublisher publisher) {
        super.subscribe(publisher);
        return this;
    }

    @Override
    public String getSubscriptionType() {
        return this.subscriptionType;
    }

    //Flow
    @Override
    public void onSubscribe(Subscription subscription) {

        subscription.request(1000);
    }

    @Override
    public void onNext(Character item) {
        this.message += item;
    }

    @Override
    public void onError(Throwable throwable) {
        super.onError(throwable);
    }

    @Override
    public void onComplete() {
        System.out.println(this.name +" "+ subscriptionType + " SubscriberType" + " receive the message : "+ this.message+"\n");

        try {
            if(!this.message.contentEquals("")){
            Writer fileWriter = new FileWriter(filePath,true);
            fileWriter.write(this.message+"\n");
            fileWriter.close();
            this.message="";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
