$().ready(function(){
   
    console.log("Hi....");
    $("#email_error_message").hide();
    $("#password_error_message").hide();

    var focus_email = false;
    var focus_password = false;

    var valid_email = false;
    var valid_password = false;

    // $("#email").focus(function(){
    //     if( !focus_email)
    //     {
    //         focus_email = true;
    //         alert("focus_email");
    //     }
    // });

    // $("#password").focus(function(){
    //     if( !focus_password)
    //     {
    //         focus_password = true;
    //         alert("focus_password");
    //     }
    // });

    $("#email").focusout(function(){
        checkEmail();
    });

    $("#password").focusout(function(){
        checkPassword();
    });

    function checkEmail()
    {
        // if( !focus_email )
        // {
        //     console.log("chua vao email");
        //     return ;
        // } 
        var email = $("#email").val();
        var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

        if(email.length == 0) 
        {
            valid_email = false;
            $("#email_error_message").html("Please enter your email !");
            $("#email_error_message").show();
        }

        else if( !re.test(email) ){
            valid_email = false;
            $("#email_error_message").html("Not a email !");
            $("#email_error_message").show();
        }

        else 
        {
            valid_email = true;
            $("#email_error_message").hide();
        }
    }

    function checkPassword()
    {
        // if( !focus_password ) return ;
        var pW = $("#password").val();
        
        if(pW.length == 0) 
        {
            valid_password = false;
            $("#password_error_message").html("Please enter your password !");
            $("#password_error_message").show();
        }

        else if( pW.length < 5 ){
            valid_password = false;
            $("#password_error_message").html("At least 5 characters !");
            $("#password_error_message").show();
        }

        else 
        {
            valid_password = true;
            $("#password_error_message").hide();
        }
    }

    $("#login-button-submit").click(function(event){
        console.log("press submit...");
        valid_email = false;
        valid_password = false;

        var email = $("#email").val();
        var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

        if(email.length == 0) 
        {
            valid_email = false;
            $("#email_error_message").html("Please enter your email !");
            $("#email_error_message").show();
        }

        else if( !re.test(email) ){
            valid_email = false;
            $("#email_error_message").html("Not a email !");
            $("#email_error_message").show();
        }

        else 
        {
            valid_email = true;
            $("#email_error_message").hide();
        }
        
        ////////////////

        var pW = $("#password").val();
        
        if(pW.length == 0) 
        {
            valid_password = false;
            $("#password_error_message").html("Please enter your password !");
            $("#password_error_message").show();
        }

        else if( pW.length < 5 ){
            valid_password = false;
            $("#password_error_message").html("At least 5 characters !");
            $("#password_error_message").show();
        }

        else 
        {
            valid_password = true;
            $("#password_error_message").hide();
        }

        ///////////////
        console.log(valid_email + ".. " + valid_password);
        if(valid_email && valid_password)
        {
            event.preventDefault();
            handleLoginFormSubmit();
        }
        //else false;
    });

});