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
import rtype.Layer;
import rtype.Prototyp;
import rtype.entity.SpaceTrash;

public class TrashGenerator extends Generator {

    private static final Vector2f defaultTrashSpeed = new Vector2f(-34.3f, 0);
    private static final Layer[] layers = {Prototyp.background, Prototyp.frontground};
    private static float lastTrash = 0;
    private static SpaceTrash spawningTrash = null;
    private static int trashType = Constants.SPACE_TRASH_1;
    private static float trashSpawningRate = 3f;
    private static float trashDeltaAcc = 0;
    private static float rotationSpeed = 2f;

    public void generateEntities() {
        trashDeltaAcc += Prototyp.tick;
        if (trashDeltaAcc > trashSpawningRate) {
            trashDeltaAcc = 0;
            trashType = Prototyp.random.nextInt(2) + 9;
            spawningTrash = new SpaceTrash(trashType);
            if (Prototyp.random.nextInt(2) == 0) {
                rotationSpeed = -rotationSpeed;
            }
            spawningTrash.spawn(new Vector2f(Prototyp.SCREEN_WIDTH / 2 + 10, Prototyp.random.nextInt() % Prototyp.SCREEN_HEIGHT / 2), defaultTrashSpeed, rotationSpeed, layers[Prototyp.random.nextInt(3) % 2]);
        }
    }

}
