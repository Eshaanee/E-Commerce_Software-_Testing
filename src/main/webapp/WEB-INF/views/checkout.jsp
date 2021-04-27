
<!DOCTYPE html>
<html>
<head>
	
	<link rel="stylesheet" type="text/css" href="${contextRoot}/static/css/style2.css">
	

</head>
<body>
	<div class="main">
	
	
		<div class="col-75">
			<div class="container_1">
				<form action="#" >
					<div class="main">
						<div class="col-50">
							<h3>Billing Address</h3>
							<label for="f-name">Full Name</label>
							<input type="text" name="firstname" id="fname" placeholder="Enter Your Name">
							<label for="email">Email</label>
							<input type="text" name="email" id="email" placeholder="Enter Your Email">
							<label for="address">Adress</label>
							<input type="text" name="address" id="address" placeholder="Enter Your Address">
							<label for="city">City</label>
							<input type="text" name="city" id="city" placeholder="Enter Your City">
							
							<div class="main">
								<div class="col-50">
								<label for="state">State</i></label>
							<input type="text" name="state" id="state" placeholder="State">
									
								</div>
								<div class="col-50">
								<label for="zip">Zip</i></label>
							<input type="text" name="zip" id="zip" placeholder="Zip">
									
								</div>
								
							</div>
							
						</div>
						<div class="col-50">
							<h3>Payment</h3>
							
							<label for="cname">Card Name</label>
							<input type="text" name="cname" id="cname" placeholder="Enter Card Name">
							<label for="cno">Card Number</label>
							<input type="text" name="cno" id="cno" placeholder="Enter Card Number">
							
							<label for="expmonth">Exp Month</label>
							<input type="text" name="expmonth" id="expmonth" placeholder="Exp Month">
							<div class="main">
								<div class="col-50">
									<label for="expyear">Exp Year</label>
									<input type="text" name="expyear" id="expyear" placeholder="Exp Year">
									
								</div>
								<div class="col-50">
									<label for="cvv">CVV</label>
									<input type="text" name="cvv" id="cvv" placeholder="CVV">
									
								</div>

								
							</div>

							
						</div>
				
					</div>
					<label for="">
						<input type="checkbox" name="checkbox" id="checkbox">Shipping address same
						
					</label>
					<input type="button"  value="Continue to checkout"  class="btn" onclick="return validate();">
					
				</form>
				
			</div>
			
		</div>

		
	</div>

</body>
<script>
        function validate(){
        
        
        alert("Checkout Successfully!");
  return true;
}
    </script>
</html>