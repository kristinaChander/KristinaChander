package hw4.ex2;

import java.util.ArrayList;
import java.util.List;

public class TestCaseData {

    private List<Integer> summary;
    private List<String> elements;
    private String colors;
    private String metals;
    private List<String> vegetables;

    private Integer expectedSummary;
    private String expectedElements;
    private String expectedColor;
    private String expectedMetal;
    private String expectedVegetables;

    public TestCaseData(List<Integer> summary, List<String> elements, String colors, String metals,
                        List<String> vegetables, Integer expectedSummary, String expectedElements,
                        String expectedColor, String expectedMetal, String expectedVegetables) {
        this.summary = summary;
        this.elements = elements;
        this.colors = colors;
        this.metals = metals;
        this.vegetables = vegetables;
        this.expectedSummary = expectedSummary;
        this.expectedElements = expectedElements;
        this.expectedColor = expectedColor;
        this.expectedMetal = expectedMetal;
        this.expectedVegetables = expectedVegetables;
    }

    public List<Integer> getSummary() {
        return summary;
    }

    public List<String> getElements() {
        return elements;
    }

    public String getColors() {
        return colors;
    }

    public String getMetals() {
        return metals;
    }

    public List<String> getVegetables() {
        return vegetables;
    }

    public Integer getExpectedSummary() {
        return expectedSummary;
    }

    public String getExpectedColor() {
        return expectedColor;
    }

    public String getExpectedMetal() {
        return expectedMetal;
    }

    public String getExpectedVegetables() {
        return expectedVegetables;
    }

    public String getExpectedElements() {
        return expectedElements;
    }

    public static class Builder {
        private List<Integer> summary;
        private List<String> elements;
        private String colors;
        private String metals;
        private List<String> vegetables;
        private Integer expectedSummary;
        private String expectedColor;
        private String expectedMetal;
        private String expectedVegetables;
        private String expectedElements;

        public Builder() {
            summary = new ArrayList<>();
            elements = new ArrayList<>();
            colors = null;
            metals = null;
            vegetables = new ArrayList<>();
            expectedSummary = null;
            expectedColor = null;
            expectedElements = null;
            expectedMetal = null;
            expectedVegetables = null;
        }

        public Builder setExpectedSummary(Integer expectedSummary) {
            this.expectedSummary = expectedSummary;
            return this;
        }

        public Builder setExpectedColor(String expectedColor) {
            this.expectedColor = expectedColor;
            return this;
        }

        public Builder setExpectedMetal(String expectedMetal) {
            this.expectedMetal = expectedMetal;
            return this;
        }

        public Builder setExpectedVegetables(String expectedVegetables) {
            this.expectedVegetables = expectedVegetables;
            return this;
        }

        public Builder setExpectedElements(String expectedElements) {
            this.expectedElements = expectedElements;
            return this;
        }

        public Builder addSummary(Integer value){
            summary.add(value);
            return this;
        }

        public Builder addElement(String value){
            elements.add(value);
            return this;
        }

        public Builder addVegetable(String value){
            vegetables.add(value);
            return this;
        }

        public Builder setColors(String colors) {
            this.colors = colors;
            return this;
        }

        public Builder setMetals(String metals) {
            this.metals = metals;
            return this;
        }

        public TestCaseData build(){
            return new TestCaseData(summary,elements,colors,metals,vegetables,
                    expectedSummary,expectedElements,expectedColor,expectedMetal,expectedVegetables);
        }
    }
}
