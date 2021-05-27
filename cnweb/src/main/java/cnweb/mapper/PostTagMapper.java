package cnweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import cnweb.model.PostTag;

public class PostTagMapper implements RowMapper<PostTag>{

	@Override
	public PostTag mapRow(ResultSet rs) {
		try {
			PostTag pt = new PostTag();
			pt.setId(rs.getInt("id"));
			pt.setPostId(rs.getInt("post_id"));
			pt.setTagId(rs.getInt("tag_id"));
			
			return pt;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
