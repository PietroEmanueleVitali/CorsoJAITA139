function celsiusConverter(){
    let span = document.getElementById("celsiusSpan");
    let input = document.getElementById("data");

    span.textContent = input.value;

}


function fahrenheitConverter(){
    let span = document.getElementById('fahrenheitSpan');
    let input = document.getElementById('data');
    //(0 °C × 9/5) + 32

    span.textContent = Math.floor(((input.value * (9/5))+32));
}