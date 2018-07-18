package blog.controllers;

import blog.models.Post;
import blog.models.User;
import blog.repositories.PostRepository;
import blog.repositories.UserRepository;
import blog.services.CustomUserDetails;
import blog.services.CustomUserDetailsService;
import blog.services.PostService;
import blog.services.UserService;
import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PostsController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepo;

    @RequestMapping("/posts/view/{id}")
    public String view(@PathVariable("id") Long id, Model model){
        Post post = postService.findById(id);
        model.addAttribute("post",post);
        return "posts/view";

    }

    @RequestMapping("/posts/allposts")
    public String allPosts(Model model) {
        List<Post> allPosts = postService.findAll();
        model.addAttribute("allPosts", allPosts);
        return "posts/allposts";
    }

    @GetMapping("posts/create")
    public String create(Model model) {
        Post newPost = new Post();
        model.addAttribute("newPost", newPost);
        return "posts/create";
    }

    @PostMapping("posts/create")
    public String createSubmit(@ModelAttribute Post newPost) {
        User user = userService.findActiveUser();
        user.setActivityPoints(userService.increaseActivityPoints());
        newPost.setAuthor(user);
        postService.create(newPost);
        return "posts/result";
    }
;

//    @Controller
//    public class GreetingController {
//
//        @GetMapping("/greeting")
//        public String greetingForm(Model model) {
//            model.addAttribute("greetingo", new Greeting());
//            return "greeting";
//        }
//
//        @PostMapping("/greeting")
//        public String greetingSubmit(@ModelAttribute Greeting greetingo) {
//            return "result";
//        }
//
//    }

//    @PostMapping("/notes")
//    public Post create(@Valid @RequestBody Note note) {
//        return postRepository.v(note);
//    }


}
