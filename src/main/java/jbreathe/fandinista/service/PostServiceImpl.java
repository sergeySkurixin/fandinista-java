package jbreathe.fandinista.service;

import jbreathe.fandinista.dao.PostDao;
import jbreathe.fandinista.dto.Post;
import jbreathe.fandinista.entity.PostEntity;
import jbreathe.fandinista.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    private PostDao dao;
    private Mapper mapper;

    @Autowired
    public PostServiceImpl(PostDao dao, Mapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public Post save(Post dto) {
        PostEntity postEntity = mapper.map(dto, PostEntity.class);
        PostEntity savedEntity = dao.save(postEntity);
        return mapper.map(savedEntity, Post.class);
    }

    @Override
    public Post findById(Long aLong) {
        PostEntity postEntity = dao.findById(aLong);
        return mapper.map(postEntity, Post.class);
    }

    @Override
    public List<Post> findAll() {
        List<PostEntity> postEntities = dao.findAll();
        return mapper.mapAsList(postEntities, Post.class);
    }

    @Override
    public Post update(Post dto) {
        PostEntity postEntity = mapper.map(dto, PostEntity.class);
        PostEntity updatedEntity = dao.update(postEntity);
        return mapper.map(updatedEntity, Post.class);
    }

    @Override
    public void delete(Long aLong) {
        dao.delete(aLong);
    }
}
