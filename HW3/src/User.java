import java.util.*;

class User {
    private String username;
    private String email;
    int age;
    private Profile profile;
    private Set<User> friends;
    private List<Post> posts;

    public User(String username, String email, int age) {
        this.username = username;
        this.email = email;
        this.age = age;
        this.profile = new Profile();
        this.friends = new HashSet<>();
        this.posts = new LinkedList<>();
    }

    public String getUsername() {
        return username;
    }

    public void addFriend(User user) {
        friends.add(user);
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public void likePost(Post post, User user) {
        post.addLike(user.getUsername());
    }

    public Set<User> getFriends() {
        return friends;
    }

    public List<Post> getPosts() {
        return posts;
    }

    static class Profile {
        private String bio;
        private String profilePicture;

        public Profile() {
            this.bio = "";
            this.profilePicture = "";
        }

        public String getBio() {
            return bio;
        }

        public void setBio(String bio) {
            this.bio = bio;
        }

        public String getProfilePicture() {
            return profilePicture;
        }

        public void setProfilePicture(String profilePicture) {
            this.profilePicture = profilePicture;
        }
    }
}
