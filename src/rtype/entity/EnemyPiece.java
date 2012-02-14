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

import org.lwjgl.opengl.GL11;

import rtype.Prototyp;

public class EnemyPiece extends Entity
{
	protected float alpha = 1;
	protected float disaperanceSpeed = 0.65f;//0.0065f;//
	
	public EnemyPiece(int type)
	{
		this.type = type;
		this.init();
		this.setRatio(0.13f);
		
	}
	
	@Override
	public void draw()
	{
		if (alpha < 0)
		{
			unSpawn();
			if (Logger.isLogActivate) Logger.log("Removed explosion from explosion layer");
			return;
		}
		
		alpha -= disaperanceSpeed * tick  ;
       	
       	GL11.glLoadIdentity();            
		GL11.glTranslatef(position.x,position.y,Prototyp.DEFAULT_Z);
		GL11.glRotatef(this.rotation,0f,0f,1f);
		// Translate Into/Out Of The Screen By z
		GL11.glColor4f(1,1,1,alpha);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.texture.getTextureId() );
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA,GL11.GL_ONE);
		//GL11.glBlendFunc(GL11.GL_SRC_ALPHA,GL11.GL_ONE_MINUS_SRC_ALPHA);
		
		GL11.glBegin(GL11.GL_QUADS);
		{
			GL11.glTexCoord2f(textureRight,textureUp); //Upper right
			GL11.glVertex2f(width, -height);
			
			GL11.glTexCoord2f(textureLeft,textureUp); //Upper left			
			GL11.glVertex2f(-width, -height);        
	   
			GL11.glTexCoord2f(textureLeft,textureDown); //Lower left
			GL11.glVertex2f(-width,height);
				
			GL11.glTexCoord2f(textureRight,textureDown); // Lower right
			GL11.glVertex2f(width,height);	
		}
       	GL11.glEnd();
       	GL11.glColor4f(1,1,1,1);
	}
	
	

}
