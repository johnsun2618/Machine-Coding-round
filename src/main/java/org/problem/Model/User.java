package org.problem.Model;

import java.util.*;
import java.time.LocalDateTime;

public class User {
    private int id;
    private String username;
    private List<Post> posts;
    private Set<User> following;
    private Set<User> followers;

    public User(int id, String username) {
        this.id = id;
        this.username = username;
        this.posts = new ArrayList<>();
        this.following = new HashSet<>();
        this.followers = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public Set<User> getFollowing() {
        return following;
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public void follow(User user) {
        following.add(user);
        user.followers.add(this);
    }

    public void unfollow(User user) {
        following.remove(user);
        user.followers.remove(this);
    }
}