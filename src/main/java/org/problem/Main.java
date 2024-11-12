package org.problem;

import org.problem.Service.SocialMediaApp;

public class Main {
    public static void main(String[] args) {
        SocialMediaApp app = new SocialMediaApp();

        // Example usage
        System.out.println(app.registerUser(1, "Akash"));
        System.out.println(app.registerUser(2, "Hemant"));

        System.out.println(app.uploadPost(1, "This is my first post. My name is Akash."));
        System.out.println(app.uploadPost(1, "I work at Flipkart as a SDE1"));
        System.out.println(app.uploadPost(2, "I too worked at Flipkart as a SDE1"));

        System.out.println(app.interactWithUser("FOLLOW", 2, 1));
        System.out.println(app.interactWithUser("UNFOLLOW", 2, 1));

        app.showFeed(1);
    }
}