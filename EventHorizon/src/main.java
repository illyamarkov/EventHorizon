import java.util.Scanner;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


	public class main {
		
		public static List<String> people = new ArrayList<String>();
		public static List<Integer> peopleSTY = new ArrayList<Integer>();
		public static List<Integer> peopleAGE = new ArrayList<Integer>();
		public static List<Integer> peopleTRD = new ArrayList<Integer>();
		public static List<Integer> peopleINJ = new ArrayList<Integer>();
		public static List<Integer> peopleDAY = new ArrayList<Integer>();
		
		public static String[] trade = {"Dr. ", "Prof. ", "Lt. ", "Cpt. ", "Maj. ", "Cmdr. ", "St. ", "Pres. ", "Gov. ", "Lord ", "Master ", "Sir ", "Padre ", "Monk ", "Priest ", "Surgeon ", "Child ", "Prodigy ", "Miracle "};
		
		public static String[] commuters = {"Tardigrade", "Arachnid", "Termite", "Ant", "Beetle", "Dwarf rat"};
		
		public static int faith;
		public static int military;
		public static int education;
		public static int medicine;
		public static int politics;
		
		public static int unexpectedLife = (int)(Math.random() * (commuters.length-1 - -50 + 1) + -50);
		
		public static int oxygen = 100;
		public static float temperature = 2.7f;
		public static float pressure = 0;
		public static int thirst = 100;
		public static int thirstDays = 0;
		public static int hunger = 100;
		public static int hungerDays = 0;
		
		public static int YN = 0;
		
		public static boolean oxyGen = true;
		public static int circuitry = 100;
		public static int condition = 100;
		public static boolean nutritionGen = true;
		public static boolean hydrationGen = true;
		public static int RTG = 348;
		public static int fuel = 342483;
		
		public static boolean isArrived = false;
		public static boolean isDead = false;
		public static String causeOfDeath = "";
		
		public static long daysTotal = 0;
		public static long AUtotal = 0;
		
		public static boolean womb = false;
		public static int trimesterNum = -1;
		public static int gametesCapacity = 100;
		public static int daysOfIncubation = 0;
		
		public static int distanceAU = (int)(Math.random() * (10 - 5 + 1) + 5);
		public static int velocityKM = (int)(Math.random() * (65000 - 55000 + 1) + 55000);
		
		public static int distanceKM;
		
	    public static void main(String[] args) {
	    	
	    	PrintDistance.event = true;
	    	
	    	// initializing people
	    	
	    	for (int i = 0; i < (Math.random() * (7 - 4 + 1) + 4); i++) {
	    	people.add(genname());
	    	peopleAGE.add(genage());
	    	peopleTRD.add(gentrade());
	    	peopleSTY.add(100);
	    	peopleINJ.add(0);
	    	peopleDAY.add(genday());
	    	updateStats(peopleTRD.get(i));
	    	}
	    	
	    	// [DEBUG] printing stats
	    	try {
	    		
	    		// [DEBUG] distance, and info
	    		// Also, sleep to sync music
	    		
				System.out.println("Distance from Inhabitable Planet: " + distanceAU + " AU");
//				Thread.sleep(2000);
		    	Thread.sleep(3200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	while (KeyListen.input == false) {
	    		System.out.print("");
	    	}
	    	
//	    	start();
	    	
	    	PrintDistance.transfer[0] = "";
	    	KeyListen.input = false;
        	KeyListen.introSeq = false;
        	test.currentView = 1;
	    	
	        new Thread(new ReadRunnable()).start();
	        new Thread(new PrintDistance()).start();
	        new Thread(new crew()).start();
	        
	        
	    }
	    
	    // start intro
	    
	    public static void start() {
	    	String[] start = {"Hey! This is a secret String, I added this in just for others to find it.", "The distant future hold troubling stories...",
	    			"NASA had kept as many people safe as possible...",  "but unfortunately their efforts were meaningless.",
	    			"With every coming day, more and more died.",
	    			"A plan was inititated, a simple idea for departure.", "Few would be sent to a suitable planet for humans.",
	    			"It sounded insane at first, but it was the only option.",
	    			"The assembly began, it lasted several years.", "As it was finished, unexpected jumps in death occured.",
	    			"Before it could get worse, few quickly boarded...", "A launch sequence began in the coming minutes..."};
	    	
	    	String[] outcome = {"Decade-long wars started using biological weapons.",
	    			"An unfortunate plague caught the world by surprize.",
	    			"Pollution reached an irreversible state."};
	    	
	    	Scanner startscanner = new Scanner(System.in);
	    	
	    	try {
                PrintDistance.transfer[0] = (start[1]);
                Thread.sleep(3000);
                PrintDistance.transfer[0] = (outcome[(int)(Math.random() * (2 - 1 + 1) + 2) -2]);
    	    	Thread.sleep(3000);
    	    	for (int i = 2; i < start.length; i++) {
    	    		PrintDistance.transfer[0] = (start[i]);
    	    		Thread.sleep(3000);
    	    	}
    	    	for (int i1 = 5; i1 >= 1; i1--) {
    	    		PrintDistance.transfer[0] = (i1 + "...");
    	    		Thread.sleep(2000);
    	    	}
    	    	PrintDistance.transfer[0] = (".........");
    	    	Thread.sleep(3000);
    	    	PrintDistance.transfer[0] = ("..............");
    	    	Thread.sleep(3000);
    	    	PrintDistance.transfer[0] = ("Distance from Inhabitable Planet: " + distanceAU + " AU");
    	    	Thread.sleep(3000);
    	    	PrintDistance.transfer[0] = ("Constant velocity of: " + main.velocityKM + " KM/h");
    	    	Thread.sleep(3000);
    	    	PrintDistance.transfer[0] = ("Press 'i' for more info...");
    	    	Thread.sleep(3000);
    	    	
            } catch (InterruptedException ex) {
                throw new IllegalStateException(ex);
            }
	    }
	    
	    // gen trade val
	    
	    public static int gentrade() {
	    	int trade = (int)(Math.random() * (0 - 15 + 0) + 15);
			return trade;
	    }
	    
	    // gen age
	    
	    public static int genday() {
	    	int dayage = (int)(Math.random() * (1 - 355 + 0) + 355);
			return dayage;
	    }
	    
	    // gen age
	    
	    public static int genage() {
	    	int age = (int)(Math.random() * (18 - 35 + 1) + 35);
			return age;
	    }
	    
	    // update current stats
	    
	    public static void updateStats(int cval) {
	    		switch(cval+1) {
				case 1:
					main.medicine++;
					main.education++;
					break;
				case 2:
					main.education++;
					main.education++;
					break;
				case 3:
					main.military++;
					main.education++;
					break;
				case 4:
					main.military++;
					main.politics++;
					break;
				case 5:
					main.military++;
					main.medicine++;
					break;
				case 6:
					main.military++;
					main.military++;
					break;
				case 7:
					main.faith++;
					main.faith++;
					break;
				case 8:
					main.politics++;
					main.politics++;
					break;
				case 9:
					main.politics++;
					main.education++;
					break;
				case 10:
					main.politics++;
					main.faith++;
					break;
				case 11:
					int rnum = (int)(Math.random() * (1 - 5 + 1) + 5);
					switch (rnum) {
						case 1:
							main.politics++;
							main.politics++;
						case 2:
							main.education++;
							main.education++;
						case 3:
							main.faith++;
							main.faith++;
						case 4:
							main.medicine++;
							main.medicine++;
						case 5:
							main.military++;
							main.military++;
					}
					break;
				case 12:
					main.politics++;
					main.medicine++;
					break;
				case 13:
					main.military++;
					main.faith++;
					break;
				case 14:
					main.education++;
					main.faith++;
					break;
				case 15:
					main.medicine++;
					main.faith++;
					break;
				case 16:
					main.medicine++;
					main.medicine++;
					break;
    		}
	    }
	    
	    // name gen
	    
	    public static String genname() {
    		String[] chars = {"jo", "rod", "bil", "tim", "na", "anne", "ne", "in", "tod", "de", "re", "gar", "ra", "zer", "gi", "ket", "ter", "hur", "para", "zen", "dem", "me", "tep", "vain", "hill", "gard", "mond", "guil", "del", "ger", "li"};
    		String[] vowels = {"a", "e", "i", "o", "u"};
    		String charname = "";
    		boolean rchar;
    		int rnum = (int)(Math.random() * (2 - 1 + 1) + 1);
    		if (rnum == 2) {
    			rchar = false;
    		}
    		else {
    			rchar = true;
    		}
    		for (int i = 0; i < (Math.random() * (2 - 1 + 1) + 1); i++) {
    			if (rchar == false) {
    				for (int rc = 0; rc <= (Math.random() * (1 - 1 + 1) + 1); rc++) {
    					charname += chars[(int)(Math.random() * ((chars.length-1) - 0 + 1) + 0)];
    	    		}
    				rchar = true;
    			}
    			else {
					charname += vowels[(int)(Math.random() * ((vowels.length-1) - 0 + 1) + 0)];
    				rchar = false;
    			}
    		}
    		
    		rnum = (int)(Math.random() * (4 - 6 + 1) + 6);
    		
    		if (charname.length() >= 8) {
    			charname = charname.substring(0, rnum) + "-" + charname.substring(rnum, charname.length());
    			char[] charnameChars = charname.toCharArray();
    			charnameChars[0] = Character.toTitleCase(charnameChars[0]);
    			charnameChars[rnum+1] = Character.toTitleCase(charnameChars[rnum+1]);
    			charname = String.valueOf(charnameChars);
    		}
    		
    		else {
    			char[] charnameChars = charname.toCharArray();
    			charnameChars[0] = Character.toTitleCase(charnameChars[0]);
    			charname = String.valueOf(charnameChars);
    		}	
	    	return charname;
	    }
	}

	class ReadRunnable implements Runnable {
		
		public static boolean event = false;
		public static String eventInput = "placeholder";
		
		// initiating thread that listens for console inputs
		
		// it's quite logical what each input does, so I doubt I have to explain each individual one

	    @Override
	    public void run() {
	        final Scanner in = new Scanner(System.in);
	        while(in.hasNext()) {
	            final String line = in.nextLine();
	            eventInput = line;
	            if ("console".equalsIgnoreCase(line) && PrintDistance.event == false) {
	            	crew.gen = false;
	            	crew.event = false;
	            	ReadRunnable.event = true;
	            	System.out.println("\nYou began checking the console...");
	            	System.out.println("[you]");
	            	System.out.println("[crew]");
	            	System.out.println("[ship]");
	            	System.out.println("\n[back]");
	            	while(ReadRunnable.event == true) {
	            		String consoleMenu = in.nextLine();
	            		
		                if ("crew".equalsIgnoreCase(consoleMenu)) {
		                	System.out.println("\nYou look at the crew... " + main.people.size() + " people... What would you like to know?");
		                	System.out.println("[people]");
		                	System.out.println("[trades]");
		                	System.out.println("[health]");
		                	System.out.println("\n[back]");
		                	boolean crew = true;
		                	while (crew == true) {
		                		String crewMenu = in.nextLine();
		                		if ("people".equalsIgnoreCase(crewMenu)) {
		                			System.out.println("");
		                			for (int i = 0; i < main.people.size(); i++) {
		                				System.out.print(main.trade[main.peopleTRD.get(i)] + main.people.get(i) + ", age: " + main.peopleAGE.get(i) + ". ");
		                			}
		                			System.out.println("");
		                		}
		                		else if ("trades".equalsIgnoreCase(crewMenu)) {
		                			System.out.println("\nEducation: " + main.education);
		                	    	System.out.println("Medicine: " + main.medicine);
		                	    	System.out.println("Military: " + main.military);
		                	    	System.out.println("Politics: " + main.politics);
		                	    	System.out.println("Faith: " + main.faith);
		                		}
		                		else if ("health".equalsIgnoreCase(crewMenu)) {
		                			for (int i = 0; i < main.people.size(); i++) {
		                			System.out.print(main.people.get(i) + ", STY:" + main.peopleSTY.get(i) + ", INJ: " + main.peopleINJ.get(i) + ". ");
		                			}
		                		}
		                		else if ("back".equalsIgnoreCase(crewMenu)) {
		                			crew = false;
		                			System.out.println("\nYou look back towards the console...");
		                		}
		                	}
		                }
		                else if ("ship".equalsIgnoreCase(consoleMenu)) {
		                	System.out.println("\nYou examine the ship... What would you like to know?");
		                	System.out.println("[details]");
		                	System.out.println("[stats]");
		                	System.out.println("[incubation]");
		                	System.out.println("\n[back]");
		                	boolean ship = true;
		                	while (ship == true) {
		                		String shipMenu = in.nextLine();
		                		if ("details".equalsIgnoreCase(shipMenu)) {
		                			System.out.print("\nOxyGens: ");
				                	if (main.oxyGen == true) {
				                		System.out.println("ACTIVE");
				                	}
				                	else {
				                		System.out.println("INACTIVE ! ALERT ! O2 WILL DEPLETE !");
				                	}
				                	System.out.println("Condition: " + main.condition + "%");
				                	System.out.println("Circuitry: " + main.circuitry + "% functional");
				                	System.out.println("Radioisotope Thermoelectric Generators: " + main.RTG + "lb of radioactive matieral left");
				                	System.out.println("Fuel: " + main.fuel + " gal");
		                		}
		                		else if ("stats".equalsIgnoreCase(shipMenu)) {
		                			System.out.println("\nTotal days traveled: " + main.daysTotal);
				                	System.out.println("Distance: " + main.distanceAU + " AU left");
		                		}
		                		else if ("incubation".equalsIgnoreCase(shipMenu)) {
		                			if (main.womb == false) {
		                				System.out.println("\nThe artificial womb if currently not in use...");
		                			}
		                			else {
		                				System.out.println("\nThe artificial womb if currently in use!");
		                			}
		                			System.out.println("Gametes capacity: " + main.gametesCapacity + "%");
		                		}
		                		if ("back".equalsIgnoreCase(shipMenu)) {
		                			ship = false;
		                			System.out.println("\nYou look back towards the console...");
		                		}
		                	}
		                }
		                
		                else if ("you".equalsIgnoreCase(consoleMenu)) {
		                	System.out.println("You look at yourself...");
		                	
		                	
		                	
		                }
		                
		                
			            else if ("back".equalsIgnoreCase(consoleMenu)) {
			            	System.out.println("\nYou look away from the console...");
			                ReadRunnable.event = false;
			            }
	            	}
	            }
	            else if ("info".equalsIgnoreCase(line) && PrintDistance.event == false) {
	            	ReadRunnable.event = true;
	            	crew.gen = false;
	            	crew.event = false;
                	System.out.println("\nYou flip open the Deep space Voyager's Handbook™, " + " which page would you like to go to?");
                	System.out.println("[basics]");
                	System.out.println("[crew]");
                	System.out.println("[ship]");
                	System.out.println("[encounters]");
                	System.out.println("\n[back]");
                	boolean info = true;
                	while (info == true) {
                		String infoMenu = in.nextLine();
                		if ("basics".equalsIgnoreCase(infoMenu)) {
                			System.out.println("\nAh, hello there! If you're reading this you're likely on a space station, and would like to get the lay of the land.");
                			System.out.println("You're right to do so! You'll be spending many generations here, and one mistake can cause it all to end very quickly.");
                			System.out.println("\nLet's start with the very basics, like the console!");
                			System.out.println("The console is your control center, without it all people, and systems would perish at an alarming rate.");
                			System.out.println("You can take a look at the console by typing 'console', this will then present you with the various options you can also type in to access.");
                			System.out.println("Using the console, you can see various information about the crew, ship, and even yourself! This will all be discussed in the handbook.");
                			System.out.println("\nNext would be time!");
                			System.out.println("By default, time goes by at a 3sec:1day speed, but you can up it all the way to 3sec:1gen (roughly 100 years) by typing '1[Time Unit]'");
                			System.out.println("As a general recommendation, you should avoid increasing the time while still a few Astronomical Units away from earth.");
                			System.out.println("The time options are: day, week, month, year, decade, and generation.");
                		}
                		else if ("crew".equalsIgnoreCase(infoMenu)) {
                			System.out.println("\nThe 'lucky' bunch that will spend their lives together, these individuals are what you're keeping alive with all effort!");
                			System.out.println("The second humanity had gone extinct, that's it! We've lost to the harse conditions of the cold, empty void of space.");
                			System.out.println("\nThe first point of discussion is the crew themselves.");
                			System.out.println("Each of these members have an age, and a life expectancy. They can get injured, starve, dehydrate, and even lose sanity.");
                			System.out.println("Your duty is to keep up their health, ensure that all their basic needs are met, and that the population never exceeds 8, or recedes 6.");
                			System.out.println("That's right, population management is something to take into account! The ship has a gametes repository, and an artificial womb to do that!");
                			System.out.println("Serious concerns would include the enviroment they are in. High pressure, heat, or lack in oxygen result in very swift death.");
                			System.out.println("\nNext is trades.");
                			System.out.println("Trades contribute to your capabilities on the ship, and are decided based on the ranking a certain individual has. These are very valuable!");
                			System.out.println("The different catagories are: education, medicine, military, politics, and faith. Each of them are useful in their own way.");
                			System.out.println("Depending on the points you have towards a certain catagory, challenges requiring those fields will be performed easier!");
                			System.out.println("Education helps repair, medicine helps heal, military helps stay fit, politics helps sanity, and faith helps persistance.");
                			System.out.println("Having no points allocated to a field can result in very quick death, but you still have a chance in birthing a child based in the field.");
                		}
                		else if ("ship".equalsIgnoreCase(infoMenu)) {
                			System.out.println("\nBuilt with the latest fabrication process, and also with the intent to last incredibly long, we present the ship!");
                			System.out.println("This is the wonderful metal chamber where hundreds, or thousands of generations will spend their whole lives.");
                			System.out.println("\nFirst up is the parts.");
                			System.out.println("The parts are everything the ship contains, this includes fuel chambers, Radioscopic Thermoelectric Generators, OxyGens, and others.");
                			System.out.println("Water is filtered through, and also stored. Food is locally grown. And OxyGens are genetically modified plants with optimized O2 production.");
                			System.out.println("These are very important, and they actually can be damaged, so you have to be very careful. And react with immedietly or you will perish.");
                			System.out.println("Repairing components requires high education, but some components are irriplacable, so they have to have the highest priority.");
                			System.out.println("\nAfter that is the processes.");
                			System.out.println("The ship is constantly trying to be in a stable situation, and be inhabitable by humans. So it has many probes and capabilities.");
                			System.out.println("You can get a display of the valuble information after every iteration of position, and you want to keep them optimal.");
                			System.out.println("The ship also has the ability to accelerate in speed to reach destination quiker, however this causes it to heat up and burn fuel.");
                			System.out.println("You can also expand the size of the ship, and repair parts using scrap metal. This is very useful, and will help significantly.");
                		}
                		else if ("encounters".equalsIgnoreCase(infoMenu)) {
                			System.out.println("\nAlthough everything was planned, on such a large scale, very little planning can actually be conducted at an efficient level.");
                			System.out.println("With every coming day, the probability of something happening is there, and it's best you you are prepared for when it does.");
                			System.out.println("\nThe first type is external.");
                			System.out.println("These are occurances that happen outside of the ship. Encounters with space debris, satelites, probes, asteroids, or even planets!");
                			System.out.println("You can either recieve the resource, and harvest valuable materials from it. Or land on it and begin mining for large quantities.");
                			System.out.println("Although you often end up only benifiting a trivial amount from these external occurances, in some cases the benifits are massive.");
                			System.out.println("If you manage to encounter a planet that is possibly habitable, you can create a minor civilization, and use it as an anchor point.");
                			System.out.println("\nAnd the other type is internal.");
                			System.out.println("With so many bright minds, crew members often cannot simply sit still. They will instigate conflicts, or face problems of their own.");
                			System.out.println("These conflicts usually occur when there is a lack in a catagory of specialty, and if they are not treated, suicide is possible.");
                			System.out.println("It is very important to treat internal problems seriously, a simply lack in sanity can cause someone to open the airlock on everyone...");
                			System.out.println("There are however oditites that could also occur, like mutating plants, or unexpected commuters. These are usually harmless though.");
                		}
                		else if ("back".equalsIgnoreCase(infoMenu)) {
			            	System.out.println("\nYou close the Deep space Voyager's Handbook™, and look up...");
			                ReadRunnable.event = false;
			                info = false;
			            }
                	}
                }
	        }
	    }
	}

	class PrintDistance implements Runnable {

		public static boolean event = false;
		
		public static boolean displayText = false;
		
		public static String[] transfer = {"", "", "", "", ""};
		public static String[] conditionDescription = {"Everything is fine...", "Something seems off...", "Issues detected! investigation required.", "CRITICAL ISSUES FOUND! INVESTIGATE IMMEDIETLY!", "IRRICOVERABLE CONDITION! Irricoverable condition... Goodbye..."};
		
		public static int AUKM = (int)(149600000/(24*main.velocityKM));
    	public static int kmt = 0;
    	
    	public static boolean landed = false;
    	public static boolean mining = false;
		
	    @Override
	    public void run() {
	    	
	    	// setting AU in KM and KM time
	    	String[] aDayHasPassed = {"Oh look, another day", "And yet another day goes by", "There goes another day", "Another one goes by", "Yet another day goes by", "Look, there goes another day"};
	    	// initial print
//	    	main.start();
	    	
	    	crew.initialCrewAction();
	    	
	    	
	    	System.out.println("\nYou've exited earths orbit, you're traveling at a constant velocity of " + main.velocityKM + " KM/h, " + (AUKM-kmt) + " days left to travel 1 AU...");
	    	
	    	// unexpected life event
	    	
	    	if (main.unexpectedLife > -1) {
	    		try {
	    			Thread.sleep(1000);
	    			PrintDistance.transfer[0] = ("Wait... Hold on...");
					Thread.sleep(3000);
					PrintDistance.transfer[0] = ("Apparently some " + main.commuters[main.unexpectedLife] + "s boarded the ship. 2x[FTH++]");
					main.faith+=2;
					Thread.sleep(3000);
					PrintDistance.transfer[0] = ("They shouldn't cause much harm...");
					Thread.sleep(2000);
					PrintDistance.transfer[0] = "";
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	    	}
	    	
	    	PrintDistance.event = false;
	    	crew.gen = true;
	    	
	        while(main.distanceAU > 0  && main.isDead == false && main.isArrived == false) {
	        	while((AUKM-kmt) > 0 && main.isDead == false  && main.isArrived == false) {
	        		try {
	        			
	        			// day iteration
	        			
	        			crew.gen = true;
		                Thread.sleep(3000);
		                main.RTG -= (int)(Math.random() * (0 - 50 + 1) + 50);
		                
		                verifyLoop();
		                
		                if (ReadRunnable.event == false && main.isDead == false  && main.isArrived == false) {
		                ReadRunnable.eventInput = "placeholder";
		                kmt++;
		                main.daysTotal++;
		                System.out.println("\n" + aDayHasPassed[(int)(Math.random() * (0 - aDayHasPassed.length + 1) + aDayHasPassed.length)] + ". You traveled " + kmt*main.velocityKM*24 + " KM, " + (AUKM-kmt) + " days left to travel 1 AU...");
		                System.out.println("\n[O2:" + main.oxygen + "][HNG:" + main.hunger + "][TST:" + main.thirst + "][TMP:" + main.temperature + "K][PRS:" + main.pressure + "PSI]");
		                System.out.println(conditionDescription[0]);
		                
		                if (crew.event == false) {
		                	// generating ship event
		                	shipEvent();
		                }
		                
	        			}
		            } catch (InterruptedException ex) {
		                throw new IllegalStateException(ex);
		            }
	        	}
	        		main.distanceAU--;
	        		main.AUtotal++;
	        		kmt = 0;
	        		if (main.distanceAU <= 0) {
	        			test.currentView = -1;
	        			System.out.println("Arrived");
	    	        	main.isArrived = true;
	    	        }
	        }
	    }
	    
	    public static void verifyLoop() {
	    	if (main.isDead == false) {
            	for (int i = 0; i < main.peopleSTY.size(); i++) {
            		if (main.peopleSTY.get(i) == 0) {
            			System.out.println("Still survived...");
            			int rsty = (int)(Math.random() * (10 - 1 + 1) + 1);
            			if (rsty == (int)(Math.random() * (10 - 1 + 1) + 1)) {
            				main.isDead = true;
            				test.currentView = -1;
            				main.causeOfDeath = main.people.get(i) + " opened the airlock due to insanity, suffocating everyone.";
            				System.out.println(main.causeOfDeath);
            			}
            		}
            	}
            	if (KeyListen.end != true) {
            		if (main.oxygen == 0) {
            			main.isDead = true;
        				test.currentView = -1;
        				main.causeOfDeath = "The ship ran out of oxygen, everyone died.";
        				System.out.println(main.causeOfDeath);
            		}
            	}
            	if (KeyListen.end != true) {
            		if (main.pressure >= 300f) {
            			main.isDead = true;
        				test.currentView = -1;
        				main.causeOfDeath = "The pressure killed the crew.";
        				System.out.println(main.causeOfDeath);
            		}
            	}
            	if (KeyListen.end != true) {
            		if (main.temperature >= 317f) {
            			main.isDead = true;
        				test.currentView = -1;
        				main.causeOfDeath = "The crew died from the intense heat.";
        				System.out.println(main.causeOfDeath);
            		}
            	}
            	if (KeyListen.end != true) {
            		if (main.thirstDays > 7) {
            			main.isDead = true;
        				test.currentView = -1;
        				main.causeOfDeath = "The crew died from dehydration.";
        				System.out.println(main.causeOfDeath);
            		}
            	}
            	if (KeyListen.end != true) {
            		if (main.hungerDays > 30 && main.faith < 7) {
            			main.isDead = true;
        				test.currentView = -1;
        				main.causeOfDeath = "The crew starved to death.";
        				System.out.println(main.causeOfDeath);
            		}
            		else if (main.hungerDays > (30 + main.faith*7)) {
            			main.isDead = true;
        				test.currentView = -1;
        				main.causeOfDeath = "The crew starved to death.";
        				System.out.println(main.causeOfDeath);
            		}
            	}
            	if (KeyListen.end != true) {
            		if (main.people.size() == 0) {
            			main.isDead = true;
        				test.currentView = -1;
        				main.causeOfDeath = "Nobody is alive.";
        				System.out.println(main.causeOfDeath);
            		}
            	}
            	if (KeyListen.end != true) {
            		if (main.RTG <= 0) {
            			main.isDead = true;
        				test.currentView = -1;
        				main.causeOfDeath = "No more electricity, you froze to death.";
        				System.out.println(main.causeOfDeath);
            		}
            	}
            	if (KeyListen.end != true) {
            		if (main.fuel <= 0) {
            			main.isDead = true;
        				test.currentView = -1;
        				main.causeOfDeath = "You ran out of fuel, so you got lost in space.";
        				System.out.println(main.causeOfDeath);
            		}
            	}
            	for (int i = 0; i < main.peopleAGE.size(); i++) {
            		if (main.peopleAGE.get(i) >= 85) {
            			int rsty = (int)(Math.random() * (10 - 1 + 1) + 1);
            			if (rsty == (int)(Math.random() * (10 - 1 + 1) + 1)) {
            				main.peopleAGE.remove(i);
            				main.peopleSTY.remove(i);
            				main.peopleINJ.remove(i);
            				main.peopleTRD.remove(i);
            				main.people.remove(i);
            			}
            		}
            	}
            }
            
            if (main.thirst == 0) {
            	main.thirstDays++;
            	System.out.println(main.thirstDays);
            }
            if (main.hunger == 0) {
            	main.hungerDays++;
            }
            if (main.nutritionGen == false) {
            	if (main.hunger > 0) {
            	main.hunger -= (main.people.size()*2);
            	if (main.hunger < 0) {
            		main.hunger = 0;
            	}
            	}
            }
            if (main.hydrationGen == false) {
            	if (main.thirst > 0) {
            	main.thirst-= (main.people.size()*2);
            	if (main.thirst < 0) {
            		main.thirst  = 0;
            	}
            	}
            }
            if (main.oxyGen == false) {
            	if (main.oxygen > 0) {
            	main.oxygen+= (main.people.size()*2);
                if (main.oxygen < 0) {
                	main.thirst  = 0;
                }
            	}
            }
            
            
            
            if (main.RTG > 999) {
            	main.RTG = 999;
            }
            
            if (main.fuel > 999999) {
            	main.RTG = 999999;
            }
            
            if (main.womb == true) {
            	main.daysOfIncubation++;
            	if (main.daysOfIncubation < 2) {
            		main.trimesterNum = 0;
            	}
            	else if (main.daysOfIncubation >2 && main.daysOfIncubation < 4) {
            		main.trimesterNum = 1;
            	}
            	else if (main.daysOfIncubation >=4 && main.daysOfIncubation < 6) {
            		main.trimesterNum = 2;
            	}
            	else if (main.daysOfIncubation >=6 && main.daysOfIncubation < 8) {
            		main.trimesterNum = 3;
            	}
            	else if (main.daysOfIncubation == 8) {
        	    	main.people.add(main.genname());
        	    	main.peopleAGE.add(0);
        	    	int child = (int)(Math.random() * (1000 - 1 + 1) + 1);
        	    	if (child == 777) {
        	    		main.peopleTRD.add(18);
        	    	}
        	    	else if (child >= 950) {
        	    		main.peopleTRD.add(17);
        	    	}
        	    	else if (child < 950){
        	    		main.peopleTRD.add(16);
        	    	}
        	    	int trade = 0;
        	    	main.peopleSTY.add(100);
        	    	main.peopleINJ.add(0);
        	    	main.peopleDAY.add(0);
        	    	main.womb = false;
            		main.trimesterNum = -1;
            		main.daysOfIncubation = 0;
            	}
            }
            
            for (int i = 0; i < main.peopleDAY.size(); i++) {
            	main.peopleDAY.set(i, 365);
            	System.out.println(main.peopleDAY.get(i));
            	if (main.peopleDAY.get(i) == 365) {
            		main.peopleDAY.set(i, 1 + main.peopleAGE.get(i));
            		main.peopleDAY.set(i, 0);
            	}
            }
            
            for (int i = 0; i < main.peopleTRD.size(); i++) {
            	if (main.peopleAGE.get(i) >= 18) {
            		if (main.peopleTRD.get(i) == 16) {
                		main.peopleTRD.set(i, main.gentrade());
                		main.updateStats(main.peopleTRD.get(i));
                	}	
            		else if (main.peopleTRD.get(i) == 17) {
            			main.peopleTRD.set(i, main.gentrade());
                		main.updateStats(main.peopleTRD.get(i));
                	}
            		else if (main.peopleTRD.get(i) == 18) {
            			main.peopleTRD.set(i, main.gentrade());
                		main.updateStats(main.peopleTRD.get(i));
                		main.updateStats(main.peopleTRD.get(i));
                	}
            	}
            }
	    }
	    
	    public static void shipEvent() {
	    	
	    	
	    	
	    	int rnum = (int)(Math.random() * (1 - 5 + 1) + 5) -1;
	    	
	    	
	    	boolean chosen = false;
	    	switch (rnum) {
	    	case 1:
	    		if (main.AUtotal == 0) {
	    			shipEvent(20, 50, 70, 1, 10, 100, 500, 200, 300, 2, "a broken satelite");
		    	}
	    	case 2:
	    		if (main.AUtotal <= 2) {
	    			shipEvent(20, 10, 20, 1, 5, 100, 200, 100, 200, 1, "some space debris");
		    	}
	    	case 3:
	    		if (main.AUtotal >= 3 && main.AUtotal <= 40) {
	    			shipEvent(40, 50, 100, 10, 20, 100, 1000, 400, 500, 5, "the remains of a deep space probe");
	    		}
	    	case 4:
	    		if (main.AUtotal >= 2) {
	    			landEvent(50, 100000, 250000, 10, 20, 10, 100, 50, 150, 3, "an asteroid");
	    		}
	    	case 5:
	    		if (main.AUtotal >= 2) {
	    			landEvent(50, 100000, 250000, 10, 20, 2000, 10000, 20, 40, 4, "a comet");
	    		}
	    	case 6:
	    		if (main.AUtotal >= 6) {
	    			landEvent(100, 100000, 250000, 10, 20, 4000, 8000, 20, 40, 6, "a planet");
	    		}
	    		
	    	}
	    	
	    }
	    
	    public static void clearEvent() {
	    	test.event = false;
			test.eventYN = false;
			test.aObj = 0;
			ReadRunnable.event = false;
	    	PrintDistance.event = false;
			PrintDistance.transfer[0] = "";
			PrintDistance.transfer[1] = "";
			PrintDistance.transfer[2] = "";
			test.currentView = 2;
			KeyListen.menuSelect = 0;
			main.YN = 0;
	    }
	    
	    public static void shipEvent(int probability, int fRangeMin, int fRangeMax, int rRangeMin, int rRangeMax,  int fRangeMin2, int fRangeMax2, int rRangeMin2, int rRangeMax2, int OBJ, String approaching) {
	    	int rnum = (int)(Math.random() * (probability - 1 + 1) + 1);
    		if (rnum == (int)(Math.random() * (probability - 1 + 1) + 1)) {
    			ReadRunnable.event = true;
    			PrintDistance.event = true;
    			int rfuel = (int)(Math.random() * (fRangeMin - fRangeMax + 1) + fRangeMax);
    			int rRTG = (int)(Math.random() * (rRangeMin - rRangeMax + 1) + rRangeMax);
    			PrintDistance.transfer[0] = "We are approaching " + approaching + "!";
    			PrintDistance.transfer[1] = "Would you like to use " + rfuel + " gal of fuel to reach it,";
    			PrintDistance.transfer[2] = "and " + rRTG + "lb of radioactive mateiral to salvage it?";
    			test.event = true;
    			test.eventYN = true;
    			test.aObj = OBJ;
    			boolean chosen = false;
    			boolean initialized = false;
    			while (chosen == false) {
    				System.out.print("");
    				if (main.YN == 1) {
    					System.out.println(main.YN);
    					if (main.fuel >= rfuel && main.RTG >= rRTG) {
    						main.fuel -= rfuel;
    						main.RTG -= rRTG;
    						try {
								PrintDistance.transfer[0] = ("Receiving...");
								Thread.sleep((int)(Math.random() * (4000 - 2000 + 1) + 2000));
								PrintDistance.transfer[0] = ("Examining...");
								Thread.sleep((int)(Math.random() * (4000 - 2000 + 1) + 2000));
								PrintDistance.transfer[0] = ("Salvaging...");
								Thread.sleep((int)(Math.random() * (4000 - 2000 + 1) + 2000));
								PrintDistance.transfer[0] = ("Refining...");
								Thread.sleep((int)(Math.random() * (4000 - 2000 + 1) + 2000));
								PrintDistance.transfer[0] = ("Salvaged!");
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
    						
    						rfuel = (int)(Math.random() * (fRangeMin2 - fRangeMax2 + 1) + fRangeMax2);
    		    			rRTG = (int)(Math.random() * (rRangeMin2 - rRangeMax2 + 1) + rRangeMax2);
    		    			main.fuel += rfuel;
    						main.RTG += rRTG;
    						displayText = true;
    						PrintDistance.transfer[0] =  ("We recovered " + rfuel + " gal of fuel, and " + rRTG + " lb of RM!");
    						try {
								Thread.sleep(3000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
    						chosen = true;
    						clearEvent();
    						
    					}
    					
    					else {
    						chosen = true;
    						displayText = true;
    						PrintDistance.transfer[0] =  ("It seems that we cant make the trip...");
    						try {
								Thread.sleep(3000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
    						clearEvent();
    					}
    				}
    				else if (main.YN == 2) {
    					chosen = true;
    					System.out.println("\nOh, alright...");
						clearEvent();
    				}
    				else {
    					chosen = false;
    				}
    			}
    			
    		}
	    }
	    public static void landEvent(int probability, int fRangeMin, int fRangeMax, int rRangeMin, int rRangeMax,  int fRangeMin2, int fRangeMax2, int rRangeMin2, int rRangeMax2, int OBJ, String approaching) {
	    	System.out.println("Asteroid");
	    	int rnum = (int)(Math.random() * (probability - 1 + 1) + 1);
    		if (rnum == (int)(Math.random() * (probability - 1 + 1) + 1)) {
    			ReadRunnable.event = true;
    			PrintDistance.event = true;
    			int rfuel = (int)(Math.random() * (fRangeMin - fRangeMax + 1) + fRangeMax);
    			PrintDistance.transfer[0] = "We are approaching " + approaching + "!";
    			PrintDistance.transfer[1] = "Would you like to use " + rfuel + " gal of fuel to reach it?";
    			test.event = true;
    			test.eventYN = true;
    			test.aObj = OBJ;
    			System.out.println(test.aObj);
    			int rRTG = 0;
    			boolean chosen = false;
    			boolean initialized = false;
    			while (chosen == false) {
    				System.out.print("");
    				if (main.YN == 1) {
    					System.out.println(main.YN);
    					if (main.fuel >= rfuel) {
    						main.fuel -= rfuel;
    						landed = true;
    						test.currentView = 3;
    						while (landed == true) {
    							try {
    								if (mining == true) {
    									PrintDistance.transfer[0] =  "Mining...";
    								}
    								else {
    									PrintDistance.transfer[0] =  "Idling...";
    								}
									Thread.sleep(600);
									verifyLoop();
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								System.out.println("");
								if (OBJ == 3) {
									main.pressure+=0.5;
								}
								else if (OBJ == 4) {
									main.temperature++;
								}
								else if (OBJ == 6) {
									int rEvent = (int)(Math.random() * (300 - 1 + 1) + 1);
									if (rEvent == (int)(Math.random() * (101 - 200 + 1) + 200)){
										main.oxyGen = false;
									}
									else if (rEvent == (int)(Math.random() * (100 - 0 + 1) + 0)){
										main.nutritionGen = false;
									}
									else if (rEvent == (int)(Math.random() * (201 - 300 + 1) + 300)){
										main.hydrationGen = false;
									}
								}
								if (mining == true) {
									switch(OBJ) {
									case 3:
										main.RTG -= (int)(Math.random() * (10 - 20 + 1) + 20);
										rRTG = (int)(Math.random() * (30 - 40 + 1) + 40);
										main.RTG += rRTG;
										break;
									case 4:
										main.RTG -= (int)(Math.random() * (5 - 10 + 1) + 10);
										rfuel = (int)(Math.random() * (100 - 200 + 1) + 200);
										main.fuel += rfuel;
										break;
									case 6:
										main.RTG -= (int)(Math.random() * (20 - 30 + 1) + 30);
										rRTG = (int)(Math.random() * (30 - 40 + 1) + 40);
										rfuel = (int)(Math.random() * (100 - 200 + 1) + 200);
										main.RTG += rRTG;
										main.fuel += rfuel;
										break;
									}
								}
								else if (mining == false) {
									System.out.print("");
								}
								else {
									System.out.print("");
								}
							}
    						test.currentView = 2;
    						displayText = true;
    						chosen = true;
    						clearEvent();
    						
    					}
    					
    					else {
    						chosen = true;
    						displayText = true;
    						PrintDistance.transfer[0] =  ("It seems that we cant make the trip...");
    						try {
								Thread.sleep(3000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
    						clearEvent();
    					}
    				}
    				else if (main.YN == 2) {
    					chosen = true;
    					System.out.println("\nOh, alright...");
						clearEvent();
    				}
    				else {
    					chosen = false;
    				}
    			}
    			
    		}
	    }
	    
	}
	
	class crew implements Runnable {
		
		public static boolean gen = false;
		public static boolean event = false;
		
		public void run() {
			
			// initial exit event
			
			while(main.distanceAU > 0 && gen == true && main.isDead == false && main.isArrived == false) {
			try {
				
				// calling the person event every second (compared to a ship event every 3 seconds)
				
				ReadRunnable.eventInput = "placeholder";
				Thread.sleep(1000);
//				crewEvent();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
		}
		
		public static void initialCrewAction() {
			String[] crewInitialization = {"The crew has settled fine.", "The crew is terrified for the coming days... [STY--]", "The crew was praying. [FTH++]", "The crew calmed eachother down. [PTC++]"};
			int cirnum = (int)(Math.random() * (0 - (crewInitialization.length) + 1) + (crewInitialization.length));
			PrintDistance.transfer[0] = (crewInitialization[cirnum]);
			switch (cirnum) {
			case 1:
				for (int i = 0; i < main.people.size(); i++) {
					main.peopleSTY.set(i, -1 + main.peopleSTY.get(i));
				}
			case 2:
				main.faith++;
			case 3:
				main.politics++;
			}
			try {
				Thread.sleep(2000);
				PrintDistance.transfer[0] = "";
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static void crewEvent() {
			
			// person event
			
	    	int rnum = 1;
	    	boolean chosen = false;
	    	switch (rnum) {
	    	case 1:
	    		if (main.AUtotal == 0 && PrintDistance.event == false) {
		    		rnum = (int)(Math.random() * (1 - (100) + 1) + (100));
		    		if (rnum == (int)(Math.random() * (1 - (100) + 1) + (100))) {
		    			ReadRunnable.event = true;
		    			PrintDistance.event = true;
		    			crew.gen = false;
		    			crew.event = true;
		    			int person = (int)(Math.random() * (1 - (main.people.size()-1) + 1) + (main.people.size()-1));
		    			String[] options = {"medicate them", "reason with them", "isolate them", "encourage meditiation", "command them to calm down", "ignore"};
		    			System.out.println("\n" + main.people.get(person) + " is suddenly terrified...");
		    			System.out.println("This is a concern to everyone, who knows how this will affect morale? What will you do?\n");
		    			for (int i = 0; i < options.length; i ++) {
		    				System.out.println("[" + (i + 1) + "]" + options[i]);
		    			}
		    			rnum = (int)(Math.random() * (1 - options.length-1 + 1) + options.length-1) + 1;
		    			String answerString = ReadRunnable.eventInput;
	    				int answer = Character.getNumericValue(answerString.charAt(0));
		    			while (chosen == false) {
		    				if (answer > 0 && answer < options.length+1) {
		    					if (answer == rnum) {
		    					System.out.println("That worked! Peace was restored. [Poilitics++]");
		    					main.politics++;
		    					chosen = true;
	    						ReadRunnable.event = false;
	    						PrintDistance.event = false;
	    						crew.event = false;
	    						crew.gen = true;
	    						rnum = -1;
		    					}
		    					else if (answer == 6) {
			    					System.out.println("Ignoring them certaintly did not work... [Sanity--][Sanity--]");
			    					main.peopleSTY.set(person, -2+main.peopleSTY.get(person));
			    					chosen = true;
		    						ReadRunnable.event = false;
		    						PrintDistance.event = false;
		    						crew.event = false;
		    						crew.gen = true;
		    						rnum = -1;
			    					}
		    					else {
		    						System.out.println("That seems to have been the wrong choice... [Sanity--]");
		    						main.peopleSTY.set(person, -1+main.peopleSTY.get(person));
		    						chosen = true;
		    						ReadRunnable.event = false;
		    						PrintDistance.event = false;
		    						crew.event = false;
		    						crew.gen = true;
		    						rnum = -1;
		    					}
		    				}
		    					
		    				else {
		    					answerString = ReadRunnable.eventInput;
			    				answer = Character.getNumericValue(answerString.charAt(0));
		    				}
		    			}
		    			
		    		}
		    	}
	    	
	    	}
		}
	}

//	
