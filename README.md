# Employee Scheduling System

## Overview
This project is a simple employee scheduling system that allows employees to choose their preferred shifts for each day of the week. The system assigns shifts while ensuring no employee works more than one shift per day and a maximum of five days per week. If a shift does not have enough employees, additional employees are randomly assigned while maintaining the constraints.

## Features
- Employees can select preferred shifts (morning, afternoon, evening) for each day.
- The system ensures no employee works more than one shift per day.
- Employees are limited to a maximum of five workdays per week.
- Additional employees are assigned randomly if fewer than two employees are available for a shift.
- Conflict resolution ensures employees are reassigned when necessary.
- Final schedule is displayed in a structured format.

## Technologies Used
- **Python** for implementation
- **Java** for an alternative implementation
- **Random module** for assigning employees to shifts when needed
- **OOP (Object-Oriented Programming)** principles with `Employee`, `Day`, and `Schedule` classes

## Installation and Setup
### Python Version
1. Clone the repository:
   ```sh
   git clone https://github.com/leminh646/Schedule
   ```
2. Navigate to the Python directory:
   ```sh
   cd python
   ```
3. Run the program:
   ```sh
   python main.py
   ```

### Java Version
1. Navigate to the Java directory:
   ```sh
   cd java
   ```
2. Compile the Java files:
   ```sh
   javac Employee.java Day.java Schedule.java Main.java
   ```
3. Run the program:
   ```sh
   java Main
   ```

## Usage
1. The system initializes with employees and their shift preferences.
2. Employees are assigned shifts based on their preferences and scheduling rules.
3. The final schedule is displayed in the terminal.

## Example Python Output
![Screenshot 2025-03-30 113230](https://github.com/user-attachments/assets/2bb795e8-edaa-42f5-8f2f-61faa091b9fc)

## Example Java Output
![Screenshot 2025-03-30 115137](https://github.com/user-attachments/assets/c0a5474c-6d08-4697-ba64-d6b4eb214cc2)

## Future Enhancements
- Implement a GUI for user-friendly interaction.
- Store employee data in a database.
- Add shift preference priority rankings.

