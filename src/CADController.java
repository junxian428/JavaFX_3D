import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;

public class CADController  implements Initializable {
    @FXML private Group my3DGroup;

    @FXML private SubScene viewSub;

    @FXML private PerspectiveCamera camera;

    @FXML private Box myBox;

    @FXML private Label Label3DProperties;
    
    @FXML private Button CreateBox;

    @FXML private VBox myScene;
    
    @FXML private TextField lengthparameterinput,heightparameterinput,depthparameterinput;
    //public void initialize(URL url, ResourceBundle rb) {
    private Image cursorImage;

    private double mousePosX, mousePosY;
    private double mouseOldX, mouseOldY;
    private final double rotateSpeed = 0.2;
    private final double zoomSpeed = 0.5;
    private final double panSpeed = 0.3;

    //}

    @Override
    public void initialize(java.net.URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        //my3DGroup(viewSub);
        //myBox = new Box(100, 100, 100);
        PhongMaterial material = new PhongMaterial();
        //Rotate rotateX = new Rotate(45, Rotate.X_AXIS);
        //Rotate rotateY = new Rotate(45, Rotate.Y_AXIS);
        //myBox.getTransforms().addAll(rotateX, rotateY);
        material.setDiffuseColor(Color.RED);
        myBox.setMaterial(material);
        my3DGroup.getChildren().add(myBox);
        //EventHandler<MouseEvent> mouseClickHandler = (EventHandler<MouseEvent>) myBox.getOnMouseClicked();
        //System.out.println("Current mouse click handler: " + mouseClickHandler);

        
        //PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setNearClip(0.1);
        camera.setFarClip(100.0);
        //camera.setTranslateZ(-1000);
        //camera.setTranslateY(-100);
        //camera.setTranslateX(-200);
        //camera.setTranslateY(100);
        //camera.setTranslateZ(-800);
        //my3DGroup.getScene().setCamera(camera);
        //throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }

    @FXML
    private void handleMousePressed(MouseEvent me) {
        mousePosX = me.getSceneX();
        mousePosY = me.getSceneY();
        mouseOldX = me.getSceneX();
        mouseOldY = me.getSceneY();
    }

    @FXML
    private void handleMouseDragged(MouseEvent me) {
        // Calculate mouse delta
        double deltaX = (mousePosX - me.getSceneX());
        double deltaY = (mousePosY - me.getSceneY());

        // Store new mouse position
        mousePosX = me.getSceneX();
        mousePosY = me.getSceneY();

        // Get the box
        //Box box = (Box) my3DGroup.getChildren().get(0);

        // Rotate the box based on mouse delta
        myBox.setRotate(myBox.getRotate() - deltaX * rotateSpeed);

        // Pan the box based on mouse delta
        myBox.setTranslateX(myBox.getTranslateX() - deltaX * panSpeed);
        myBox.setTranslateY(myBox.getTranslateY() + deltaY * panSpeed);
    }


    @FXML
    private void handleMouseReleased(MouseEvent me) {
        // No-op
    }

    @FXML
    public void ShapeClick(){
        //System.out.println("It is clicked ");
        //System.out.println(myBox.getWidth());
        //System.out.println(myBox.getHeight());
        //System.out.println(myBox.getDepth());
        lengthparameterinput.setText(Double.toString(myBox.getWidth()));
        heightparameterinput.setText(Double.toString(myBox.getHeight()));
        depthparameterinput.setText(Double.toString(myBox.getDepth()));

    }

    @FXML
    public void AdjustLength(ActionEvent event){
        myBox.setWidth(Double.parseDouble(lengthparameterinput.getText()));
        System.out.println(lengthparameterinput.getText());
        
    }

    @FXML
    public void CreateBox(ActionEvent event){
        System.out.println("Create Box");
        cursorImage = new Image("Image/box.jpg");
        //myScene.setCursor(javafx.scene.Cursor.DEFAULT);
        //myScene.setCursor(new Cursor(cursorImage, cursorImage.getWidth() / 2, cursorImage.getHeight() / 2));
    }

    @FXML
    public void AdjustHeight(ActionEvent event){
        myBox.setHeight(Double.parseDouble(heightparameterinput.getText()));
        System.out.println(heightparameterinput.getText());
        
    }

    @FXML
    public void AdjustDepth(ActionEvent event){
        myBox.setDepth(Double.parseDouble(depthparameterinput.getText()));
        System.out.println(depthparameterinput.getText());
        
    }

  
}
