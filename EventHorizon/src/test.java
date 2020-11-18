import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

class KeyListen implements KeyListener{
	
	public static char textinput;
	public static String fullstring = "";
	public static String currentConsoleAction = "";
	public static int delay = 1000;
	public static boolean introSeq = true;
	public static int introSeqStep = -1;
	public static int speed = 0;
	public static boolean input = false;
	public static int menuSelect = 0;
	public static int crewSelect = 0;
	public static int shipSelect = 0;
	public static boolean end = false;
	public static boolean antenna = false;
	public static int commanderCompliment = -1;
    public static String[] compliments = {"Looking sharp, commander!", "Wow, you're so healthy!", "You're a perfect specimen.", "Healthy as can be!", "You look great!"};

	@Override
    public void keyTyped(KeyEvent e) {
		
		// input event for Y/N or multi-option
		
		if (test.event == true && test.eventYN == true && menuSelect == -1) {
			if (e.getKeyChar() == 'y') {
				System.out.println("Response: YES");
				main.YN = 1;
	        }
			else if (e.getKeyChar() == 'n') {
				System.out.println("Response: NO");
				main.YN = 2;
			}
		}
		
		// only execute if in console
        
		if (test.currentView == 2 && e.getKeyChar() != '') {
        	textinput = e.getKeyChar();
        	fullstring = fullstring + Character.toString(textinput);
        	fullstring = fullstring.replace("\n", "");
		    if (e.getKeyChar() == '\n') {
				fullstring = fullstring.toLowerCase();
				
				try {
					
				// returns to the previous menu if "back" is typed, or defaults to the console if not in a menu
				
				if (fullstring.equalsIgnoreCase("back")) {
					System.out.println("Went back");
					if (crewSelect > 0) {
						crewSelect = 0;
					}
					else if (shipSelect > 0) {
						shipSelect = 0;
					}
					else {
						menuSelect = 0;
					}
				}
				
				// switched the menu to ME if "me" is typed
					
				else if (fullstring.equalsIgnoreCase("me")) {
					System.out.println("Selected ME");
					menuSelect = 1;
					commanderCompliment = (int) (Math.random() * ((compliments.length-1) - 0 + 1) + 0);
				}
				
				// switched the menu to CREW if "crew" is typed
				
				else if (fullstring.equalsIgnoreCase("crew")) {
					System.out.println("Selected CREW");
					menuSelect = 2;
					commanderCompliment = (int) (Math.random() * ((compliments.length-1) - 0 + 1) + 0);
				}
				
				// switched the menu to crew.people if "people" is typed while in crew
				
				else if (menuSelect == 2 && fullstring.equalsIgnoreCase("people")) {
					crewSelect = 1;
				}
				
				// switched the menu to crew.stats if "stats" is typed while in crew
				
				else if (menuSelect == 2 && fullstring.equalsIgnoreCase("stats")) {
					crewSelect = 2;
				}
				
				// switched the menu to ship.stats if "stats" is typed while in ship
				
				else if (menuSelect == 3 && fullstring.equalsIgnoreCase("stats")) {
					shipSelect = 1;
				}
				
				else if (menuSelect == 3 && shipSelect == 2 && fullstring.equalsIgnoreCase("incubate") && main.people.size() <= 8) {
					main.trimesterNum = 0;
					main.womb = true;
				}
				
				// switched the menu to ship.incubation if "incubation" is typed while in ship
				else if (menuSelect == 3 && fullstring.equalsIgnoreCase("incubation")) {
					shipSelect = 2;
				}

				// switched the menu to SHIP if "ship" is typed
				
				else if (fullstring.equalsIgnoreCase("ship")) {
					System.out.println("Selected SHIP");
					menuSelect = 3;
					commanderCompliment = (int) (Math.random() * ((compliments.length-1) - 0 + 1) + 0);
				}
				

				// switched the menu to EVENT if "event" is typed
				
				else if (test.event == true && fullstring.equalsIgnoreCase("event")) {
					menuSelect = -1;
					commanderCompliment = (int) (Math.random() * ((compliments.length-1) - 0 + 1) + 0);
				}
				
				else {
				}
				}
				catch(Exception improperInput) {
					

					// [DEBUG] wrong input
					
					System.out.println("Wronng Input...");
				}
				
				fullstring = "";
				
			// clears String in backspace is pressed
				
			}
		    if (e.getKeyChar() == '') {
				System.out.println("DELETED String");
				fullstring = "";
			}
        }
		
		else if (e.getKeyChar() == 'i') {
			System.out.println("Selected INFO");
			File info = new File(".\\res\\HOWTOPLAY.txt");
			try {
				Desktop.getDesktop().open(info);
			} catch (IOException fileError) {
				fileError.printStackTrace();
			}
        }
		

		// turns on antenna once ca is pressed
		
		else if (e.getKeyChar() == 'a') {
			System.out.println("Selected ANTENNA");
			antenna = !antenna;
        }
		
		if (test.currentView == 3) {
			if (e.getKeyChar() == 's') {
				System.out.println("PressureSet");
				PrintDistance.mining = false;
			}
			else if (e.getKeyChar() == 'l' && PrintDistance.mining == false) {
				PrintDistance.landed = false;
				int rInj = (int) (Math.random() * (10 - 1 + 1) + 1);
				if (rInj == (int) (Math.random() * (40 - 1 + 1) + 1)) {
					int rPerson = (int) (Math.random() * (main.people.size() - 1 + 1) + 1);
					main.peopleINJ.set(rPerson, 20+main.peopleINJ.get(rPerson));
					PrintDistance.transfer[0] = main.people.get(rPerson) + " was injured!";
					
				}
			}
			else if (e.getKeyChar() == 'm') {
				PrintDistance.mining = true;
			}
			
			
		}
		

		// switches to console once c is pressed
		
		else if (e.getKeyChar() == 'c' && test.currentView != 3) {
			System.out.println("Selected CONSOLE");
        	test.currentView = 2;

        }

		// switches to info once i is pressed
		
		// sends input when enter is pressed
		
		else if (e.getKeyChar() == '\n') {
			System.out.println("ENTER pressed");
			input = true;
        }
		

		// switches to ship is ESC is pressed
           
        else if (e.getKeyChar() == '' && test.currentView != 3) {
        	System.out.println("ESC pressed");
        	test.currentView = 1;
        }
    }
	
	// necessary events for the keyPress function, I just used them to increase time

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (delay < 1000) {
            	delay += 100;	
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (delay > 0) {
            	delay -= 100;	
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        }
    }
	
}

public class test extends JPanel{
	
	public static int iterationSpeed = 1;
	public static int currentView = 1;
	public static AnimatedPanel panel = new AnimatedPanel();
	public static char textinput;
	
	public static boolean event = false;
	public static boolean eventYN = false;
	public static boolean eventMO = false;
	public static int aObj = 0;
	
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            	
            	// starting intitial function
            	
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                
                // setting hue displacement
                int hueDisplacement = (int) (Math.random() * (360 - 0 + 1) + 0);
                int currentImage = 1;
                for (currentImage = 1; currentImage < 7; currentImage++) {
                	try {
						HueChanger.changeHue(hueDisplacement, ".\\res\\defaultRes\\ship"+ currentImage + ".png", ".\\res\\shipDayWeek\\ship"+ currentImage + ".png");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("Failed...");
					}
                }
                for (currentImage = 1; currentImage < 3; currentImage++) {
                	try {
						HueChanger.changeHue(hueDisplacement, ".\\res\\defaultRes\\consoleScreen"+ currentImage + ".png", ".\\res\\console\\consoleScreen"+ currentImage + ".png");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("Failed...");
					}
                }
                try {
					HueChanger.changeHue(hueDisplacement, ".\\res\\defaultRes\\icon.png", ".\\res\\icon\\icon.png");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
                // initiating JFrame

                JFrame frame = new JFrame("EVENT HORIZON");
                frame.addKeyListener(new KeyListen());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(panel);
                frame.pack();
                frame.setLocationRelativeTo(null);
                ImageIcon icon = new ImageIcon(".\\res\\icon\\icon.png");
                frame.setIconImage(icon.getImage());
                frame.setVisible(true);
                frame.setResizable(false);
                
                // starting animation loop

                panel.animate();
                
            }
        });
    }

    public static class AnimatedPanel extends JPanel {
    	
    	// [DEBUG] progress

        private float newProgress = 0.0f;
        
        // initiating animated panel

        public AnimatedPanel() {
        	setPreferredSize(new Dimension(768, 600));
        }
        
        public static int count  = 1;
        public static int countStars  = 1;
        
        // setting certain iteration speed for the game starting
        
        public void animate() {
        	if (KeyListen.introSeqStep == -1) {
        		KeyListen.delay = 3000;
        	}
        	
        	// setting necessary variables
        	
            final long start = System.currentTimeMillis();
            final Timer timer = new Timer(KeyListen.delay, null);
            timer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	
                	// sets certain iteration speed while intro is active
                	
                	if (KeyListen.end == true) {
                		timer.stop();
                	}
                	
                	
                	if (KeyListen.introSeq == true) {
                		timer.stop();
                		KeyListen.delay = 600;
                		panel.animate();
                	}
                	
                	// checks if count (current frame value) is greater than 6, and resets it to cause a smooth frame loop
                	
                    if (count > 6 && currentView == 1) {
                    	timer.stop();
                    	count = 1;
                    	panel.animate();
                    	
                    }
                    
                    // similar process for the console
                    
                    if (count > 2 && currentView == 2) {
                    	timer.stop();
                    	count = 1;
                    	panel.animate();
                    	
                    }
                    
                    repaint();
                }
            });
            timer.start();
        }
        

        @Override
        protected void paintComponent(Graphics g) {
        	
            Graphics2D g2d = (Graphics2D) g;
            
            // initializing fonts
            
            Font font = null;
            Font fontBig = null;
            Font fontSmall = null;
            
			try {
				fontSmall = Font.createFont(Font.TRUETYPE_FONT, new File("res\\font.ttf")).deriveFont(8f);
				font = Font.createFont(Font.TRUETYPE_FONT, new File("res\\font.ttf")).deriveFont(12f);
				fontBig = Font.createFont(Font.TRUETYPE_FONT, new File("res\\font.ttf")).deriveFont(24f);
			} catch (FontFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// declaring variables to be used in image (and placement)
            
            int width = getWidth();
            int height = getHeight();
            int distanceFromTop = 100;
            Image shipTmp;
  	      	Image starsTmp;
  	      	Image womb = null;
  	        Image fetus = null;
  	        Image planetTmp = null;
  	        Image landed = null;
  	        Image shipIcon = null;
  	        boolean genColor = false;
  	        
  	        // [DEBUG] progress rectangle
  	        
//            int progressWidth = (int) (width * newProgress*2);
//            g2d.setColor(Color.BLACK);
//            g2d.fillRect(0, 0, progressWidth, getHeight());
//            g2d.setColor(Color.WHITE);
//            g2d.fillRect(progressWidth, 0, width - progressWidth, getHeight());
  	        
  	        // initiating intro sequence
            
            if (KeyListen.introSeq == true) {
				KeyListen.introSeqStep++;
            	super.paintComponent(g);
            	g2d.setColor(Color.BLACK);
            	currentView = -10;
            	g2d.setColor(Color.BLACK);
            	Image eventTmp;
      	      	Image horizonTmp;
            	try {
            		switch(KeyListen.introSeqStep) {
            		case 1:
            			g2d.setColor(Color.BLACK);
                		g2d.fillRect(0, 0, width, getHeight());
                		g.setFont(font);
                		g.setColor(Color.WHITE);
                		g.drawString("Made entirely by", (width/2)-150, 350);
                		g.setFont(fontBig);
                		g.drawString("ILLYA MARKOV", (width/2)-150, 380);
                		break;
            		case 2:
            			g2d.setColor(Color.BLACK);
                		g2d.fillRect(0, 0, width, getHeight());
                		g.setFont(font);
                		g.setColor(Color.WHITE);
                		g.drawString("In ten days...", (int)((width/2)-(Math.random() * (300 - 100 + 1) + 100)), (int)((Math.random() * (300 - 100 + 1) + 100)));
                		break;
            		case 3:
            			g2d.setColor(Color.BLACK);
                		g2d.fillRect(0, 0, width, getHeight());
                		g.setFont(font);
                		g.setColor(Color.WHITE);
                		g.drawString("With minimal prior Java experience...", (int)((width/2)-(Math.random() * (300 - 100 + 1) + 100)), (int)((Math.random() * (300 - 100 + 1) + 100)));
                		KeyListen.speed = 1;
                		break;
            		case 4:
                		g2d.setColor(Color.BLACK);
                		g2d.fillRect(0, 0, width, getHeight());
    					eventTmp = ImageIO.read(new File(".\\res\\eventHorizonTitle\\Event.png"));
    					Image event = eventTmp.getScaledInstance(eventTmp.getWidth(null)*4, eventTmp.getHeight(null)*4, Image.SCALE_SMOOTH);
    					horizonTmp = ImageIO.read(new File(".\\res\\eventHorizonTitle\\Horizon.png"));
    					Image horizon = horizonTmp.getScaledInstance(horizonTmp.getWidth(null)*4, horizonTmp.getHeight(null)*4, Image.SCALE_SMOOTH);
    					g.drawImage(event, 25, 200, null);
    					g.drawImage(horizon, (eventTmp.getWidth(null)*4)+70, 200, null);
    					g.setFont(font);
    					g.setColor(Color.WHITE);
    		            g.drawString("Press ENTER to begin", (width/2)-130, 350);
    		            if (KeyListen.input == true) {
    		            	g2d.setColor(Color.BLACK);
                    		g2d.fillRect(0, 0, width, getHeight());
                    		g.setFont(font);
                    		g.setColor(Color.WHITE);
                    		g.drawString(PrintDistance.transfer[0], 10, 340);
    		            }	
    		            KeyListen.introSeqStep = 3;
    		            break;
            		}
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
            
            // drawing view relative to currentview
            
            switch (currentView){
            case 1:
            	try {
            		
            		// drawing main ship view
            		
            		g2d.setColor(Color.BLACK);
            		g2d.fillRect(0, 0, width, getHeight());
    				starsTmp = ImageIO.read(new File(".\\res\\stars\\stars"+ 1 + ".png"));
    				Image starsCurrent = starsTmp.getScaledInstance(768, 432, Image.SCALE_SMOOTH);
    				 g.drawImage(starsCurrent, 0, 84, null);
    				 if (event == true) {
    					 Image aObjIMG = ImageIO.read(new File(".\\res\\astronomicalObjects\\" + aObj + ".png"));
    					 aObjIMG = aObjIMG.getScaledInstance(aObjIMG.getWidth(null)*5, aObjIMG.getHeight(null)*5, Image.SCALE_SMOOTH);
    					 if (aObj == 4) {
    						 g.drawImage(aObjIMG, ((width/2)-(aObjIMG.getWidth(null))+40), ((height/2)-(aObjIMG.getHeight(null)/2)), null);
    					 }
    					 else {
    						 g.drawImage(aObjIMG, ((width/2)-(aObjIMG.getWidth(null)/2)), ((height/2)-(aObjIMG.getHeight(null)/2)), null);
    					 }
    				 }
    				shipTmp = ImageIO.read(new File(".\\res\\shipDayWeek\\ship"+ count + ".png"));
    				Image shipFrame = shipTmp.getScaledInstance(768, 432, Image.SCALE_SMOOTH);
    			    g.drawImage(shipFrame, 0, 84, null);
    			    g.setFont(font);
            		g.setColor(Color.WHITE);
    			    g.drawString(PrintDistance.transfer[0], 30, 50);
    			    
    			    if (KeyListen.antenna == true) {
    			    	g.drawString("[O2: " + main.oxygen + "] [FOD: " + main.hunger + "] [H2O: " + main.thirst + "] [TMP: " + main.temperature + "K] [PRS: " + main.pressure + "PSI]", 30, 550);
    			    	g.drawString("Traveled: " + (PrintDistance.kmt*main.velocityKM*24) + "KM, days to 1AU: " + (PrintDistance.AUKM-PrintDistance.kmt) , 30, 580);
    			    }
    			    
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
            	break;
            case 2:
            	
            	// drawing console
            	
            	try {
    				shipTmp = ImageIO.read(new File(".\\res\\console\\consoleScreen" + count + ".png"));
    				g.setFont(fontBig);
            		g.setColor(Color.BLACK);
    				Image shipFrame = shipTmp.getScaledInstance(768, 600, Image.SCALE_SMOOTH);
    			    g.drawImage(shipFrame, 0, 0, null);
    			    
    			    switch(KeyListen.menuSelect) {
    			    
    			    case 1:
    			    	// drawing console.me 
    			    	
    			    	g.setFont(font);
    			    	g.drawString("<< " + KeyListen.compliments[KeyListen.commanderCompliment], (width/2)-210, 300);
    			    	break;
    			    	
    			    case 2:
    			    	
    			    	if (KeyListen.crewSelect == 1) {
    			    		
    			    		// drawing console.crew.people
    			    		
    			    		g.setFont(font);
    			    		distanceFromTop = 100;
    			    		for (int i = 0; i < main.people.size(); i++){
    			    			g.drawString(main.trade[main.peopleTRD.get(i)] + " " + main.people.get(i), (width/2)-200, distanceFromTop);
    			    			g.drawString("SANITY: " + main.peopleSTY.get(i) + ", INJURY: " + main.peopleINJ.get(i) + ", AGE:" + main.peopleAGE.get(i), (width/2)-200, distanceFromTop+20);
    			    			distanceFromTop += 50;
    			    		}
    			    	}
    			    	
    			    	else if (KeyListen.crewSelect == 2) {
    			    		
    			    		// drawing console.crew.stats
    			    		
    			    		g.setFont(font);
    			    		g.drawString("FAITH: " + main.faith, (width/2)-210, 100);
    			    		g.drawString("EDUCATION: " + main.education, (width/2)-210, 150);
    			    		g.drawString("MILITARY: " + main.military, (width/2)-210, 200);
    			    		g.drawString("POLITICS: " + main.politics, (width/2)-210, 250);
    			    		g.drawString("MEDICINE: " + main.medicine, (width/2)-210, 300);
    			    	}
    			    	
    			    	else {
    			    	
    			    		// drawing console.crew if nothing inder crew is selected
    			    		
    			    	g.setFont(font);
    			    	g.drawString("<< There are " + main.people.size() + " people on the ship...", (width/2)-210, 100);
    			    	g.setFont(fontBig);
    			    	g.drawString("PEOPLE", (width/2)-170, 450);
    			    	g.drawString("STATS", (width/2)-170, 500);
    			    	}
    			    	
    			    	
    			    	break;
    			    	
    			    case 3:
    			    	if (KeyListen.shipSelect == 1) {
    			    		
    			    		// drawing console.ship.stats
    			    		
    			    		g.setFont(font);
    			    		String oxyGens = "ACTIVE!";
    			    		if (main.oxyGen == false) {
    			    			g.setColor(Color.RED);
    			    			oxyGens = "INACTIVE ! ALERT ! O2 WILL DEPLETE !";
    			    		}
    			    		g.drawString("OXYGENS : " + oxyGens, (width/2)-210, 100);
    			    		g.setColor(Color.BLACK);
    			    		g.drawString("CIRCUITRY: " + main.circuitry + "%", (width/2)-210, 150);
    			    		g.drawString("CONDITION: " + main.condition + "%", (width/2)-210, 200);
    			    		g.drawString("RTG: " + main.RTG + "lb of radioactive material", (width/2)-210, 250);
    			    		g.drawString("FUEL: " + main.fuel + "gal", (width/2)-210, 300);
    			    		g.drawString("DAYS: " + main.daysTotal, (width/2)-210, 350);
    			    		g.drawString("DISTANCE Traveled: " + main.AUtotal + "AU", (width/2)-210, 400);
    			    		g.drawString("DISTANCE remaining: " + main.distanceAU + "AU", (width/2)-210, 450);
    			    	}
    			    	
    			    	else if (KeyListen.shipSelect == 2) {
    			    		
    			    		// drawing console.ship.incubation
    			    		
    			    		g.setFont(font);
    			    		if (main.womb == false) {
    			    			g.drawString("THE ARTIFICIAL WOMB IS NOT IN USE...", (width/2)-210, 100);
    			    			if (main.people.size() < 8) {
    			    				g.setFont(fontSmall);
    			    				g.drawString("Type 'incubate' to begin incubation...", (width/2)-210, 120);
    			    			}
    			    			else {
    			    				g.setFont(fontSmall);
    			    				g.drawString("Ship too full to incubate...", (width/2)-210, 120);
    			    			}
    			    		}
    			    		else {
    			    			g.drawString("THE ARTIFICIAL WOMB IS IN USE!", (width/2)-210, 100);
    			    			fetus = ImageIO.read(new File(".\\res\\incubation\\" + main.trimesterNum + "trimester.png"));
        			    		fetus = fetus.getScaledInstance(fetus.getWidth(null)*3, fetus.getHeight(null)*3, Image.SCALE_SMOOTH);
        			    		g.drawImage(fetus, (width/2)-(fetus.getWidth(null)/2), (height/2)-(fetus.getHeight(null)/2) + 60, null);
    			    		}
    			    		g.setFont(font);
    			    		g.drawString("Gametes repository: " + main.gametesCapacity + "%", (width/2)-210, 150);
    			    		womb = ImageIO.read(new File(".\\res\\incubation\\womb.png"));
    			    		womb = womb.getScaledInstance(womb.getWidth(null)*3, womb.getHeight(null)*3, Image.SCALE_SMOOTH);
    			    		g.drawImage(womb, (width/2)-(womb.getWidth(null)/2), 250, null);
    			    	}
    			    	
    			    	else {
    			    		
    			    		// drawing console.ship is nothing is selected under ship
    			    	
    			    	g.setFont(font);
    			    	g.drawString("<< " + PrintDistance.conditionDescription[0], (width/2)-210, 100);
    			    	g.setFont(fontBig);
    			    	g.drawString("STATS", (width/2)-170, 450);
    			    	g.drawString("INCUBATION", (width/2)-170, 500);
    			    	}
    			    	break;
    			    	
    			    case -1:
    			    	if (main.YN == 1) {
    			    		int displace = 0;
    			    		if (PrintDistance.displayText == true) {
    			    			g.setFont(fontSmall);
    			    			displace = 9;
    			    		}
    			    		else {
    			    			g.setFont(fontBig);	
    			    			displace = 18;
    			    		}
    			    		g.drawString(PrintDistance.transfer[0], (width/2)-((PrintDistance.transfer[0].length()*displace)/2), 300);
    			    	}
    			    	else {
    			    	g.setFont(font);
    			    	distanceFromTop = 100;
    			    	for (int i = 0; i < PrintDistance.transfer.length; i++) {
    			    		g.setFont(fontSmall);
    			    		g.drawString(PrintDistance.transfer[i], (width/2)-210, distanceFromTop);
    			    		distanceFromTop += 25;
    			    	}
    			    	g.setFont(fontBig);
    			    	if (test.eventYN == true) {
    			    		g.drawString("[Y/N]", (width/2)-50, 400);
    			    	}
    			    	}
    			    	break;
    			    
    			    case 0:
    			    	g.drawString("ME", (width/2)-50, 250);
                		g.drawString("CREW", (width/2)-50, 300);
                		g.drawString("SHIP", (width/2)-50, 350);
                		if (event == true) {
                			g.drawString("EVENT", (width/2)-50, 400);
                		}
                		break;
    			    }
    			    
    			    
    			    
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
            	break;
        case 3:
        	
        	try {
        		int rsize = 0;
        		g2d.setColor(Color.BLACK);
        		g2d.fillRect(0, 0, width, getHeight());
				if (genColor == true) {
					HueChanger.changeHue((int) (Math.random() * (-100 - 50 + 1) + 50), ".\\res\\astronomicalObject\\" + aObj + ".png", ".\\res\\astronomicalObject\\" + aObj + ".png");
					rsize = (int) (Math.random() * (1 - 4 + 1) + 4);
				}
				landed = ImageIO.read(new File(".\\res\\astronomicalObjects\\"+ aObj +".png"));
				shipIcon = ImageIO.read(new File(".\\res\\icon\\icon.png"));
				Image landedFull = landed.getScaledInstance(landed.getWidth(null)*10, landed.getHeight(null)*10, Image.SCALE_SMOOTH);
				Image shipIconFull = shipIcon.getScaledInstance(shipIcon.getWidth(null)*5, shipIcon.getHeight(null)*5, Image.SCALE_SMOOTH);
				if (aObj == 4) {
					g.drawImage(landedFull, (width/2)-((landedFull.getWidth(null))-120), (height/2)-((landedFull.getHeight(null))/2)-10, null);
				}
				else {
			    g.drawImage(landedFull, (width/2)-((landedFull.getWidth(null))/2), (height/2)-((landedFull.getHeight(null))/2)-10, null);
				}
			    g.drawImage(shipIconFull, (width/2)-((shipIconFull.getWidth(null))/2), (height/2)-((shipIconFull.getHeight(null))/2)-50, null);
			    g.setFont(fontSmall);
			    g2d.setColor(Color.WHITE);
        		g2d.fillRect((width/2)-50, (height/2)+50, 100, 9);
        		g2d.setColor(Color.RED);
        		g.drawString("RM", (width/2)-((2*8)/2), (height/2)+40);
        		g2d.fillRect((width/2)-50, (height/2)+50, main.RTG/10, 9);
			    g2d.setColor(Color.WHITE);
        		g2d.fillRect((width/2)-50, (height/2)+100, 100, 9);
        		g2d.setColor(Color.BLUE);
        		g.drawString("FUEL", (width/2)-((8*4)/2), (height/2)+90);
        		g2d.fillRect((width/2)-50, (height/2)+100, main.fuel/10000, 9);
        		if (KeyListen.antenna == true) {
        			g.setColor(Color.WHITE);
            		g.drawString("PRS: " + main.pressure + "PSI", 10, 10);	
            		g.drawString("TMP: " + main.temperature + "K", 10, 20);	
            		g.drawString("FOD: " + main.hunger, 10, 30);
            		g.drawString("H2O: " + main.thirst, 10, 40);
            		g.drawString("O2: " + main.oxygen, 10, 50);
        		}
        		g2d.setColor(Color.WHITE);
        		g.drawString("'M'ine/'S'TOP/'L'EAVE", (width/2)-((8*21)/2), (height/2)+120);
        		g.drawString(PrintDistance.transfer[0], (width/2)-((8*PrintDistance.transfer[0].length())/2), (height/2)+150);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	break;
        	
        case -1:
        	
        	if (main.isArrived == true) {
        		KeyListen.end = true;
        		g2d.setColor(Color.decode("#4E74A5"));
        		g2d.fillRect(0, 0, width, getHeight());
        		g.setColor(Color.WHITE);
        		g.setFont(fontSmall);
        		String ending = "After your long journey, everything will be okay...";
        		try {
    				HueChanger.changeHue((int) (Math.random() * (-100 - 50 + 1) + 50), ".\\res\\newPlanet\\land.png", ".\\res\\newPlanet\\land.png");
    				planetTmp = ImageIO.read(new File(".\\res\\newPlanet\\land.png"));
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
				Image planet = planetTmp.getScaledInstance(768, 432, Image.SCALE_SMOOTH);
			    g.drawImage(planet, 0, 168, null);
        		g.drawString(ending, (width/2)-((ending.length()*9)/2), 50);
        		
        	}
        	
        	if (main.isDead == true) {
        		KeyListen.end = true;
        		g2d.setColor(Color.BLACK);
        		g2d.fillRect(0, 0, width, getHeight());
        		g.setColor(Color.WHITE);
        		g.setFont(fontSmall);
        		g.drawString(main.causeOfDeath, (width/2)-((main.causeOfDeath.length()*9)/2), 300);
        		
        	}
        	
        	break;
        }
            
            // adding various progress
            
            count++;
            if (newProgress >= 0.5f) {
            	newProgress = 0f;
            }
            else {
            	newProgress+=0.1;
            }
			
        }
        
    }
}