package cnweb.service.impl;

import java.util.List;

import cnweb.dao.ICommentDAO;
import cnweb.dao.impl.CommentDAO;
import cnweb.model.Comment;
import cnweb.service.ICommentService;

public class CommentService implements ICommentService {

	private ICommentDAO dao = new CommentDAO();

	@Override
	public int newComment(Comment comment) {
		int id = dao.newComment(comment);
		return id;
	}

	@Override
	public void updateComment(Comment comment){
		dao.updateComment(comment);
	}

	@Override
	public void deleteComment(int commentId) {
		dao.deleteComment(commentId);
	}

	@Override
	public List<Comment> findAllCommentsInAPost(int postId) {
		return dao.findAllCommentsInAPost(postId);
	}

	@Override
	public Comment findById(int commentId) {
		Comment comment = dao.findById(commentId);
		return comment;
	}

	@Override
	public List<Comment> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Comment> findByAuthor(int id) {
		return dao.findByAuthor(id);
	}
}
