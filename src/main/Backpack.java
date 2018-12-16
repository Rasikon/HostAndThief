package main;

import java.util.ArrayList;
import java.util.List;

public class Backpack {
    public List<Subject> backpackList = null;
    public int maxMass;
    public int bestPrice;

    public Backpack(int maxMass) {
        this.maxMass = maxMass;
    }

    public List<Subject> getBackpackList() {
        return backpackList;
    }

    public int sumMass(List<Subject> subjects){
        int sumM = 0;
        for(Subject subject:subjects){
            sumM += subject.weight;
        }
        return sumM;
    }

    public int sumPrice(List<Subject> subjects){
        int sumP = 0;
        for(Subject subject:subjects){
            sumP += subject.price;
        }
        return sumP;
    }

    public void checkSet(List<Subject> subjects){
        if(backpackList == null){
            if(sumMass(subjects)<=maxMass){
                backpackList = subjects;
                bestPrice = sumPrice(subjects);
            }
        }
        else
        {
            if (sumMass(subjects)<=maxMass && sumPrice(subjects)>bestPrice){
                backpackList = subjects;
                bestPrice=sumPrice(subjects);
            }
        }
    }

    public synchronized void bustAllSet(List<Subject> subjects){
        if(subjects.size()>0){
            checkSet(subjects);
        }
        for(int i=0; i<subjects.size();i++){
           List<Subject> list = new ArrayList<>(subjects);
           list.remove(i);
           bustAllSet(list);
        }
    }
}
