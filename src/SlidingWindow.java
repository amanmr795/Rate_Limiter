import java.util.concurrent.ConcurrentLinkedQueue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class SlidingWindow implements Rate_Limiter {
    ConcurrentLinkedQueue<Long> slidingWindow;
    int bucketCap;
    int time;

    public SlidingWindow(int time, int cap){
        this.time = time;
        this.bucketCap = cap;
        slidingWindow = new ConcurrentLinkedQueue<Long>();
    }

    @Override
    public boolean grantAccess(){
        long currentTime = System.currentTimeMillis();
        updateQueue(currentTime);
        if(slidingWindow.size() < bucketCap){
            slidingWindow.offer(currentTime);
            return true;
        }
        return false;
    }

    private void updateQueue(long currentTime) {
        if(slidingWindow.isEmpty()) return;
        long time = (currentTime - slidingWindow.peek())/1000;

        while(time>=this.time){
            slidingWindow.poll();
            if(slidingWindow.isEmpty()) {
                break;
            }
            time = (currentTime - slidingWindow.peek())/1000;
        }
    }
}