package hw7.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class ExpectedData {

    private String expectedSummary;
    private String expectedElements;
    private String expectedColor;
    private String expectedMetals;
    private String expectedVegetables;

    public static ExpectedData EXPECTED_DATA_1 = ExpectedData.builder()
            .expectedSummary("3")
            .expectedElements("Water, Fire")
            .expectedColor("Red")
            .expectedMetals("Gold")
            .expectedVegetables("Cucumber")
            .build();

    public static ExpectedData EXPECTED_DATA_2 = ExpectedData.builder()
            .expectedSummary("9")
            .expectedElements("Earth, Wind")
            .expectedColor("Green")
            .expectedMetals("Silver")
            .expectedVegetables("Tomato, Vegetables")
            .build();

    public static ExpectedData EXPECTED_DATA_3 = ExpectedData.builder()
            .expectedSummary("15")
            .expectedElements("Earth, Fire")
            .expectedColor("Blue")
            .expectedMetals("Bronze")
            .expectedVegetables("Tomato, Vegetables, Onion")
            .build();

    public static ExpectedData EXPECTED_DATA_4 = ExpectedData.builder()
            .expectedSummary("11")
            .expectedElements("Water, Wind")
            .expectedColor("Yellow")
            .expectedMetals("Selen")
            .expectedVegetables("Cucumber, Onion")
            .build();

    public static ExpectedData EXPECTED_DATA_5 = ExpectedData.builder()
            .expectedSummary("9")
            .expectedElements("Water, Earth, Wind, Fire")
            .expectedColor("Blue")
            .expectedMetals("Selen")
            .expectedVegetables("Cucumber, Tomato, Vegetables, Onion")
            .build();
}
