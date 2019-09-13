package test.Controller;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import test.Dao.KatetDao;
import test.entity.Katet;
import test.entity.Seam;

import javax.validation.Valid;
import java.util.*;

@Controller
public class MainController {

    public double wire = 0.0;
    public double gas = 0.0;
    public double gasCO2 = 0.0;
    public double gasAr = 0.0;
    public double svarPol = 0.0;
    public ArrayList<Seam> history = new ArrayList();




    @Autowired
    private KatetDao katetDao;

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
        model.addAttribute("T1", katetDao.findAllBySeam("Т1"));
        model.addAttribute("T3", katetDao.findAllBySeam("Т3"));
        model.addAttribute("T6", katetDao.findAllBySeam("Т6"));
        model.addAttribute("Н1", katetDao.findAllBySeam("Н1"));
        model.addAttribute("У4", katetDao.findAllBySeam("У4"));


        return "tables";
    }

    @GetMapping("/edit/{id}")
    public String editPage(Model model, @PathVariable int id) {
        model.addAttribute("katet", katetDao.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Katet katet, Model model) {
        katetDao.save(katet);
        return "redirect:/tables";
    }

    @GetMapping("/tables/{id}")
    public String deleteFromTable(Model model, @PathVariable int id) {
        Katet katet = katetDao.findById(id);
        katetDao.delete(katet);
        return "redirect:/tables";
    }

    @PostMapping("/")
    public String calc(@RequestParam(name = "seam") String seam,
                       @RequestParam(name = "length") double lenght,
                       @RequestParam(name = "k") int k,
                       RedirectAttributes redirectAttributes,
                       Model model) {
        if (seam.equals("null")) {
            model.addAttribute("fail", "Выберете тип шва");
            return "main";

        }
        Katet katet = katetDao.findOneBySeamAndK(seam, k);
        if (katet != null) {
            wire = katet.getKoef() * lenght;
            gas = wire * 1.5;
            gasCO2 = wire * 0.87;
            gasAr = wire * 0.39;
            svarPol = lenght * 10;
            history.clear();

            history.add(new Seam(history.size()+1,katet, lenght));


            redirectAttributes.addFlashAttribute("history", history);
            redirectAttributes.addFlashAttribute("gasAr", String.format("%.2f", gasAr));
            redirectAttributes.addFlashAttribute("gasCO2", String.format("%.2f", gasCO2));
            redirectAttributes.addFlashAttribute("gas", String.format("%.2f", gas));
            redirectAttributes.addFlashAttribute("wire", String.format("%.2f", wire));
            redirectAttributes.addFlashAttribute("svarPol", String.format("%.2f", svarPol));


        } else {
            model.addAttribute("fail", "Выберете пожалуйста другой катет");
        }
        return "redirect:/newSeam";
    }

    @GetMapping("/newSeam")
    public String getCalc(
            Model model) {
        modelAdd(model);
        return "newSeam";
    }

    @PostMapping("/newSeam/remove")
    public String removeSeam(@RequestParam(name = "katet") int katetId,
                             @RequestParam(name = "seam") int seamId,
                             @RequestParam(name = "lenght") double lenght,
            Model model) {
        System.out.println(seamId);
        System.out.println(katetId);
        System.out.println(lenght);

//
        var katet = katetDao.findById(katetId);
        wire -= katet.getKoef() * lenght;
        var localWire = katet.getKoef() * lenght;
        gas -= localWire * 1.5;
        gasCO2 -= localWire * 0.87;
        gasAr -= localWire * 0.39;
        svarPol -= lenght * 10;

        Seam seam = null;

        for(Seam s : history){
            if(s.getId()==seamId){
                seam = s;
            }
        }
        history.remove(seam);

        return "redirect:/newSeam";
    }


    @PostMapping("/newSeam")
    public String calcPlus(@RequestParam(name = "seam") String seam,
                           @RequestParam(name = "length") double lenght,
                           @RequestParam(name = "k") int k,
                           RedirectAttributes redirectAttributes,
                           Model model) {
        if (seam.equals("null")) {
            modelAdd(model);
            model.addAttribute("fail", "Выберете тип шва");
            return "newSeam";
        }
        Katet katet = katetDao.findOneBySeamAndK(seam, k);
        if (katet != null) {
            history.add(new Seam(history.size()+1,katet, lenght));
            wire += katet.getKoef() * lenght;
            var localWire = katet.getKoef() * lenght;
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

    @PostMapping("/add/{seam}")
    public String add(@ModelAttribute Katet katet, Model model, BindingResult result, @PathVariable String seam) {
        var seam2 = "Т1";
        if (katet.getSeam().equals("null")) {
            model.addAttribute("fail", "Выберете тип шва");
            return "add";
        }
        Katet katetFromDb = katetDao.findOneBySeamAndK(katet.getSeam(), katet.getK());
        if (katetFromDb != null) {
            model.addAttribute("fail", "Катет уже существует в базе данных");
            return "add";
        }
        katetDao.save(katet);
        model.addAttribute("fail", "Добавлено!");
        return "add";
    }

}