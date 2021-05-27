package cnweb.service;

import java.util.List;

import cnweb.model.Tag;

public interface ITagService {
	public int newTag(Tag tag);
	public void deleteTag(int tagId);
	
	public List<Tag> findAll();
	public Tag findTagByName(String name);
	public Tag findTagById(int tagId);
}
