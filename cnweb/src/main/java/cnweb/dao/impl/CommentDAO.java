package cnweb.dao.impl;

import java.util.List;

import cnweb.dao.ICommentDAO;
import cnweb.mapper.CommentMapper;
import cnweb.model.Comment;

public class CommentDAO extends AbstractDAO<Comment> implements ICommentDAO{

	@Override
	public List<Comment> findAllCommentsInAPost(int postId) {
		String sql = "SELECT * FROM comment WHERE post_id = ?";
		List<Comment> comments = this.query(sql, new CommentMapper(), postId);
		
		return comments;
	}
	
	@Override
	public Comment findById(int commentId) {
		String sql = "SELECT * FROM comment WHERE id = ?";
		List<Comment> comments = this.query(sql, new CommentMapper(), commentId);
		if(comments.size() == 0) return null;
		return comments.get(0);
	}

	@Override
	public int newComment(Comment comment){
		String sql = "INSERT INTO comment(post_id, user_id, content) VALUES(?,?,?)";
		return insert(sql, comment.getPostId(), comment.getUserId(), comment.getContent());
	}

	@Override
	public void updateComment(Comment comment){
		String sql = "UPDATE comment SET content = ?, updated_time = ? WHERE id = ?";
		update(sql, comment.getContent(), comment.getUpdatedTime(), comment.getId());
	}

	@Override
	public void deleteComment(int id){
		String sql = "DELETE FROM comment WHERE id = ?";
		update(sql, id);
	}

	@Override
	public List<Comment> findAll() {
		String sql = "SELECT * FROM comment";
		return this.query(sql, new CommentMapper());
	}

	@Override
	public List<Comment> findByAuthor(int id) {
		String sql = "SELECT * FROM comment WHERE author_id = ?";
		return this.query(sql, new CommentMapper(), id);
	}

}
