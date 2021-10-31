package Subscriber;

import java.util.concurrent.Flow;

public abstract class StringSubscriber implements Flow.Subscriber<Character> {


    public abstract void onSubscribe(Flow.Subscription subscription);
    public abstract void onNext(Character item);
    public abstract  String getSubscriptionType();

    public void onError(Throwable throwable){
        throwable.printStackTrace();
    }

    public void onComplete(){

    }


}
