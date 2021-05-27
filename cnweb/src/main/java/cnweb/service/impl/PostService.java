package cnweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import cnweb.dao.IPostDAO;
import cnweb.dao.IPostTagDAO;
import cnweb.dao.ITagDAO;
import cnweb.dao.impl.PostDAO;
import cnweb.dao.impl.PostTagDAO;
import cnweb.dao.impl.TagDAO;
import cnweb.model.Post;
import cnweb.model.PostTag;
import cnweb.model.Tag;
import cnweb.service.IPostService;

public class PostService implements IPostService {

	private IPostDAO postDao = new PostDAO();
	private IPostTagDAO postTagDao = new PostTagDAO();
	private ITagDAO tagDao = new TagDAO();

	@Override
	public int newPost(Post post) {
		return postDao.newPost(post);
	}

	@Override
	public void updatePost(Post post) {
		postDao.updatePost(post);
	}

	@Override
	public void deletePost(int postId) {
		postDao.deletePost(postId);
		List<PostTag> pts = postTagDao.findTagsOfPost(postId);
		for (PostTag pt : pts) {
			postTagDao.deletePostTag(pt.getId());
		}
	}

	@Override
	public List<Post> findPostByAuthor(int authorId){
		return postDao.findPostsByAuthor(authorId);
	}

	@Override
	public List<Post> findAll()   {
		return postDao.findAll();
	}
	
	@Override
	public List<Post> getPosts(int index, int offset) {
		return postDao.getPosts(index, offset);
	}

	@Override
	public Post findPostById(int postId)   {
		return postDao.findPostById(postId);
	}

	@Override
	public List<Post> findPostsByTag(int tagId)   {
		List<Post> posts = new ArrayList<Post>();
		List<PostTag> pts = postTagDao.findPostsByTag(tagId);
		for (PostTag pt : pts) {
			Post post = postDao.findPostById(pt.getPostId());
			if (post != null)
				posts.add(post);
		}

		if (posts.size() == 0)
			return null;

		return posts;
	}

	@Override
	public void addTag(PostTag pt)   {
		postTagDao.newPostTag(pt);
	}

	@Override
	public List<Tag> findTagsOfPost(int postId)   {
		List<Tag> tags = new ArrayList<Tag>();
		List<PostTag> pts = postTagDao.findTagsOfPost(postId);
		for (PostTag pt : pts) {
			Tag tag = tagDao.findTagById(pt.getTagId());
			if (tag != null)
				tags.add(tag);
		}

		return tags;
	}
	
	@Override
	public Post getNextPost(Post post) {
		return postDao.getNextPost(post);
	}
	
	@Override
	public Post getPreviousPost(Post post) {
		return postDao.getPreviousPost(post);
	}

}
