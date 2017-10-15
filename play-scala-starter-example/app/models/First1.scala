package models
import javax.imageio.ImageIO
import com.github.sarxos.webcam._
import java.io.File
class First1 {
     
  def cam:String={
      val webcam = Webcam.getDefault() 
	    if (webcam != null) {
	    println("Webcam: " + webcam.getName())
	    var x=webcam.getName
			webcam.open()
			//ImageIO.write(webcam.getImage(), "PNG",new File("D:/folder1/hh"+".png"))
			x
	    } 
	    else {
	        println("No webcam detected");
	        val x1= "failure"
	        x1
	    }}
 
}