package kumar;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;

/**
 * Programm zum Testen der Klasse Auto(erstellt vom Hern Prof. Weiser)
 * @author jyotikumar
 * @version 2016/02/20
 * Aufgabenstellung: Schreibe eine Klasse AutoTest. 
 * Diese möge JUnit-Testmethoden enthalten, welche die angeführten Methoden 
 * und Konstruktoren testen. Teste auch die Exceptions. Die Klasse enthält einige 
 * wenige kleine fehler. Diese sollten sich nach Möglichkeit in fehlgeschlagenen Tests 
 * wiederfinden.
 * 
 * Fehler 1: Color.BLACK = schwarz(nicht rot)
 * Fehler 2: es wird Color ausgegeben wie im Konstruktur sondern nur 
 *			farbstring
 *
 *
 *sshversion: git@github.com:jkumar2015/AutoTestA19.git
 * 
 */

public class AutoTest {
	
	
	/**
	 * test1: check if the non default constructor works correctly 
	 * check if it gives an Exception
	 */
	@Test
	public void test1(){
		Auto a = new Auto("Lambhorghnin", Color.BLACK, 100); //Fehler in Auto class 
		System.out.println(a);
		
		a = new Auto("", null,0); //works good i got an an IllegalArgumentException,
		System.out.println(a); //so it won't print it out
		
		a = new Auto("Ferrari", Color.BLUE, 10); //Fehler
		System.out.println(a);
	
	}
	
	/**
	 * test2: is about the default constructor 
	 */
	@Test
	public void test2(){
		Auto a = new Auto();
		a.toString();
		System.out.println(a);//perfect
	}
	
	/**
	 * test3: is about testing with assertTrue check if the PS is correct
	 */
	@Test
	public  void test3() {
		Auto a = new Auto();
		// TODO Auto-generated method stub
		assertTrue(a.getLeistung()==0); //false, good
		assertTrue(a.getLeistung()==160); //true, good
	}
	
	/**
	 * There are more test in a method like: 
	 * RUnWith, Suite, BeforeClass, AfterClass
	 * @author jyotikumar
	 *
	 */
	@RunWith(Suite.class) 
	@Suite.SuiteClasses({AutoTest.class}) 
	public static class TestSuite1 {
		
		@BeforeClass 
		public static void setUpClass(){
			System.out.println("setUp");
		}
		
		@AfterClass
		public static void setDownClass(){
			System.out.println("setDown");
		}
	}
	/**
	 * This is the TestRunner Test
	 * if its an success it will print was successfull 
	 * if its a fail it will print was a failure
	 * @author jyotikumar
	 *
	 */
	public static class TestRunner{
		public static void main(String[]args){
			Result r  = JUnitCore.runClasses(TestSuite1.class);
			 for (Failure failure : r.getFailures()) {
		         System.out.println(failure.toString());
		      }
		      System.out.println(r.wasSuccessful());
		   }
		}  	
		
	}


