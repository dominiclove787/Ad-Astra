package earth.terrarium.ad_astra.recipes;

import net.minecraft.fluid.Fluid;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.HolderSet;
import net.minecraft.util.Identifier;

public abstract class ConversionRecipe extends ModRecipe {

    private final Fluid output;
    private final double conversionRatio;
    private HolderSet<Fluid> input;

    public ConversionRecipe(Identifier id, HolderSet<Fluid> input, Fluid output, double conversionRatio) {
        super(id);
        this.input = input;
        this.output = output;
        this.conversionRatio = conversionRatio;
    }

    public ConversionRecipe(Identifier id, Ingredient input, Fluid output, double conversionRatio) {
        super(id);
        this.inputs.add(input);
        this.output = output;
        this.conversionRatio = conversionRatio;
    }

    public boolean matches(Fluid input) {
        return this.input.contains(input.getBuiltInRegistryHolder());
    }

    public HolderSet<Fluid> getFluidInput() {
        return this.input;
    }

    public Fluid getFluidOutput() {
        return this.output;
    }

    public double getConversionRatio() {
        return this.conversionRatio;
    }
}