package wt.restaurant;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping(path = "/")
    public ModelAndView index(){
        return new ModelAndView("index");
    }
}
