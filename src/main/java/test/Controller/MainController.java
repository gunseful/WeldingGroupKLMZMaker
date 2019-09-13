package test.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import test.Dao.CathetDao;
import test.entity.Cathet;
import test.entity.Seam;

import java.util.ArrayList;
import java.util.Set;

@Controller
public class MainController {

    private double wire = 0.0;
    private double gas = 0.0;
    private double gasCO2 = 0.0;
    private double gasAr = 0.0;
    private double svarPol = 0.0;
    private ArrayList<Seam> history = new ArrayList<>();


    private final CathetDao cathetDao;

    public MainController(CathetDao cathetDao) {
        this.cathetDao = cathetDao;
    }

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
    public String tables(Model model) {
        Set.of("Т1", "Т3", "Т6", "Н1", "У4").forEach(s -> model.addAttribute(s, cathetDao.findAllBySeam(s)));
        return "tables";
    }

    @GetMapping("/edit/{id}")
    public String editPage(Model model, @PathVariable int id) {
        model.addAttribute("cathet", cathetDao.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Cathet cathet) {
        cathetDao.save(cathet);
        return "redirect:/tables";
    }

    @GetMapping("/tables/{id}")
    public String deleteFromTable(@PathVariable int id) {
        Cathet cathet = cathetDao.findById(id);
        cathetDao.delete(cathet);
        return "redirect:/tables";
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

        Cathet cathet = cathetDao.findOneBySeamAndCathet(seam, k);
        if (cathet != null) {
            wire = cathet.getCoefficient() * lenght;
            gas = wire * 1.5;
            gasCO2 = wire * 0.87;
            gasAr = wire * 0.39;
            svarPol = lenght * 10;
            history.clear();
            history.add(new Seam(history.size() + 1, cathet, lenght));
        } else {
            model.addAttribute("fail", "Выберете пожалуйста другой катет");
        }
        return "redirect:/newSeam";
    }

    @GetMapping("/newSeam")
    public String getCalc(Model model) {
        modelAdd(model);
        return "newSeam";
    }

    @PostMapping("/newSeam/remove")
    public String removeSeam(@RequestParam(name = "cathet") int cathetId,
                             @RequestParam(name = "seam") int seamId,
                             @RequestParam(name = "lenght") double lenght) {

        var cathet = cathetDao.findById(cathetId);
        wire -= cathet.getCoefficient() * lenght;
        var localWire = cathet.getCoefficient() * lenght;
        gas -= localWire * 1.5;
        gasCO2 -= localWire * 0.87;
        gasAr -= localWire * 0.39;
        svarPol -= lenght * 10;

        Seam seam = null;

        for (Seam s : history) {
            if (s.getId() == seamId) {
                seam = s;
            }
        }

        history.remove(seam);

        return "redirect:/newSeam";
    }


    @PostMapping("/newSeam")
    public String calcPlus(@RequestParam(name = "seam") String seam,
                           @RequestParam(name = "length") double lenght,
                           @RequestParam(name = "cathet") int k,
                           Model model) {
        if (seam.equals("null")) {
            modelAdd(model);
            model.addAttribute("fail", "Выберете тип шва");
            return "newSeam";
        }

        Cathet cathet = cathetDao.findOneBySeamAndCathet(seam, k);
        if (cathet != null) {
            history.add(new Seam(history.size() + 1, cathet, lenght));
            wire += cathet.getCoefficient() * lenght;
            var localWire = cathet.getCoefficient() * lenght;
            gas += localWire * 1.5;
            gasCO2 += localWire * 0.87;
            gasAr += localWire * 0.39;
            svarPol += lenght * 10;
            modelAdd(model);
        } else {
            modelAdd(model);
            model.addAttribute("fail", "Выберете пожалуйста другой катет");
        }
        return "newSeam";
    }

    private void modelAdd(Model model) {
        model.addAttribute("history", history);
        model.addAttribute("wire", String.format("%.2f", wire));
        model.addAttribute("gas", String.format("%.2f", gas));
        model.addAttribute("gasCO2", String.format("%.2f", gasCO2));
        model.addAttribute("gasAr", String.format("%.2f", gasAr));
        model.addAttribute("svarPol", String.format("%.2f", svarPol));
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Cathet cathet, Model model) {
        if (cathet.getSeam().equals("null")) {
            model.addAttribute("fail", "Выберете тип шва");
            return "add";
        }
        Cathet cathetFromDb = cathetDao.findOneBySeamAndCathet(cathet.getSeam(), cathet.getCathet());
        if (cathetFromDb != null) {
            model.addAttribute("fail", "Катет уже существует в базе данных");
            return "add";
        }
        cathetDao.save(cathet);
        model.addAttribute("fail", "Добавлено!");
        return "add";
    }
}