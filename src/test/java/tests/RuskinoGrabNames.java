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
    String baseUrlM = "https://ruskino.ru/art/groups/actors?page=";
    String baseUrlF = "https://ruskino.ru/art/groups/actresses?page=";
    String baseUrlS = "https://ruskino.ru/art/groups/stars?page=";

    ArrayList<String> strGrabbedMaleNames = new ArrayList<>();
    int maxM = 193; // full is 192 + 1 pages
    int maxF = 152; // full is 151 + 1 pages
    int maxS = 24; // full is 23 + 1 pages
    @Test
    @DisplayName("Open consecutive pages and print out the names")

    void actorsNamesGrabber() {

        for (int i = 1; i < maxM; i++) {
                open(baseUrlM + i + "&&show=table");
                for (int j=1;j<= $$(".person_zodiac_person_name").size(); j++ )
//                    System.out.println($(".person_zodiac_person_name",j-1).$("a").innerHtml().replaceFirst("<br>", " "));
                    strGrabbedMaleNames.add($(".person_zodiac_person_name",j-1).$("a").innerHtml().replaceFirst("<br>", " "));
        }
        System.out.println(strGrabbedMaleNames);
        new DumpArrayListAsStringToFile(strGrabbedMaleNames, "male_n.txt");
    }
    @Test
    @DisplayName("Open consecutive pages and print out the names")

    void actressNamesGrabber() {

        for (int i = 1; i < maxF; i++) {
                open(baseUrlF + i + "&&show=table");
                for (int j=1;j<= $$(".person_zodiac_person_name").size(); j++ )
//                    System.out.println($(".person_zodiac_person_name",j-1).$("a").innerHtml().replaceFirst("<br>", " "));
                    strGrabbedMaleNames.add($(".person_zodiac_person_name",j-1).$("a").innerHtml().replaceFirst("<br>", " "));
        }
        System.out.println(strGrabbedMaleNames);
        new DumpArrayListAsStringToFile(strGrabbedMaleNames, "female_n.txt");
    }
    @Test
    @DisplayName("Open consecutive pages and print out the names")

    void starsNamesGrabber() {

        for (int i = 1; i < maxS; i++) {
                open(baseUrlS + i + "&&show=table");
                for (int j=1;j<= $$(".person_zodiac_person_name").size(); j++ )
//                    System.out.println($(".person_zodiac_person_name",j-1).$("a").innerHtml().replaceFirst("<br>", " "));
                    strGrabbedMaleNames.add($(".person_zodiac_person_name",j-1).$("a").innerHtml().replaceFirst("<br>", " "));
        }
        System.out.println(strGrabbedMaleNames);
        new DumpArrayListAsStringToFile(strGrabbedMaleNames, "stars_n.txt");
    }
}