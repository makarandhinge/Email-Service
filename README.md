<p align="center">
  <img src="Logo/mail.png" alt="Logo" width="150" />
</p>




# Email Sending Service

I designed an email-sending service that supports sending emails to single or multiple recipients, with options for file attachments and rich HTML content. It ensures flexibility for both personal and professional communication.

## Tech Stack

**Client:** React, TailwindCSS

**Server:** Spring Boot


## Run Locally

1. Clone the project

```bash
  git clone https://github.com/makarandhinge/Email-Service.git
```

2. Go to the backend project directory

```bash
  cd Email-Service
  cd Backend of Email Sender
  cd Email Sender
```

3. Ensure that Java is installed on your system. You can verify this by running the following command

```bash
  java -version
```

4. To build and run the Spring Boot application, you need Maven. If Maven is not installed, you can follow the installation instructions from [here](https://github.com/makarandhinge/Installtion-Guideline/blob/main/Maven.md)

- Build the project

```bash
  ./mvnw clean install
```
- Run the Spring Boot application

```bash
  ./mvnw spring-boot:run
```
The backend should now be running on http://localhost:8080.

5. Navigate to the Frontend Directory

```bash
  cd ../..
  cd Frontend_email
  cd email_sender
```
6. Install Frontend Dependencies

Make sure you have Node.js installed. You can verify it with

```bash
node -v
npm -v
```
If Node.js is not installed, you can download it from [here](https://github.com/makarandhinge/Installtion-Guideline/blob/main/Node.md)

Run the following command to install the necessary dependencies for the frontend

```bash
 npm install
```

7. Start the React Development Server

To start the React development server (using Vite), use the following command:

```bash
npm run dev
```
The frontend should now be running on http://localhost:5173.

