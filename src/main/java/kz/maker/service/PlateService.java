package kz.maker.service;

import kz.maker.dao.PlateDao;
import kz.maker.entity.Cut;
import kz.maker.entity.Plate;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Comparator;

@Service
public class PlateService {

    private double o2 = 0.0;
    private double propan = 0.0;
    private ArrayList<Cut> history = new ArrayList<>();

    private final PlateDao plateDao;

    public PlateService(PlateDao plateDao) {
        this.plateDao = plateDao;
    }

    public Plate findById(int id){
        return plateDao.findById(id);
    }

    public Plate findOneByPlateValue(int plateValue){
        return plateDao.findOneByPlateValue(plateValue);
    }

    public void deleteFromTable(int id){
        Plate plate = plateDao.findById(id);
        plateDao.delete(plate);
    }

    public void getTables(String str,Model model){
        var list = plateDao.findAll();
        list.sort(Comparator.comparingInt(Plate::getPlateValue));
        model.addAttribute("seamList", list);
    }

    public void save(Plate plate){
        plateDao.save(plate);
    }

    public boolean calc(int plateValue, double length, Model model) {
        Plate plate = plateDao.findOneByPlateValue(plateValue);
        if (plate != null) {
            o2 = plate.getCoefficientO2() * length;
            propan = plate.getCoefficientProp() * length;
            history.clear();
            history.add(new Cut(history.size() + 1, plate, length));
            return true;
        } else {
            model.addAttribute("fail", "Выберете пожалуйста другую толщину");
            return false;
        }
    }

    public void calcPlus(int plateValue, double length, Model model){
        Plate plate = plateDao.findOneByPlateValue(plateValue);
        if (plate != null) {
            o2 += plate.getCoefficientO2() * length;
            propan += plate.getCoefficientProp() * length;
            history.add(new Cut(history.size() + 1, plate, length));
            modelAdd(model);
        } else {
            modelAdd(model);
            model.addAttribute("fail", "Выберете пожалуйста другую толщину");
        }
    }

    public void calcMinus(int plateId, int cutId, double length){
        var plate = plateDao.findById(plateId);
        o2 -= plate.getCoefficientO2() * length;
        propan -= plate.getCoefficientProp() * length;

        Cut cut = null;

        for (Cut s : history) {
            if (s.getId() == cutId) {
                cut = s;
            }
        }

        history.remove(cut);
    }

    public void modelAdd(Model model) {
        model.addAttribute("history", history);
        model.addAttribute("o2", String.format("%.2f", o2));
        model.addAttribute("propan", String.format("%.2f", propan));

    }
}
