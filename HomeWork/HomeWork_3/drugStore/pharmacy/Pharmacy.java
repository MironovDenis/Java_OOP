package pharmacy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pharmacy implements Iterable<Component>, Comparable<Pharmacy> {
    private List<Component> components;
    private int index;

    public Pharmacy() {
        this.components = new ArrayList<>();
        this.index = 0;
    }

    public Pharmacy addComponent(Component component){
        if (component == null) throw new NullPointerException("Компонент не может быть null");
        components.add(component);
        return this;
    }

    public int getPharmPower(){
        int count = 0;
        for (Component component : components){
            count += component.getPower();
        }
        return count;
    }



//    int count = components.stream().mapToInt(Component::getPower).sum();

//    @Override
//    public boolean hasNext() {
//        return index < components.size();
//    }
//
//    @Override
//    public Component next() {
//        return components.get(index++);
//    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "components=" + components +
                ", index=" +
                '}';
    }

//    @Override
//    public Iterator<Component> iterator() {
//        return new PharmacyIterator();
//    }

    @Override
    public Iterator<Component> iterator() {
        return new Iterator<Component>() {
            @Override
            public boolean hasNext() {
                return index < components.size();
            }

            @Override
            public Component next() {
                return components.get(index++);
            }
        };
    }

    @Override
    public int compareTo(Pharmacy o) {
        int pharmPower = getPharmPower();
        if  (this.getPharmPower() != o.getPharmPower()){
            return Integer.compare(this.getPharmPower(), o.getPharmPower());
//        if (this.getPharmPower()>o.getPharmPower()){
//            return 1;
//        }
//        if (this.getPharmPower()<o.getPharmPower()){
//            return -1;
        }
        return 0;
    }





    //    for (Iterator<Component> iterator = drug.iterator(); iterator.hasNext();) {
//        Component c = iterator.next();
//    }
}
