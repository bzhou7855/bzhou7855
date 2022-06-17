package com.hou.mapper;

import com.hou.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    void addBlog(Blog blog);

    List<Blog> queryBlogIF(Map map);

    List<Blog> queryBlogchoose(Map map);

    void updateBlog(Map map);

    /*
        * @param map
        * @return java.util.List<com.hou.pojo.Blog>
        * @author bobzhou
        * @date 2022/6/17 16:18
    */
    List<Blog> queryBlogForeach(Map map);
    
    

}
