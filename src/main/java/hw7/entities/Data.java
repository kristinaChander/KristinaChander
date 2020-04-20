package hw7.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class Data {

    private String summaryOdd;
    private String summaryEven;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;

    public static Data DATA_1 = Data.builder()
            .summaryOdd("1")
            .summaryEven("2")
            .elements(Arrays.asList("Water","Fire"))
            .color("Red")
            .metals("Gold")
            .vegetables(Arrays.asList("Cucumber"))
            .build();

    public static Data DATA_2 = Data.builder()
            .summaryOdd("1")
            .summaryEven("8")
            .elements(Arrays.asList("Earth", "Wind"))
            .color("Green")
            .metals("Silver")
            .vegetables(Arrays.asList("Tomato","Vegetables"))
            .build();


    public static Data DATA_3 = Data.builder()
            .summaryOdd("7")
            .summaryEven("8")
            .elements(Arrays.asList("Earth", "Fire"))
            .color("Blue")
            .metals("Bronze")
            .vegetables(Arrays.asList("Tomato","Vegetables","Onion"))
            .build();

    public static Data DATA_4 = Data.builder()
            .summaryOdd("5")
            .summaryEven("6")
            .elements(Arrays.asList("Water", "Wind"))
            .color("Yellow")
            .metals("Selen")
            .vegetables(Arrays.asList("Cucumber","Onion"))
            .build();

    public static Data DATA_5 = Data.builder()
            .summaryOdd("7")
            .summaryEven("2")
            .elements(Arrays.asList("Water","Earth" ,"Wind", "Fire"))
            .color("Blue")
            .metals("Selen")
            .vegetables(Arrays.asList("Cucumber","Tomato", "Vegetables","Onion"))
            .build();

}
