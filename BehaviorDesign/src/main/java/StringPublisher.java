import java.sql.SQLOutput;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import Subscriber.StringSubscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.SubmissionPublisher;

public class StringPublisher implements Publisher<String> {
    private final ExecutorService executor = ForkJoinPool.commonPool();
    private boolean subscribed;
    private String message = "";
    private String alphabetMsg = "";
    private String numberMsg = "";
    private String symbolMsg = "";
    private Map<StringSubscriber, String> subscriberMap = new HashMap<>();

    public StringPublisher(){}
    public void resetArticle(){
        this.message = "";
        this.alphabetMsg = "";
        this.numberMsg = "";
        this.symbolMsg = "";
    }
    public void write(String message){

        this.message = message;
        for (int i = 0; i < message.length(); i++) {
            char tmp = message.charAt(i);
            if(Character.isAlphabetic(tmp)){
                this.alphabetMsg += tmp;
            }
            else if (Character.isDigit(tmp)){
                this.numberMsg += tmp;
            }
            else{
                this.symbolMsg += tmp;
            }
        }
        System.out.println("===============================================================================");
        System.out.println("Publisher write : " + message);

    }

    //use this instead of subscribe
    public void publish(){
       subscriberMap.forEach((subscriber,subscriptionType)->{
           if(subscriptionType.contentEquals("Alphabet")){
               System.out.println("Publish " + "===> "+alphabetMsg +" <==="+ " To Alphabet Subscriber...");
               this.publishMessage(subscriber,alphabetMsg);
           }
           else if(subscriptionType.contentEquals("Number")){
               System.out.println("Publish " + "===> "+numberMsg +" <==="+ " To Alphabet Subscriber...");
               this.publishMessage(subscriber,numberMsg);
           }
           else if(subscriptionType.contentEquals("Symbol")){
               System.out.println("Publish " + "===> "+symbolMsg +" <==="+ " To Alphabet Subscriber...");
               this.publishMessage(subscriber,symbolMsg);
           }

       });
        this.resetArticle();
    }

    private void publishMessage(Subscriber subscriber, String message){
        subscriber.onSubscribe(new StringSubscription(subscriber,message));
    }

    // add map of subscriber and its subscriptionType
    public void addSubscriber(StringSubscriber subscriber)
    {
        String subscriptionType = subscriber.getSubscriptionType();
        subscriberMap.put(subscriber,subscriptionType);
    }

    //use publish instead
    public void subscribe(Subscriber subscriber) {
        subscriber.onSubscribe(new StringSubscription(subscriber,message));
    }



}

