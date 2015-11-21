$('document').ready(function(){
	//Form validation 
	jQuery.validator.addMethod("noSpaces", function(value, element) {
        return this.optional(element) || value.trim().length > 0;
    });    //validates input against spaces
	
	//basic validation. Can write complex validation rules to restrict users to use strong username and password
    $('#loginForm').validate({
        rules:{
        	username: {
                noSpaces: true,
                required: true
            },
            inputPassword: {
                noSpaces: true,
                required: true
            }
        },
        messages: {
        	username: "Please enter valid username",
        	inputPassword: "Please enter valid password",
        }
    });
});