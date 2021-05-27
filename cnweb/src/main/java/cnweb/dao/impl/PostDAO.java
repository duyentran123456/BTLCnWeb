package cnweb.dao.impl;

import java.util.List;

import cnweb.dao.IPostDAO;
import cnweb.mapper.PostMapper;
import cnweb.model.Post;

public class PostDAO extends AbstractDAO<Post> implements IPostDAO {

	@Override
	public List<Post> findAll()  {
		String sql = "SELECT * FROM post";
		List<Post> posts = this.query(sql, new PostMapper());

		return posts;
	}
	
	@Override
	public List<Post> getPosts(int index, int offset) {
		String sql = "SELECT * FROM post ORDER BY created_time DESC LIMIT ?, ?";
		List<Post> posts = this.query(sql, new PostMapper(), index, offset);
		return posts;
	}

	@Override
	public List<Post> findPostsByAuthor(int authorId)  {
		String sql = "SELECT * FROM post WHERE author_id = ?";
		List<Post> posts = this.query(sql, new PostMapper(), authorId);

		return posts;
	}

	@Override
	public Post findPostById(int id)  {
		String sql = "SELECT * FROM post WHERE id = ?";
		List<Post> posts = this.query(sql, new PostMapper(), id);

		return posts.isEmpty() ? null : posts.get(0);
	}

	@Override
	public int newPost(Post post)  {
		String sql = "INSERT INTO post(author_id, title, content) VALUES(?,?,?)";
		
		return insert(sql, post.getAuthorId(), post.getTitle(), post.getContent());
	}

	@Override
	public void updatePost(Post post)  {
		String sql = "UPDATE post SET title = ? content = ? WHERE id = ?";
		update(sql, post.getTitle(), post.getContent(), post.getId());
		sql = "UPDATE post SET content = ? WHERE id = ?";
		update(sql, post.getContent(), post.getId());
		sql = "UPDATE post SET updated_time = ? WHERE id = ?";
		update(sql, post.getUpdatedTime(), post.getId());
	}

	@Override
	public void deletePost(int id)  {
		String sql = "DELETE FROM post WHERE id = ?";
		update(sql, id);
	}
	
	@Override
	public Post getNextPost(Post post) {
		String sql = "SELECT * FROM post WHERE created_time > ? ORDER BY created_time ASC LIMIT 1";
		List<Post> posts = this.query(sql, new PostMapper(), post.getCreatedTime());
		
		return posts.isEmpty() ? null : posts.get(0);
	}
	
	@Override
	public Post getPreviousPost(Post post) {
		String sql = "SELECT * FROM post WHERE created_time < ? ORDER BY created_time DESC LIMIT 1";
		List<Post> posts = this.query(sql, new PostMapper(), post.getCreatedTime());
		
		return posts.isEmpty() ? null : posts.get(0);
	}
}
