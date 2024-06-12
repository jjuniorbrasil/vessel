const billInput = document.querySelector('main .input.bill');
const customInput = document.querySelector('main .input.custom');
const numPeopleInput = document.querySelector('main .input.num-people');
const numPeopleLabel = document.querySelector('main .desc.num-people');
const numPeople = [numPeopleInput, numPeopleLabel];
const tipResultValue = document.querySelector('.tip-amount .value');
const totalResultValue = document.querySelector('.total .value');
const buttons = document.querySelectorAll('.buttons .button');
const resetButton = document.querySelector('.result .button.reset');
let tipPercent = customInput.value / 100;


for (let button of buttons) {
    button.addEventListener('click', buttonHandler);
}
    

function inputHandler() {
    if (this.classList[1] == 'num-people') {
        let errorState = (active) => {
            for (let e of numPeople) { active ? e.classList.add('error') : e.classList.remove('error') };
        }
        this.value == 0 ? errorState(true) : errorState(false);
    }
    this.value = Math.abs(this.value);
    updateResult();
}

function inputHandlerCustomBtn() {
    this.value = Math.abs(this.value);
    tipPercent = customInput.value / 100;
    updateResult();
}

function buttonHandler(e) {
    tipPercent = e.target.getAttribute('value') / 100;
    updateResult();
}

function updateResult() {
    let tipAmount = billInput.value * tipPercent/numPeopleInput.value;
    let totalValue = (billInput.value/numPeopleInput.value) + tipAmount;
    if (!isNaN(tipAmount) && numPeopleInput.value != 0) {
        tipResultValue.innerHTML = `\$${tipAmount.toFixed(2)}`;
        totalResultValue.innerHTML = `\$${totalValue.toFixed(2)}`;
    }
    resetButton.classList.remove("inactive");
}

resetButton.addEventListener('click', (e) => {
    e.target.classList.add('inactive');
    billInput.value = 0;
    customInput.value = 0;
    numPeopleInput.value = 0;
    tipResultValue.innerHTML = `\$${(0.0).toFixed(2)}`;
    totalResultValue.innerHTML = `\$${(0.0).toFixed(2)}`;
})

billInput.addEventListener('input', inputHandler);
customInput.addEventListener('input', inputHandlerCustomBtn);
numPeopleInput.addEventListener('input', inputHandler);