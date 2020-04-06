package hw4.ex2;

import java.util.ArrayList;
import java.util.List;

public class ExpectedTestCaseData {


    private String expectedSummary;
    private String expectedElements;
    private String expectedColor;
    private String expectedMetal;

    public ExpectedTestCaseData(String expectedSummary, String expectedElements, String expectedColor, String expectedMetal, String expectedVegetables) {
        this.expectedSummary = expectedSummary;
        this.expectedElements = expectedElements;
        this.expectedColor = expectedColor;
        this.expectedMetal = expectedMetal;
        this.expectedVegetables = expectedVegetables;
    }

    private String expectedVegetables;

    public String getExpectedSummary() {
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
        private String expectedSummary;
        private String expectedColor;
        private String expectedMetal;
        private String expectedVegetables;
        private String expectedElements;

        public Builder() {
            expectedSummary = null;
            expectedColor = null;
            expectedElements = null;
            expectedMetal = null;
            expectedVegetables = null;
        }

        public ExpectedTestCaseData.Builder setExpectedSummary(String expectedSummary) {
            this.expectedSummary = expectedSummary;
            return this;
        }

        public ExpectedTestCaseData.Builder setExpectedColor(String expectedColor) {
            this.expectedColor = expectedColor;
            return this;
        }

        public ExpectedTestCaseData.Builder setExpectedMetal(String expectedMetal) {
            this.expectedMetal = expectedMetal;
            return this;
        }

        public ExpectedTestCaseData.Builder setExpectedVegetables(String expectedVegetables) {
            this.expectedVegetables = expectedVegetables;
            return this;
        }

        public ExpectedTestCaseData.Builder setExpectedElements(String expectedElements) {
            this.expectedElements = expectedElements;
            return this;
        }

        public ExpectedTestCaseData build(){
            return new ExpectedTestCaseData(expectedSummary,expectedElements,expectedColor,expectedMetal,expectedVegetables);
        }
    }
}
