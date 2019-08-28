function data(){
    let ul = document.getElementById("ul");
    let val = document.getElementById("myField");
    let inp = val.value;
	if(inp == "test"){
		var request = new XMLHttpRequest();
	    request.open("GET","http://localhost:8080/JSPReports/DataServlet",false); //Fetch from JSON file
	    request.send(null);
	    var obj = JSON.parse(request.responseText);
	    //console.log(obj);
	    let j = 0;

	    while(j < obj.length){

	    
	        var node = document.createElement("LI");                 // Create a <li> node
	        if(obj[j].doco != 8){
	        var textnode = document.createTextNode(obj[j].doco+" "+obj[j].lnid+" "+obj[j].team+" "+obj[j].city);         // Create a text node
	        node.appendChild(textnode);                              // Append the text to <li>
	        ul.appendChild(node); 
	        }
	        j++;
	      }
		val.value  = "";

	}else{
		
		ul.innerHTML = "";
		val.value = "test";
	}
    


   
}
