<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="ISO-8859-1">
<title>bill </title>
<script src="check.js"></script>
<head>
<title>GameChanger</title>
<%@include file="includes/head.jsp"%>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;1,200&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="css/checkout.css">
<link rel="stylesheet" href="css/topbar.css">
</head>

<body>

<%@include file="includes/topbar.jsp"%>
  <div class="container-total">
    <div class="container-fluid">
      <!--barra di esperienza-->
      <section class="step-wizard">
        <ul class="step-wizard-list">
          <li class="step-wizard-item current-item ">
            <span class="progress-count">1</span>
            <span class="progress-label">Billing Info</span>
          </li>
          <li class="step-wizard-item ">
            <span class="progress-count">2</span>
            <span class="progress-label">Pay</span>
          </li>
        
          <li class="step-wizard-item ">
            <span class="progress-count">3</span>
            <span class="progress-label">Checkout</span>
          </li>
    
          <li class="step-wizard-item">
            <span class="progress-count">4</span>
            <span class="progress-label">Finish</span>
          </li>
        </ul>
        </section>
      
    </div> 
  </div>
  <!--informazioni di spedizione-->
  <fieldset>
      <div class="row">
        <div class="col-75">
          <div class="container">
            <form action="/action_page.php">
              <div class="row">
                <div class="col-50">
                  <h3><b> Address</b></h3>
                  <label for="fname"><i class="fa fa-user"></i> Full Name</label>
                  <input type="text" id="fname" name="firstname" placeholder="John M. Doe">
                  <label for="email"><i class="fa fa-envelope"></i> Email</label>
                  <input type="text" id="email" name="email" placeholder="john@example.com">
                  <label for="adr"><i class="fa fa-address-card-o"></i> Address</label>
                  <input type="text" id="adr" name="address" placeholder="542 W. 15th Street">
                  <label for="city"><i class="fa fa-institution"></i> City</label>
                  <input type="text" id="city" name="city" placeholder="New York">
                  <div class="row">
                    <div class="col-50">
                      <label for="state">State</label>
                      <input type="text" id="state" name="state" placeholder="NY">
                    </div>
                    <div class="col-50">
                      <label for="zip">Zip</label>
                      <input type="text" id="zip" name="zip" placeholder="10001">
                    </div>
                  </div>
                </div>
              </div>
              <label>
                <input type="checkbox" checked="checked" name="sameadr"> Shipping address same as billing
              </label>
             <input type="submit" id="submitBtn" value="Continue to checkout" class="btn" onclick="redirectToCheckout2()">
            </form> 
          </div>
        </div>
       </div>
  </fieldset>
<script>
  document.getElementById("submitBtn").addEventListener("click", function() {
    window.location.href = "Checkout2.jsp";
  });
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
=======
	<%@include file="includes/footer.jsp"%>
</body>
</html>
