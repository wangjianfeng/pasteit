package fr.matleclaire.pasteit;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class PasteController {

    @Autowired
    private PasteRepository pasteRepository;


    @RequestMapping(value="last", method = RequestMethod.GET)
    @ResponseBody
    public Page<Paste> getLast() {
        Pageable pageable = new PageRequest(0,5, Sort.Direction.DESC, "createdDate");
        return pasteRepository.findAll(pageable);
    }

    @RequestMapping(value="{id}", method = RequestMethod.GET)
    @ResponseBody
    public Paste getPaste(@PathVariable String id) {
        return pasteRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public Paste addPaste(@RequestBody Paste p) {
        return pasteRepository.save(p);
    }


}