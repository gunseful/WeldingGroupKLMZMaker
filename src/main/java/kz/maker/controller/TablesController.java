package kz.maker.controller;

import kz.maker.entity.Cathet;
import kz.maker.service.CathetService;
import kz.maker.service.PlateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tables")
public class TablesController {

    public TablesController(CathetService cathetService) {
        this.cathetService = cathetService;
    }

    private final CathetService cathetService;

    @GetMapping
    public String tables() {
        return "tables";
    }

    @GetMapping("{tableName}")
    public String getTableByName(Model model, @PathVariable String tableName) {
        cathetService.getTables(tableName, model);
        model.addAttribute("seam", tableName);
        return "tables";
    }

    @GetMapping("edit/{id}")
    public String editPage(Model model, @PathVariable int id) {
        model.addAttribute("cathet", cathetService.findById(id));
        return "edit";
    }

    @PostMapping("edit")
    public String edit(@ModelAttribute Cathet cathet) {
        cathetService.save(cathet);
        return "redirect:/tables";
    }

    @GetMapping("delete/{id}")
    public String deleteFromTable(@PathVariable int id, Model model) {
        var s = cathetService.findById(id);
        cathetService.deleteFromTable(id);
        return getTableByName(model, s.getSeam());
    }


}
