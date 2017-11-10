/**
 * A handler function to prevent default submission and run our custom script.
 * @param  {Event} event  the submit event triggered by the user
 * @return {void}
 */
const handleTransferFormSubmit = event => {

    // Call our function to get the form data.
    const inputElements = $("#transfer-form .form-group input");
    
    const data = formToJSON(inputElements);

    // Stop the form from submitting since we’re handling that with AJAX.
    event.preventDefault();

    // Demo only: print the form data onscreen as a formatted JSON object.
    // const dataContainer = document.getElementById("transfer-message-error");
    // dataContainer.textContent = convertedJson;

    // Use `JSON.stringify()` to make the output valid, human-readable JSON.
    var convertedJson = JSON.stringify(data, null, "  ");

    console.log(convertedJson);

    ajaxRequest = {
        contentType: 'application/json',
        type: 'post',
        data: convertedJson,
        dataType: 'text',

        success: function (response) {
            console.log("transfer - Success...");
            alert("OK !");
            resetTransferForm();

            // setTimeout(function () {
            //     window.location.href = "/";
            // }, 2000);
        },

        error: function (e) {
            console.log("transfer - Erorr..");
            console.log(e);
        }
    };

    jsRoutes.controllers.Service.postTransfer().ajax(ajaxRequest);

    // ...this is where we’d actually do something with the form data...
};

function resetTransferForm()
{
    $("#transfer-form .input").val("");
}



/*
 * This is where things actually get started. We find the form element using
 * its class name, then attach the `handleFormSubmit()` function to the 
 * `submit` event.
 */
// const form = document.getElementById("transfer-form");

// const transferButtonSubmit = document.getElementById("button-submit");
// transferButtonSubmit.addEventListener('click', handletransferFormSubmit);

$("#transfer-button-submit")[0].addEventListener('click', handleTransferFormSubmit);
