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
import rtype.Constants;
import rtype.Prototyp;
import rtype.entity.Star;

public class StarGenerator extends Generator {
    private static final Vector2f defaultStarSpeed = new Vector2f(-34.3f, 0);
    static float lastStar = 0;
    private static Star spawningStar = null;
    private static int starType = Constants.STAR_1;
    private static float starSpawningRate = 5f;
    private static float starDeltaAcc = 0;

    public void generateEntities() {
        starDeltaAcc += Prototyp.tick;
        if (starDeltaAcc > starSpawningRate) {
            starDeltaAcc = 0;
            starType = Prototyp.random.nextInt(6) + 11;
            spawningStar = new Star(starType);
            spawningStar.spawn(new Vector2f(Prototyp.SCREEN_WIDTH / 2 + 10, Prototyp.random.nextInt() % Prototyp.SCREEN_HEIGHT / 2), defaultStarSpeed, Prototyp.background);
        }
    }

}
