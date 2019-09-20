package kz.maker.controller;

import kz.maker.service.CathetService;
import kz.maker.service.PlateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/weld")
public class WeldController {

    public WeldController(CathetService cathetService) {
        this.cathetService = cathetService;
    }

    private final CathetService cathetService;



    @GetMapping
    public String weld(String name, Model model) {
        model.addAttribute("name", name);
        return "main";
    }

    @PostMapping
    public String calc(@RequestParam(name = "seam") String seam,
                       @RequestParam(name = "length") double lenght,
                       @RequestParam(name = "k") int k,
                       Model model) {

        if (seam.equals("null")) {
            model.addAttribute("fail", "Выберете тип шва");
            return "main";
        }
        if(cathetService.calc(seam, lenght, k, model)) {
            return "redirect:/weld/newSeam";
        }else{
            return "main";
        }
    }

    @GetMapping("newSeam")
    public String getCalc(Model model) {
        cathetService.modelAdd(model);
        return "newSeam";
    }

    @PostMapping("newSeam/remove")
    public String removeSeam(@RequestParam(name = "cathet") int cathetId,
                             @RequestParam(name = "seam") int seamId,
                             @RequestParam(name = "lenght") double lenght) {

        cathetService.calcMinus(cathetId, seamId, lenght);
        return "redirect:/weld/newSeam";
    }


    @PostMapping("newSeam")
    public String calcPlus(@RequestParam(name = "seam") String seam,
                           @RequestParam(name = "length") double lenght,
                           @RequestParam(name = "cathet") int k,
                           Model model) {
        if (seam.equals("null")) {
            cathetService.modelAdd(model);
            model.addAttribute("fail", "Выберете тип шва");
            return "newSeam";
        }
        cathetService.calcPlus(seam, lenght, k, model);
        return "newSeam";
    }


}
