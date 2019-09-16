package kz.maker.service;

import kz.maker.dao.CathetDao;
import kz.maker.entity.Cathet;
import kz.maker.entity.Seam;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Comparator;

@Service
public class CathetService {

    private double wire = 0.0;
    private double gas = 0.0;
    private double gasCO2 = 0.0;
    private double gasAr = 0.0;
    private double svarPol = 0.0;
    private ArrayList<Seam> history = new ArrayList<>();

    private final CathetDao cathetDao;

    public CathetService(CathetDao cathetDao) {
        this.cathetDao = cathetDao;
    }

    public Cathet findById(int id){
        return cathetDao.findById(id);
    }

    public Cathet findOneBySeamAndCathet(Cathet cathet){
        System.out.println(cathetDao.findOneBySeamAndCathetValue(cathet.getSeam(), cathet.getCathetValue()));
        return cathetDao.findOneBySeamAndCathetValue(cathet.getSeam(), cathet.getCathetValue());

    }


    public void deleteFromTable(int id){
        Cathet cathet = cathetDao.findById(id);
        cathetDao.delete(cathet);
    }

    public void getTables(String str,Model model){
        var list = cathetDao.findAllBySeam(str);
        list.sort(Comparator.comparingInt(Cathet::getCathetValue));
        model.addAttribute("seamList", list);
    }

    public void save(Cathet cathet){
        cathetDao.save(cathet);
    }

    public void calc(String seam, double length, int k, Model model) {
        Cathet cathet = cathetDao.findOneBySeamAndCathetValue(seam, k);
        if (cathet != null) {
            wire = cathet.getCoefficient() * length;
            gas = wire * 1.5;
            gasCO2 = wire * 0.87;
            gasAr = wire * 0.39;
            svarPol = length * 10;
            history.clear();
            history.add(new Seam(history.size() + 1, cathet, length));
        } else {
            model.addAttribute("fail", "Выберете пожалуйста другой катет");
        }
    }

    public void calcPlus(String seam, double lenght, int k, Model model){
        Cathet cathet = cathetDao.findOneBySeamAndCathetValue(seam, k);
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
    }

    public void calcMinus(int cathetId, int seamId, double lenght){
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
    }

    public void modelAdd(Model model) {
        model.addAttribute("history", history);
        model.addAttribute("wire", String.format("%.2f", wire));
        model.addAttribute("gas", String.format("%.2f", gas));
        model.addAttribute("gasCO2", String.format("%.2f", gasCO2));
        model.addAttribute("gasAr", String.format("%.2f", gasAr));
        model.addAttribute("svarPol", String.format("%.2f", svarPol));
    }
}
