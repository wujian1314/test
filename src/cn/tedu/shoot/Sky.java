package cn.tedu.shoot;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
/** 天空: 是飞行物 */
public class Sky extends FlyingObject{
	private static BufferedImage image;
	static {
		image = loadImage("background.png");
	}
	
	private int speed; //移动速度
	private int y1; //第2张图的y坐标
	/** 构造方法 */
	public Sky(){
		super(World.WIDTH,World.HEIGHT,0,0);
		speed = 1;
		y1 = -World.HEIGHT;
	}
	
	/** 重写step()移动 */
	public void step() {
		y+=speed;  //y+(向下)
		y1+=speed; //y1+(向下)
		if(y>=World.HEIGHT) { //当y>=窗口的高
			y=-World.HEIGHT;  //则修改y的值为负的窗口的高(移到最上面)
		}
		if(y1>=World.HEIGHT) { //当y1>=窗口的高
			y1=-World.HEIGHT;  //则修改y1的值为负的窗口的高(移到最上面)
		}
	}
	
	/** 重写getImage()获取图片 */
	public BufferedImage getImage() {
		return image; //直接返回image即可
	}
	
	/** 重写paintObject()画对象 */
	public void paintObject(Graphics g) {
		g.drawImage(this.getImage(),this.x,this.y,null);
		g.drawImage(this.getImage(),this.x,this.y1,null);
	}
	
}


















