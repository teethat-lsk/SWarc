

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

        //Publisher
        StringPublisher publisher = new StringPublisher();


        //Subscriber
        StringSubscriber alphaSub1 = new AlphabetSubscriber("alphaSub1").subscribe(publisher);
        StringSubscriber alphaSub2 = new AlphabetSubscriber("alphaSub2").subscribe(publisher);
        StringSubscriber numSub1 = new NumberSubscriber("numSub1").subscribe(publisher);
        StringSubscriber numSub2 = new NumberSubscriber("numSub2").subscribe(publisher);
        StringSubscriber symSub1 = new SymbolSubscriber("symSub1").subscribe(publisher);
        StringSubscriber symSub2 = new SymbolSubscriber("symSub2").subscribe(publisher);



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
