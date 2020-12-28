package tests;

import helpers.DumpArrayListAsStringToFile;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;


@Feature("Ruskino actors")
@Story("Ruskino actors grab names")
@Tag("ruskino_tests")
@Owner("egorivanov")
class RuskinoGrabNames extends TestBase {

    ArrayList<String> strGrabbedNames = new ArrayList<>();
    int maxM = 193; // full is 192 + 1 pages
    int maxF = 152; // full is 151 + 1 pages
    int maxS = 24; // full is 23 + 1 pages
    int maxFr = 24; // full is 23 + 1 pages
    @Test
    @DisplayName("Open consecutive pages and print out the names")

    void actorsNamesGrabber() {

        for (int i = 1; i < maxM; i++) {
                open("https://ruskino.ru/art/groups/actors?page=" + i + "&&show=table");
                for (int j=1;j<= $$(".person_zodiac_person_name").size(); j++ )
//                    System.out.println($(".person_zodiac_person_name",j-1).$("a").innerHtml().replaceFirst("<br>", " "));
                    strGrabbedNames.add($(".person_zodiac_person_name",j-1).$("a").innerHtml().replaceFirst("<br>", " "));
        }
        System.out.println(strGrabbedNames);
        new DumpArrayListAsStringToFile(strGrabbedNames, "male_n.txt");
    }
    @Test
    @DisplayName("Open consecutive pages and print out the names")

    void actressNamesGrabber() {

        for (int i = 1; i < maxF; i++) {
                open("https://ruskino.ru/art/groups/actresses?page=" + i + "&&show=table");
                for (int j=1;j<= $$(".person_zodiac_person_name").size(); j++ )
//                    System.out.println($(".person_zodiac_person_name",j-1).$("a").innerHtml().replaceFirst("<br>", " "));
                    strGrabbedNames.add($(".person_zodiac_person_name",j-1).$("a").innerHtml().replaceFirst("<br>", " "));
        }
        System.out.println(strGrabbedNames);
        new DumpArrayListAsStringToFile(strGrabbedNames, "female_n.txt");
    }
    @Test
    @DisplayName("Open consecutive pages and print out the names")

    void starsNamesGrabber() {

        for (int i = 1; i < maxS; i++) {
                open("https://ruskino.ru/art/groups/stars?page=" + i + "&&show=table");
                for (int j=1;j<= $$(".person_zodiac_person_name").size(); j++ )
//                    System.out.println($(".person_zodiac_person_name",j-1).$("a").innerHtml().replaceFirst("<br>", " "));
                    strGrabbedNames.add($(".person_zodiac_person_name",j-1).$("a").innerHtml().replaceFirst("<br>", " "));
        }
        System.out.println(strGrabbedNames);
        new DumpArrayListAsStringToFile(strGrabbedNames, "stars_n.txt");
    }
    @Test
    @DisplayName("Open consecutive pages and print out the names")

    void foreignersNamesGrabber() {

        for (int i = 1; i < maxFr; i++) {
                open("https://ruskino.ru/art/groups/foreigners?page=" + i + "&&show=table");
                for (int j=1;j<= $$(".person_zodiac_person_name").size(); j++ )
//                    System.out.println($(".person_zodiac_person_name",j-1).$("a").innerHtml().replaceFirst("<br>", " "));
                    strGrabbedNames.add($(".person_zodiac_person_name",j-1).$("a").innerHtml().replaceFirst("<br>", " "));
        }
        System.out.println(strGrabbedNames);
        new DumpArrayListAsStringToFile(strGrabbedNames, "foreign_n.txt");
    }
}