package fr.matleclaire.pasteit;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PasteController {

    @RequestMapping(value = "/", produces = "application/json")
    @ResponseBody
    public Paste hello() {
        return new Paste("1-test", "hello", "world");
    }


}