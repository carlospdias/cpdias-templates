package br.com.cpdias.news;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @GetMapping(value = "/")
    ModelAndView index(){
        System.out.println("okikk kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
        ModelAndView mv = new ModelAndView();

        mv.setViewName("index");
        return mv;
    }
}
