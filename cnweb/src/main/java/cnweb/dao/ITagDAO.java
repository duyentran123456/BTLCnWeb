package cnweb.dao;

import java.util.List;

import cnweb.model.Tag;

public interface ITagDAO extends GenericDAO<Tag> {
	
	public int newTag(Tag tag) ;
	public void deleteTag(int id) ;
	
	public List<Tag> findAll() ;
	
	public Tag findTagByName(String tagName) ;

	public Tag findTagById(int tagId) ;
}
