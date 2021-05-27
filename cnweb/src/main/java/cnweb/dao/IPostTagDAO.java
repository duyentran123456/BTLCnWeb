package cnweb.dao;

import java.util.List;

import cnweb.model.PostTag;

public interface IPostTagDAO extends GenericDAO<PostTag>{
	
	public int newPostTag(PostTag pt) ;
	public void updatePostTag(PostTag pt) ;
	public void deletePostTag(int id) ;
	
	public List<PostTag> findPostsByTag(int tagId) ;
	
	public List<PostTag> findTagsOfPost(int postId) ;
}
