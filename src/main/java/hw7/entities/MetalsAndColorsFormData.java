package hw7.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MetalsAndColorsFormData {

    private List<Integer> summary;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;

    public List<String> getExpectedResult(){
        return Arrays.asList(
                "Summary: "+ (summary.get(0)+summary.get(1)) ,
                "Elements: " + elements.toString().replace("[", "").replace("]", ""),
                "Color: " + color,
                "Metal: " + metals,
                "Vegetables: "+ vegetables.toString().replace("[", "").replace("]", "")
        );
    }
}