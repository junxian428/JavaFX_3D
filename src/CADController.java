import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.SubScene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

public class CADController  implements Initializable {
    @FXML private Group my3DGroup;

    @FXML private SubScene viewSub;

    @FXML private PerspectiveCamera camera;

    @FXML private Box myBox;
    
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
        
        //PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setNearClip(0.1);
        camera.setFarClip(100.0);
        camera.setTranslateZ(-1000);
        camera.setTranslateY(-100);

        //my3DGroup.getScene().setCamera(camera);
        //throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }
}
