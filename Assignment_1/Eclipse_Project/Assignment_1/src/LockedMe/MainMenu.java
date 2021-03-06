package LockedMe;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class MainMenu {

	static final String path = "/home/mrosdianamrmayb/Desktop/Asssignment/Phase1/Eclipse_Project/Assignment_1/main/";
	//static final String path = "C:\\Maslina\\Assignment\\Phase1\\Eclipse_Project\\Assignment_1\\main";
	static final String errorMessage= "Some error occured. Please contact admin or sent an E-mail at report@lockedme.com";
	
	public static void display() 
	{
		//System.out.println("1- Create directory/folder");
		System.out.println("1- Check all the files");
		System.out.println("2- Create a new file");
		System.out.println("3- Delete a file");
		System.out.println("4- Search a file");
		System.out.println("5- Exit from the application");
	}
	
	//This method to create folder/directory else
	//public static void createFolder(String folderPath, Scanner sc) {
	//	//Scanner scanner = new Scanner(System.in);
	//	try {
	//		File folder = new File(folderPath);
	//		if (folder.exists()) {
	//			System.out
	//					.println(folder.getName() + " folder already exists.");
	//		} else if (folder.mkdir()) {
	//			System.out.println(folder.getName() + " folder is created.");
	//		} else {
	//			System.out.println(folder.getName()
	//					+ " folder failed to create.");
	//		}
	//	} catch (Exception Ex) {
	//		System.out.println(errorMessage);
	//	}
	//}
	
	//This method will show all the files in the directory.
	public static void fileDetails() 
	{
		try {
			File folder = new File(path);
			File[] listOfFiles = folder.listFiles();
			List<File> fileList = Arrays.asList(listOfFiles);
			Collections.sort(fileList);
			
			if (listOfFiles.length==0)
				System.out.println("No Files exist in the Folder");
			else
			{
				System.out.println("All the files are listed below in Ascending order:\n");
				for(File file:fileList)
				{
					System.out.println(file.getName());
				}
			}
		}
		catch (Exception Ex)
		{
			System.out.println(errorMessage);
		}	
	}
	
	//This method will create a new file in the directory.
	public static void addFile() 
	{
		Scanner sc = new Scanner(System.in);
		try {
			
			String fileName;
			
			System.out.println("Enter the name of the desired a File: ");  
			fileName = sc.nextLine();
			String fl=fileName.toUpperCase();
			
			int linesCount;
			System.out.println("Enter how many lines you have to write in the File: ");
			linesCount=Integer.parseInt(sc.nextLine());

			FileWriter wr = new FileWriter(path + "\\"+fl);
			
			for(int i=1;i<=linesCount;i++)
			{
				System.out.println("Enter the Line: ");
				wr.write(sc.nextLine()+"\n");
			}
			System.out.println(fl +" File has been created successfully");
			wr.close();
		}
		catch (Exception Ex) 
		{
			System.out.println(errorMessage);
		}
	}
	
	//This method will delete the file in a directory.
	public static void deleteFile()
	{
		Scanner sc= new Scanner(System.in);
		try 
		{
			String fileName;
			System.out.println("Enter the name of file to be deleted: ");
			fileName=sc.nextLine();
			String fl=fileName.toUpperCase();
			
			File file = new File(path+"\\"+fl);
			if(file.exists())
			{
				file.delete();
				System.out.println(fl +" File deleted successfully: ");
			}
			else
			{
				System.out.println("File is not present");
			}
		}
		catch (Exception Ex)
		{
			System.out.println(errorMessage);
		}
	}
	
	//This method will search a file in a directory.
	public static void searchFile() 
	{
		Scanner sc = new Scanner(System.in);
		try
		{
			String fileName;
			System.out.println("Enter the same name of a file to be searched: ");
			fileName=sc.nextLine();
			String fl=fileName.toUpperCase();
			
			File folder = new File(path);
			File[] listOfFiles = folder.listFiles();
			List<File> fileList = Arrays.asList(listOfFiles);
			
			LinkedList<String> fileNames = new LinkedList<String>();
			
			for(File file:fileList)
				fileNames.add(file.getName());
			
			if(fileNames.contains(fileName))
				System.out.println(fileName + " File is available.");
			else
				System.out.println(fileName+" File is not available");
		}
		catch(Exception Ex)
		{
			System.out.println(errorMessage);
		}
	}
	
	//This method will exit from the application.
	public static void exit() 
	{
		System.out.println("");
		System.out.println("****************************************************************************************************");
		System.out.println("Thanks for using the application");
	}
	
	public static void main(String[]args) 
	{
		System.out.println("****************************************************************************************************");
		System.out.println("\t\t\t\t\t WELCOME TO LOCKEDME.COM");
		System.out.println("****************************************************************************************************");
		Scanner sc = new Scanner(System.in);	
		int num=0;
		try {
			do {
				display();
				System.out.println("");
				System.out.println("Enter a number to select the operation above:");
				num =Integer.parseInt(sc.nextLine());
				
				switch(num) {
				//case 1:
				//	System.out.println("Enter folder path + name you want to create eg (D:\\FileManagement):");
				//	String foldertoCreate=sc.next();
				//	createFolder(foldertoCreate, sc);
				//	System.out.println("----------------------------------------------------------------------------------------");
				//   break;
				case 1:
					fileDetails();
					System.out.println("----------------------------------------------------------------------------------------");
				    break;
				case 2:
				    addFile();
				    System.out.println("----------------------------------------------------------------------------------------");
				    break;
				case 3:
				    deleteFile();
				    System.out.println("----------------------------------------------------------------------------------------");
				    break;
				case 4:
				    searchFile();
				    System.out.println("----------------------------------------------------------------------------------------");
				    break;
				case 5:
				    exit();
				    System.out.println("****************************************************************************************************");
				    System.exit(0);
				    break;
				default:
					System.out.println("You are entering a wrong number");
					System.out.println("");
					}

				}
			while (num>0);
				sc.close();
			}
			catch (InputMismatchException e) {
				System.out.println("InputMismatchException Error");
			}
			catch (Exception e) {
				System.out.println(errorMessage);
			}
		}

}
