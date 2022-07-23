/*Put every js function method here*/

/*  Move the js function from index.html
$(document).ready(function() {
    $("#logoutLink").on("click", function(e) {
        e.preventDefault();
        document.logoutForm.submit();
    });
});

$(document).ready(function() {
    $("#logoutLink1").on("click", function(e) {
        e.preventDefault();
        document.logoutForm.submit();
    });
});*/

$(document).ready(function() {
    $(".quit_item").on("click", function(e) {
        var id = $(this).attr("id");
        e.preventDefault();
        document.logoutForm.submit();
    });
});