# CompagniaAereaJava

## 1. Project Overview
This project is a java application made with netbeans inside the IIS Galileo Galilei Crema. its purpose is to create an app that allows you to manage an airline (as an example I used ItaAirways, but this project is not associated in any way with the real company).

## 2. Login and Registration
### 2.1 Login
the login page serves to authenticate users already registered on the page. there is a "master" user who has access to all the features of the program, and to an additional feature which we will see later. 
<br>
Default master username: <b> master </b> 
<br>
Default master password: <b>master </b> 
<br>
you can change this data by editing it inside the "utenti.txt" file inside the main directory of the program

### 2.2 Registration
registration is more complex than simple login, to register you must enter the following data:
- First name
- Surname
- Email (important)
- Username (to be chosen)
- Account type
- Password & confirm password (choose)
<br>
after entering all this data and pressing register you will receive an email with the verification code to insert into the program
once the email verification has been completed, your data will be written into the "utenti.txt" file. at this point you will be returned to the login page where you can use the data you just registered.
<br><br>
<b> N.B To create an admin or pilot account you need to know the master password before verifying the email </b>

## 3. Dashboard
the dashboard is a page from which you can choose the mode you prefer to use. there are three types of Dashboards: Admin, User and Pilot. Each account has its own dashboard*
<br>
*except the master user who can use them all
### 3.1 Admin Dashboard
The Admin Dashboard allows admin users to access 6 functions. at the top there is the wifi icon (only works on mac os) and today's date.
the functions are:
- Flight Manager
- Passenger Manager
- Radio
- Radar
- Aircraft Manager
- Acars
