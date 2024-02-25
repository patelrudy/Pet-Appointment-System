# Pet Appointment System

The Pet Appointment System is a Java application that manages appointments for pets at a clinic. It provides functionality to schedule appointments, record pet information, and perform treatments based on the pet's health and condition.

## Features

- Appointment Scheduling: The system allows users to schedule appointments for pets by providing information such as pet name, type, health, and pain level.
- Pet Information Management: The system stores and manages information about each pet, including their name, health status, pain level, and specific pet attributes such as mice caught (for cats) or drool rate (for dogs).
- Treatment Calculation: The system calculates the treatment time based on the pet's health, pain level, and specific pet attributes. The treatment time determines the duration of the appointment.
- Pet Communication: The system enables pets to communicate by providing a "speak" method that generates pet-specific sounds based on their attributes and pain level.
- File Handling: The system reads appointment and patient information from CSV files and writes appointment updates to a patient file.
- Exception Handling: The system includes custom exception classes, such as `InvalidPetException`, to handle invalid pet data or file-related errors.

## Installation

To use the Pet Appointment System, follow these steps:

1. Clone the repository or download the source code.
2. Ensure that you have Java Development Kit (JDK) installed on your system.
3. Open the project in your preferred Java Integrated Development Environment (IDE).
4. Build and run the application using your IDE's tools or command-line interface.

## Usage

To use the Pet Appointment System, you need to provide appointment and patient information in CSV files.

### Appointment CSV File

Create a CSV file containing the appointment details. Each line represents a separate appointment with the following format:

`<name>,<typeOfPet>,<additionalAttribute>,<entryTime>`

- `<name>`: The name of the pet.
- `<typeOfPet>`: The type of pet (either "Dog" or "Cat").
- `<additionalAttribute>`: Additional attribute specific to the pet type (e.g., "droolRate" for dogs, "miceCaught" for cats).
- `<entryTime>`: The entry time of the appointment.

Save the appointment CSV file as `Appointments.csv` in the project directory.

### Patient CSV File

Create a CSV file containing existing patient information. Each line represents a separate patient with the following format:

`<name>,<typeOfPet>,<additionalAttribute>,<day>,<entryTime>,<exitTime>,<health>,<painLevel>`


- `<name>`: The name of the pet.
- `<typeOfPet>`: The type of pet (either "Dog" or "Cat").
- `<additionalAttribute>`: Additional attribute specific to the pet type (e.g., "droolRate" for dogs, "miceCaught" for cats).
- `<day>`: The day of the appointment.
- `<entryTime>`: The entry time of the appointment.
- `<exitTime>`: The exit time of the appointment.
- `<health>`: The health status of the pet.
- `<painLevel>`: The pain level of the pet.

Save the patient CSV file as `Patients.csv` in the project directory.

### Running the Application

1. Compile and run the `ClinicDriver` class, either using your IDE or the command-line interface.
2. The system will read the appointment file (`Appointments.csv`), process each appointment, and generate a report.
3. The report will be displayed in the console, showing the details of each appointment.
4. The system will update the patient file (`Patients.csv`) with the new appointment information.
5. If the appointment update is successful, the system will print "File created: hello.txt" to indicate that a new file has been created.
