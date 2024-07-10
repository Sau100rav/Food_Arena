document.addEventListener("DOMContentLoaded", function(){
    var iconContainer=document.getElementById("iconContainer");
    var currentUrl=window.location.pathname;
    if(currentUrl=="/menupagehome"){
        iconContainer.style.display="block";
        console.log(currentUrl);

    } else{
        iconContainer.style.display="none";
    }
});