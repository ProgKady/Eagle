const submitBtn = document.querySelector('.submit-btn'),
      phone = document.querySelector('#phone'),
      password = document.querySelector('#user-password'),
      passwordConfirm = document.querySelector('#user-password-confirm'),
      email = document.querySelector('#mail'),
      errorDisplayers = document.getElementsByClassName('error'),
      inputFields = document.querySelectorAll('input'),
      cardContainer = document.querySelector('.card-container'),
      outroOverlay = document.querySelector('.outro-overlay')

let count = 2

function onValidation(current ,messageString, booleanTest){
    let message = current
    message.textContent = messageString
    booleanTest != 0 ? ++count : count
}

for(let i=0; i<inputFields.length; i++){
    let currentInputField = inputFields[i]
    let currentErrorDisplayer = errorDisplayers[i]

    currentInputField.addEventListener('keyup', (e)=>{
        let message = currentErrorDisplayer
        e.target.value != "" ? onValidation(currentErrorDisplayer, '', 0) : onValidation(currentErrorDisplayer, '*This field is Required', 0)
    })
}

phone.addEventListener('keyup', (e)=>{
    let message = errorDisplayers[3]
    e.target.value == e.target.value.replace(/\D/g,'') ? onValidation(message, '', 1) : onValidation(message, '*Please enter valid number', 0)
})

email.addEventListener('keyup', (e)=>{
    let message = errorDisplayers[2]
    mail.value.includes('@') & mail.value.includes('.com') ? onValidation(message, '', 1) : onValidation(message, '*Please provide a valid Email', 0)
})

password.addEventListener('keyup', (e)=>{
    let message = errorDisplayers[4]
    password.value.length >= 8 ? onValidation(message, '', 1) :  onValidation(message, 'Password requires minimum 8 charecters', 0)
})

passwordConfirm.addEventListener('keyup', (e)=>{
    let message = errorDisplayers[5]
    password.value === e.target.value ? onValidation(message, '', 1) : onValidation(message, '*Password did not match', 0)
})

submitBtn.addEventListener('click', (e)=>{
    e.preventDefault()
    if(count > 5){
        cardContainer.style.display = 'none'
        outroOverlay.classList.remove('disabled')
    }
    else{
        for(let i=0; i<errorDisplayers.length; i++){
            errorDisplayers[i].textContent = '*This field is Required'
        }
    }
})






$(document).ready(function(){

  var val , found , result_no;
  
  // All the names to be searched
  var keys= ["Your_Name_Is","Your_Code_Is","Department"];
  
  var source = ["Cer_Link"];
  
  $("#search").keyup(function(){
    
    result_no = 0;
    
    $("#result").html("");
    
    val = $(this).val().toString().toUpperCase();

    val = val.split(" ");
    
    for(i=0;i<object.length;i++){
      
      // false at the beinning
      found = false;
      
      // searching for the names in 'keys'
      for(j=0;j<keys.length;j++){
        for(k=0;k<val.length;k++){
          if(val[k] && object[i][keys[j]].toString().toUpperCase().indexOf(val[k]) != -1 ){
            found = true;
            break;
          }
        }
      }
      
      if(found){
        appendNode(i);
        continue;
      }

      // Searching in _source
      for(j=0;j<source.length;j++){
        for(k=0;k<val.length;k++){
          if(val[k] && ( (object[i]._source[source[j]] && object[i]._source[source[j]].toString().toUpperCase().indexOf(val[k]) != -1) || !object[i]._source[source[j]] && val[k].toUpperCase() == "NULL" )){
            found = true;
            break;
          }
        }
      }
      
      if(found){
        appendNode(i);
        continue;
      }
      
    }
    
  });
  
  function appendNode(i){
    
    $("#main-content").html("");
    $("#source-content").html("");
    
    // appending the data of the object with index 'i' in the array of objects
    for(j=0;j<keys.length;j++){
        $("#main-content").append('&emsp;&emsp;'+keys[j]+' : '+object[i][keys[j]]+'<br>');
      }
    
    for(j=0;j<source.length;j++){
        $("#source-content").append('&emsp;&emsp;&emsp;&emsp;'+source[j]+' : '+object[i]._source[source[j]]+'<br>');
		$("#result").append('<div class="panel panel-primary" style="padding:1em 2em"><span style="font-weight:bold;font-size:120%">'+(++result_no)+'</span>&nbsp;<a class="data-toggle" data-id="mc'+i+'"><span class="glyphicon glyphicon-chevron-down"></span></a><br><div class="main-content" id="mc'+i+'"><b><mark>'+$("#main-content").html()+'</b></mark>&emsp;<a class="data-toggle" data-id="sc'+i+'"><span class="glyphicon glyphicon-chevron-down"></span></a><mark><b>Information</b></mark> : <div class="source-content" id="sc'+i+'"><b><mark>'+$("#source-content").html()+'</b></mark></div></div></div><center><img src="'+object[i]._source[source[j]]+'" width="250" height="400"></center>');
      }
    
    
    
    $(".data-toggle").unbind().click(function(){

        if($("#"+$(this).attr('data-id')).is(":visible")){
          $("#"+$(this).attr('data-id')).slideUp();
          $(this).html('<span class="glyphicon glyphicon-chevron-right"></span>');
        } else {
          $("#"+$(this).attr('data-id')).slideDown();
          $(this).html('<span class="glyphicon glyphicon-chevron-down"></span>');
        }

      });

  }
});