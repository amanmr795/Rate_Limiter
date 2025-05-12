import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserSlidingWindow {
    Map<Integer, SlidingWindow> bucket;

    public UserSlidingWindow(int id){
        bucket = new ConcurrentHashMap<>();
        bucket.put(id , new SlidingWindow(1,10));
    }

    void accessApplication(int id){
        bucket.putIfAbsent(id, new SlidingWindow(1, 10));
        if(bucket.get(id).grantAccess()){
            System.out.println("user " + id + " Able to access");
        }
        else{
            System.out.println("user " + id + " not able to access, Too many requests");
        }
    }
}

