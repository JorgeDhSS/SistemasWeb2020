var bLogeo = document.getElementById("singin");
bLogeo.addEventListener('click', function(){
    //alert("Hola"+document.getElementById("email").value);
    //alert("Hola"+document.getElementById("password").value);
    const parametros = new URLSearchParams();
    parametros.append("prtemail", document.getElementById("email").value);
    parametros.append("prtPassword", document.getElementById("password").value);
    //axios.get('http://127.0.0.1:4567/hello/'+parametros)
    //.then(function(response){
    //    console.log(response)
    //    console.log(response.data)
    //    console.log(response.statusText)
    //    document.getElementById("Titulo").innerHTML=response.data
    //})
    //.catch(function(error){
    //    console.log(error)
    //})
    axios.post('http://127.0.0.1:4567/otro/', {
    PrtEmail : document.getElementById('email').value,
    PrtPassword : document.getElementById('password').value
    })
    .then(function(response){
        console.log(response)
        console.log(response.data)
        console.log(response.statusText)
        document.getElementById("Titulo").innerHTML=response.data
    })
    .catch(function(error){
        console.log(error)
    })
});