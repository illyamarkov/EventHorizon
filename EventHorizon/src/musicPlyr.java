

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Soundbank;
import javax.sound.midi.Synthesizer;

public class musicPlyr {

    private static final String APP_TITLE = "Keyboard Piano";

    public static Synthesizer synthesizer;
    public static MidiChannel[] midiChannels;
    private final Instrument[] instruments;
    private int instrumentIndex = 0;
    public static int differentSound = -1;

    
    // initiating synthesizer, and MIDI channels to the default Soundbank
    
    musicPlyr() {
        try {
            synthesizer = MidiSystem.getSynthesizer();
            synthesizer.open();
        } catch (MidiUnavailableException ex) {
            ex.printStackTrace();
            System.exit(1);
        }   

        this.midiChannels = synthesizer.getChannels();

        Soundbank bank = synthesizer.getDefaultSoundbank();

        synthesizer.loadAllInstruments(bank);


        this.instruments = synthesizer.getAvailableInstruments();
        synthesizer.loadAllInstruments(synthesizer.getDefaultSoundbank());
        synthesizer.getChannels()[0].programChange(instrumentIndex);

        System.out.println("[STATE] MIDI channels: " + midiChannels.length);
        System.out.println("[STATE] Instruments: " + instruments.length);
    }

    public static void main(String[] args) {
    	
    	// initializing music loop
    	
    	musicPlyr musicLoop = new musicPlyr();
        
        for (int i = 0; i<100; i++) {
        	playSong1();
        }
    }
    
    public static void playSong1() {
    	
    	// picking random note and scale, and playing it for 2 seconds
    	
    	int[] noteNumber = {40, 42, 44, 46, 41, 43, 45, 47};
    	int note = (int) (Math.random() * (noteNumber.length-1 - 0 + 1) + 0); 
    	while (differentSound == note) {
    		note = (int) (Math.random() * (noteNumber.length-1 - 0 + 1) + 0); 
//    		System.out.println(note);
    	}
    	synthesizer.getChannels()[0].programChange(60);
    	midiChannels[0].noteOn(noteNumber[note], 60);
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	// playing a quick note sequence
    	
    	synthesizer.getChannels()[1].programChange(52);
    	int[] notePitch = {60, 62, 64, 66, 68, 70};
		int rchance = (int) (Math.random() * (5 - 1 + 1) + 1);
		int rsfx = 0;
    	try {
    		if (rchance ==  ((int) (Math.random() * (5 - 1 + 1) + 1))) {
    			rsfx = (int) (Math.random() * (5 - 1 + 1) + 1);
	    		for (int i = 0; i < rsfx; i++) {
	    			int rpitch = (int) (Math.random() * (notePitch.length-1 - 0 + 1) + 0);
	    			midiChannels[0].noteOn(notePitch[rpitch], 45);
	        		Thread.sleep(100);
	        		midiChannels[0].noteOn(notePitch[rpitch], -1);
	    		}
    		}
			Thread.sleep(1000 - 100*rsfx);
			midiChannels[0].noteOn(notePitch[(int) (Math.random() * (notePitch.length-1 - 0 + 1) + 0)], -1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	midiChannels[0].noteOn(noteNumber[note], -1);
    	differentSound = note;
//    	System.out.println(differentSound);
    }
}