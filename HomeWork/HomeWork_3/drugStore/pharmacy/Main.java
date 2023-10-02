package pharmacy;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Component penicil = new Penicillin("2 mg");
        penicil.setWeight("7 mg");

        // Создаем и добавляем в сет элементы с одинаковыми компонентами
        Set<Component> result = new HashSet<>();
        result.add(new Penicillin("10 mg"));
        result.add(new Penicillin("10 mg"));
        result.add(new Water("25 ml"));
        result.add(new Azitronit("30 mg"));
        System.out.println(result + "\n");

        // Создаем лекарства для кошек
        Pharmacy catPharmacy = new CatPharmacy();
        catPharmacy.addComponent(new Azitronit("1 mg"))
                .addComponent(new Water("5 ml"))
                .addComponent(new Penicillin("10 mg"));

        Pharmacy catPharmacy1 = new CatPharmacy();
        catPharmacy1.addComponent(new Azitronit("10 mg"))
                .addComponent(new Penicillin("25"));

        Pharmacy catPharmacy2 = new CatPharmacy();
        catPharmacy2.addComponent(new Azitronit("15 mg"))
                .addComponent(new Azitronit("10 mg"))
                .addComponent(new Water("15 ml"));

        Pharmacy catPharmacy3 = new CatPharmacy();
        catPharmacy3.addComponent(new Penicillin("15 mg"))
                .addComponent(new Water("30 ml"));

        // Создаем список лекарств
        List<Pharmacy> pharmacyList = new ArrayList<>();
        pharmacyList.add(catPharmacy);
        pharmacyList.add(catPharmacy1);
        pharmacyList.add(catPharmacy2);
        pharmacyList.add(catPharmacy3);

        // Выводим на печать список и потом сортируем его по увеличению силы лекарства
        for (Pharmacy pharm : pharmacyList) {
        System.out.println(pharm.getPharmPower() + " --- " + pharm);
        }
        System.out.println("********");
        Collections.sort(pharmacyList);
        for (Pharmacy pharm : pharmacyList) {
            System.out.println(pharm.getPharmPower() + " --- " + pharm);
        }

//        while (((Iterator<Component>)catPharmacy).hasNext()){
//            System.out.println(((Iterator<Component>)catPharmacy).next());
//        }
//        for (Component component : catPharmacy) {
//            System.out.println(component);
//        }


    }


}
