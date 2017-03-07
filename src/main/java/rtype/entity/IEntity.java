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

package rtype.entity;


public interface IEntity {
    int PLANET = 0;
    int PLAYER_SHIP = 1;
    int GREEN_ORB = 2;
    int SCANLINE = 3;
    int BULLET = 4;
    int FORCEBLAST = 5;
    int SPACE_TRASH_1 = 6;
    int SPACE_TRASH_2 = 7;
    int SPACE_TRASH_3 = 8;
    int SPACE_TRASH_4 = 9;
    int FIRE_BALL = 10;
    int STAR_1 = 11;
    int STAR_2 = 12;
    int STAR_3 = 13;
    int STAR_4 = 14;
    int STAR_5 = 15;
    int STAR_6 = 16;
    int FORCE_CHARGE = 15;
    int PLAYER_SPEED = 16;
    int LADYBIRD = 17;
    int EXPLOSION1 = 18;
    int EXPLOSION2 = 19;
    int ORB_BEAM = 20;
    int FONT = 21;
    int ENEMY_BULLET = 22;
    int BULLET_HIT_YELLOW = 23;
    int BULLET_HIT_GREEN = 24;
    int BULLET_HIT_BLUE = 25;
    int BLUE_ORB = 26;
    int PINK_ORB = 27;
    int RED_ORB = 28;
    int ENEMY_PIECE_1 = 29;
    int ENEMY_PIECE_2 = 30;
    int ENEMY_PIECE_3 = 31;
    int ENEMY_PIECE_4 = 32;
    int ENEMY_PIECE_5 = 33;
    int ENEMY_PIECE_6 = 34;
    int ENEMY_PIECE_7 = 35;
    int ENEMY_PIECE_8 = 36;
    int BIT_UPGRADE = 37;
    int IMPLOSION = 38;

    int BONUS_BOOSTER = 39;
    int BONUS_LIGHTNING_ORB = 40;
    int BONUS_GRAVITY_ORB = 41;
    int BONUS_RAPID_SHOOT_ORB = 42;
    int BONUS_CRYSTAL_ORB = 43;
    int BONUS_MULTI_SHOOT_ORB = 44;
    int BONUS_SPEED = 45;
    int BONUS_HOMING_MISSILE = 46;
    // Leaving space for futur bonus

    int X = 63;
    int BULLET_RAPID_FIRE = 64;
    int BULLET_MULTI_SHOOT = 65;
    int BULLET_BASE = 66;
    int MISSILE = 67;
    int SMOKE = 68;
    //public int PLANET2 = 69;
    int SPACE_TRASH_5 = 70;
}
