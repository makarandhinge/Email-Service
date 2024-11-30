import React, { useState } from "react";
import toast from "react-hot-toast";
import { sendEmail } from "../services/email.service.js";

function EmailSender() {
  const [emailData, setEmailData] = useState({
    to: "",
    subject: "",
    message: "",
  });

  function handleFieldChange(event, name) {
    setEmailData({ ...emailData, [name]: event.target.value });
  }

  async function handleSubmit(event) {
    event.preventDefault();
    if (
      emailData.to.trim() === "" ||
      emailData.subject.trim() === "" ||
      emailData.message.trim() === ""
    ) {
      toast.error("All fields are required!");
      return;
    }

    try {
      // Mocking an API call
      await sendEmail(emailData);
      toast.success("Email sent successfully!");
      setEmailData({
        to: "",
        subject: "",
        message: "",
      });
    } catch (error) {
      console.error(error);
      toast.error("Failed to send email. Please try again.");
    }
  }

  function handleClear() {
    setEmailData({
      to: "",
      subject: "",
      message: "",
    });
    toast("Fields cleared!");
  }

  return (
    <div className="w-full min-h-screen flex justify-center items-center">
      <div className="email_card bg-white md:w-1/3 w-full mx-4 md:mx-0 p-4 border shadow rounded-lg">
        <h1 className="text-gray-900 text-3xl">EMAIL SENDER</h1>
        <p className="text-gray-700 p-3">
          Send an email to your favorite person with your own app...
        </p>
        <form action="" onSubmit={handleSubmit}>
          <div className="input_field mt-4">
            <label
              htmlFor="to-input"
              className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
            >
              To Whom
            </label>
            <input
              value={emailData.to}
              onChange={(event) => handleFieldChange(event, "to")}
              type="text"
              id="to-input"
              className="block w-full p-4 text-gray-900 border border-gray-300 rounded-lg bg-gray-50 text-base focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            />
          </div>
          <div className="input_field mt-4">
            <label
              htmlFor="subject-input"
              className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
            >
              Subject
            </label>
            <input
              value={emailData.subject}
              onChange={(event) => handleFieldChange(event, "subject")}
              type="text"
              id="subject-input"
              className="block w-full p-4 text-gray-900 border border-gray-300 rounded-lg bg-gray-50 text-base focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            />
          </div>
          <div className="form_field mt-4">
            <label
              htmlFor="message"
              className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
            >
              Your message
            </label>
            <textarea
              value={emailData.message}
              onChange={(event) => handleFieldChange(event, "message")}
              id="message"
              rows="5"
              className="block p-2.5 w-full text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
              placeholder="Write your thoughts here..."
            ></textarea>
          </div>
          <div className="button_container flex justify-center gap-2 mt-4">
            <button
              type="submit"
              className="hover:bg-blue-900 text-white bg-blue-700 px-3 py-2 rounded"
            >
              Send Email
            </button>
            <button
              type="button"
              onClick={handleClear}
              className="hover:bg-gray-900 text-white bg-red-700 px-3 py-2 rounded"
            >
              Clear
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}

export default EmailSender;
