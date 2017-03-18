/**
 * 
 */
package application.users;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXButton;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import tools.InfoTool;

/**
 * @author GOXR3PLUS
 *
 */
public class UserMode extends BorderPane {

    @FXML
    private ImageView userImageView;

    @FXML
    private Label userNameLabel;

    @FXML
    private JFXButton goBack;

    // ----------------------

    /** The logger. */
    private Logger logger = Logger.getLogger(getClass().getName());

    User user;

    /**
     * Constructor.
     */
    public UserMode() {
	
	// ------------------------------------FXMLLOADER ----------------------------------------
	FXMLLoader loader = new FXMLLoader(getClass().getResource(InfoTool.fxmls + "UserMode.fxml"));
	loader.setController(this);
	loader.setRoot(this);

	try {
	    loader.load();
	} catch (IOException ex) {
	    logger.log(Level.WARNING, "", ex);
	}
    }

    /**
     * Called as soon as .fxml is initialized
     */
    @FXML
    private void initialize() {	

	//goBack
	goBack.setOnAction(a -> Main.sideBar.goMainMode());
    }
    
    /**This method should be called after fxml has been initialized for this controller
     * @param user
     */
    public void setUser(User user) {
	this.user = user;
	
	//-----UserNameLabel
		userNameLabel.textProperty().bind(user.nameField.textProperty());
    }

}