package com.gl.caseStudy1;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StaffMain {

	public static Double totalCalculation (Applicant applicant) {
		Double s1= applicant.getSubject1Mark();
		Double s2= applicant.getSubjec2Mark();
		Double s3= applicant.getSubject3Mark();
		if(s1<50.0||s2<50.0||s2<50.0) 
			return 0.0;
		else {
	    Double total=s1+s2+s3;
	    return total;
		}
	}
	public static Double percentageCalculation (Double total) {
		double percentage = (total/300)*100;
		return percentage;
	}
	public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    List<Applicant> listApplicant = new ArrayList<Applicant>();
    DecimalFormat df = new DecimalFormat("0.00");
    System.out.println("Enter the number of applicants");
    int n=Integer.parseInt(sc.nextLine());
    for(int i=0;i<n;i++) {
    	System.out.println("Enter applicants details");
    	String inuptString=sc.nextLine();
    		String arr[]=inuptString.split(",");
    		double subMark1=Double.parseDouble(arr[1]);
    		double subMark2=Double.parseDouble(arr[2]);
    		double subMark3=Double.parseDouble(arr[3]);
    		if(subMark1<0.0|| subMark2<0.0 || subMark3<0.0||subMark1>100.0|| subMark2>100.0 || subMark3>100.0) {
    			throw new MarksException("Mark is negative!");
    		}
    			Applicant a=new Applicant(arr[0],subMark1,subMark2,subMark3,null,null);
    			double total = totalCalculation(a);
    			a.setTotal(total);
    			double percentage = Double.parseDouble(df.format(percentageCalculation(total)));
    			a.setPercentage(percentage);
    			listApplicant.add(a);
    			
    		}
    		
    		for(Applicant applicant: listApplicant) {
    			if(applicant.getPercentage()>70)
    				System.out.println(applicant);
    		}
    		}
	
}

	


