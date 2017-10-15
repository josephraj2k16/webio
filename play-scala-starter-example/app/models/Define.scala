package models

import Luxand._
import Luxand.FSDK._
import Luxand.FSDKCam._

import java.io.File
import java.util.Scanner
import javax.imageio.ImageIO
import java.util.Calendar
import java.util.Date
import java.nio.file.attribute.BasicFileAttributes
import java.nio.file.Files
import java.nio.file.LinkOption.NOFOLLOW_LINKS
import java.nio.file.Path
import java.text.SimpleDateFormat
import scala.util.control.Breaks._
import com.github.sarxos.webcam.Webcam
import com.sun.jna.Native

//import  com.sun.jna.Native

class Define(var xpic:String) {
  //Native.loadLibrary("facesdk12")
  var n = System.load("C:/Program Files/dll/facesdk15.dll")
 
  var licen: Int = FSDK.ActivateLibrary("MC98D+bRolV33U0ZwFJItBO3gOOoQDRz5WiLxEQHUBnrrjjwzPi+BkoJ/fUaRDY4I/XHoyLzS+nDEyB8wi/+vtspB/QSIa3JHFgHBYgy9EVLI9TiNTRieyBWiZMi42Anb+TDvjCMbhlbt9YPjkCyjrN6eE7NVFQFSgPd+quVaFU=")
	if (licen != FSDK.FSDKE_OK){
		println("No active license")
		val txtMsg = "JeeBoomBAA... - A Facial Recognition System. Luxand License is NOT active"
		//JeeBoomBAA.JeeBoomBaa.txtLabel.text = txtMsg
		
	}

	else {
		val txtMsg = "JeeBoomBAA... - A Facial Recognition System. Luxand License is active"
		println ("Luxand License is Active")
	//	JeeBoomBAA.JeeBoomBaa.txtLabel.text = txtMsg
	}

	val now = Calendar.getInstance().getTime()
	println ("Timestamp: "+ now)
	//var d:String=now.getDay.toString()
	//var name=JeeBoomBaa.txtName.getText
	//println(name)
	

	/*def capture = {
		val webcam = Webcam.getDefault() // FaceTime HD Camera CC253577UNXG1HNAL	
		println (webcam)
	    if (webcam != null) {
	        println("Webcam: " + webcam.getName())
			webcam.open()
			
			ImageIO.write(webcam.getImage(), "PNG",new File("D:/folder1/ok.png"))
	    } 
	    else {
	        println("No webcam detected");
	    }
	}*/
def getListOfFiles(dir: File, extensions: List[String]): List[File] = {
    dir.listFiles.filter(_.isFile).toList.filter { file =>
        extensions.exists(file.getName.endsWith(_))
    }
}
def listFilesForFolder(dir: File):Unit = {
  var fileentry= new Array[File](100)
  for(fileentry <- dir.listFiles()){
    if(fileentry.isDirectory()){
      listFilesForFolder(fileentry)
    }else{
      println(fileentry.getName)
    }
    
  }
  
}
	def scan = {
	  
		
		var sim = new Array[Float](100)
		var Threshold = new Array[Float](100)
		
		var file1 = new Array[File](100)
		//var linnkk =new Array[Int](10)
		var i:Int = 0
	  //	var names:String=""
		var FARvalue:Float =0
		var FRRvalue :Float = 0
		var threshold = new Array[Float](100)
		var s:String=""
		//val quality:Int=90
		//val file = new File("D:/joseph1.png")
		var hIm = new Luxand.FSDK.HImage
		//var him = new Luxand.FSDK.HImage
		var byref = new Luxand.FSDK.TFacePosition.ByReference
		var facetemp = new Luxand.FSDK.FSDK_FaceTemplate.ByReference
		var hIm1 = new Luxand.FSDK.HImage
		var dee = new FSDK_Features.ByReference 
		var dee1 = new FSDK_Features.ByReference 
		var template_using_eyes=new Luxand.FSDK.FSDK_FaceTemplate.ByReference
		var template_using_eyes1=new FSDK_FaceTemplate.ByReference
		var facetemp2 = new Luxand.FSDK.FSDK_FaceTemplate.ByReference
		var byref2 = new Luxand.FSDK.TFacePosition.ByReference
		var initL = FSDK.Initialize() // Should be called before using of any face detection functions.
		var initC = FSDKCam.InitializeCapturing()
		
		//var file = new java.io.File
		/*var folder = new File("D:/folder")
		file1 = folder.listFiles
		println(file1)*/
		
	/*	for( i <- file1){
		    var nameeval:String = name+".png"
		   //var names:String = i.getName
		   //println(names)
		  // if(byref.xc==
		     //FSDK.DetectFace((var hmage=FSDK.LoadImageFromFile(hIm1,"D:/folder/"+nameeval)),byref2)
		    // println("File exists") 
		    // var di = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new Date(new File("D:/folder/"+name+".png").lastModified));
		    // println("The specified Person already came to shop on:"+di)
		    
		     
		   
		      // else {
		         
		          
		
          		//println(initC)
          	  
          		//println(loadImage)
          		//FSDK.SetFaceDetectionParameters(false,false, 100)
            
          //	}  
		}*/
		         // println("WELCOME NEW CUSTOMER")
		          var loadImage: Int = FSDK.LoadImageFromFile(hIm, "D:/folder1/"+xpic+".png")
		          
		          
		          var de1 = FSDK.DetectFacialFeatures(hIm, dee1);
          		var se1= FSDK.DetectEyes(hIm,dee1);
		          var detusingeyes1= FSDK.GetFaceTemplateUsingEyes(hIm, dee1,  template_using_eyes1);
		          
		          
		          var detectFace:Int =  FSDK.DetectFace(hIm, byref)
              println("Face-angle:"+byref.angle)
              println("Face-Xcoordinates:"+byref.xc)
              println("Face-Ycoordinates:"+byref.yc)
              println("Face-Width:"+byref.w)
              var facetemplate:Int = FSDK.GetFaceTemplate(hIm, facetemp);//facetemp has the template.
          		if(facetemplate==0)println("template retrival went successfully")
          		
          	
          		val extensions = List("png","jpg")
          		var files = getListOfFiles(new File("D:/folder"),extensions)
          		var listnames = files.mkString("\n")
          	  var split = listnames.split(" ")
          	  //println(split)
          	  
          		for(s<-split){
          		//println(s)
          		var new1 =s.split("\n")
          		for(e<-new1){
          		println(e)
          		var loadsec:Int = FSDK.LoadImageFromFile(hIm1,e)//"D:/folder/"+e+".png"
          		if(loadsec == 0)println("Second face loaded")else println(loadsec)
          		
          		
          		var de = FSDK.DetectFacialFeatures(hIm1, dee)
          		var se= FSDK.DetectEyes(hIm1,dee);
          		println("facial featurres -- "+de)//+""+dee)
          		var detusingeyes= FSDK.GetFaceTemplateUsingEyes(hIm1, dee,  template_using_eyes);
          		println("template using eyes--"+detusingeyes)
          		
          		
          		var detectface2:Int = FSDK.DetectFace(hIm1, byref2)
          		println("Second-Face-angle:"+byref2.angle)
              println("Second-Face-Xcoordinates:"+byref2.xc)
              println("Second-Face-Ycoordinates:"+byref2.yc)
              println("Second-Face-Width:"+byref2.w)
          		var temp2:Int = FSDK.GetFaceTemplate(hIm1, facetemp2)
          		//println(temp2)
          		var matches:Int = FSDK.MatchFaces(template_using_eyes1,template_using_eyes,sim)
          		println("Face match status:"+matches)
          		//println("similarity:"+sim)
          		//if(matches == 0)println("Face-match")else println("no match")
          		var FAR:Int = FSDK.GetMatchingThresholdAtFAR(0.2.toFloat,Threshold)
          		var FRR:Int=  FSDK.GetMatchingThresholdAtFRR(0.8.toFloat, threshold);
          		//if(threshold(0) < sim(0))println("same face")else println("different-face")
          		println("Similarity level"+sim(0)+"Threshold at FAR:"+Threshold(0)+"Threshold at FRR:"+threshold(0))
          		val msggg = "sameface"//0
          		val msgggg = "diff face"//1
          		if(sim(0)>threshold(0))println("same face")else println("different-face")
          		
          		}}
          		//println("FAR value:"+Threshold)
          		
          		 hIm = null
          		 byref = null
          		 facetemp = null
          		 hIm1 = null
          	   dee = null
          		 dee1 = null
          		 template_using_eyes=null
          		 template_using_eyes1=null
          		 facetemp2 = null
          		 byref2 = null
          		 System.gc
          		
	         		if(sim(0)>threshold(0)) 0 else 1
          		}
	
          		
	
	
	def camExit = {
	
		val webcam = Webcam.getDefault() // FaceTime HD Camera CC253577UNXG1HNAL			
		var exitL = FSDK.Finalize() // Should be called when the application is exited.
		webcam.close()
		println("Scans")
		
		
	}
  
}