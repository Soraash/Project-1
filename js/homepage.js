function increase() {
    document.getElementById("spanID").innerText++;
    //var num1 = document.getElementById("spanID").innerText;
    setColor();
}




function decrease() {
    document.getElementById("spanID").innerText--;
    //var num = document.getElementById("spanID").innerText;
    setColor();
}

function toast() {
    document.getElementById("toast").style.display = "block";
    document.getElementById("toastButton").disabled = true;
    setTimeout(() => {
        document.getElementById("toastButton").disabled = false;
        document.getElementById("toast").style.display = "none";
    }, 2000);
}

function setColor() {
    var num = document.getElementById("spanID").innerText;

    var numID = document.getElementById("spanID");
    if (num === 0) {
        document.getElementById("spanID").style.color = "blue";
        numID.classList.replace(numID.classList.item(0), 'blue');

    } else if (num > 0) {
        numID.classList.replace(numID.classList.item(0), 'green');
    } else if (num < 0) {
        numID.classList.replace(numID.classList.item(0), 'red');
    }

}

function validateForm() {
    var email = document.forms.form1.email.value;
    var password = document.forms.form1.password.value;

    if (email == "") {
        document.getElementById("toast2").style.display = "block";
        setTimeout(() => {
            document.getElementById("toast2").style.display = "none";
        }, 2000);
        return false;
    }
    if (password == "") {

        document.getElementById("toast1").style.display = "block";
        setTimeout(() => {
            document.getElementById("toast1").style.display = "none";
        }, 2000);
        return false;
    }
    alert("Submitted Successfully!")
    return true;
}


function increaseWidth() {

    var width = document.getElementById("imgWidth").width + 5;
    var height = document.getElementById("imgWidth").height + 5;

    if (width < 350) {
        document.getElementById("imgWidth").style.width = width + "px";
        document.getElementById("imgWidth").style.height = height + "px";
    } else {
        alert("Max size limit reached");
    }
}

function decreaseWidth() {
    var width = document.getElementById("imgWidth").width - 5;
    var height = document.getElementById("imgWidth").height - 5;
    if (width > 200) {
        document.getElementById("imgWidth").style.width = width + "px";
        document.getElementById("imgWidth").style.height = height + "px";
    } else {
        alert("Min size limit reached");
    }
}

function increaseRadius() {

    document.getElementById("imgWidth").style.borderRadius = "50%";
}

function decreaseRadius() {


    document.getElementById("imgWidth").style.borderRadius = "0px";

}

function normalRadius() {
    document.getElementById("imgWidth").style.borderRadius = "20px";

}