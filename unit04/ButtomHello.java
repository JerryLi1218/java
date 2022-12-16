package unit04;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.*;
import javafx.scene.*;
//import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ButtomHello extends Application{
	//定义字体样式：粗体、斜体、粗体且斜体
    Font fontNormal = Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR,16);
    Font fontBold = Font.font("Times New Roman",FontWeight.BOLD,FontPosture.REGULAR,16);
    Font fontItalic = Font.font("Times New Roman",FontWeight.NORMAL,FontPosture.ITALIC,16);
    Font fontBoldItalic = Font.font("Times New Roman",FontWeight.BOLD,FontPosture.ITALIC,16);

    //定义多选按钮
    CheckBox chkBold = new CheckBox("粗体");
    CheckBox chkItalic = new CheckBox("斜体");

    //定义单选按钮
    RadioButton red = new RadioButton("红色");
    RadioButton green = new RadioButton("绿色");
    RadioButton blue = new RadioButton("蓝色");

    //定义文本
    Text text = new Text("I Love JavaFX");
    
	public static void main(String[] args) {launch(args);}

	 @Override
	    public void start(Stage primaryStage) throws Exception {
	        //定义单列面板，且其中的组件间距为20像素
	        VBox vBoxLeft = new VBox(20);
	        //设置单列面板的边界颜色为绿色
	        vBoxLeft.setStyle("-fx-border-color:green");
	        vBoxLeft.getChildren().addAll(chkBold,chkItalic);
	        //定义单选按钮组
	        ToggleGroup toggleGroup = new ToggleGroup();
	        //将单选按钮统一共同的按钮组
	        red.setToggleGroup(toggleGroup);
	        green.setToggleGroup(toggleGroup);
	        blue.setToggleGroup(toggleGroup);
	        VBox vBoxRight = new VBox();
	        vBoxRight.setStyle("-fx-border-color:blue");
	        vBoxRight.getChildren().addAll(red,green,blue);
	        //边界面板添加组件
	        BorderPane borderPane = new BorderPane();
	        borderPane.setLeft(vBoxLeft);
	        borderPane.setCenter(text);
	        borderPane.setRight(vBoxRight);
	        //创建监听对象
	        ChangeStyle changeStyle = new ChangeStyle();
	        //事件监听
	        red.setOnAction(changeStyle);
	        green.setOnAction(changeStyle);
	        blue.setOnAction(changeStyle);
	        chkBold.setOnAction(changeStyle);
	        chkItalic.setOnAction(changeStyle);
	        Scene scene = new Scene(borderPane,300,200);
	        primaryStage.setTitle("复选框与单选框");
	        primaryStage.setScene(scene);
	        primaryStage.show();
	    }

	
	class ChangeStyle implements EventHandler<ActionEvent> {

	    @Override
	    public void handle(ActionEvent event) {
			//改变字体颜色
	        if(red.isSelected()){
	            text.setFill(Color.RED);
	        }
	        if(green.isSelected()){
	            text.setFill(Color.GREEN);
	        }
	        if(blue.isSelected()){
	            text.setFill(Color.BLUE);
	        }
	            
	        //改变字体粗体、斜体等属性
	        if(chkBold.isSelected() && chkItalic.isSelected()){
	            text.setFont(fontBoldItalic);
	        }
	        else if (chkItalic.isSelected()){
	            text.setFont(fontItalic);
	        }
	        else if (chkBold.isSelected()){
	            text.setFont(fontBold);
	        }
	        else{
	            text.setFont(fontNormal);
	        }
	    }
	}


}

