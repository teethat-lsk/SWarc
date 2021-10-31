import Subscriber.AlphabetSubscriber;
import Subscriber.NumberSubscriber;
import Subscriber.StringSubscriber;
import Subscriber.SymbolSubscriber;


import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

//Edit Content In PublisherXX.txt
//Run Main
//output files will be written in Subscriber/Output/...
public class Main {

    public static void main(String[] args) throws IOException {
        List<Path> filePath = List.of(
                Path.of("src/main/java/Publisher01.txt"),
                Path.of("src/main/java/Publisher02.txt"),
                Path.of("src/main/java/Publisher03.txt")
        );

        String message;
        //Subscriber
        StringSubscriber alphaSub1 = new AlphabetSubscriber("alphaSub1");
        StringSubscriber alphaSub2 = new AlphabetSubscriber("alphaSub2");
        StringSubscriber numSub1 = new NumberSubscriber("numSub1");
        StringSubscriber numSub2 = new NumberSubscriber("numSub2");
        StringSubscriber symSub1 = new SymbolSubscriber("symSub1");
        StringSubscriber symSub2 = new SymbolSubscriber("symSub2");

        //Publisher
        StringPublisher publisher = new StringPublisher();
        publisher.addSubscriber(alphaSub1);
        publisher.addSubscriber(alphaSub2);
        publisher.addSubscriber(numSub1);
        publisher.addSubscriber(numSub2);
        publisher.addSubscriber(symSub1);
        publisher.addSubscriber(symSub2);

        //Publisher publishes content in Publisher01.txt
        for (Path path:filePath) {
            message = Files.readString(path);
            publisher.write(message);
            publisher.publish();
        }
//        Path filePath = Path.of("src/main/java/Publisher01.txt");
//        message = Files.readString(filePath);
//        publisher.write(message);
//        publisher.publish();

    }
}
