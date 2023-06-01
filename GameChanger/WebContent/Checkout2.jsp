<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="ISO-8859-1">
<title>payment</title>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;1,200&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous"> 
<link rel="stylesheet" href="css/checkout.css">
<link rel="stylesheet" href="css/topbar.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
<%@include file="includes/topbar.jsp"%>
  <div class="container-total">
    <div class="container-fluid">
      <!--barra di esperienza-->
      <section class="step-wizard">
        <ul class="step-wizard-list">
          <li class="step-wizard-item">
            <span class="progress-count">1</span>
            <span class="progress-label">Billing Info</span>
          </li>
          <li class="step-wizard-item current-item">
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
  
      <!--payment-->
  <fieldset>
    <div>
      <div class="col-75">
        <div class="container">
          <div class="col-50">
          <h3><b>Payment</b></h3>
          <label for="fname">Accepted Cards</label>
        <div class="icon-container">
          <i class="fa fa-cc-visa" style="color:navy;"></i>
          <i class="fa fa-cc-amex" style="color:blue;"></i>
          <i class="fa fa-cc-mastercard" style="color:red;"></i>
          <i class="fa fa-cc-discover" style="color:orange;"></i>
        </div>
        <label for="cname">Name on Card</label>
        <input type="text" id="cname" name="cardname" placeholder="John More Doe">
        <label for="ccnum">Credit card number</label>
        <input type="text" id="ccnum" name="cardnumber" placeholder="1111-2222-3333-4444">
        <label for="expmonth">Exp Month</label>
        <input type="text" id="expmonth" name="expmonth" placeholder="September">

        <div class="row">
          <div class="col-50">
            <label for="expyear">Exp Year</label>
            <input type="text" id="expyear" name="expyear" placeholder="2018">
          </div>
          <div class="col-50">
            <label for="cvv">CVV</label>
            <input type="text" id="cvv" name="cvv" placeholder="352">
            
          </div>
          <label>
            <input type="checkbox" checked="checked" name="sameadr"> Shipping address same as billing
          </label>
          <input type="submit" value="Continue to checkout" class="btn">
        </div>
      </div>
      </div>
    </div>
    </fieldset>
    </div>
    
  </form>
</div>
</div>
    
      
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</body>
</html>
