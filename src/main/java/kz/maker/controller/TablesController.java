package kz.maker.controller;

import kz.maker.entity.Cathet;
import kz.maker.service.CathetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tables")
public class TablesController {

    private final CathetService cathetService;


    public TablesController(CathetService cathetService) {
        this.cathetService = cathetService;
    }


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

    @PostMapping("edit")
    public String edit(@ModelAttribute Cathet cathet) {
        cathetService.save(cathet);
        return "redirect:/tables";
    }

    @GetMapping("edit/{id}")
    public String editPage(Model model, @PathVariable int id) {
        model.addAttribute("cathet", cathetService.findById(id));
        return "edit";
    }

    @GetMapping("delete/{id}")
    public String deleteFromTable(@PathVariable int id, Model model) {
        var s = cathetService.findById(id);
        cathetService.deleteFromTable(id);
        return getTableByName(model, s.getSeam());
    }
}
