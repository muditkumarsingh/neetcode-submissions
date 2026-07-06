class Twitter {
    HashMap<Integer, HashSet<Integer>> followers = new HashMap<>();
    HashMap<Integer, List<int[]>> tweets = new HashMap<>();
    int time;

    public Twitter() {
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        time++;
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new int[] { time, tweetId });
    }

    public List<Integer> getNewsFeed(int userId) {
        followers.putIfAbsent(userId, new HashSet<>());
        followers.get(userId).add(userId);
        HashSet<Integer> followed = followers.get(userId);
        if (followed == null) {
            return new ArrayList<>();
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        for (int user : followed) {
            if (!tweets.containsKey(user))
                continue;
            for (int[] tweet : tweets.get(user)) {
                maxHeap.offer(tweet);
            }
        }

        int k = 1;
        List<Integer> res = new ArrayList<>();

        while (k <= 10 && !maxHeap.isEmpty()) {
            res.add(maxHeap.poll()[1]);
            k++;
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        followers.putIfAbsent(followerId, new HashSet<>());
        followers.get(followerId).add(followeeId);
        if (!followers.get(followerId).contains(followerId)) {
            followers.get(followerId).add(followerId);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }

        if (followers.get(followerId) != null && followers.get(followerId).contains(followeeId)) {
            followers.get(followerId).remove(followeeId);
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