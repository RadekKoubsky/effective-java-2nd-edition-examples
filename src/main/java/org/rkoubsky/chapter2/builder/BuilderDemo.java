package org.rkoubsky.chapter2.builder;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class BuilderDemo {
    public static void main(final String[] args) {
        final IBuilder<NutritionFacts> builder = new NutritionFacts.Builder(5, 3).calories(1000);
        final NutritionFacts nutritionFacts = createNutritionFacts(builder);
        System.out.println(nutritionFacts);
    }

    private static NutritionFacts createNutritionFacts(final IBuilder<NutritionFacts> builder) {
        return builder.build();
    }
}
