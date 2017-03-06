package generator;

import org.lwjgl.util.vector.Vector2f;
import rtype.BonusFactory;
import rtype.Prototyp;
import rtype.entity.Bonus;
import rtype.entity.LadyBird;

public class EnemyWave extends IGenerator {

    static final Vector2f defaultLadySpeed = new Vector2f(-76.3f, 0);
    // Rate at which generating entities.
    public static float rate = 2f;
    float tickAccumulator = 0;

    // Where the entity will be generated
    float delayAccumualor = 0;
    private int x;
    private int generatedUnitCounter = 1;

    private int maxUnitGenerated = 5;

    public EnemyWave(int x, float delay) {
        super(delay);
        this.x = x;
    }

    public void generateEntities() {
        tickAccumulator += Prototyp.tick;
        if (tickAccumulator > rate) {
            tickAccumulator = 0;
            LadyBird lady = new LadyBird();

            if (generatedUnitCounter == maxUnitGenerated) {
                lady.setPresetBonus(BonusFactory.createBonus(Prototyp.random.nextInt(Bonus.BONUS_COUNT)));
            }
            lady.spawn(new Vector2f(Prototyp.SCREEN_WIDTH / 2 + 10, x), defaultLadySpeed, Prototyp.enemies);

            generatedUnitCounter++;
        }

        if (generatedUnitCounter > maxUnitGenerated)
            this.done = true;
    }

}
