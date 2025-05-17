import java.util.*;

public class MiniSocialNetwork {
    private Map<String, User> users; //user mapping users
    private Map<String, List<Post>> allPosts; // user mapping posts

    public MiniSocialNetwork() {
        users = new HashMap<>();
        allPosts = new HashMap<>();
    }

    // add user
    public void addUser(String username, String email, int age) {
        if (!users.containsKey(username)) {
            User newUser = new User(username, email, age);
            users.put(username, newUser);
            allPosts.put(username, new ArrayList<>());
        }
    }

    // add friend for user
    public void addFriend(String username, String friendUsername) {
        User user = users.get(username);
        User friend = users.get(friendUsername);
        if (user != null && friend != null) {
            user.addFriend(friend);
        }
    }

    // add post for user
    public void addPost(String username, String content) {
        User user = users.get(username);
        if (user != null) {
            Post post = new Post(content);
            user.addPost(post);
            allPosts.get(username).add(post);
        }
    }

    // like post's user
    public void likePost(String username, String content) {
        for (Post post : allPosts.get(username)) {
            if (post.getContent().equals(content)) {
                post.addLike(username);
            }
        }
    }

    // sorting users according to the post's like
    public void sortUsersByLikes() {
        TreeMap<Integer, List<String>> sortedUsers = new TreeMap<>(Comparator.reverseOrder());
        for (User user : users.values()) {
            int totalLikes = 0;
            for (Post post : user.getPosts()) {
                totalLikes += post.getLikes().size();
            }

            sortedUsers.computeIfAbsent(totalLikes, k -> new ArrayList<>()).add(user.getUsername());
        }
        System.out.println("Users sorted by total likes (descending):");
        for (Map.Entry<Integer, List<String>> entry : sortedUsers.entrySet()) {
            entry.getValue().sort(Comparator.naturalOrder());
            System.out.println("Likes: " + entry.getKey() + " - Users: " + entry.getValue());
        }
    }


    // Listing all users and posts
    public void listUsersAndPosts() {
        Iterator<Map.Entry<String, List<Post>>> iterator = allPosts.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<Post>> entry = iterator.next();
            System.out.println("User: " + entry.getKey());
            for (Post post : entry.getValue()) {
                System.out.println("Post: " + post.getContent());
                System.out.println("Likes: " + post.getLikes());
            }
        }
    }

    public void listUsersUnder18() {
        users.values().stream()
                .filter(user -> user.age < 18)
                .forEach(user -> System.out.println(user.getUsername() + " - Age: " + user.age));
    }
}
