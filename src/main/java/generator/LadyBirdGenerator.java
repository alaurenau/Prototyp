/*
 *
 * Created: Jun  7 2006
 *
 * Copyright (C) 1999-2000 Fabien Sanglard
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package generator;

import org.lwjgl.util.vector.Vector2f;
import rtype.Prototyp;
import rtype.entity.LadyBird;

public class LadyBirdGenerator extends Generator {

    private static final Vector2f defaultLadySpeed = new Vector2f(-56.3f, 0);
    private static LadyBird lad = null;
    private static float ladySpawningRate = 0.005f;
    //static float ladySpawningRate = 111f;
    private static float ladyDeltaAcc = 0;

    public LadyBirdGenerator(float delay) {
        super(delay);
    }

    public void generateEntities() {
        ladyDeltaAcc += Prototyp.tick;
        if (ladyDeltaAcc > ladySpawningRate) {
            ladyDeltaAcc = 0;
            lad = new LadyBird();
            lad.spawn(new Vector2f(Prototyp.SCREEN_WIDTH / 2 + 10, Prototyp.random.nextInt() % Prototyp.SCREEN_HEIGHT / 2), defaultLadySpeed, Prototyp.enemies);
        }
    }

}
