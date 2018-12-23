import java.io.Serializable;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;


public class DataStorage implements Serializable{

    private Map[] map;
    private SoundEffect[] soundEffect;
    private Tutorial tutorial;
    private Charts chart;
    private Skin[] skins;
    //private Color chosenColor;
    private String chosenColor;

    public DataStorage() {
        map = new Map[15];
        map[0] = new Map(6,3,5);
        map[1] = new Map(8,3,7);
        map[2] = new Map(10,3,9);
        /*
        //==========================SOUND EFFECTS=======================================
        soundEffect = new SoundEffect[2];
        File soundFolder = new File("/Users/Desktop/soundFolder/");   //update the path
        File[] listOfFiles = soundFolder.listFiles();

        for (File file : listOfFiles) {
            int i = 0;
            if (file.isFile()) {
                soundEffect[i] = new SoundEffect(file.getPath(), 50);
            }
            i++;
        }

        //==========================TUTORIAL============================================
        String tutorialLoc = "./ / / / ";  //path to the directory where tutorial is saved
        tutorial = new Tutorial(tutorialLoc, ".jpg");

        //==========================SKINS===============================================
        skins = new Skin[5];
        File skinFolder = new File("/Users/Desktop/skinFolder/");   //update the path
        listOfFiles = skinFolder.listFiles();

        for (File file : listOfFiles) {
            int i = 0;
            BufferedImage image = null;
            try {
                image = ImageIO.read(new File(file.getPath()));
            } catch( Exception e) {}

            if (file.isFile()) {
                skins[i] = new Skin(i, image, true);
            }
            i++;
        }
        */
        //===========================CHOSEN COLOR=======================================
        chosenColor = "LIGHT_GRAY";
    }
    //returns maps
    public Map[] getMaps(){
        return map;
    }

    public Map getMap(int dimension) {
        if (dimension == 6){
            return map[0];
        }
        else if (dimension == 8){
            return map[1];
        }
        if (dimension == 10){
            return map[2];
        } else {
            return map[0];
        }
        
    }
    //returns soundEffect
    public SoundEffect[] getSoundEffects(){
        return soundEffect;
    }

    //return tutorial file
    public Tutorial getTutorial(){
        return tutorial;
    }

    //return chart
    public Charts getCharts(){
        return chart;
    }

    //return skins
    public Skin[] getSkins(){
        return skins;
    }

    // return chosenColor, default at first
    public String getChosenColor(){
        return chosenColor;
    }

}
