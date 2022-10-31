package earth.terrarium.ad_astra.client.dimension.rendering;

import com.teamresourceful.resourcefullib.common.caches.CacheableBiFunction;
import com.teamresourceful.resourcefullib.common.color.Color;
import com.teamresourceful.resourcefullib.common.color.ConstantColors;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3f;

import java.util.Random;

public class StarInformation {
    public static final Color[] STAR_COLOURS = new Color[]{
            ConstantColors.white,
            new Color(204, 238, 255, 255),
            new Color(204, 153, 255, 255),
            new Color(255, 255, 153, 255),
            new Color(255, 204, 102, 255)
    };
    public static final CacheableBiFunction<Long, Integer, StarInformation> STAR_CACHE = new CacheableBiFunction<>(StarInformation::new);
    private final Vec3f[] param1;
    private final float[] multiplier;
    private final float[] randomPi;
    private final Color[][] colour;

    public StarInformation(long seed, int stars) {
        param1 = new Vec3f[stars];
        multiplier = new float[stars];
        randomPi = new float[stars];
        colour = new Color[stars][4];

        Random random = new Random(seed);
        for (int i = 0; i < stars; i++) {
            float d = random.nextFloat() * 2.0f - 1.0f;
            float e = random.nextFloat() * 2.0f - 1.0f;
            float f = random.nextFloat() * 2.0f - 1.0f;
            param1[i] = new Vec3f(d, e, f);
            multiplier[i] = 0.15f + random.nextFloat() * 0.01f;
            randomPi[i] = random.nextFloat() * MathHelper.TAU;
            for (int j = 0; j < 4; j++) {
                colour[i][j] = STAR_COLOURS[random.nextInt(STAR_COLOURS.length)];
            }
        }
    }

    public Vec3f getParam1(int i) {
        return param1[i];
    }

    public float getMultiplier(int i) {
        return multiplier[i];
    }

    public float getRandomPi(int i) {
        return randomPi[i];
    }

    public Color getColour(int i, int j, boolean coloured) {
        return coloured ? colour[i][j] : ConstantColors.white;
    }
}