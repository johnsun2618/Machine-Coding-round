package org.problem.Service;

import org.problem.Model.Post;
import org.problem.Model.User;

import java.util.*;
import java.time.format.DateTimeFormatter;

public class SocialMediaApp {

    private Map<Integer, User> users;

    public SocialMediaApp() {
        this.users = new HashMap<>();
    }

    // Register a new user
    public String registerUser(int userId, String username) {
        if (users.containsKey(userId)) {
            return "User ID already exists!";
        }
        users.put(userId, new User(userId, username));
        return username + " Registered!!";
    }

    // Upload a post for a user
    public String uploadPost(int userId, String content) {
        User user = users.get(userId);
        if (user == null) {
            return "User not found!";
        }
        Post post = new Post(content);
        user.addPost(post);
        return "Upload Successful with post id: " + post.getId();
    }

    // Follow or unfollow another user
    public String interactWithUser(String interactionType, int userId1, int userId2) {
        User user1 = users.get(userId1);
        User user2 = users.get(userId2);
        if (user1 == null || user2 == null) {
            return "User not found!";
        }
        if (interactionType.equalsIgnoreCase("FOLLOW")) {
            user1.follow(user2);
            return "Followed " + user2.getUsername() + "!!";
        } else if (interactionType.equalsIgnoreCase("UNFOLLOW")) {
            user1.unfollow(user2);
            return "Unfollowed " + user2.getUsername() + "!!";
        }
        return "Invalid interaction type!";
    }

    // Show feed for a user
    public void showFeed(int userId) {
        User user = users.get(userId);
        if (user == null) {
            System.out.println("User not found!");
            return;
        }

        // Collect posts from followed and non-followed users
        List<Post> feed = new ArrayList<>();
        Set<User> following = user.getFollowing();

        for (User u : users.values()) {
            if (following.contains(u) || u == user) {
                feed.addAll(u.getPosts());
            }
        }

        // Sort posts based on following status and timestamp
        feed.sort((p1, p2) -> {
            boolean isFollowed1 = following.contains(users.get(userId));
            boolean isFollowed2 = following.contains(users.get(userId));

            if (isFollowed1 && !isFollowed2) return -1;
            if (!isFollowed1 && isFollowed2) return 1;

            return p2.getTimestamp().compareTo(p1.getTimestamp());
        });

        // Display the feed
        for (Post post : feed) {
            User postUser = users.get(userId);
            System.out.println("UserName - " + postUser.getUsername());
            System.out.println("Post - " + post.getContent());
            System.out.println("Post time - " + post.getTimestamp());
            System.out.println("# of Likes - " + post.getLikes());
            System.out.println("# of Dislikes - " + post.getDislikes());
            System.out.println();
        }
    }
}