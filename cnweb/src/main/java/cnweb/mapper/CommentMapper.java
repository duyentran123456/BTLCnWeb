package cnweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import cnweb.model.Comment;

public class CommentMapper implements RowMapper<Comment>{

	@Override
	public Comment mapRow(ResultSet rs) {
		try {
			Comment comment = new Comment();
			
			comment.setId(rs.getInt("id"));
			comment.setPostId(rs.getInt("post_id"));
			comment.setUserId(rs.getInt("user_id"));
			comment.setContent(rs.getString("content"));
			comment.setCreatedTime(rs.getTimestamp("created_time"));
			comment.setUpdatedTime(rs.getTimestamp("updated_time"));
			
			return comment;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
