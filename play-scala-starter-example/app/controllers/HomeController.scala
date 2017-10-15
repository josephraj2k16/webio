package controllers

import javax.inject._
import play.api.mvc._
import models.First
import models.First1
import models.Define
import javax.imageio.ImageIO
import java.io.IOException;
import com.github.sarxos.webcam._
import java.io.File
import play.libs._
import play.api.libs.concurrent.Execution.Implicits._
import scala.concurrent.duration._
import play.api.data._
import play.api.data.Forms._



/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) with play.api.i18n.I18nSupport {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */

  def index = Action {
    //Play.application().classloader().getResource("main1.txt");
    Ok(views.html.index("Your new application is ready."))
  }
  
  
  def about(name:String) = Action {
     Ok(views.html.index(name))
  }
 /* def person = Action  {
    var se= new First
    var t:Set[String] = se.fun
    Ok(views.html.welcome(t))
    
  }*/
  
  val hello = Form(
      "name" -> text
  )
  
  
  def index1 = Action{
    Redirect(routes.HomeController.sayHello)
  }
  
  
   def sayHello = Action { implicit request =>
   
     val in =  hello.bindFromRequest
   in.fold(
                errors => { 
                  BadRequest(views.html.main(errors))
                },
                name => {
                  
                                       
                       // Webcam.setAutoOpenMode(true);
                        val webcam = Webcam.getDefault 
                  	    if (webcam != null) {
                            	  println("Webcam: " + webcam.getName)
                            	  webcam.open()
                  	    }
                       else {
                      	        println("No webcam detected")        
                       }
                       ImageIO.write(webcam.getImage(), "PNG",new File("D:/folder1/"+name+".png"))
                       var e1 = new Define(name)
                       var rr = e1.scan
                        e1.camExit
                       if (rr ==0){
                         Ok(views.html.welcome("Hello " +name+ " You already came"))
                       }else{
                       Ok(views.html.welcome("Hello " +name+ " your face is different "))
                       }
                      
                })
  }
  

  
  /*def camera = Action {
    val m = new First1
    var r = m.cam
    Ok(views.html.welcome(r))
    
  }*/
  def cap = Action {
     var e = Webcam.getDefault
     e.open()
     ImageIO.write(e.getImage(), "PNG",new File("D:/folder1/1.png"))
     val x="Image captured from Webcam"
     Ok(views.html.welcome(x))
  }
  
  def cap1 = Action{
    //NativeLoader.load("facesdk1")
   // val lines = scala.io.Source.fromFile("main1.txt").mkString
    //System.loadLibrary("facesdk")
    //var e1 = new Define
    Ok(views.html.index(" sdf"))
    
    
  }

}
