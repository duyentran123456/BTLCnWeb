package cnweb.dao.impl;

import java.util.List;

import cnweb.dao.ITagDAO;
import cnweb.mapper.TagMapper;
import cnweb.model.Tag;

public class TagDAO extends AbstractDAO<Tag> implements ITagDAO {

	@Override
	public List<Tag> findAll()  {
		StringBuilder sql = new StringBuilder("SELECT * FROM tag");
		List<Tag> tags = query(sql.toString(), new TagMapper());

		return tags;
	}

	@Override
	public Tag findTagByName(String tagName)  {
		StringBuilder sql = new StringBuilder("SELECT * FROM tag WHERE name = ?");
		List<Tag> tags = query(sql.toString(), new TagMapper(), tagName);

		return tags.isEmpty() ? null : tags.get(0);
	}

	@Override
	public Tag findTagById(int tagId)  {
		StringBuilder sql = new StringBuilder("SELECT * FROM tag WHERE id = ?");
		List<Tag> tags = query(sql.toString(), new TagMapper(), tagId);

		return tags.isEmpty() ? null : tags.get(0);
	}

	@Override
	public int newTag(Tag tag)  {
		String sql = "INSERT INTO tag(name) VALUES(?)";
		
		return insert(sql, tag.getName());
	}

	@Override
	public void deleteTag(int id)  {
		String sql = "DELETE FROM tag WHERE id = ?";
		update(sql, id);
	}

}
