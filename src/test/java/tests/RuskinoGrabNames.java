package tests;

import com.codeborne.selenide.Configuration;
import helpers.DumpArrayListToFile;
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
    String baseUrl = "https://ruskino.ru/art/groups/actors?page=";
    ArrayList<String> strGrabbedMaleNames = new ArrayList<>();
    int maxI = 4;
    @Test
    @DisplayName("Open consecutive pages and print out the names")

    void actorsNamesGrabber() throws FileNotFoundException {

        for (int i = 1; i < maxI; i++) {
                open(baseUrl + i + "&&show=table");
                for (int j=1;j<= $$(".person_zodiac_person_name").size(); j++ )
//                    System.out.println($(".person_zodiac_person_name",j-1).$("a").innerHtml().replaceFirst("<br>", " "));
                    strGrabbedMaleNames.add($(".person_zodiac_person_name",j-1).$("a").innerHtml().replaceFirst("<br>", " "));
        }
        System.out.println(strGrabbedMaleNames);
        new DumpArrayListToFile(strGrabbedMaleNames, "/resources/male_n.txt");
    }
}