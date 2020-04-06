package hw4.ex2;

import java.util.ArrayList;
import java.util.List;

public class TestCaseData {

    private List<String> summary;
    private List<String> elements;
    private List<String> colors;
    private List<String> metals;
    private List<String> vegetables;


    public TestCaseData(List<String> summary, List<String> elements, List<String> colors, List<String> metals, List<String> vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.colors = colors;
        this.metals = metals;
        this.vegetables = vegetables;
    }

    public List<String> getSummary() {
        return summary;
    }

    public List<String> getElements() {
        return elements;
    }

    public List<String> getColors() {
        return colors;
    }

    public List<String> getMetals() {
        return metals;
    }

    public List<String> getVegetables() {
        return vegetables;
    }

    public static class Builder {
        private List<String> summary;
        private List<String> elements;
        private List<String> colors;
        private List<String> metals;
        private List<String> vegetables;

        public Builder() {
            summary = new ArrayList<>();
            elements = new ArrayList<>();
            colors = new ArrayList<>();
            metals = new ArrayList<>();
            vegetables = new ArrayList<>();
        }

        public Builder addSummary(String value){
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

        public Builder addColor(String color) {
            colors.add(color);
            return this;
        }

        public Builder addMetal(String metal) {
            metals.add(metal);
            return this;
        }

        public TestCaseData build(){
            return new TestCaseData(summary,elements,colors,metals,vegetables);
        }
    }
}
