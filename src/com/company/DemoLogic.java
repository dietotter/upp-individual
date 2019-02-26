package com.company;

import model.*;

public class DemoLogic {

    // ALL DRUGS
    private Drug[] drugsArr = {
            new Drug(0, "Ібупрофен", "ВОЛЯ ТОВ", 1000),
            new Drug(1, "Парацетамол", "Дарниця", 1100),
            new Drug(2, "Аспірін", "ВОЛЯ ТОВ", 900),
            new Drug(3, "Йод", "Чернігівниця", 535.6)
    };

    // ALL DRUGSTORES
    private Drugstore[] drugstoresArr = {
            new Drugstore(0, "Аптека низьких цін", "Сковороди, 2"),
            new Drugstore(1, "Аптека Бджілка", "Хрещатик, 79")
    };

    private Recipe[] recipesArr;
    private Doctor[] doctorsArr;
    private Patient[] patientsArr;

    public DemoLogic() {
        recipesArr = prepareRecipes();
        doctorsArr = prepareDoctors();
        patientsArr = preparePatients();
    }

    // ALL RECIPES
    public Recipe[] prepareRecipes() {
        Recipe[] arr = {
                new Recipe(0, "20.02.2019", "Вася", "Якийсь-чувак"),
                new Recipe(1, "13.01.2019", "Петя", "Побігайчик"),
                new Recipe(2, "31.12.2018", "Вася", "Побігайчик")
        };

        arr[0].getPrescribedDrugs().add(new DrugInRecipe(drugsArr[0], 2));
        arr[0].getPrescribedDrugs().add(new DrugInRecipe(drugsArr[1], 1));

        arr[1].getPrescribedDrugs().add(new DrugInRecipe(drugsArr[1], 1));
        arr[1].getPrescribedDrugs().add(new DrugInRecipe(drugsArr[2], 3));

        arr[2].getPrescribedDrugs().add(new DrugInRecipe(drugsArr[2], 1));
        arr[2].getPrescribedDrugs().add(new DrugInRecipe(drugsArr[3], 2));

        return arr;
    }

    // ALL DOCTORS
    public Doctor[] prepareDoctors() {
        Doctor[] arr = {
                new Doctor(0, "Вася", "Онколог", 2),
                new Doctor(1, "Петя", "Дерматолог", 3)
        };

        arr[0].getWrittenRecipes().add(recipesArr[0]);
        arr[0].getWrittenRecipes().add(recipesArr[2]);

        arr[1].getWrittenRecipes().add(recipesArr[1]);
        return arr;

        // DefaultListModel<>
    }

    // ALL PATIENTS
    public Patient[] preparePatients() {
        Patient[] arr = {
                new Patient("AS123456", "Якийсь-чувак", "11.12.1990"),
                new Patient("QW789012", "Побігайчик", "01.05.1965")
        };

        arr[0].getWrittenRecipes().add(recipesArr[0]);

        arr[1].getWrittenRecipes().add(recipesArr[1]);
        arr[1].getWrittenRecipes().add(recipesArr[2]);

        return arr;
    }

    public Drug[] getDrugsArr() {
        return drugsArr;
    }

    public Drugstore[] getDrugstoresArr() {
        return drugstoresArr;
    }

    public Recipe[] getRecipesArr() {
        return recipesArr;
    }

    public Doctor[] getDoctorsArr() {
        return doctorsArr;
    }

    public Patient[] getPatientsArr() {
        return patientsArr;
    }
}
