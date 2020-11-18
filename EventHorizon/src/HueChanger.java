import java.io.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;
public class HueChanger
{
 public static void changeHue(int iHUE, String inputFilepath, String outputFilepath) throws IOException {
 while((iHUE > 360 || iHUE < 0));
 float hue = iHUE/360.0f;
 
 // reading file from filepath
 
 BufferedImage raw,processed;
 raw = ImageIO.read(new File(inputFilepath));
 int WIDTH = raw.getWidth();
 int HEIGHT = raw.getHeight();
 processed = new BufferedImage(WIDTH,HEIGHT,raw.getType());
 
 // per row of pixels, iterate through the pixels
 
 for(int Y=0; Y<HEIGHT;Y++) {
  for(int X=0;X<WIDTH;X++) {
	  
	  // set RGB variables
	  
   int RGB = raw.getRGB(X,Y);
   int A = (RGB >> 24) & 0xff;
   int R = (RGB >> 16) & 0xff;
   int G = (RGB >> 8) & 0xff;
   int B = (RGB) & 0xff;
   
   // change to HSB
   
   float[] HSB = Color.RGBtoHSB(R, G, B, null);
   float tmphue = HSB[0];
   
   // displace hue by exact amount set
   
   float hueFinal = (tmphue-hue)%360;
   int RGBFinal = Color.HSBtoRGB(hueFinal, HSB[1], HSB[2]);
   R = (RGBFinal>>16)&0xFF;
   G = (RGBFinal>>8)&0xFF;
   B = RGBFinal&0xFF;
   Color finalcolor = new Color(R, G, B, A);
   
   // setting the RGB
   
   processed.setRGB(X,Y,finalcolor.getRGB());
  }
 }
 // write file to correct filepath
 ImageIO.write(processed,"PNG",new File(outputFilepath));
 }
}