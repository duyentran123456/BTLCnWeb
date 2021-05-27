package cnweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import cnweb.model.Tag;

public class TagMapper implements RowMapper<Tag> {

	@Override
	public Tag mapRow(ResultSet rs) {
		try {
			Tag tag = new Tag();
			tag.setId(rs.getInt("id"));
			tag.setName(rs.getString("name"));
			
			return tag;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
