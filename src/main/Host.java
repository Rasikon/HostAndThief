package main;

import java.util.List;

public class Host extends Thread {
    private List<Subject> hostList;

    Host(List<Subject> hostList) {
        this.hostList = hostList;
    }

    @Override
    public void run() {
        while (hostList.size() > 0) {
            isAdd();
        }
    }

    private void isAdd() {
            int sizeList = hostList.size() - 1;
            Apartment.apartmentList.add(hostList.get(sizeList));
            System.out.println(Thread.currentThread().getName() + " выложил " +
                    hostList.get(sizeList).getName() + " весом " + hostList.get(sizeList).getWeight()
                    + "кг и ценой " + hostList.get(sizeList).getPrice() + "р. в квартиру");
            hostList.remove(hostList.get(sizeList));
    }
}


