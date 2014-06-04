package controllers;

import javax.swing.JOptionPane;



import play.*;
import play.data.Form;
import play.data.validation.Constraints.Required;
import play.mvc.*;
import views.html.*;
import views.html.defaultpages.error;

public class Application extends Controller {
	
	
	public static class Equation {
		 public Double a;
         public Double b;
         public Double c;
    } 
  
  
  public static Result index() {
  
  return ok(index.render(form(Equation.class),""));
    
    
  }
  
  public static Result calculate() {
	  Form<Equation> form = form(Equation.class).bindFromRequest();
	  
	  Equation  equationData = form.get();
	
	 Double a= equationData.a; 
	 
	 Double b= equationData.b; 
	 
	 Double c= equationData.c; 
	 
	 if(a==null || b == null || c == null){
		 
		
		 
		 return badRequest(index.render(form,"Please Enter Complete Parameters!!!"));
		 
		 
	 }
	 
	 Double delta= Math.pow( b , 2 ) - ( 4*a*c );
	 
	 Double answer1 = 0.0;
	 Double answer2 = 0.0;
	 
	 
	 
	 if( delta > 0 ){
		 
		answer1 = (-b + Math.sqrt(delta)) / ( 2 * a ); 
		
		answer2 = (-b - Math.sqrt(delta)) / ( 2 * a ); 
		 
		return ok(equation.render( answer1 , answer2 ));  
	 }
	 
	 else if ( delta == 0){
		 
		 answer1 = (-b ) / ( 2 * a );
		 
		 answer2 = (-b ) / ( 2 * a );
		 
		 return ok(equation.render( answer1 , answer2 ));  
	 }
	 else{
	 	 
		 answer1 = Double.MIN_VALUE;
		 answer2 = Double.MIN_VALUE;
		 return ok(equation.render( answer1 , answer2 ));  
	 }
	   
  
  }
  
}