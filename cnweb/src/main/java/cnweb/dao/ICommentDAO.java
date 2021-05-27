package cnweb.dao;

import java.util.List;

import cnweb.model.Comment;

public interface ICommentDAO extends GenericDAO<Comment>{
	public int newComment(Comment comment) ;
	public void updateComment(Comment comment) ;
	public void deleteComment(int id) ;
	
	public List<Comment> findAllCommentsInAPost(int postId) ;
	public Comment findById(int commentId) ;
	public List<Comment> findAll();
	public List<Comment> findByAuthor(int id);
}
