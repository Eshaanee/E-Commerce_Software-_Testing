<div class="container">

	<div class="row">

		<div class="col-md-3">
			<%@include file="./share/sidebar.jsp"%>
		</div>

		<div class="col-md-9">

			<div class="row carousel-holder">

				<div class="col-md-12">
					<div id="carousel-example-generic" class="carousel slide"
						data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#carousel-example-generic" data-slide-to="0"
								class="active"></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"></li>
							<li data-target="#carousel-example-generic" data-slide-to="2"></li>
							<li data-target="#carousel-example-generic" data-slide-to="3"></li>
						</ol>
						<div class="carousel-inner">
							
							<div class="item active">
								<img class="slide-image" src="${contextRoot }/static/images/banner.jpg"
									alt="">
							</div>
							<div class="item">
								<img class="slide-image" src="${contextRoot }/static/images/Banner_1.jpg"
									alt="">
							</div>
							<div class="item">
								<img class="slide-image" src="${contextRoot }/static/images/banner1.jpg"
									alt="">
							</div>
							<div class="item">
								<img class="slide-image" src="${contextRoot }/static/images/banner2.jpg"
									alt="">
							</div>
						</div>
						<a class="left carousel-control" href="#carousel-example-generic"
							data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left"></span>
						</a> <a class="right carousel-control"
							href="#carousel-example-generic" data-slide="next"> <span
							class="glyphicon glyphicon-chevron-right"></span>
						</a>
					</div>
				</div>

			</div>

				<div class="row">
                	<div class="col-xs-12">
                		<h3>Our Most Viewed Products</h3>
                		<hr/>
                	</div>
                </div>

                <div class="row is-table-row">
                	
                    <div class="col-sm-4" >                    	
                        <div class="thumbnail">
                            <img  class="landingImg" src="${contextRoot }/static/images/product1.jpg">
                            <h5>Denim Dress</h5>
                          
                                <h4 class="pull-right">$30 </h4>
                                <p></p>
                                <a  class="btn btn-primary pull-left" href="${contextRoot}/WEB-INF/views/singleProduct.jsp">View</a>
                           
                        </div>
                        
                    </div>

                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <h4>Checkout more products!</h4>
                        <hr/>
                        <a class="btn btn-primary" href="${contextRoot}/show/all/products">More Products</a>
                    </div>

                </div>
				
				<div class="row">
                	<div class="col-xs-12">
                		<h3>Our Most Purchased Products</h3>
                		<hr/>
                	</div>
                </div>
               <div class="row is-table-row">
                	
                    <div class="col-sm-4" >                    	
                        <div class="thumbnail">
                            <img class="landingImg" src="${contextRoot }/static/images/product7.jpg">
                            <h5>Hanging Lamp</h5>
                            
                                <h4 class="pull-right">$20 </h4>
                                <p></p>
                                <a  class="btn btn-primary pull-left">View</a>
                            
                        </div>
                    </div>

                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <h4>Checkout more products!</h4>
                        <hr/>
                        <a class="btn btn-primary" href="${contextRoot}/show/all/products">More Products</a>
                    </div>

                </div>

		</div>

	</div>

</div>
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

		<hr>
		
			<img src="${contextRoot }/static/images/payment.png" class="pay-img">
		<p class="copyright"> Copyright 2021-Online Shopping</p>
	</div>
	

</div>
<!-- /.container -->
