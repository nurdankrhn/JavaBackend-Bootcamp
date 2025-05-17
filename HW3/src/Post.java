import java.util.HashSet;
import java.util.Set;

class Post {
    private String content;
    private Set<String> likes;

    public Post(String content) {
        this.content = content;
        this.likes = new HashSet<>();
    }

    public String getContent() {
        return content;
    }

    public void addLike(String username) {
        likes.add(username);
    }

    public Set<String> getLikes() {
        return likes;
    }
}
