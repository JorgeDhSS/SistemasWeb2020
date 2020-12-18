var bLogeo = document.getElementById("singin");
bLogeo.addEventListener('click', function(){
    
    //crea parámetros
    const parametros = new URLSearchParams();
    parametros.append("email", document.getElementById("email").value);
    parametros.append("password", document.getElementById("password").value);
    parametros.append("id", document.getElementById("id").value);
    //axios.get('http://127.0.0.1:4567/hello?'+parametros)
    //.then(function(response){
    //    console.log(response)
    //    console.log(response.data)
    //    console.log(response.statusText)
    //    document.getElementById("Titulo").innerHTML=response.data
    //})
    //.catch(function(error){
    //    console.log(error)
    //})

    //manda los parámetros a queryparams con el método get
    // axios.get('http://127.0.0.1:4567/queryparams?'+parametros)
    // .then(function(response){
    //    console.log(response)
    //    console.log(response.data)
    //    console.log(response.statusText)
    //    document.getElementById("Titulo").innerHTML=response.data
    // })
    // .catch(function(error){
    //    console.log(error)
    // })

    //Envía datos al servidor en apartado JSON con el método POST
    axios.post('http://127.0.0.1:4567/usuariosC', {
        email : document.getElementById('email').value,
        password : document.getElementById('password').value,
        id : document.getElementById('id').value
    })
    .then(function (response) {
        console.log(response)
        console.log(response.data)
        console.log(response.statusText)
        document.getElementById('titulo').innerHTML = response.data
    })
    .catch(function (error) {
        console.log(error)
    })

    // axios.post('http://127.0.0.1:4567/formdata', parametros)
    // .then(function(response){
    //     console.log(response)
    //     console.log(response.data)
    //     console.log(response.statusText)
    //     document.getElementById("Titulo").innerHTML=response.data
    // })
    // .catch(function(error){
    //     console.log(error)
    // })
});