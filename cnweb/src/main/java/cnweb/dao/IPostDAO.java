package cnweb.dao;

import java.util.List;

import cnweb.model.Post;

public interface IPostDAO extends GenericDAO<Post>{
	
	public int newPost(Post post) ;
	public void updatePost(Post post) ;
	public void deletePost(int id) ;
	
	public List<Post> findAll() ;
	
	public List<Post> findPostsByAuthor(int authorId) ;
	
	public Post findPostById(int id) ;
	public Post getNextPost(Post post);
	public Post getPreviousPost(Post post);
	public List<Post> getPosts(int index, int offset);
	
}
