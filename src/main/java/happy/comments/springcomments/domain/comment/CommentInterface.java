package happy.comments.springcomments.domain.comment;

public interface CommentInterface {
    public String showContent();
    public boolean checkUpdate();
    public void updateComment(String content);
}
