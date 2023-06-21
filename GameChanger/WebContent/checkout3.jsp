<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="ISO-8859-1">
<title>parte 3 </title>
<script src="check.js"></script>
<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'> 
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.cdnfonts.com/css/games" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;1,200&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous"> 
<link rel="stylesheet" href="css/checkout3.css">
<link rel="stylesheet" href="css/topbar.css">
</head>

<body>
<%@include file="includes/topbar.jsp"%>
  <div class="container-total">
    <div class="container-fluid">
      <!--barra di esperienza-->
      <section class="step-wizard">
        <ul class="step-wizard-list">
          <li class="step-wizard-item  ">
            <span class="progress-count">1</span>
            <span class="progress-label">Billing Info</span>
          </li>
          <li class="step-wizard-item ">
            <span class="progress-count">2</span>
            <span class="progress-label">Pay</span>
          </li>
        
          <li class="step-wizard-item current-item">
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
  <!--informazioni oggetti -->
  <div class ="container-info">
  <div class= "container-3">
  	<div class="row">
        <div class="col-md-8 order-md-1 div1" >
          <h4 class="d-flex justify-content-between align-items-center mb-3">
            
            <span class="text-muted" style="color: blue; @import url('https://fonts.cdnfonts.com/css/games'); ">Your cart</span>
            <span class="badge badge-secondary badge-pill">3</span>
          
        </h4>
          <ul class="list-group mb-3">
            <li class="list-group-item d-flex justify-content-between lh-condensed mb-3">
              
            <div class="oggetto venduto">
              <div class="arrow_prev1">
                <img src="https://m.media-amazon.com/images/I/81cb0qPa8LL._AC_UF1000,1000_QL80_.jpg" alt="Girl in a jacket" style="width:100px;height:150px;">
              </div>
              <div class="info-Prod">
                <h6 class="my-0 mb-3">Product name</h6>
                <small class="text-muted mb-3">Brief description</small>
                <span class="text-muted mb-3">$12</span>
              </div>
              

            </div>
            </li>
            <li class="list-group-item d-flex justify-content-between lh-condensed mb-3">
              <div>
                <h6 class="my-0">Second product</h6>
                <small class="text-muted">Brief description</small>
              </div>
              <span class="text-muted">$8</span>
            </li>
            <li class="list-group-item d-flex justify-content-between lh-condensed mb-3">
              <div>
                <h6 class="my-0">Third item</h6>
                <small class="text-muted">Brief description</small>
              </div>
              <span class="text-muted">$5</span>
            </li>
            <li class="list-group-item d-flex justify-content-between bg-light mb-3">
              <div class="text-success">
                <h6 class="my-0">Promo code</h6>
                <small>EXAMPLECODE</small>
              </div>
              <span class="text-success">-$5</span>
            </li>
            <li class="list-group-item d-flex justify-content-between">
              <span>Total (USD)</span>
              <strong>$20</strong>
            </li>
          </ul>

          
        </div>
        <!--distanziamento--> 
        <div class="col-md-1 order-md-2"></div>
        <!------------------>

        <!---finestra check delle info-->
        <div class=" col-md-3 order-md-3 mb-4">
          <div class="momento">
          <form class="needs-validation" novalidate="">
            <div class="row">
              <div class="col-md-6 mb-3 nome">
                <h3 style="text-align: center;">Il mio Indirizzo</h3>
                <div class="Indirizzo">
                  <h6>nome cognome</h6>
                  <h6> via residenza + num civico</h6>
                  <h6> cap e città</h6>
                  <h6> provincia </h6>
                  <h6> numero di telefono</h6>
                </div>
                <!--<input type="text" class="form-control" id="firstName" placeholder="" value="" required="">
                <div class="invalid-feedback">
                  Valid first name is required.
                </div> -->
              </div>
            </div>

            <div class="mb-3">
              <h3 style="text-align: center;"> Pagamento </h3>
              <div class="PagCarta"> 
                <h6> Tipo di Carta : Visa </h6>
                <h6> numero carta: 1234 5678 9123 4567</h6>
              </div>
              <div class="PagPaypal"style=display:>
                <div style="display: flex;">
                <i class='fa fa-paypal' style="font-size:x;"></i>
                <h6>Paypal</h6>
                </div>
                <h6> email: giorgio.marcello@gmail.com</h6>
              </div>
              <label for="address">Address</label>
              <input type="text" class="form-control" id="address" placeholder="1234 Main St" required="">
              <div class="invalid-feedback">
                Please enter your shipping address.
              </div>
            </div>

            <div class="mb-3">
              <label for="address2">Payment <span class="text-muted">(Optional)</span></label>
              <input type="text" class="form-control" id="address2" placeholder="Apartment or suite">
            </div>

            <hr class="mb-4">
            <div class="prezzoFinale"> 
            <h5 class="mb-3">Prezzo totale:  </h5>
            <strong>$$$</strong>
            </div>
            <button class="btn btn-primary btn-lg btn-block" type="submit">Continue to checkout</button>
          </form>
        </div>
      </div>
      </div>	
    </div>
    </div>	
<script>
  document.getElementById("submitBtn").addEventListener("click", function() {
    window.location.href = "Checkout2.jsp";
  });
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</body>
</html>
