/**
 * A handler function to prevent default submission and run our custom script.
 * @param  {Event} event  the submit event triggered by the user
 * @return {void}
 */
const handleRegisterFormSubmit = event => {

    // Call our function to get the form data.
    const inputElements = $("#register-form .form-group input");
    
    const data = formToJSON(inputElements);

    // Stop the form from submitting since we’re handling that with AJAX.
    event.preventDefault();

    // Use `JSON.stringify()` to make the output valid, human-readable JSON.
    var convertedJson = JSON.stringify(data, null, "  ");

    // Demo only: print the form data onscreen as a formatted JSON object.
    const dataContainer = document.getElementById("register-message-error");
    dataContainer.textContent = convertedJson;

    console.log(convertedJson);

    ajaxRequest = {
        contentType: 'application/json',
        type: 'post',
        data: convertedJson,
        dataType: 'text',
    
        success: function (response) {
            console.log("register - Success...");

            setTimeout(function () {
                window.location.href = "/";
            }, 2000);
        },

        error: function (e) {
            console.log("register - Erorr..");
            console.log(e);
        }
    };

    jsRoutes.controllers.Application.postRegister().ajax(ajaxRequest);

    // ...this is where we’d actually do something with the form data...
};



/*
 * This is where things actually get started. We find the form element using
 * its class name, then attach the `handleFormSubmit()` function to the 
 * `submit` event.
 */
// const form = document.getElementById("register-form");

// const registerButtonSubmit = document.getElementById("button-submit");
// registerButtonSubmit.addEventListener('click', handleregisterFormSubmit);
$("#register-button-submit")[0].addEventListener('click', handleRegisterFormSubmit);
