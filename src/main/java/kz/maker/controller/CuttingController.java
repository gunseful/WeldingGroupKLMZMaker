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
@RequestMapping("/cutting")
public class CuttingController {


    public CuttingController(PlateService plateService) {
        this.plateService = plateService;
    }

    private final PlateService plateService;

    @GetMapping
    public String cutting(String name, Model model) {
        model.addAttribute("name", name);
        return "cutting";
    }

    @PostMapping
    public String calc(@RequestParam(name = "length") double lenght,
                       @RequestParam(name = "b") int k,
                       Model model) {
        if(plateService.calc(k, lenght, model)){
            return "redirect:/cutting/more";
        }else{
            return "cutting";
        }
    }

    @GetMapping("more")
    public String keepcutting(Model model) {
        plateService.modelAdd(model);
        return "keepCutting";
    }

    @PostMapping("more")
    public String calcPlusCut(
            @RequestParam(name = "length") double lenght,
            @RequestParam(name = "b") int k,
            Model model) {
        plateService.calcPlus(k, lenght, model);
        return "keepCutting";
    }


    @PostMapping("more/remove")
    public String removeCut(@RequestParam(name = "plateId") int plateId,
                            @RequestParam(name = "cutId") int cutId,
                            @RequestParam(name = "lenght") double lenght) {

        plateService.calcMinus(plateId, cutId, lenght);
        return "redirect:/cutting/more";
    }


}
