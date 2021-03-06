import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.geometry.*;
import javafx.scene.text.*;
import javafx.scene.input.MouseEvent;

public class Settings extends Pane {
    //Constants
    private final String SOUND_ICON = "/img/soundIcon.png";
    private final String SOUND_BAR_ICON = "/img/sound.png";
    private final String BACK_ICON = "/img/backIcon.png";
    private final String THEMES_ICON = "/img/themesIcon.png";
    private final String TIMER_ICON = "/img/timerIcon.png";
    private final String TIMER_BUTTON_ICON = "/img/toggleON.png";
    private final String TIMER_BUTTON_ICON_OFF = "/img/toggleOFF.png";
    private final String COPYRIGHT_LABEL = "Developed by Royal Flush";
    private final double WIDTH  = 1080;
    private final double HEIGHT = 720;
    private final double COPYRIGHT_PANEL_SIZE = 60;
    private final int ICON_SIZE = 64;

    //Variables
    private String[] colorButtonIcon;

    //Labels
    private Label copyRightLabel;
    private Pane copyRightPanel;
    private Label version;

    //Buttons
    private Button backButton;

    //Images
    private ImageView backImage;
    private ImageView timerButtonImage;
    private ToggleButton timerButton;

    private VBox center;
    private ImageView timer;
    private boolean toogler;
    private Slider slider;
    private Button buttons[];
    private int currentSelectedThemeIndex;

    public Settings() {
        super();
        slider = new Slider();
        slider.setValue(40);
        currentSelectedThemeIndex = -1;
        toogler = false;
        initialize(toogler);
    }

    public void initialize(boolean togle){
        getChildren().removeAll();
        //Creating middle panel
        this.setMinHeight(HEIGHT - COPYRIGHT_PANEL_SIZE);
        this.setMinWidth(WIDTH);

        //Creating copyright panel
        copyRightPanel = new Pane();

        //Copyright label
        copyRightLabel = new Label(COPYRIGHT_LABEL);

        //Version label
        version = new Label("Version b0.1");

        //Back button
        backImage = new ImageView(BACK_ICON);
        backImage.setFitWidth(ICON_SIZE);
        backImage.setFitHeight(ICON_SIZE);
        backButton = new Button();
        backButton.setGraphic(backImage);
        backButton.setStyle("-fx-background-color: transparent");
        backButton.setMinSize(ICON_SIZE, ICON_SIZE);
        backButton.setLayoutX(25);
        backButton.setLayoutY(25);

        Label settings = new Label("");
        settings.setStyle("-fx-font-weight: bold;");
        ImageView labelImage = new ImageView("/img/settings_label.png");
        labelImage.setFitWidth(400);
        labelImage.setFitHeight(60);

        settings.setGraphic(labelImage);
        settings.setMaxSize(450,75);
        settings.setFont(new Font("Verdana", 45));
        settings.setLayoutX(335);
        settings.setLayoutY(50);

        VBox left = new VBox(100);
        left.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-radius: 50px 0 0px 50px;");
        left.setPadding(new Insets(10, 50, 50, 40));
        left.setLayoutX(20);
        left.setLayoutY(150);
        left.setMinHeight(2*HEIGHT/3);
        left.setMinWidth(WIDTH/3 - 25);
        left.setMaxHeight(2*HEIGHT/3);
        left.setMaxWidth(WIDTH/3 - 25);

        ImageView soundIcon = new ImageView(new Image(SOUND_ICON));
        soundIcon.setFitWidth(WIDTH/3 - 150);
        soundIcon.setFitHeight(2*HEIGHT/3 - 200);
        soundIcon.setLayoutX(256);
        soundIcon.setFitWidth(256);

        HBox h = new HBox();
        ImageView sound = new ImageView(new Image(SOUND_BAR_ICON));
        soundIcon.setFitWidth(WIDTH/3 - 150);
        soundIcon.setFitHeight(2*HEIGHT/3 - 200);
        soundIcon.setFitHeight(32);
        soundIcon.setFitWidth(32);

        ImageView soundBarIcon = new ImageView(new Image(SOUND_ICON));
        soundIcon.setFitWidth(WIDTH/3 - 150);
        soundIcon.setFitHeight(2*HEIGHT/3 - 200);
        soundIcon.setFitHeight(256);
        soundIcon.setFitWidth(256);

        slider.setMin(0);
        slider.setMax(100);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(50);
        slider.setMinorTickCount(5);
        slider.setBlockIncrement(10);
        slider.setMinWidth(234);
        slider.setLayoutY(75);
        h.getChildren().addAll(sound, slider);
        left.getChildren().addAll(soundIcon, h);

        center = new VBox(65);
        center.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        center.setPadding(new Insets(10, 50, 50, 50));
        center.setLayoutX(10 + WIDTH/3);
        center.setLayoutY(150);
        center.setMinHeight(2*HEIGHT/3);
        center.setMinWidth(WIDTH/3 -25);
        center.setMaxHeight(2*HEIGHT/3);
        center.setMaxWidth(WIDTH/3 - 25);

        timer = new ImageView(new Image(TIMER_ICON));
        timer.setFitWidth(WIDTH/3 - 150);
        timer.setFitHeight(2*HEIGHT/3 - 200);
        timer.setFitHeight(256);
        timer.setFitWidth(256);

        if (togle){
            timerButtonImage = new ImageView(new Image(TIMER_BUTTON_ICON_OFF));
        }else{
            timerButtonImage = new ImageView(new Image(TIMER_BUTTON_ICON));

        }
        //Image timerButtonImage = new Image(getClass().getResourceAsStream(TIMER_BUTTON_ICON));
        //timerButtonImage.setFitHeight(96);
        //timerButtonImage.setFitWidth(128);

        timerButton = new ToggleButton();
        timerButton.setGraphic(timerButtonImage);
        timerButton.setStyle("-fx-background-color: transparent");
        timerButton.setMinSize(ICON_SIZE, ICON_SIZE);
        center.setAlignment(Pos.CENTER);
        center.getChildren().addAll(timer, timerButton);


        VBox right = new VBox(new Label());
        right.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-border-radius: 0px 50 50px 0px;");
        right.setPadding(new Insets(0, 50, 50, 40));
        right.setLayoutX(2*WIDTH/3);
        right.setLayoutY(150);
        right.setMinHeight(2*HEIGHT/3);
        right.setMinWidth(WIDTH/3 -25);
        right.setMaxHeight(2*HEIGHT/3);
        right.setMaxWidth(WIDTH/3 - 25);

        ImageView themes = new ImageView(new Image(THEMES_ICON));
        //themes.setLayoutY(500);
        themes.setFitWidth(WIDTH/3 - 150);
        themes.setFitHeight(2*HEIGHT/3 - 200);
        themes.setFitHeight(256);
        themes.setFitWidth(256);

        colorButtonIcon = new String[6];
        colorButtonIcon = getColorButtons();
        int space = 50;
        buttons = new Button[6];
        for ( int i = 0; i < 6; i++) {
            space = space + 80;
            buttons[i] = new Button();
            buttons[i].setMaxSize(ICON_SIZE - 32, ICON_SIZE - 32);
            if (i <= 2) {
                buttons[i].setLayoutX(650 + space);
                buttons[i].setLayoutY(450);

            }else if ( i == 3){
                space = 130;
                buttons[i].setLayoutX(650 + space);
                buttons[i].setLayoutY(525);
            }else if ( i == 4){
                buttons[i].setLayoutX(650 + space);
                buttons[i].setLayoutY(525);
            }else if ( i == 5){
                buttons[i].setLayoutX(650 + space);
                buttons[i].setLayoutY(525);
            }
            buttons[i].setStyle("-fx-background-color: transparent");
        }

        ImageView circle = new ImageView(new Image(colorButtonIcon[0]));
        circle.setFitHeight(48);
        circle.setFitWidth(48);
        buttons[0].setGraphic(circle);

        ImageView blueCircle = new ImageView(new Image(colorButtonIcon[1]));
        blueCircle.setFitHeight(48);
        blueCircle.setFitWidth(48);
        buttons[1].setGraphic(blueCircle);

        ImageView greenCircle = new ImageView(new Image(colorButtonIcon[2]));
        greenCircle.setFitHeight(48);
        greenCircle.setFitWidth(48);
        buttons[2].setGraphic(greenCircle);

        ImageView lilacCircle = new ImageView(new Image(colorButtonIcon[3]));
        lilacCircle.setFitHeight(48);
        lilacCircle.setFitWidth(48);
        buttons[3].setGraphic(lilacCircle);

        ImageView pinkCircle = new ImageView(new Image(colorButtonIcon[4]));
        pinkCircle.setFitHeight(48);
        pinkCircle.setFitWidth(48);
        buttons[4].setGraphic(pinkCircle);

        ImageView colorBlinkCircle = new ImageView(new Image(colorButtonIcon[5]));
        colorBlinkCircle.setFitHeight(48);
        colorBlinkCircle.setFitWidth(48);
        buttons[5].setGraphic(colorBlinkCircle);

        right.getChildren().addAll(themes);

        addAnimation(10);

        this.getChildren().addAll(settings,backButton,left,center,right, buttons[0], buttons[1], buttons[2], buttons[3], buttons[4], buttons[5]);

        //Adding labels to panel
        copyRightPanel.getChildren().add(copyRightLabel);
        copyRightPanel.getChildren().add(version);

        //Default theme
        //setCurrentColor(null);
    }

    public void addHandler( GameManager.ButtonListener e) {
      backButton.addEventHandler(MouseEvent.MOUSE_CLICKED, e);

      GameManager.ButtonListener timerMode = e.clone();
      timerMode.setIndex(30);
      timerButton.addEventHandler(MouseEvent.MOUSE_CLICKED, timerMode);

      GameManager.ButtonListener soundSlider = e.clone();
      soundSlider.setIndex(32);
      slider.addEventHandler(MouseEvent.MOUSE_CLICKED, soundSlider);

      GameManager.ButtonListener themesListeners[];
      themesListeners = new GameManager.ButtonListener[buttons.length];
      for (int i = 0; i < buttons.length; i++){
          themesListeners[i] = e.clone();
          themesListeners[i].setIndex(33+i);
          buttons[i].addEventHandler(MouseEvent.MOUSE_CLICKED, themesListeners[i]);
      }

    }

    public double getSliderVolume(){
         return slider.getValue();
    }

    private String[] getColorButtons(){
        resetColorButtons();
        if (currentSelectedThemeIndex < 0 ){
            return colorButtonIcon;
        }
        String selectedTheme = "";
        switch(currentSelectedThemeIndex) {
            case -1:
                break;
            case 0 :
                selectedTheme = "/img/chosenYellow.png";
                break;
            case 1 :
                selectedTheme = "/img/chosenBlue.png";
                break; 
            case 2 :
                selectedTheme = "/img/chosenGreen.png";
                break; 
            case 3 :
                selectedTheme = "/img/chosenLilac.png";
                break; 
            case 4 :
                selectedTheme = "/img/chosenPink.png";
                break;
            case 5 :
                selectedTheme = "/img/colorblindTheme.png";
                break;

            // You can have any number of case statements.
            default : // Optional
                selectedTheme = "/img/circle.png";
                break;
        }
        if (currentSelectedThemeIndex > -1){
            colorButtonIcon[currentSelectedThemeIndex] = selectedTheme;
            System.out.println(colorButtonIcon[currentSelectedThemeIndex]);
        }
        return colorButtonIcon;
    }

    public void resetColorButtons(){
        colorButtonIcon[0] = "/img/circle.png";
        colorButtonIcon[1] = "/img/blueCircle.png";
        colorButtonIcon[2] = "/img/greenCircle.png";
        colorButtonIcon[3] = "/img/lilacCircle.png";
        colorButtonIcon[4] = "/img/pinkCircle.png";
        colorButtonIcon[5] = "/img/colorblindTheme.png";
    }

    public void setSelectedTheme(int valueIndex){
        currentSelectedThemeIndex = valueIndex;
    }

    public void toogleTimer(){
        toogler = !toogler;
        initialize(toogler);
    
    }
    public void addAnimation(int factor) {
        backButton.setOnMouseEntered(new GameManager.Animation(backButton, factor, true));
        backButton.setOnMouseExited(new GameManager.Animation(backButton, factor, false));
    }

    public boolean isTimerToogleOn(){
        return toogler;
    }
}
