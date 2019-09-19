package kz.maker.controller;

import kz.maker.entity.Cathet;
import kz.maker.entity.Plate;
import kz.maker.service.CathetService;
import kz.maker.service.PlateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    public MainController(CathetService cathetService, PlateService plateService) {
        this.cathetService = cathetService;
        this.plateService = plateService;
    }

    private final CathetService cathetService;
    private final PlateService plateService;

    @GetMapping("/add/{seam}")
    public String add(Model model, @PathVariable String seam) {
        model.addAttribute("seam", seam);
        return "add";
    }


    @GetMapping("/")
    public String greeting(String name, Model model) {
        model.addAttribute("name", name);
        return "main";
    }

    @GetMapping("/cutting")
    public String cutting(String name, Model model) {
        model.addAttribute("name", name);
        return "cutting";
    }

    @PostMapping("/cutting")
    public String calc(@RequestParam(name = "length") double lenght,
                       @RequestParam(name = "b") int k,
                       Model model) {
        if(plateService.calc(k, lenght, model)){
            return "redirect:/keepcutting";
        }else{
            return "cutting";
        }
    }

    @GetMapping("/keepcutting")
    public String keepcutting(Model model) {
        plateService.modelAdd(model);
        return "keepCutting";
    }


    @GetMapping("/addNewCut")
    public String addNewCut() {
        return "addNewCut";
    }

    @PostMapping("/addNewCut")
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


    @PostMapping("/keepcutting")
    public String calcPlusCut(
                           @RequestParam(name = "length") double lenght,
                           @RequestParam(name = "b") int k,
                           Model model) {
        plateService.calcPlus(k, lenght, model);
        return "keepCutting";
    }


    @PostMapping("/keepcutting/remove")
    public String removeCut(@RequestParam(name = "plateId") int plateId,
                             @RequestParam(name = "cutId") int cutId,
                             @RequestParam(name = "lenght") double lenght) {

        plateService.calcMinus(plateId, cutId, lenght);
        return "redirect:/keepcutting";
    }

    @GetMapping("/tables")
    public String tables() {
        return "tables";
    }

    @GetMapping("/tables/{tableName}")
    public String getTableByName(Model model, @PathVariable String tableName) {
        cathetService.getTables(tableName, model);
        model.addAttribute("seam", tableName);
        return "tables";
    }

    @GetMapping("/edit/{id}")
    public String editPage(Model model, @PathVariable int id) {
        model.addAttribute("cathet", cathetService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Cathet cathet) {
        cathetService.save(cathet);
        return "redirect:/tables";
    }

    @GetMapping("/tables/delete/{id}")
    public String deleteFromTable(@PathVariable int id, Model model) {
        var s = cathetService.findById(id);
        cathetService.deleteFromTable(id);
        return  getTableByName(model, s.getSeam());
    }

    @PostMapping("/")
    public String calc(@RequestParam(name = "seam") String seam,
                       @RequestParam(name = "length") double lenght,
                       @RequestParam(name = "k") int k,
                       Model model) {

        if (seam.equals("null")) {
            model.addAttribute("fail", "Выберете тип шва");
            return "main";
        }
        if(cathetService.calc(seam, lenght, k, model)) {
            return "redirect:/newSeam";
        }else{
            return "main";
        }
    }

    @GetMapping("/newSeam")
    public String getCalc(Model model) {
        cathetService.modelAdd(model);
        return "newSeam";
    }

    @PostMapping("/newSeam/remove")
    public String removeSeam(@RequestParam(name = "cathet") int cathetId,
                             @RequestParam(name = "seam") int seamId,
                             @RequestParam(name = "lenght") double lenght) {

        cathetService.calcMinus(cathetId, seamId, lenght);
        return "redirect:/newSeam";
    }


    @PostMapping("/newSeam")
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

    @PostMapping("/add")
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