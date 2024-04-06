/*
Jonathan Etiz & Luan Nguyen
Publisher.java
Version 0
 */

package mvc;

import java.util.*;

public class Publisher {
    private Set<Subscriber> subscribers = new HashSet<>();
    public void notifySubscribers() {
        for(Subscriber s: subscribers) s.update();
    }
    public void subscribe(Subscriber s) { subscribers.add(s); }
    public void unsubscribe(Subscriber s) { subscribers.remove(s); }
}