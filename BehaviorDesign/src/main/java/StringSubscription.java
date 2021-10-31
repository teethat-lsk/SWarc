
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.atomic.AtomicBoolean;


public class StringSubscription implements Subscription{
    private Subscriber subscriber;
    private String message;
    private final AtomicBoolean terminated = new AtomicBoolean(false);

    public StringSubscription(Subscriber subscriber,String message){
        this.message = message;
        this.subscriber = subscriber;

    }
    //Flow
    @Override
    public void request(long n) {
        if (n <= 0){
            subscriber.onError(new IllegalArgumentException());
        }
        for (long x = n; x > 0 && message.length()>0 && !terminated.get() ; x--){
            subscriber.onNext(message.charAt(0));
            message = message.substring(1);


        }
        if (message.length()<=0 && !terminated.getAndSet(true)){
            subscriber.onComplete();
        }

    }


    @Override
    public void cancel() {
        terminated.set(true);
    }




}
