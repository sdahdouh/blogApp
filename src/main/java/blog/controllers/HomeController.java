package blog.controllers;

import blog.models.Post;
import blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    @Autowired
    private PostService postService;

    /*Puts in the view model the latest 5 posts as an object named "latest 5 posts
    and the latest 3 posts as an object named "latest3posts" to be shown at the home page by the view*/
    @RequestMapping("/")
    public String index(Model model)
    {
        List<Post> latest5Posts = postService.findLatest5();
        model.addAttribute("latest5posts", latest5Posts);

        List<Post> latest3Posts = latest5Posts.stream().limit(3).collect(Collectors.toList());
        model.addAttribute("latest3posts", latest3Posts);
        return "index";
    }




    @RequestMapping("/login")
    public String login(Model model)
    {

        return "login";
    }



}
