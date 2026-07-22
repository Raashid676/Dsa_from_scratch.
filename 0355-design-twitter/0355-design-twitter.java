
class Twitter {

    private int time;
    private HashMap<Integer, Tweet> tweetMap;
    private HashMap<Integer, HashSet<Integer>> followMap;

    public Twitter() {
        time = 0;
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        Tweet newTweet = new Tweet(tweetId, time++);
        newTweet.next = tweetMap.get(userId);
        tweetMap.put(userId, newTweet);
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> ans = new ArrayList<>();

        PriorityQueue<Tweet> pq = new PriorityQueue<>(
            (a, b) -> b.time - a.time
        );

        // Add user's own latest tweet
        if (tweetMap.containsKey(userId)) {
            pq.offer(tweetMap.get(userId));
        }

        // Add latest tweet of every followee
        if (followMap.containsKey(userId)) {
            for (int id : followMap.get(userId)) {
                if (tweetMap.containsKey(id)) {
                    pq.offer(tweetMap.get(id));
                }
            }
        }

        // Get at most 10 recent tweets
        while (!pq.isEmpty() && ans.size() < 10) {
            Tweet curr = pq.poll();
            ans.add(curr.tweetId);

            if (curr.next != null) {
                pq.offer(curr.next);
            }
        }

        return ans;
    }

    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }

    class Tweet {
        int tweetId;
        int time;
        Tweet next;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
            this.next = null;
        }
    }
}
/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */