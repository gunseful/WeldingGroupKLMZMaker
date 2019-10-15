package kz.maker.controller;

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

    private final PlateService plateService;

    public CuttingController(PlateService plateService) {
        this.plateService = plateService;
    }


    @GetMapping
    public String cutting(String name, Model model) {
        model.addAttribute("name", name);
        return "cutting";
    }

    @PostMapping
    public String calc(@RequestParam(name = "length") double length,
                       @RequestParam(name = "b") int k,
                       Model model) {
        if(plateService.calc(k, length, model)){
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
            @RequestParam(name = "length") double length,
            @RequestParam(name = "b") int k,
            Model model) {
        plateService.calcPlus(k, length, model);
        return "keepCutting";
    }


    @PostMapping("more/remove")
    public String removeCut(@RequestParam(name = "plateId") int plateId,
                            @RequestParam(name = "cutId") int cutId,
                            @RequestParam(name = "length") double length) {

        plateService.calcMinus(plateId, cutId, length);
        return "redirect:/cutting/more";
    }
}
