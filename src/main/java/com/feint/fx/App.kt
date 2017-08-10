package com.feint.fx

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

class App:Application(){
    override fun start(primaryStage: Stage?) {
        val root:Parent=FXMLLoader.load<Parent>(javaClass.classLoader.getResource("main.fxml"))
        primaryStage!!.title="二维码生成器"
        val scene=Scene(root,600.0,400.0)
        primaryStage.scene=scene
        //scene.stylesheets.add(javaClass.classLoader.getResource("main.css").toExternalForm())
        primaryStage.show()
    }

}

fun main(args: Array<String>) {
    Application.launch(App::class.java,*args)
}