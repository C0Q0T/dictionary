package feature;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class TextToSpeech {

    public void makeSound(String text) {
        Voice[] voices;
        VoiceManager vm;
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");

        vm = VoiceManager.getInstance();

        voices = vm.getVoices();
        Voice voice = vm.getVoice("kevin");
        voice.allocate();
        voice.speak(text);
        voice.deallocate();

    }
}
