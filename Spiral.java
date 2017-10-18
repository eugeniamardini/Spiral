//Yauheniya Zapryvaryna
//CS 210
//Instructor: William Iverson
//Bellevue College
//October 22, 2013
//Revised on October 23, 2013
//The interactive program Spiral is created to construct 
// a spiral,using UW's Drawing Panel and allowing the user to input 
//the desired data to modify the spiral's and panel's parameters.
import java.awt.*;
import java.util.*;
public class Spiral {

	public static void main(String[] args) {
		intro();
		Scanner console = new Scanner (System.in);
        // getting user's input
		System.out.println("Enter the desired length of the window:");
		int length = console.nextInt();
		System.out.println("Enter the desired width of the window:");
		int width = console.nextInt();
		System.out.println("Enter the desired number of spirals:");
		int spirals = console.nextInt();	
		System.out.println("Enter the desired distance between the arms of the spiral:");
		int dist = console.nextInt();
		System.out.println("Specify the desired intensity of red from 0 to 255:");
		int red = console.nextInt();
		System.out.println("Specify the desired intensity of green from 0 to 255:");
		int green = console.nextInt();
		System.out.println("Specify the desired intensity of blue from 0 to 255:");
		int blue = console.nextInt();
		System.out.println("Specify the desired intensity of red for \nthe spiral from 0 to 255 :");
		int myColor1 = console.nextInt();
		System.out.println("Specify the desired intensity of green \nfor the spiral from 0 to 255:");
		int myColor2 = console.nextInt();
		System.out.println("Specify the desired intensity of blue \nfor the spiral from 0 to 255:");
		int myColor3 = console.nextInt();

		DrawingPanel panel = new DrawingPanel(length,width);
		Graphics g = panel.getGraphics();
		//calling 3 methods to get colors of background, lines and draw lines
		Color backgroundColor= getColorForBackground(panel, red, green, blue);
		panel.setBackground(backgroundColor);
        Color spiralColor = getColorForSpirals(g, myColor1, myColor2, myColor3);
        g.setColor(spiralColor);
        Graphics n = drawSpiral(g, length, width, spirals, dist);
        }
	public static void intro(){
		System.out.println("Hello,");
		System.out.println("This program reads data");
		System.out.println("and constructs a maze of \nthe size and color you prefer");
		System.out.println();
	}
	//Creating a method with if-else statements 
	//to make sure the user enters a valid number for color.
	//Returns the newly created color to the main() to set it for background.
public static  Color getColorForBackground (DrawingPanel panel, int red, int green,int blue ){
	if (red > 255){
		red=255;
	}else if (red<0){
		red = 0;
	}
	
	if (green > 255){
		green=255;
	}else if (green<0){
		green = 0;
	}
	
    if (blue > 255){
    	blue=255;
    }else if (blue<0){
		blue = 0;
	}
    return new Color(red,green,blue);
}
//Creating a method with if-else statements to make sure 
//the user enters a valid number for color.
//Returns color to the main() to set the color for drawing lines.
public static Color getColorForSpirals(Graphics g, int myColor1, int myColor2, int myColor3){
	if (myColor1 > 255){
		myColor1=255;
	}else if (myColor1<0){
		myColor1 = 0;
	}
	
	if (myColor2> 255){
		myColor2=255;
	}else if (myColor2<0){
		myColor2 = 0;
	}
	
	if (myColor3 > 255){
		myColor3=255;
	}
    else if (myColor3<0){
    	myColor3 = 0;
    }
	return new Color (myColor1, myColor2, myColor3);
}
//creating a method with for-loops inside to construct a maze, using the input as parameters of 
//length and number of lines, as well as their locations. 
public static Graphics drawSpiral(Graphics g, int length, int width, int spirals, int dist){
	int x1 = 0, x2 = length-dist;
    int y1 = dist, y2 = dist;
    //top
    for (int i = 0;i<spirals;i++){
		g.drawLine(x1,y1,x2,y2);
    	x1+=dist;
    	y1+=dist;
    	x2-=dist;
    	y2+=dist;
    }
    //bottom
    x1=dist; 
    x2=length-dist;
    y1=width-dist; 
    y2=width-dist;
    for (int l=0; l<spirals-1;l++){
    	g.drawLine(x1, y1, x2, y2);
    	x1+=dist;
    	y1-=dist;
    	x2-=dist;
    	y2-=dist;
    }
    //left
    x1=dist; 
    x2=dist;
    y1=dist*2; 
    y2=width-dist;
    for (int j=0; j<spirals-1;j++){
    	g.drawLine(x1, y1, x2, y2);
    	x1+=dist;
    	y1+=dist;
    	x2+=dist;
    	y2-=dist;
    }
    //right
    x1=length-dist; 
    x2=length-dist;
    y1=dist; 
    y2=width-dist;
    for (int k=0; k<spirals;k++){
    	g.drawLine(x1, y1, x2, y2);
    	x1-=dist;
    	y1+=dist;
    	x2-=dist;
    	y2-=dist;
    }
	return g;
}
}
