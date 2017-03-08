/*
 *
 * Created: Jan  7 2008
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

package rtype;

import org.lwjgl.opengl.GL11;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.Hashtable;

public class JNLPTextureLoader implements TextureLoader {
    private static Texture[] textures = new Texture[1024];
    private static Texture[][] animations = new Texture[1024][1024];
    Hashtable imageCache = new Hashtable();

    public JNLPTextureLoader() {
    }

    /* (non-Javadoc)
     * @see rtype.ITextureLoader#init()
     */
    public void init() {
        textures[Constants.PLANET] = loadTexture("Data/Stage1Layer1.png", 490, 473, 512, 512);

        textures[Constants.SPACE_TRASH_1] = loadTexture("Data/Stage1Layer1.png", 256, 438, 256, 256); // Big huge spaceship with 5 reactors
        textures[Constants.SPACE_TRASH_2] = loadTexture("Data/Stage1Layer1.png", 257, 700, 256, 256);
        textures[Constants.SPACE_TRASH_3] = loadTexture("Data/Stage1Layer1.png", 373, 956, 64, 64); // Round trash
        textures[Constants.SPACE_TRASH_4] = loadTexture("Data/Stage1Layer1.png", 492, 102, 256, 128); // Sattelite trash
        textures[Constants.STAR_1] = loadTexture("Data/Stage1Layer1.png", 612, 1011, 8, 8);
        textures[Constants.STAR_2] = loadTexture("Data/Stage1Layer1.png", 649, 990, 16, 32);
        textures[Constants.STAR_3] = loadTexture("Data/Stage1Layer1.png", 674, 994, 16, 16);
        textures[Constants.STAR_4] = loadTexture("Data/Stage1Layer1.png", 716, 1004, 16, 16);
        textures[Constants.STAR_5] = loadTexture("Data/Stage1Layer1.png", 738, 990, 32, 32);
        textures[Constants.STAR_6] = loadTexture("Data/Stage1Layer1.png", 780, 994, 16, 16);

        textures[Constants.BULLET] = loadTexture("Data/BulletSet1.png", 32, 00, 32, 32);

        textures[Constants.ORB_BEAM] = loadTexture("Data/GlowBullets.png", 32, 0, 32, 32);
        textures[Constants.ENEMY_BULLET] = loadTexture("Data/BulletSet1.png", 0, 0, 32, 32);
        textures[Constants.ENEMY_PIECE_1] = loadTexture("Data/SpaceTrash.png", 00, 00, 32, 32);
        textures[Constants.ENEMY_PIECE_2] = loadTexture("Data/SpaceTrash.png", 32, 00, 32, 32);
        textures[Constants.ENEMY_PIECE_3] = loadTexture("Data/SpaceTrash.png", 64, 00, 32, 32);
        textures[Constants.ENEMY_PIECE_4] = loadTexture("Data/SpaceTrash.png", 96, 00, 32, 32);
        textures[Constants.ENEMY_PIECE_5] = loadTexture("Data/SpaceTrash.png", 00, 32, 32, 32);
        textures[Constants.ENEMY_PIECE_6] = loadTexture("Data/SpaceTrash.png", 32, 32, 32, 32);
        textures[Constants.ENEMY_PIECE_7] = loadTexture("Data/SpaceTrash.png", 64, 32, 32, 32);
        textures[Constants.ENEMY_PIECE_8] = loadTexture("Data/SpaceTrash.png", 96, 32, 32, 32);
        textures[Constants.BULLET_RAPID_FIRE] = loadTexture("Data/BulletSet1.png", 00, 64, 32, 32);
        textures[Constants.BULLET_MULTI_SHOOT] = loadTexture("Data/BulletSet1.png", 0, 32, 32, 32);
        textures[Constants.BULLET_BASE] = loadTexture("Data/BulletSet1.png", 32, 32, 32, 32);
        textures[Constants.SPACE_TRASH_5] = loadTexture("Data/Stage1Layer1.png", 148, 721, 64, 64); // Extreme left trash

        textures[Constants.FORCEBLAST] = loadTexture("Data/forceblast.png", 0, 0, 128, 64);


        //textures[IEntity.SCANLINE] = loadTexture("Data/Scanlines.png",0,0,32,32);


        animations[Constants.PLAYER_SHIP] = loadAnimation("Data/PlayerShip.png", 4, 4, 128, 128);
        animations[Constants.GREEN_ORB] = loadAnimation("Data/Orb1.png", 8, 2, 64, 64);
        animations[Constants.BLUE_ORB] = loadAnimation("Data/Orb1.png", 8, 2, 64, 64, 0, 128);
        animations[Constants.PINK_ORB] = loadAnimation("Data/Orb1.png", 8, 2, 64, 64, 0, 256);
        animations[Constants.RED_ORB] = loadAnimation("Data/Orb1.png", 8, 2, 64, 64, 0, 384);
        animations[Constants.FORCE_CHARGE] = loadAnimation("Data/forcecharge.png", 8, 4, 64, 64);
        animations[Constants.PLAYER_SPEED] = loadAnimation("Data/PlayerSpeed.png", 8, 4, 64, 64);
        animations[Constants.EXPLOSION1] = loadAnimation("Data/Explosion2.png", 8, 4, 64, 64);
        animations[Constants.EXPLOSION2] = loadAnimation("Data/ExplosionSmall.png", 8, 4, 128, 128);
        animations[Constants.LADYBIRD] = loadAnimation("Data/ladybird.png", 4, 4, 64, 64);
        animations[Constants.FIRE_BALL] = loadAnimation("Data/FireBall.png", 4, 4, 128, 128);
        animations[Constants.FONT] = loadAnimation("Data/Fonts.png", 16, 16, 32, 32);
        animations[Constants.BULLET_HIT_YELLOW] = loadAnimation("Data/BulletHit.png", 4, 2, 32, 32);
        animations[Constants.BULLET_HIT_GREEN] = loadAnimation("Data/BulletHit2.png", 4, 2, 32, 32);
        animations[Constants.BULLET_HIT_BLUE] = loadAnimation("Data/BulletHit3.png", 4, 2, 32, 32);
        animations[Constants.BIT_UPGRADE] = loadAnimation("Data/BitUpgrade.png", 4, 2, 32, 32);
        animations[Constants.BONUS_MULTI_SHOOT_ORB] = loadAnimation("Data/PowerUp1.png", 8, 1, 64, 64, 00, 00);
        animations[Constants.BONUS_LIGHTNING_ORB] = loadAnimation("Data/PowerUp1.png", 8, 1, 64, 64, 00, 64);
        animations[Constants.BONUS_RAPID_SHOOT_ORB] = loadAnimation("Data/PowerUp1.png", 8, 1, 64, 64, 00, 128);
        animations[Constants.BONUS_GRAVITY_ORB] = loadAnimation("Data/PowerUp1.png", 8, 1, 64, 64, 00, 192);
        animations[Constants.BONUS_SPEED] = loadAnimation("Data/PowerUp1.png", 8, 1, 64, 64, 00, 256);
        animations[Constants.BONUS_CRYSTAL_ORB] = loadAnimation("Data/PowerUp1.png", 8, 1, 64, 64, 00, 320);
        animations[Constants.BONUS_BOOSTER] = loadAnimation("Data/PowerUp1.png", 8, 1, 64, 64, 00, 384);
        animations[Constants.IMPLOSION] = loadAnimation("Data/Implosion.png", 8, 4, 64, 64);
        animations[Constants.MISSILE] = loadAnimation("Data/HomingMissile.png", 4, 4, 64, 64);
        animations[Constants.SMOKE] = loadAnimation("Data/SmokePuff.png", 4, 4, 32, 32);
    }

    /* (non-Javadoc)
     * @see rtype.ITextureLoader#getTexture(int)
     */
    public Texture getTexture(int textureID) {
        return textures[textureID];
    }

    /* (non-Javadoc)
     * @see rtype.ITextureLoader#getAnimation(int)
     */
    public Texture[] getAnimation(int animationID) {
        return animations[animationID];
    }

    // Offset are in term off pixel, not byte, the image loader figure out alone what is the bytesPerPixel
    private Texture loadTexture(String path, int xOffSet, int yOffSet, int textWidth, int textHeight) {


        BufferedImage buffImage = null;
        try {
            if (imageCache.get(path) != null) {
                buffImage = (BufferedImage) imageCache.get(path);
            } else {
                System.out.println("Loading image:" + path);
                buffImage = ImageIO.read(new FileImageInputStream(new File(path)));
                imageCache.put(path, buffImage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int bytesPerPixel = buffImage.getColorModel().getPixelSize() / 8;

        ByteBuffer scratch = ByteBuffer.allocateDirect(textWidth * textHeight * bytesPerPixel).order(ByteOrder.nativeOrder());
        DataBufferByte data = ((DataBufferByte) buffImage.getRaster().getDataBuffer());

        for (int i = 0; i < textHeight; i++) {
            scratch.put(data.getData(), (xOffSet + (yOffSet + i) * buffImage.getWidth()) * bytesPerPixel, textWidth * bytesPerPixel);
        }

        scratch.rewind();


        // Create A IntBuffer For Image Address In Memory
        IntBuffer buf = ByteBuffer.allocateDirect(4).order(ByteOrder.nativeOrder()).asIntBuffer();
        GL11.glGenTextures(buf); // Create Texture In OpenGL

        // Create Nearest Filtered Texture
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, buf.get(0));
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
        GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, textWidth, textHeight, 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, scratch);

        Texture newTexture = new Texture();
        newTexture.textureId = buf.get(0);     // Return Image Addresses In Memory
        newTexture.textureHeight = textHeight;
        newTexture.textureWidth = textWidth;

        return newTexture;
    }


    private Texture[] loadAnimation(String path, int cols, int rows, int textWidth, int textHeight) {
        return loadAnimation(path, cols, rows, textWidth, textHeight, 0, 0);
    }

    private Texture[] loadAnimation(String path, int cols, int rows, int textWidth, int textHeight, int xOffSet, int yOffSet) {
        Texture[] toReturntextures = new Texture[cols * rows];


        BufferedImage buffImage = null;
        try {
            if (imageCache.get(path) != null) {
                buffImage = (BufferedImage) imageCache.get(path);
            } else {
                System.out.println("Loading image:" + path);
                buffImage = ImageIO.read(new FileImageInputStream(new File(path)));
                imageCache.put(path, buffImage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int bytesPerPixel = buffImage.getColorModel().getPixelSize() / 8;


        ByteBuffer scratch = ByteBuffer.allocateDirect(textWidth * textHeight * bytesPerPixel).order(ByteOrder.nativeOrder());

        byte[] data = ((DataBufferByte) buffImage.getRaster().getDataBuffer()).getData();


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                toReturntextures[i * cols + j] = loadTexture(path, j * textWidth + xOffSet, i * textHeight + yOffSet, textWidth, textHeight);
                /*
                for (int z = 0 ; z < textHeight ; z ++)
					scratch.put(data,(xOffSet+(yOffSet+z)*buffImage.getWidth())*bytesPerPixel  + (j * textWidth + i* buffImage.getWidth()) * bytesPerPixel, textWidth*bytesPerPixel);

				scratch.rewind();

		        // Create A IntBuffer For Image Address In Memory
		        IntBuffer buf = ByteBuffer.allocateDirect(12).order(ByteOrder.nativeOrder()).asIntBuffer();
		        GL11.glGenTextures(buf); // Create Texture In OpenGL

		         // Create Nearest Filtered Texture
		        GL11.glBindTexture(GL11.GL_TEXTURE_2D, buf.get(0));
		        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
		        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
		        GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0,GL11.GL_RGBA,textWidth,textHeight, 0,GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, scratch);

		        Texture newTexture = new Texture();
		        newTexture.textureId = buf.get(0);     // Return Image Addresses In Memory
		        newTexture.textureHeight = textHeight;
		        newTexture.textureWidth = textWidth;

		        toReturntextures[i*cols+j] = newTexture;
		        toReturntextures[i*cols+j].textureHeight = textHeight;
		        toReturntextures[i*cols+j].textureWidth = textWidth;
		        */
            }
        }

        return toReturntextures;
    }

}