package cnweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import cnweb.dao.IPostTagDAO;
import cnweb.dao.ITagDAO;
import cnweb.dao.impl.PostTagDAO;
import cnweb.dao.impl.TagDAO;
import cnweb.model.PostTag;
import cnweb.model.Tag;
import cnweb.service.ITagService;

public class TagService implements ITagService {
	
	private ITagDAO tagDao = new TagDAO();
	private IPostTagDAO postTagDao = new PostTagDAO();

	@Override
	public int newTag(Tag tag)   {
		return tagDao.newTag(tag);
	}

	@Override
	public void deleteTag(int tagId)   {
		tagDao.deleteTag(tagId);
		List<PostTag> pts = new ArrayList<PostTag>();
		pts = postTagDao.findPostsByTag(tagId);
		for(PostTag pt : pts) {
			tagDao.deleteTag(pt.getTagId());
			postTagDao.deletePostTag(pt.getId());
		}
	}

	@Override
	public List<Tag> findAll()   {
		return tagDao.findAll();
	}

	@Override
	public Tag findTagByName(String name)   {
		return tagDao.findTagByName(name);
	}

	@Override
	public Tag findTagById(int tagId)   {
		return tagDao.findTagById(tagId);
	}

}
