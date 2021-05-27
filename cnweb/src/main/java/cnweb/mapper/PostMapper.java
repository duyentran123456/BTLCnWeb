package cnweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import cnweb.model.Post;

public class PostMapper implements RowMapper<Post> {

	@Override
	public Post mapRow(ResultSet rs) {
		try {
			Post post = new Post();
			
			post.setId(rs.getInt("id"));
			post.setAuthorId(rs.getInt("author_id"));
			post.setTitle(rs.getString("title"));
			post.setContent(rs.getString("content"));
			post.setCreatedTime(rs.getTimestamp("created_time"));
			post.setUpdatedTime(rs.getTimestamp("updated_time"));
			
			return post;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
