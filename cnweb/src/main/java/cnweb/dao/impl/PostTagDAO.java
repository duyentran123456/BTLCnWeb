package cnweb.dao.impl;

import java.util.List;

import cnweb.dao.IPostTagDAO;
import cnweb.mapper.PostTagMapper;
import cnweb.model.PostTag;

public class PostTagDAO extends AbstractDAO<PostTag> implements IPostTagDAO{

	@Override
	public List<PostTag> findPostsByTag(int tagId) {
		String sql = "SELECT * FROM post_tag WHERE tag_id = ?";
		List<PostTag> postTags= this.query(sql, new PostTagMapper(), tagId);
		
		return postTags;
	}

	@Override
	public List<PostTag> findTagsOfPost(int postId) {
		String sql = "SELECT * FROM post_tag WHERE post_id = ?";
		List<PostTag> postTags= this.query(sql, new PostTagMapper(), postId);
		
		return postTags;
	}

	@Override
	public int newPostTag(PostTag pt) {
		String sql = "INSERT INTO post_tag(post_id, tag_id) VALUE(?,?)";
		return insert(sql, pt.getPostId(), pt.getTagId());
	}

	@Override
	public void updatePostTag(PostTag pt) {
		String sql = "UPDATE post_tag SET post_id = ? tag_id = ? WHERE id = ?";
		update(sql, pt.getPostId(), pt.getTagId(), pt.getId());
	}

	@Override
	public void deletePostTag(int id) {
		String sql = "DELETE FROM post_tag WHERE id = ?";
		update(sql, id);
	}

}
