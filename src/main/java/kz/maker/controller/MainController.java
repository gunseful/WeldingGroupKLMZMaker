package kz.maker.controller;

import kz.maker.entity.Cathet;
import kz.maker.service.CathetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    public MainController(CathetService cathetService) {
        this.cathetService = cathetService;
    }

    private final CathetService cathetService;

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
        cathetService.calc(seam, lenght, k, model);
        return "redirect:/newSeam";
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