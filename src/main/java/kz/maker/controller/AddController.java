package kz.maker.controller;

import kz.maker.entity.Cathet;
import kz.maker.entity.Plate;
import kz.maker.service.CathetService;
import kz.maker.service.PlateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/add")
public class AddController {

    public AddController(CathetService cathetService, PlateService plateService) {
        this.cathetService = cathetService;
        this.plateService = plateService;
    }

    private final CathetService cathetService;
    private final PlateService plateService;

    @GetMapping("{seam}")
    public String add(Model model, @PathVariable String seam) {
        model.addAttribute("seam", seam);
        return "add";
    }

    @GetMapping("cut")
    public String addNewCut() {
        return "addNewCut";
    }

    @PostMapping("cut")
    public String addNewCut(@ModelAttribute Plate plate, Model model) {
        Plate plateFromDb = plateService.findOneByPlateValue(plate.getPlateValue());
        if (plateFromDb != null) {
            model.addAttribute("b", plate.getPlateValue());
            model.addAttribute("fail", "Катет уже существует в базе данных");
            return "add";
        }
        plateService.save(plate);
        model.addAttribute("fail", "Добавлено!");
        model.addAttribute("b", plate.getPlateValue());
        return "addNewCut";
    }

    @PostMapping
    public String add(@ModelAttribute Cathet cathet, Model model) {
        Cathet cathetFromDb = cathetService.findOneBySeamAndCathet(cathet);
        if (cathetFromDb != null) {
            model.addAttribute("seam", cathet.getSeam());
            model.addAttribute("fail", "Катет уже существует в базе данных");
            return "add";
        }
        cathetService.save(cathet);
        model.addAttribute("fail", "Добавлено!");
        model.addAttribute("seam", cathet.getSeam());
        return "add";
    }
}
