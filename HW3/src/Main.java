public class Main {
    public static void main(String[] args) {
        MiniSocialNetwork network = new MiniSocialNetwork();

        //adding user
        network.addUser("user1", "user1@example.com", 25);
        network.addUser("user2", "user2@example.com", 17);
        network.addUser("user3", "user3@example.com", 19);

        // adding friends
        network.addFriend("user1", "user2");

        // adding post
        network.addPost("user1", "Hello, this is my first post!");
        network.addPost("user2", "Enjoying the weekend!");

        // like post
        network.likePost("user1", "Enjoying the weekend!");

        // Listing users and posts
        network.listUsersAndPosts();

        // Sorting users by likes
        network.sortUsersByLikes();

        // Listing users who are under 18 (Bonus)
        network.listUsersUnder18();
    }
}
