package cnweb.service;

import java.util.List;

import cnweb.model.Post;
import cnweb.model.PostTag;
import cnweb.model.Tag;

public interface IPostService {
	public int newPost(Post post);
	public void updatePost(Post post);
	public void deletePost(int postId);
	public void addTag(PostTag pt);
	
	public List<Post> findPostByAuthor(int authorId);
	public List<Post> findAll();
	public Post findPostById(int postId);
	public List<Post> findPostsByTag(int tagId);
	public List<Tag> findTagsOfPost(int postId);
	
	public Post getNextPost(Post post);
	public Post getPreviousPost(Post post);
	public List<Post> getPosts(int index, int offset);
}
