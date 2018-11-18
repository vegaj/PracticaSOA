
jQuery(document).ready(function($) { 
    $("table").center(true);
    $("table").addClass("mdl-data-table mdl-js-1data-table");
    $("tr").addClass("mdl-data-table__cell--non-numeric");
    $("input[type=submit]").addClass("mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent");
    $("a").addClass("mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"); 
    $("form").css("text-align", "center");
    $("body").addClass("field-center").addClass("field-left");
    $(".field-left").css("text-align", "left");
    $(".field-center").css("text-align", "center");
    $("body").css("margin-top", "20px");
    $("body").css("margin-bottom", "100px");
    $(".ui-datalist-content").css("border", "none");
});

jQuery.fn.center = function(parent) {
    if (parent) {
        parent = this.parent();
    } else {
        parent = window;
    }
    this.css({
        
    });
    
    return this;
};