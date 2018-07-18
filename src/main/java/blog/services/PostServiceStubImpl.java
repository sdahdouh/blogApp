/*
package blog.services;

import blog.models.Post;
import blog.models.User;
import blog.models.UserRole;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PostServiceStubImpl implements PostService{

    private List <Post> posts = new ArrayList<Post>(){{
        add(new Post(1L, "Write Code for Coffee", "<p> Do you need a coder? #1.</p><p>Hit me up in Facebook! #2</pl>", null));
        add(new Post(2L, "Searching for a Front-End Dev!", "<p> Searching for someone near Frankfurt</p><p> Send me a dm if intrested!",new User(10L,"Recruiter96","Adam Stevans",5L)));
        add(new Post(3L,"Hey I need some friends","<p>Iam not akward I swear!</p>",new User(10L, "lonelySamurai99", "Patrick Miller",5L,new UserRole("USER"))));
        add(new Post(4L,"Lets talk about Code Baby!","<p>Who wants to talk about code?!</p>",null));
        add(new Post(4L,"Have you watched the new Blade Runner Movie!","<p>Any reviews?</p>",null));
        add(new Post(4L,"I want a girlfriend so badly","Iam a good guy, but I face difficulties when talking to girls</p>",null));
    }};


    @Override
    public List<Post> findAll() {
        return this.posts;
    }

   */
/* Sorts the list using a stream. Lambda expressions are used to compare the posts id, limits the results to the first 5 and collects them in
    another list which is returned*//*

    @Override
    public List<Post> findLatest5() {

        return this.posts.stream().sorted((a, b) -> b.getDate().compareTo(a.getDate())).limit(5).collect(Collectors.toList());
    }

    */
/*Filters the list using a stream. Lambda expressions are used to iterate over the list in compares each element by the id*//*

    @Override
    public Post findById(Long id) {

        return this.posts.stream().filter(p -> Objects.equals(p.getId(), id)).findFirst().orElse(null);
    }

    */
/*Creates a new post. A Stream of the posts list is created. The max id is searched and a new id is created which is +1 of the old max ID*//*

    @Override
    public Post create(Post post) {
        post.setId(this.posts.stream().mapToLong(p -> p.getId()).max().getAsLong()+1);
        this.posts.add(post);
        return post;
    }

    */
/*Iterates over the posts list and searches for the post that is to be edited*//*

    @Override
    public Post edit(Post post) {
        for(int i = 0; i < this.posts.size(); i++) {
            if(Objects.equals(this.posts.get(i).getId(), post.getId())){
                this.posts.set(i, post);
                return post;
            }
        }
        throw new RuntimeException("post not found: " + post.getId());
    }

    */
/*Iterates over the list and searches by id. The post is beeing removed*//*

    @Override
    public void deleteById(Long id) {
        for(int i = 0; i < this.posts.size(); i++) {
            if(Objects.equals(this.posts.get(i).getId(), id)){
                this.posts.remove(i);
                return;
            }
        }
        throw new RuntimeException("post not found: " + id);
    }

}
*/
