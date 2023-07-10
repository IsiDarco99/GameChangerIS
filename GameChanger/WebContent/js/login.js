<% String loginError = (String) request.getAttribute("loginError");
       if (loginError != null) { %>
    window.addEventListener('DOMContentLoaded', function() {
        var errorMessage = '<%= loginError %>';
        if (errorMessage !== '') {
            alert(errorMessage);
        }
    });
    <% } %>
