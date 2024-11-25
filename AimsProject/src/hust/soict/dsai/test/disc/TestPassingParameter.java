package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Cinderella");

        swap(dvd1, dvd2);
        System.out.println("After swap:");
        System.out.println("DVD 1 title: " + dvd1.getTitle());
        System.out.println("DVD 2 title: " + dvd2.getTitle());

        changeTitle(dvd1, dvd2.getTitle());
        System.out.println("After changeTitle:");
        System.out.println("DVD 1 title: " + dvd1.getTitle());
    }

    public static void swap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        DigitalVideoDisc temp = dvd1;
        dvd1 = dvd2;
        dvd2 = temp;
    
        System.out.println("Inside swap method:");
        System.out.println("dvd1: " + dvd1.getTitle());
        System.out.println("dvd2: " + dvd2.getTitle());
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        dvd.setTitle(title);
    }
}