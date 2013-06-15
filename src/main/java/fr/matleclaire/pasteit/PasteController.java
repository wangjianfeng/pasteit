package fr.matleclaire.pasteit;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PasteController {

    @RequestMapping("/")
    @ResponseBody
    public String hello() {
        return "Hello world !";
    }


}