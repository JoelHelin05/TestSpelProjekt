package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{

	GamePanel gp;
	KeyHandler keyH;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		
		this.gp = gp;
		this.keyH = keyH;
		
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues() {
		
		x = 100;
		y = 100;
		speed = 4;
		direction = "down";
	}
	
	public void getPlayerImage() {
		
		try {
			
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/SnubbeU1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/SnubbeU2.png"));
			up3 = ImageIO.read(getClass().getResourceAsStream("/player/SnubbeU3.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/SnubbeN1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/SnubbeN2.png"));
			down3 = ImageIO.read(getClass().getResourceAsStream("/player/SnubbeN3.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/SnubbeV1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/SnubbeV2.png"));
			left3 = ImageIO.read(getClass().getResourceAsStream("/player/SnubbeV3.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/SnubbeH1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/SnubbeH2.png"));
			right3 = ImageIO.read(getClass().getResourceAsStream("/player/SnubbeH3.png"));
		}catch(IOException e) {
			e.printStackTrace();
			
		}
	}
	
	public void update() {

		if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {

			if(keyH.upPressed == true) {
				direction = "up";
				y -= speed;
			}
			else if (keyH.downPressed == true) {
				direction = "down";
				y += speed;
			}
			else if (keyH.leftPressed == true) {
				direction = "left";
				x -= speed;
			}
			else if (keyH.rightPressed == true) {
				direction = "right";
				x += speed;
			}
			spriteCounter++;
			//Animations hastighet
			if(spriteCounter>7) {
				spriteNum++;
				if(spriteNum > 4) {
					spriteNum = 1;
				}
				spriteCounter = 0;
				System.out.println(spriteNum);
			}
		}else {
			spriteNum = 1;
		}
	}
	public void draw(Graphics2D g2) {

		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			if(spriteNum == 1) {
				image = up1;
			}
			if(spriteNum == 2) {
				image = up2;
			}
			if(spriteNum == 3) {
				image = up1;
			}
			if(spriteNum == 4) {
				image = up3;
			}
			break;
		case "down":
			if(spriteNum == 1) {
				image = down1;
			}
			if(spriteNum == 2) {
				image = down2;
			}
			if(spriteNum == 3) {
				image = down1;
			}
			if(spriteNum == 4) {
				image = down3;
			}
			break;
		case "left":
			if(spriteNum == 1) {
				image = left1;
			}
			if(spriteNum == 2) {
				image = left2;
			}
			if(spriteNum == 3) {
				image = left1;
			}
			if(spriteNum == 4) {
				image = left3;
			}
			break;
		case "right":
			if(spriteNum == 1) {
				image = right1;
			}
			if(spriteNum == 2) {
				image = right2;
			}
			if(spriteNum == 3) {
				image = right1;
			}
			if(spriteNum == 4) {
				image = right3;
			}
			break;
		}
		
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
	}
}
