package com.feint.fx.controller

import com.feint.fx.utils.QrUtil
import com.jfoenix.controls.JFXButton
import com.jfoenix.controls.JFXSnackbar
import com.jfoenix.controls.JFXTextField
import javafx.embed.swing.SwingFXUtils
import javafx.fxml.FXML
import javafx.scene.image.ImageView
import javafx.scene.image.WritableImage
import javafx.scene.layout.VBox
import javafx.stage.FileChooser
import javafx.stage.Stage

import javax.imageio.ImageIO


class MainController{
    @FXML
    lateinit var mainRoot:VBox

    @FXML
    lateinit var creatorBtn:JFXButton

    @FXML
    lateinit var saveBtn:JFXButton

    @FXML
    lateinit var infoField:JFXTextField

    @FXML
    lateinit var qrImage:ImageView

    private var hasImage=false

    @FXML
    fun create(){
        if (infoField.text.isEmpty()) return
        val bufImage=QrUtil.createQR(infoField.text)
        val writeAbleImage=WritableImage(bufImage!!.width,bufImage.height)
        qrImage.image=SwingFXUtils.toFXImage(bufImage,writeAbleImage)
        hasImage=true
    }

    @FXML
    fun save(){
        if(!hasImage) return

        val fileChooser=FileChooser()
        fileChooser.title="save Image"
        fileChooser.initialFileName="qrcode.png"
        val file= fileChooser.showSaveDialog(Stage()) ?: return

        ImageIO.write(SwingFXUtils.fromFXImage(qrImage.image,null),"png",file)

        JFXSnackbar(mainRoot).show("Save  to ${file.absolutePath}",3000)

    }
}