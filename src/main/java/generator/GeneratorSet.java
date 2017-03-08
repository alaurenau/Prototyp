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

import rtype.Prototyp;

import java.util.ArrayList;
import java.util.Iterator;

public class GeneratorSet {
    private ArrayList<Generator> generators = new ArrayList<>();
    private float timeAccumulator = 0;

    public void addGenerator(Generator gen) {
        generators.add(gen);
    }

    public void removeGenerator(Generator gen) {
        generators.remove(gen);
    }

    public void generate() {
        timeAccumulator += Prototyp.tick;

        Generator generator;
        for (Iterator<Generator> iterator = generators.iterator(); iterator.hasNext(); ) {
            generator = iterator.next();

            if (timeAccumulator > generator.getDelay()) {
                generator.generateEntities();
            }

            if (generator.isDone()) {
                iterator.remove();
            }
        }

    }

    public boolean contains(Generator gen) {
        return (this.generators.indexOf(gen) > 0);
    }
}
