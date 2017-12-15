# EmployeeRegister
A Employee Register written in Java as part of our course in Java Enterprise Edition (JavaEE). This project is intended to (as the name suggests) manage Employees and any relevant data attached to it. The main purpose of this project is to create a connection between a client and Servlets to manage Java Beans with the help of Hibernate(ORM).

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites
 - **Java 7+**
 - **Maven 3**
 - **Eclipse Enterprise Edition** (if you use another IDE it's alright but the experience may differ)
 - **XAMPP** (or any other program/method for managing a SQL database)
 - **TomEE-Plus (Tomcat 8.5)** (or any other Application Servers with the support of EE)
 
### Installation & Setup
1. Before you begin we have to make sure that:
   - your system is running **Java 7** or higher. For information regarding the installation of Java, 
   go [here](https://docs.oracle.com/javase/7/docs/webnotes/install/).
   - you have **Maven 3** installed. [Maven Installation Guide](https://maven.apache.org/install.html)
   - you have a working installation of **Eclipse Enterprise Edition**. [Download Eclipse](https://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/oxygen1a)
   - **XAMPP** is installed and that the SQL database is created based on this [script]()
   
#### Database Script
Database: `company`

```
CREATE DATABASE 'company';
USE 'company';
```
Tablestructure `employees`
```
CREATE TABLE `employees` (
  `employee_id` int(11) NOT NULL,
  `fname` varchar(32) NOT NULL,
  `lname` varchar(32) NOT NULL,
  `location` varchar(32) NOT NULL,
  `role` varchar(32) NOT NULL,
  `registration_date` date NOT NULL
);
```
Mock-Data to table `employees`
```
INSERT INTO `employees` (`employee_id`, `fname`, `lname`, `location`, `role`, `registration_date`) VALUES
(1, 'John', 'Doe', 'New Doeland', 'Master of John', '1888-01-01'),
(2, 'Jane', 'Doe', 'The Other Doeland', 'Master of Jane', '1812-12-21'),
(3, 'Aaron', 'Talker', 'Somewhere', 'Salesman', '2017-12-11');
```
Trigger `employees`
```
DELIMITER $$
CREATE TRIGGER `generate_reg_date` BEFORE INSERT ON `employees` FOR EACH ROW BEGIN
    SET NEW.registration_date = NOW();
END
$$
DELIMITER ;
```
Tablestructure `users`
```
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `username` varchar(32) NOT NULL,
  `password` varchar(64) NOT NULL,
  `isSignedIn` bit(1) NOT NULL
);
```
Mock-Data to table `users`
```
INSERT INTO `users` (`user_id`, `username`, `password`) VALUES
(1, 'username', 'changetoencodedpasswordviautilityclassandplaceithere');
```
Index for table `employees`
```
ALTER TABLE `employees`
  ADD PRIMARY KEY (`employee_id`);
```
Index for table `users`
```
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `username` (`username`);
```
AUTO_INCREMENT for table `employees`
```
ALTER TABLE `employees`
  MODIFY `employee_id` int(11) NOT NULL AUTO_INCREMENT;
```
AUTO_INCREMENT for table `users`
```
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT;
```

## Built With
* [TomEE-Plus](http://tomee.apache.org/docs.html) - An embedded/remote EE Application Server.
* [Thymeleaf](http://www.thymeleaf.org/documentation.html) - Server-side Java template engine.
* [Maven](https://maven.apache.org/) - Dependency Management.
* [Spring 4 (MVC, Security & ORM)](https://spring.io/docs) - Framework for modern Java-based enterprise applications.

## Authors
* **Gustav Malm** - *Programmer* | [GitHub](https://github.com/GustavMalm)
* **Kami Hassanzadeh** - *Programmer* | [GitHub](https://github.com/kami83h)

See also the list of [contributors](https://github.com/GustavMalm/EmployeeRegisterRESTfulService/contributors) who participated in this project.
