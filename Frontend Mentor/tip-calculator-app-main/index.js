const billInput = document.querySelector('main .input.bill');
let billContent = billInput.value;

console.log(billInput);

billInput.addEventListener('input', inputHandler);

function inputHandler(e) {
    billContent = e.target.value;
    console.log(billContent);
}