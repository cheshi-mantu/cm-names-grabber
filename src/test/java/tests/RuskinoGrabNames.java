package tests;

import helpers.DumpArrayListAsStringToFile;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;


@Feature("Ruskino actors")
@Story("Ruskino actors grab names")
@Tag("ruskino_tests")
@Owner("egorivanov")
class RuskinoGrabNames extends TestBase {
    String baseUrlM = "https://ruskino.ru/art/groups/actors?page=";
    String baseUrlF = "https://ruskino.ru/art/groups/actresses?page=";
    ArrayList<String> strGrabbedMaleNames = new ArrayList<>();
    int maxM = 2; // full is 193 pages
    int maxF = 152; // full is 151 pages
    @Test
    @DisplayName("Open consecutive pages and print out the names")

    void actorsNamesGrabber() throws FileNotFoundException {

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

    void actressNamesGrabber() throws FileNotFoundException {

        for (int i = 1; i < maxF; i++) {
                open(baseUrlF + i + "&&show=table");
                for (int j=1;j<= $$(".person_zodiac_person_name").size(); j++ )
//                    System.out.println($(".person_zodiac_person_name",j-1).$("a").innerHtml().replaceFirst("<br>", " "));
                    strGrabbedMaleNames.add($(".person_zodiac_person_name",j-1).$("a").innerHtml().replaceFirst("<br>", " "));
        }
        System.out.println(strGrabbedMaleNames);
        new DumpArrayListAsStringToFile(strGrabbedMaleNames, "female_n.txt");
    }
}