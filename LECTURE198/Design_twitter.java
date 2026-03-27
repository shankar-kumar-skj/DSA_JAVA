package JAVA.SHASHCODE.LECTURE198;

// void postTweet(int userId,inttweetId) => userId posts a tweetId.
// List <Integer> getNewsFeed(int userId) => get recent 10 tweetIds (including self)
// void follow(int followerId,int followeeId) => followers can see followe tweets.
// void unfollow (int followerId,int followeeId) => follower cannot see followee tweets.

import java.util.*;

class Tweet implements Comparable<Tweet>{
    int time;
    int tweetId;
    Tweet(int time,int tweetId){
        this.time=time;
        this.tweetId=tweetId;
    }
    public int compareTo(Tweet that){
        return that.time-this.time; //decr
    }
}

class User{
    int userId;
    HashSet<Integer> followers;
    List<Tweet> tweets;
    User(int userId){
        this.userId=userId;
        followers=new HashSet<>();
        followers.add(userId); //add self also as follower
        tweets=new LinkedList<>();
    }
    public void addTweet(Tweet t){
        tweets.add(0,t); // insertion at the head of the linked list
    }
    public void addFollower(int followeeId){
        followers.add(followeeId);
    }
    public void removeFollower(int followeeId){
        followers.remove(followeeId);
    }
}
public class Design_twitter {
    HashMap<Integer,User> userMap;
    int timeCounter;
    public Design_twitter(){
        userMap=new HashMap<>();
        timeCounter=0;
    }

    public void postTweet(int userId,int tweetId){
        timeCounter++;
        // constant operation because of insertion at the head in linkedList
        if(!userMap.containsKey(userId)){
            userMap.put(userId,new User(userId));
        }
        // constant operation because of insertion at the head in linkedList
        User user = userMap.get(userId);
        user.addTweet(new Tweet(timeCounter,tweetId));
    }

    public List<Integer> getNewsFeed(int userId){
        // constant operation because of checking in map
        if(!userMap.containsKey(userId)){
            return new ArrayList<>();
        }
        PriorityQueue<Tweet> pq=new PriorityQueue<>();
        // Add self tweets + followers tweets
        User user=userMap.get(userId);
        // N*(10 log 10 ) 
        for(int followerId : user.followers){ //(N)
            int count=0;
            for(Tweet tweet : userMap.get(followerId).tweets){ // T => max t=10
                pq.offer(tweet); // log(T) => max t=10
                count++;
                if(count>10){
                    break; 
                }
            }
        }
        // // 10 log(10)
        // int count=0;
        // for(Tweet tweet : user.tweets){
        //     pq.offer(tweet);
        //     count++;
        //     if(count>10){
        //         break; 
        //     }
        // }

        // 10 log(10)
        List<Integer> res=new ArrayList<>();
        int index=0;
        while(!pq.isEmpty()&& index<10){
            Tweet tweet=pq.poll();
            res.add(tweet.tweetId);
            index++;
        }
        return res;
    }

    public void follow(int followerId,int followeeId){
        // constant operation because of HashSet
        if(!userMap.containsKey(followerId)){
            userMap.put(followerId,new User(followerId));
        }
        if(!userMap.containsKey(followeeId)){
            userMap.put(followeeId,new User(followeeId));
        }
        User user=userMap.get(followerId);
        user.addFollower(followeeId);
    }

    public void unfollow(int followerId,int followeeId){
        // constant operation because of HashSet
        if(!userMap.containsKey(followerId) || !userMap.containsKey(followerId)){
            return;
        }
        User user=userMap.get(followerId);
        user.removeFollower(followeeId);
    }
}
