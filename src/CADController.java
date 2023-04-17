import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.SubScene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

public class CADController  implements Initializable {
    @FXML private Group my3DGroup;

    @FXML private SubScene viewSub;

    @FXML private PerspectiveCamera camera;

    @FXML private Box myBox;

    @FXML private Label Label3DProperties;
    
    @FXML private TextField lengthparameterinput,heightparameterinput,depthparameterinput;
    //public void initialize(URL url, ResourceBundle rb) {
        
    //}

    @Override
    public void initialize(java.net.URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        //my3DGroup(viewSub);
        //myBox = new Box(100, 100, 100);
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.RED);
        myBox.setMaterial(material);
        my3DGroup.getChildren().add(myBox);
        //EventHandler<MouseEvent> mouseClickHandler = (EventHandler<MouseEvent>) myBox.getOnMouseClicked();
        //System.out.println("Current mouse click handler: " + mouseClickHandler);

        
        //PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setNearClip(0.1);
        camera.setFarClip(100.0);
        camera.setTranslateZ(-1000);
        camera.setTranslateY(-100);

        //my3DGroup.getScene().setCamera(camera);
        //throw new UnsupportedOperationException("Unimplemented method 'initialize'");
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
