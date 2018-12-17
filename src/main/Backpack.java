package main;

import java.util.ArrayList;
import java.util.List;

class Backpack {
    private List<Subject> backpackList = null;
    private int maxMass;
    private int bestPrice;

    Backpack(int maxMass) {
        this.maxMass = maxMass;
    }

    List<Subject> getBackpackList() {
        return backpackList;
    }

    private int sumMass(List<Subject> subjects) {
        int sumM = 0;
        for (Subject subject : subjects) {
            sumM += subject.weight;
        }
        return sumM;
    }

    private int sumPrice(List<Subject> subjects) {
        int sumP = 0;
        for (Subject subject : subjects) {
            sumP += subject.price;
        }
        return sumP;
    }

    private void checkSet(List<Subject> subjects) {
        if (backpackList == null) {
            if (sumMass(subjects) <= maxMass) {
                backpackList = subjects;
                bestPrice = sumPrice(subjects);
            }
        } else {
            if (sumMass(subjects) <= maxMass && sumPrice(subjects) > bestPrice) {
                backpackList = subjects;
                bestPrice = sumPrice(subjects);
            }
        }
    }

    void bustAllSet(List<Subject> subjects) {
        if (subjects.size() > 0) {
            checkSet(subjects);
        }
        for (int i = 0; i < subjects.size(); i++) {
            List<Subject> list = new ArrayList<>(subjects);
            list.remove(i);
            bustAllSet(list);
        }
    }
}
