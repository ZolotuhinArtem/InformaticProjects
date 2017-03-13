;"use strict";
$(document).ready(start);

var firstNumber;
var secondNumber;
var resultHolder;
var operation;
var submit;
var btnSubmit;
var errorClass = "input-error";

function start(){
    firstNumber = $("#input-first-number");
    secondNumber = $("#input-second-number");
    submit = $("#calculate-form");
    btnSubmit = $("#calculate-btn");
    operation = $("#calculate-operation");
    resultHolder = $("#result-holder");
    alert("hello");
    updateNumbersField(firstNumber, secondNumber);
    setElementsEnabled(true);
    firstNumber.on("input", updateNumbersField.bind(this, firstNumber, secondNumber));
    secondNumber.on("input", updateNumbersField.bind(this, firstNumber, secondNumber));
    submit.submit(onSubmit);
}


function updateNumbersField(first, second) {
    checkAndSetErrorInput(first);
    checkAndSetErrorInput(second);
    if (!(first.hasClass(errorClass) || second.hasClass(errorClass))){
        btnSubmit.css("display", "inline");
    } else {
        btnSubmit.css("display", "none");
    }
    
}

function checkAndSetErrorInput(elem) {
    if (!$.isNumeric(elem.val())) {
        elem.addClass(errorClass);
    } else {
        elem.removeClass(errorClass);
    }
}
function onSubmit(e){
    e.preventDefault();
    setElementsEnabled(false);
    
    $.ajax({
        type : "GET",
        //url : $("#path").attr("value") + "?$operation=" + operation.val() + "&$firstValue=" + firstNumber.val() + "&$secondValue=" + secondNumber.val(),
        
        url : "http:\/\/localhost:8080\/SpringCalculator\/calculate" + "?operation=" + operation.val() + "&firstValue=" + firstNumber.val() + "&secondValue=" + secondNumber.val(),
        dataType : 'json',
        timeout : 10000,
        success : function(data) {
                console.log("SUCCESS: ", data);
                if (data.status == "OK") {
                    resultHolder.text(data.result + " burgers");
                } else {
                    if (data.message){
                        resultHolder.text(data.message + "!\n No burgers :(");
                    } else {
                        resultHolder.text("Error!\n No burgers :(");
                    }
                    
                }
                setElementsEnabled(true);
        },
        error : function(e) {
                console.log("ERROR: ", e);
                setElementsEnabled(true);
        },
        done : function(e) {
                console.log("DONE");
                setElementsEnabled(true);
        }
    });
}


function setElementsEnabled(enabled) {
    enableElem(firstNumber, enabled);
    enableElem(secondNumber, enabled);
    enableElem(btnSubmit, enabled);
    enableElem(operation, enabled);
}

function enableElem(elem, enabled) {
    elem.prop("disabled", !enabled);
}