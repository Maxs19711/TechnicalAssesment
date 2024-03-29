## Description
- This Technical assesment is created using java programming language and written using vs Code. 
- There are two class of java which is Main.java and Parking.java.
- For Parking.java, it has setter and getter for the registration number, date check in and out, time check in and out and other method.
- For Main.java, it has main method to execute the code and two other method.
  -  First method is void Total() and used to check whether the date entered is weekday or weekend and then return the date checked in and out, time check in and out, duration,  and then call method of calculateTotal() to calculate amount to pay.
  -  Second method is void calculateTotal() and used to calculate the amount to pay after the Total() method find out whether the date is weekday or weekend.
- The two method is being called inside main method including the Parking.java class.
- It also use Java Swing framework for displaying dialog boxes and obtaining user input.
- It use Java standard library which Java API for Date and Time and provide functionality for working with dates and times

## Output of Scenarios 1: Vehicle exit within 15 minutes.
![Screenshot (887)](https://github.com/Maxs19711/TechnicalAssesment/assets/132529355/fa8bf18a-4e48-4e6f-aeb4-014d0ca864bc)
- Reg No:         SU 123 K
- In:             2021-10-25 08:16
- Out:            2021-10-25 08:27
- Duration:       11 Minutes      
- Amount to paid: $0.0

## Output of Scenarios 2: Vehicle exit after 15 minutes and within grace period minutes
![Screenshot (888)](https://github.com/Maxs19711/TechnicalAssesment/assets/132529355/1d623b78-a1a2-47ac-a32b-1179e2038f63)
- Reg No:         SN 3453 G
- In:             2021-10-25 08:16
- Out:            2021-10-25 12:19 
- Duration:       4 Hours 3 Minutes
- Amount to paid: $4.5

## Output when it is weekday
![Screenshot (884)](https://github.com/Maxs19711/TechnicalAssesment/assets/132529355/2946e834-df97-4bb4-8b80-61d2665a2858)
- Reg No:         SU 122 K
- In:             2023-05-25 08:00
- Out:            2023-05-25 15:00 
- Duration:       7 Hours 0 Minutes
- Amount to paid: $9.0

## Output when it is weekend
![Screenshot (885)](https://github.com/Maxs19711/TechnicalAssesment/assets/132529355/d06c7606-7898-4f89-9c9a-7fcc5b8e4a58)
- Reg No:         SN 12534 K
- In:             2023-05-28 08:00
- Out:            2023-05-28 15:00 
- Duration:       7 Hours 0 Minutes
- Amount to paid: $13.0


## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
