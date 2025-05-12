public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Initialize the rate limiter with one user (userId = 1)
        UserSlidingWindow rateLimiter = new UserSlidingWindow(1); // in 1 second only 10 request intertained per user

        // Simulate user 1 making 12 requests (limit is 10 per second)
        System.out.println("User 1 sending requests:");
        for (int i = 0; i < 15; i++) {
            rateLimiter.accessApplication(1);
            Thread.sleep(50); // 50ms delay between requests
        }

        System.out.println();

        // Simulate a second user (userId = 2) making 5 requests
        System.out.println("User 2 sending requests:");
        for (int i = 0; i < 5; i++) {
            rateLimiter.accessApplication(2); // this user will be added dynamically
            Thread.sleep(100);
        }

        System.out.println();

        // Wait for 1 second and try again for user 1
        System.out.println("Waiting for 1 second to reset rate limiter for user 1...");
        Thread.sleep(1000);

        // More requests from user 1 after reset
        System.out.println("User 1 trying again:");
        for (int i = 0; i < 3; i++) {
            rateLimiter.accessApplication(1);
        }
    }
}

