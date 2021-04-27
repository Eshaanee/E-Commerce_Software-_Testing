
<head>

    
    <link rel="stylesheet" type="text/css" href="style.css">
    
    
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>

</head>

<body>

    
<div class="contact">
  <h1>Contact us</h1>
  <div id="error_message"></div>
  <form id="myform" onsubmit="return validate();">
    <div class="input_field">
        <input type="text" placeholder="Name" id="name">
    </div>
    <div class="input_field">
        <input type="text" placeholder="Subject" id="subject">
    </div>
    <div class="input_field">
        <input type="text" placeholder="Phone" id="phone">
    </div>
    <div class="input_field">
        <input type="text" placeholder="Email" id="email">
    </div>
    <div class="input_field">
        <textarea placeholder="Message" id="message"></textarea>
    </div>
    <div class="btnn">
        <input type="submit">
    </div>
  </form>
</div>


                
<!------footer---->
<div class="footer_1">
    <div class="container">
        <div class="row_1">
            
            <div class="footer-col-1">
                <h5>INFORMATION</h5>
                <ul>
                    <li>About Us</li>
                    <li>Delivery Information</li>
                    <li>Privacy Policy</li>
                    <li>Term & Condition</li>
                    <li>Manufactures</li>

                </ul>


            </div>
            <div class="footer-col-2">
                <h5>MY ACCOUNT</h5>
                <ul>
                    <li>My Account</li>
                    <li>My Cart</li>
                    <li>Login</li>
                    <li>Wishlist</li>
                    <li>Checkout</li>

                </ul>


            </div>
            
            <div class="footer-col-3">
                <h5>FOLLOW US</h5>
                <ul>
                    <li>Facebook</li>
                    <li>Twitter</li>
                    <li>Instagram</li>
                    <li>YouTube</li>
                </ul>


            </div>
            
        </div>

</div>
        <hr>
        
            <img src="${contextRoot}/static/images/payment.png" class="pay-img">
        <p class="copyright"> Copyright 2021-OnlineStore</p>
    </div>
    

</div>
    <!-- Footer Area End -->
    <script>
        function validate(){
  var name = document.getElementById("name").value;
  var subject = document.getElementById("subject").value;
  var phone = document.getElementById("phone").value;
  var email = document.getElementById("email").value;
  var message = document.getElementById("message").value;
  var error_message = document.getElementById("error_message");
  
  error_message.style.padding = "10px";
  
  var text;
  if(name.length < 5){
    text = "Please Enter valid Name";
    error_message.innerHTML = text;
    return false;
  }
  if(subject.length < 10){
    text = "Please Enter Correct Subject";
    error_message.innerHTML = text;
    return false;
  }
  if(isNaN(phone) || phone.length != 10){
    text = "Please Enter valid Phone Number";
    error_message.innerHTML = text;
    return false;
  }
  if(email.indexOf("@") == -1 || email.length < 6){
    text = "Please Enter valid Email";
    error_message.innerHTML = text;
    return false;
  }
  if(message.length <= 10){
    text = "Please Enter More Than 10 Characters";
    error_message.innerHTML = text;
    return false;
  }
  alert("Form Submitted Successfully!");
  return true;
}
    </script>
   
    
</body>
</html>