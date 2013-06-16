package fr.matleclaire.pasteit;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PasteController {

    @Autowired
    private PasteRepository pasteRepository;

    @RequestMapping(value = "/", produces = "application/json")
    @ResponseBody
    public Paste hello() {
        return new Paste("1-test", "hello", "world");
    }


    @RequestMapping(value="createOne", method = RequestMethod.GET)
    @ResponseBody
    public void createOne() {
        Paste p = new Paste("1", "hello", "world");
        pasteRepository.save(p);
    }

    @RequestMapping(value="test", method = RequestMethod.GET)
    @ResponseBody
    public List<Paste> getAll() {
        return pasteRepository.findAll();
    }


}