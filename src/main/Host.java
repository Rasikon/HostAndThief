package main;

import java.util.List;

public class Host extends Thread {
    private List<Subject> hostList;
    int indexList = 0;
    Host(List<Subject> hostList) {
        super();
        this.hostList = hostList;
    }

    @Override
    public void run() {
        while (!Apartment.Lock && indexList<hostList.size()) {
                isAdd();
        }
        hostList.clear();
    }

    private void isAdd() {
            Apartment.apartmentList.add(hostList.get(indexList));
            System.out.println(Thread.currentThread().getName() + " выложил " +
                    hostList.get(indexList).getName() + " весом " + hostList.get(indexList).getWeight()
                    + "кг и ценой " + hostList.get(indexList).getPrice() + "р. в квартиру");
            indexList++;
    }
}


