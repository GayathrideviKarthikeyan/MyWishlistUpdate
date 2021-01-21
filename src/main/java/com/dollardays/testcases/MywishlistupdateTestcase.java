package com.dollardays.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.LoginPage;
import com.dollardays.pages.MywishlistupdatePage;


public class MywishlistupdateTestcase extends BaseTest {

	@Test

	public void MywishlistTc() throws Exception
	{


		MywishlistupdatePage Mywishlist = new MywishlistupdatePage(driver);    

		//Logging in to dollardays webpage & Comparing URL
		//click Signin dropdown thru signin submenu	

		LoginPage loginPage = new LoginPage(driver);
		loginPage.invokeLogin();

		boolean logged = Mywishlist.CompareURl("https://www.dollardays.com/");
		Mywishlist.Updatelog(logged, "Step1: Logged in to Dollar Days webpage Successfully");

		Thread.sleep(3000);

		//click okay button when Cookiepopup is display	
		Mywishlist.FindCookiepopup();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "Step2:  Clicking Cookie pop clear button got disappear");


		//clicking Wishlist icon in Home page      
		Mywishlist.clickWishlist();		
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "Step3:  Wishlist icon got clicked");

		//clicking Wishlist under dropdwn to Create a Wishlist submenu 
		Mywishlist.clickCreateaWishlist();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "Step4: Create a  Wishlist sub menu got clicked");

		//click Click Here to manage link
		Mywishlist.Clickheretomanage();	
		Thread.sleep(3000);	
		ExtentTestManager.getTest().log(Status.INFO, "Step5: Click Here to manage link got clicked");

		//clickYour Organization edit link
		Mywishlist.clickYOURORGEdit1();
		Thread.sleep(3000);
		boolean value1 = Mywishlist.CompareURl("https://www.dollardays.com/myaccount/wishlistprofile.aspx");
		Mywishlist.Updatelog(value1, "Step6: YOURORGANIZATION Edit button got clicked and got Navigate to My Account page");


		driver.navigate().back();
		ExtentTestManager.getTest().log(Status.PASS, "Step7:  Navigate back to My Wishlist page");

		//clickYour YOURPROJECTEVENT edit link		    	    
		Mywishlist.clickPROJECTEVENTEdit2();	
		Thread.sleep(3000);
		boolean value2 = Mywishlist.CompareURl("https://www.dollardays.com/myaccount/wishlistprojectevent.aspx");
		Mywishlist.Updatelog(value2, "Step8: YOURPROJECTEVENT Edit button got clicked and got Navigated to My Account page");

		driver.navigate().back();
		ExtentTestManager.getTest().log(Status.INFO, "Step9:  Navigate back to My Wishlist page");	

		//clickYour YOURWISHLISTPRODUCTS edit link	
		Mywishlist.clickWLPRODUCTSEdit3();	
		Thread.sleep(3000);
		boolean value3 = Mywishlist.CompareURl("https://www.dollardays.com/myaccount/wishlistproduct.aspx");
		Mywishlist.Updatelog(value3, "Step10: YOURWISHLISTPRODUCTS Edit button got clicked and got Navigated to My Account page");

		driver.navigate().back();
		ExtentTestManager.getTest().log(Status.INFO, "Step11:  Navigate back to My Wishlist page");	

		//clickYour YOUR WISHLIST ORDERS view all link	 
		Mywishlist.clickWLORDERSviewall();	
		Thread.sleep(3000);
		boolean value4 = Mywishlist.CompareURl("https://www.dollardays.com/myaccount/wishlist-order-history.aspx");
		Mywishlist.Updatelog(value4, "Step12: YOUR WISHLIST ORDERS view all button got clicked and got Navigated to Wishlist Order History page");

		driver.navigate().back();
		ExtentTestManager.getTest().log(Status.INFO, "Step13:  Navigate back to My Wishlist page");	

		//Comparing URL
		Mywishlist.clickYOURWISHLISTURl();	
		Thread.sleep(3000);
		boolean value5 = Mywishlist.CompareURl("https://www.dollardays.com/firstannual/wishlist.html");
		Mywishlist.Updatelog(value5, "Step14: YOUR WISHLISTURL got clicked and got Navigated to display the same URL");


		driver.navigate().back();
		System.out.println("Navigate back to My Wishlist page");
		ExtentTestManager.getTest().log(Status.INFO, "Step15:  Navigate back to My Wishlist page");	

		//clickYour YOUR WISHLIST ORDERS view all link again to check the Navigating page 

		Mywishlist.clickWLORDERSviewall();		    	    
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "Step16:  YOUR WISHLIST ORDERS view all button got clicked and got Navigated to Reqired page");	


		//calling Automate datepicker method

		Mywishlist.wishorderhistory();
		Thread.sleep(3000);
		System.out.println(" Start Date and End Date should be pass in the date field");
		ExtentTestManager.getTest().log(Status.INFO, "Step17:  Start Date should be displays in the start date field calender==> 01/12/2018 and End Date should be displays in the end date field calender==> 12/25/2019");


		//click My wishlist order history Submit button 

		Mywishlist.clickSubmitbtn();		    	    
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "Step18:  Submit button got clicked");

		//After submitiing check  My wishlist order history page updated text is displaying

		boolean textresult = Mywishlist.compareText(Mywishlist.getwishlistorderhistory(), "No wishlist orders found between 1/12/2018 and 12/25/2019");
		try {
			Assert.assertTrue(textresult);
			ExtentTestManager.getTest().log(Status.PASS, "Step19:  Navigate back to My Wishlist page");	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}



	}
}







