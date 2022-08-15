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

/*
$(document).ready(function() {
    $(".quit_item").on("click", function(e) {
        var id = $(this).attr("id");
        e.preventDefault();
        document.logoutForm.submit();
    });

    editDropdown_menu();
});

function editDropdown_menu() {
    $(".navbar .dropdown").hover(
        function() {
            $(this).find('.dropdown-menu').first().stop(true, true).delay(250).slideDown();
        },
        function() {
            $(this).find('.dropdown-menu').first().stop(true, true).delay(100).slideUp();
        }
    );

    $(".dropdown > a").click(function() {
        location.href = this.href;
    });

}*/

$(document).ready(function() {
    $("#logoutLink").on("click", function(e) {
        e.preventDefault();
        document.logoutForm.submit();
    });

    customizeDropDownMenu();
    customizeTabs();
});

function customizeDropDownMenu() {
    $(".navbar .dropdown").hover(
        function() {
            $(this).find('.dropdown-menu').first().stop(true, true).delay(250).slideDown();
        },
        function() {
            $(this).find('.dropdown-menu').first().stop(true, true).delay(100).slideUp();
        }
    );

    $(".dropdown > a").click(function() {
        location.href = this.href;
    });
}

function customizeTabs() {
    // Javascript to enable link to tab
    var url = document.location.toString();
    if (url.match('#')) {
        $('.nav-tabs a[href="#' + url.split('#')[1] + '"]').tab('show');
    }

    // Change hash for page-reload
    $('.nav-tabs a').on('shown.bs.tab', function (e) {
        window.location.hash = e.target.hash;
    })
}